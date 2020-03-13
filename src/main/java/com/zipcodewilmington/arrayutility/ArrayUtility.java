package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;

    public ArrayUtility(T[] arrayUtility) {
        array = arrayUtility;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        int count = 0;
        T[] merged = (T[]) new Object[array.length + arrayToMerge.length];
        for (int i = 0; i < arrayToMerge.length; i++) {
            merged[i] = arrayToMerge[i];
            }
        for (int i = 0; i < array.length ; i++) {
            merged[i+arrayToMerge.length] = array[i];
        }
        for (int i = 0; i < merged.length; i++) {
            if (merged[i] == valueToEvaluate){
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int count = 0;
        T mostCom = null;
        int bigCount = 0;
        T[] merged = (T[]) new Object[array.length + arrayToMerge.length];
        for (int i = 0; i < arrayToMerge.length; i++) {
            merged[i] = arrayToMerge[i];
        }
        for (int i = 0; i < array.length ; i++) {
            merged[i+arrayToMerge.length] = array[i];
        }
        for (int i = 0; i < merged.length ; i++) {
            for (int j = i; j < merged.length ; j++) {
                if (merged[i] == merged[j]){
                    count++;
                }
            }
            if (count > bigCount){
                bigCount = count;
                mostCom = merged[i];
            }
            count = 0;
        }

        return mostCom;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i] == valueToEvaluate){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        T[] arrWithOut = (T[]) Array.newInstance(valueToRemove.getClass(), array.length - getNumberOfOccurrences(valueToRemove));
        int index = 0;
        for (int i = 0; i < array.length ; i++) {
            if (!array[i].equals(valueToRemove)){
                arrWithOut[index++] = array[i];
            }
            }
        return arrWithOut;
    }
}

package com.bytedance.mira.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayUtils {
    public ArrayUtils() {
    }

    public static boolean isEmpty(Collection<?> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static int size(Collection<?> r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.size();
    }

    public static boolean isEmpty(Map<?, ?> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static int size(Object[] r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.length;
    }

    public static boolean isEmpty(byte[] r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(int[] r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(long[] r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length == 0) goto L7;
        return false;
    }

    public static <T> boolean isEmpty(T[] r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(boolean[] r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.length == 0) goto L7;
        return false;
    }

    public static boolean contains(long[] r100, long r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r100[r103] == r101) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static <T> boolean containsAll(char[] r100, char[] r101) {
        if (r101 != null) goto L5;
        return true;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        if (contains(r100, r101[r103]) == false) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static <T> boolean containsAny(T[] r100, T[] r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (contains(r100, r101[r103]) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static <T> int indexOf(T[] r100, T r101) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L16;
        T r103 = r100[r102];
        if (r103 == r101) goto L15;
        if (r103 == null) goto L14;
        if (r103.equals(r101) == true) goto L15;
    L14:
        r102 = r102 + 1;
    L15:
        return r102;
    L16:
        return -1;
    }

    public static boolean contains(char[] r100, char r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r100[r103] == r101) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static <T> boolean containsAll(T[] r100, T[] r101) {
        if (r101 != null) goto L5;
        return true;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        if (contains(r100, r101[r103]) == false) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static boolean contains(int[] r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r100[r103] == r101) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static <T> boolean contains(T[] r100, T r101) {
        if (indexOf(r100, r101) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> T[] appendElement(Class<T> r100, T[] r101, T r102) {
        return (T[]) appendElement(r100, r101, r102, false);
    }

    public static <T> T[] appendElement(Class<T> r100, T[] r101, T r102, boolean r103) {
        int r104 = 0;
        if (r101 == null) goto L9;
        if (r103 == false) goto L6;
    L8:
        int r105 = r101.length;
        T[] r106 = (T[]) ((Object[]) Array.newInstance(r100, r105 + 1));
        System.arraycopy(r101, 0, r106, 0, r105);
        r104 = r105;
    L10:
        r106[r104] = r102;
        return r106;
    L6:
        if (contains(r101, r102) == false) goto L8;
        return r101;
    L9:
        r106 = (T[]) ((Object[]) Array.newInstance(r100, 1));
        goto L10
    }
}

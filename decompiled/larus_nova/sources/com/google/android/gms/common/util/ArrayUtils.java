package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList();
    }

    public static <T> T[] concat(T[]... r100) {
        if (r100.length == 0) goto L14;
        int r101 = 0;
        int r102 = 0;
    L6:
        if (r101 >= r100.length) goto L8;
        r102 = r102 + r100[r101].length;
        r101 = r101 + 1;
        goto L6
    L8:
        T[] r103 = (T[]) Arrays.copyOf(r100[0], r102);
        int r104 = r100[0].length;
        int r105 = 1;
    L10:
        if (r105 >= r100.length) goto L12;
        T[] r106 = r100[r105];
        int r107 = r106.length;
        System.arraycopy(r106, 0, r103, r104, r107);
        r104 = r104 + r107;
        r105 = r105 + 1;
        goto L10
    L12:
        return r103;
    L14:
        return (T[]) ((Object[]) Array.newInstance(r100.getClass(), 0));
    }

    public static byte[] concatByteArrays(byte[]... r100) {
        if (r100.length == 0) goto L14;
        int r101 = 0;
        int r102 = 0;
    L6:
        if (r101 >= r100.length) goto L8;
        r102 = r102 + r100[r101].length;
        r101 = r101 + 1;
        goto L6
    L8:
        byte[] r103 = Arrays.copyOf(r100[0], r102);
        int r104 = r100[0].length;
        int r105 = 1;
    L10:
        if (r105 >= r100.length) goto L12;
        byte[] r106 = r100[r105];
        int r107 = r106.length;
        System.arraycopy(r106, 0, r103, r104, r107);
        r104 = r104 + r107;
        r105 = r105 + 1;
        goto L10
    L12:
        return r103;
    L14:
        return new byte[0];
    }

    public static <T> ArrayList<T> toArrayList(T[] r100) {
        int r101 = r100.length;
        ArrayList<T> r102 = new ArrayList(r101);
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102.add(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static int[] toPrimitiveArray(Collection<Integer> r100) {
        int r101 = 0;
        if (r100 == null) goto L13;
        if (r100.isEmpty() == true) goto L13;
        int[] r102 = new int[r100.size()];
        Iterator<Integer> r103 = r100.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r102[r101] = r103.next().intValue();
        r101 = r101 + 1;
        goto L9
    L11:
        return r102;
    L13:
        return new int[0];
    }

    public static Integer[] toWrapperArray(int[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.length;
        Integer[] r102 = new Integer[r101];
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L8;
        r102[r103] = Integer.valueOf(r100[r103]);
        r103 = r103 + 1;
        goto L6
    L8:
        return r102;
    }

    public static <T> boolean contains(T[] r100, T r101) {
        if (r100 == null) goto L5;
        int r102 = r100.length;
    L6:
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L14;
        if (Objects.equal(r100[r103], r101) == true) goto L10;
        r103 = r103 + 1;
        goto L7
    L10:
        if (r103 < 0) goto L14;
        return true;
    L14:
        return false;
    L5:
        r102 = 0;
        goto L6
    }

    public static <T> T[] removeAll(T[] r100, T... r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 == null) goto L33;
        int r102 = r101.length;
        if (r102 == 0) goto L33;
        Class<?> r103 = r101.getClass();
        int r104 = r100.length;
        T[] r105 = (T[]) ((Object[]) Array.newInstance(r103.getComponentType(), r104));
        int r106 = 0;
        if (r102 != 1) goto L17;
        int r107 = 0;
        int r108 = 0;
    L12:
        if (r107 >= r104) goto L24;
        T r109 = r100[r107];
        if (Objects.equal(r101[0], r109) == true) goto L16;
        r105[r108] = r109;
        r108 = r108 + 1;
    L16:
        r107 = r107 + 1;
    L24:
        if (r105 != null) goto L27;
        return null;
    L27:
        if (r108 != r105.length) goto L31;
        return r105;
    L31:
        return (T[]) Arrays.copyOf(r105, r108);
    L17:
        int r110 = 0;
    L18:
        if (r106 >= r104) goto L23;
        T r111 = r100[r106];
        if (contains(r101, r111) == true) goto L22;
        r105[r110] = r111;
        r110 = r110 + 1;
    L22:
        r106 = r106 + 1;
        goto L18
    L23:
        r108 = r110;
    L33:
        return (T[]) Arrays.copyOf(r100, r100.length);
    }

    public static void writeArray(StringBuilder r100, double[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L7;
        if (r103 == 0) goto L6;
        r100.append(",");
    L6:
        r100.append(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public static void writeStringArray(StringBuilder r100, String[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L7;
        if (r103 == 0) goto L6;
        r100.append(",");
    L6:
        r100.append("\"");
        r100.append(r101[r103]);
        r100.append("\"");
        r103 = r103 + 1;
        goto L3
    }

    public static boolean contains(int[] r100, int r101) {
        if (r100 == null) goto L12;
        int r102 = 0;
    L6:
        if (r102 >= r100.length) goto L12;
        if (r100[r102] == r101) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static void writeArray(StringBuilder r100, float[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L7;
        if (r103 == 0) goto L6;
        r100.append(",");
    L6:
        r100.append(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public static void writeArray(StringBuilder r100, int[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L7;
        if (r103 == 0) goto L6;
        r100.append(",");
    L6:
        r100.append(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public static void writeArray(StringBuilder r100, long[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L7;
        if (r103 == 0) goto L6;
        r100.append(",");
    L6:
        r100.append(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public static <T> void writeArray(StringBuilder r100, T[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L7;
        if (r103 == 0) goto L6;
        r100.append(",");
    L6:
        r100.append(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }

    public static void writeArray(StringBuilder r100, boolean[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L7;
        if (r103 == 0) goto L6;
        r100.append(",");
    L6:
        r100.append(r101[r103]);
        r103 = r103 + 1;
        goto L3
    }
}

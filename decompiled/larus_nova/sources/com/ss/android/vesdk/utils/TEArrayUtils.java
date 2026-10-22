package com.ss.android.vesdk.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class TEArrayUtils {
    public TEArrayUtils() {
    }

    public static double[] toDoubleArray(List<Double> r100) {
        int r101 = 0;
        if (r100 == null) goto L13;
        if (r100.isEmpty() == true) goto L13;
        double[] r102 = new double[r100.size()];
    L9:
        if (r101 >= r100.size()) goto L11;
        r102[r101] = ((Double) ListProtector.get(r100, r101)).doubleValue();
        r101 = r101 + 1;
        goto L9
    L11:
        return r102;
    L13:
        return new double[0];
    }

    public static float[] toFloatArray(List<Float> r100) {
        int r101 = 0;
        if (r100 == null) goto L13;
        if (r100.isEmpty() == true) goto L13;
        float[] r102 = new float[r100.size()];
    L9:
        if (r101 >= r100.size()) goto L11;
        r102[r101] = ((Float) ListProtector.get(r100, r101)).floatValue();
        r101 = r101 + 1;
        goto L9
    L11:
        return r102;
    L13:
        return new float[0];
    }

    public static int[] toIntArray(List<Integer> r100) {
        int r101 = 0;
        if (r100 == null) goto L13;
        if (r100.isEmpty() == true) goto L13;
        int[] r102 = new int[r100.size()];
    L9:
        if (r101 >= r100.size()) goto L11;
        r102[r101] = ((Integer) ListProtector.get(r100, r101)).intValue();
        r101 = r101 + 1;
        goto L9
    L11:
        return r102;
    L13:
        return new int[0];
    }

    public static long[] toLongArray(List<Long> r100) {
        int r101 = 0;
        if (r100 == null) goto L13;
        if (r100.isEmpty() == true) goto L13;
        long[] r102 = new long[r100.size()];
    L9:
        if (r101 >= r100.size()) goto L11;
        r102[r101] = ((Long) ListProtector.get(r100, r101)).longValue();
        r101 = r101 + 1;
        goto L9
    L11:
        return r102;
    L13:
        return new long[0];
    }

    public static String[] toStringArray(List<String> r100) {
        if (r100 == null) goto L9;
        if (r100.isEmpty() == true) goto L9;
        return (String[]) r100.toArray(new String[r100.size()]);
    L9:
        return new String[0];
    }
}

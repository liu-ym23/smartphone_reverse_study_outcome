package com.bytedance.map.api.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class CommonUtil {
    public CommonUtil() {
    }

    public static /* synthetic */ int a(Map.Entry r100, Map.Entry r101) {
        return lambda$getPairOfMinValue$0(r100, r101);
    }

    public static int avg(int r100, int r101) {
        return (r100 & r101) + ((r100 ^ r101) >> 1);
    }

    public static int[] getPairOfMinValue(Map<Integer, Integer> r100) {
        ArrayList r101 = new ArrayList(r100.entrySet());
        Collections.sort(r101, new b());
        return new int[]{((Integer) ((Map.Entry) ListProtector.get(r101, 0)).getKey()).intValue(), ((Integer) ((Map.Entry) ListProtector.get(r101, 0)).getValue()).intValue()};
    }

    private static /* synthetic */ int lambda$getPairOfMinValue$0(Map.Entry r100, Map.Entry r101) {
        return ((Integer) r100.getValue()).intValue() - ((Integer) r101.getValue()).intValue();
    }

    public static int distance(float r100, float r101, float r102, float r103) {
        return (int) Math.sqrt(Math.pow(r100 - r102, 2.0d) + Math.pow(r101 - r103, 2.0d));
    }
}

package com.bytedance.bdnavigationsdk.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static double a(double r6, int r8) {
        double r0 = r8;
        return Math.rint(r6 * Math.pow(10.0d, r0)) / Math.pow(10.0d, r0);
    }

    public static float b(float r6, int r7) {
        double r0 = r6;
        double r8 = r7;
        return (float) (Math.rint(r0 * Math.pow(10.0d, r8)) / Math.pow(10.0d, r8));
    }
}

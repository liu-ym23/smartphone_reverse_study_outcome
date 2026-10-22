package com.bytedance.bdnavigationsdk.utils;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f200375a = 0;

    static {
    }

    public static double a(double r100, int r101) {
        double r102 = r101;
        return Math.rint(r100 * Math.pow(10.0d, r102)) / Math.pow(10.0d, r102);
    }

    public static float b(float r100, int r101) {
        double r102 = r100;
        double r103 = r101;
        return (float) (Math.rint(r102 * Math.pow(10.0d, r103)) / Math.pow(10.0d, r103));
    }
}

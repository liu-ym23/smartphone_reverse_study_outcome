package com.lynx.tasm.utils;

/* JADX INFO: loaded from: classes32.dex */
public final class i {
    public i() {
    }

    public static float a(double r100) {
        return b((float) r100, 0.0f);
    }

    public static float c(float r100) {
        return r100 / DisplayMetricsHolder.getScreenDisplayMetrics().density;
    }

    public static float b(float r100, float r101) {
        if (r101 > 0.0f) goto L6;
        r101 = DisplayMetricsHolder.getScreenDisplayMetrics().density;
    L6:
        return r100 * r101;
    }
}

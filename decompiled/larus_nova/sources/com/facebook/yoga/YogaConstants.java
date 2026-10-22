package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public class YogaConstants {
    public static final float UNDEFINED = Float.NaN;

    public YogaConstants() {
    }

    public static float getUndefined() {
        return Float.NaN;
    }

    public static boolean isUndefined(float r100) {
        if (Float.compare(r100, Float.NaN) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isUndefined(YogaValue r100) {
        if (r100.unit != YogaUnit.UNDEFINED) goto L5;
        return true;
    L5:
        return false;
    }
}

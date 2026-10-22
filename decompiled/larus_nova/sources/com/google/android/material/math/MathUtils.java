package com.google.android.material.math;

/* JADX INFO: loaded from: classes23.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static boolean geq(float r100, float r101, float r102) {
        if ((r100 + r102) < r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static float lerp(float r100, float r101, float r102) {
        return ((1.0f - r102) * r100) + (r102 * r101);
    }

    private static float max(float r100, float r101, float r102, float r103) {
        if (r100 <= r101) goto L10;
        if (r100 <= r102) goto L10;
        if (r100 <= r103) goto L10;
        return r100;
    L10:
        if (r101 <= r102) goto L15;
        if (r101 <= r103) goto L15;
        return r101;
    L15:
        if (r102 <= r103) goto L18;
        return r102;
    L18:
        return r103;
    }

    public static float dist(float r100, float r101, float r102, float r103) {
        return (float) Math.hypot(r102 - r100, r103 - r101);
    }

    public static float distanceToFurthestCorner(float r100, float r101, float r102, float r103, float r104, float r105) {
        return max(dist(r100, r101, r102, r103), dist(r100, r101, r104, r103), dist(r100, r101, r104, r105), dist(r100, r101, r102, r105));
    }
}

package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes41.dex */
public class MathUtils {
    public static final float EPSILON = 0.001f;

    private MathUtils() {
    }

    public static float clamp(float r100, float r101, float r102) {
        if (r101 <= r102) goto L5;
        float r103 = r102;
    L6:
        if (r101 > r102) goto L10;
        r101 = r102;
    L10:
        if (r100 >= r103) goto L13;
        return r103;
    L13:
        if (r100 > r101) goto L15;
        return r100;
    L15:
        return r101;
    L5:
        r103 = r101;
        goto L6
    }

    public static int clamp(int r100, int r101, int r102) {
        if (r101 <= r102) goto L4;
        int r103 = r102;
    L5:
        if (r101 > r102) goto L8;
        r101 = r102;
    L8:
        if (r100 < r103) goto L13;
        if (r100 > r101) goto L12;
        return r100;
    L12:
        return r101;
    L13:
        return r103;
    L4:
        r103 = r101;
        goto L5
    }

    public static long clamp(long r100, long r101, long r102) {
        if (r101 <= r102) goto L5;
        long r103 = r102;
    L6:
        if (r101 > r102) goto L10;
        r101 = r102;
    L10:
        if (r100 >= r103) goto L13;
        return r103;
    L13:
        if (r100 > r101) goto L15;
        return r100;
    L15:
        return r101;
    L5:
        r103 = r101;
        goto L6
    }

    public static int compareLongs(long r100, long r101) {
        if (r100 >= r101) goto L5;
        return -1;
    L5:
        if (r100 != r101) goto L7;
        return 0;
    L7:
        return 1;
    }

    public static float flipSignIf(float r100, boolean r101) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        return -r100;
    }

    public static int flipSignIf(int r100, boolean r101) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        return -r100;
    }

    public static float interpolate(float r100, float r101, float r102) {
        return r100 + ((r101 - r100) * r102);
    }

    public static float map(float r100, float r101, float r102, float r103, float r104) {
        return r103 + ((r104 - r103) * ((r100 - r101) / (r102 - r101)));
    }

    public static float smoothstep(float r100) {
        return (r100 * r100) * (3.0f - (r100 * 2.0f));
    }

    public static double roundTwoDecimalPlaces(double r100) {
        return Math.round(r100 * 100.0d) / 100.0d;
    }

    public static boolean areFloatsEqual(float r100, float r101) {
        if (Math.abs(r100 - r101) >= 0.001f) goto L5;
        return true;
    L5:
        return false;
    }

    public static int positiveModulo(int r100, int r101) {
        int r102 = r100 % r101;
        if (r102 < 0) goto L6;
        return r102;
    L6:
        return r102 + r101;
    }

    public static float scaleToFitTargetSize(int[] r100, int r101, int r102) {
        if (r100.length < 2) goto L11;
        int r103 = r100[0];
        if (r103 <= 0) goto L11;
        int r104 = r100[1];
        if (r104 <= 0) goto L11;
        float r105 = Math.max(r101 / r103, r102 / r104);
        r100[0] = (int) (r100[0] * r105);
        r100[1] = (int) (r100[1] * r105);
        return r105;
    L11:
        throw new IllegalArgumentException("Expected dimensions to have length >= 2 && dimensions[0] > 0 && dimensions[1] > 0");
    }

    public static float distance(float r100, float r101, float r102, float r103) {
        float r104 = r102 - r100;
        float r105 = r103 - r101;
        return (float) Math.sqrt((r104 * r104) + (r105 * r105));
    }
}

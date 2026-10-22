package com.facebook.yoga;

/* JADX INFO: loaded from: classes23.dex */
public class YogaMeasureOutput {
    public YogaMeasureOutput() {
    }

    public static float getHeight(long r100) {
        return Float.intBitsToFloat((int) (r100 & (-1)));
    }

    public static float getWidth(long r100) {
        return Float.intBitsToFloat((int) ((r100 >> 32) & (-1)));
    }

    public static long make(float r100, float r101) {
        int r102 = Float.floatToRawIntBits(r100);
        long r103 = ((long) r102) << 32;
        return ((long) Float.floatToRawIntBits(r101)) | r103;
    }

    public static long make(int r100, int r101) {
        return make(r100, r101);
    }
}

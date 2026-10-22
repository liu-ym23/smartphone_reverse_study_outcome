package com.ss.ttm.utils;

/* JADX INFO: loaded from: classes40.dex */
public class AVUtils {

    public static class ScaleInfo {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f457048h;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f457049w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f457050x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f457051y;

        public ScaleInfo() {
        }
    }

    public AVUtils() {
    }

    public static final ScaleInfo getScaleInfoFromSize(float r100, float r101, float r102, float r103) {
        ScaleInfo r104 = new ScaleInfo();
        float r105 = r100 / r101;
        r104.f457049w = (int) r102;
        int r106 = (int) (r102 / r105);
        r104.f457048h = r106;
        if (r106 >= r103) goto L5;
        r104.f457048h = (int) r103;
        r104.f457049w = (int) (r105 * r103);
    L5:
        int r107 = r104.f457048h;
        int r108 = ((int) (r107 - r103)) >> 1;
        r104.f457051y = r108;
        int r109 = r104.f457049w;
        int r110 = ((int) (r109 - r102)) >> 1;
        r104.f457050x = r110;
        if (r107 <= r103) goto L9;
        r104.f457051y = 0 - r108;
    L9:
        if (r109 <= r102) goto L11;
        r104.f457050x = 0 - r110;
    L11:
        return r104;
    }
}

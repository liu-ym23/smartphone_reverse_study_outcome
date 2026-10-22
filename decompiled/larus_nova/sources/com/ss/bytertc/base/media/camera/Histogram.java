package com.ss.bytertc.base.media.camera;

/* JADX INFO: loaded from: classes40.dex */
class Histogram {
    private final long handle;

    private static native void nativeAddSample(long r100, int r101);

    private static native long nativeCreateCounts(String r100, int r101, int r102, int r103);

    private static native long nativeCreateEnumeration(String r100, int r101);

    private Histogram(long r100) {
        this.handle = r100;
    }

    public void addSample(int r100) {
        nativeAddSample(this.handle, r100);
    }

    public static Histogram createEnumeration(String r100, int r101) {
        return new Histogram(nativeCreateEnumeration(r100, r101));
    }

    public static Histogram createCounts(String r100, int r101, int r102, int r103) {
        return new Histogram(nativeCreateCounts(r100, r101, r102, r103));
    }
}

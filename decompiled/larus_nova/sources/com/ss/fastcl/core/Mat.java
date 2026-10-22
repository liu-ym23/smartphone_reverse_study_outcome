package com.ss.fastcl.core;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class Mat {
    private static native int nativeCols(long r100);

    private static native long nativeNewMat(int r100, int r101, int r102, ByteBuffer r103);

    private static native void nativeRelease(long r100);

    private static native int nativeRows(long r100);

    private static native long nativeTotals(long r100);
}

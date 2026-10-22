package com.ss.bytertc.engine.utils;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class ByteBufferUtils {
    public ByteBufferUtils() {
    }

    public static native ByteBuffer nativeAllocateBuffer(int r100);

    public static native int nativeRGBAToI420(ByteBuffer r100, int r101, ByteBuffer r102, int r103, ByteBuffer r104, int r105, ByteBuffer r106, int r107, int r108, int r109);

    public static native void nativeReleaseBuffer(ByteBuffer r100);
}

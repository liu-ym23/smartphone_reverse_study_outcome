package com.ss.videoarch.strategy.utils;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class JniCommon {
    public static native void nativeAddRef(long r100);

    public static native ByteBuffer nativeAllocateByteBuffer(int r100);

    public static native void nativeFreeByteBuffer(ByteBuffer r100);

    public static native void nativeReleaseRef(long r100);

    public JniCommon() {
    }
}

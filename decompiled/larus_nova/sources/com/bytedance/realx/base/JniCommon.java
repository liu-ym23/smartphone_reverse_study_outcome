package com.bytedance.realx.base;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes21.dex */
public class JniCommon {
    public JniCommon() {
    }

    public static native void nativeAddRef(long r100);

    public static native ByteBuffer nativeAllocateByteBuffer(int r100);

    public static native void nativeFreeByteBuffer(ByteBuffer r100);

    public static native void nativeReleaseRef(long r100);
}

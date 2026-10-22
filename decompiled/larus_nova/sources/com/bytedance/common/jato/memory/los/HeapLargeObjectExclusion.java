package com.bytedance.common.jato.memory.los;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class HeapLargeObjectExclusion {
    public HeapLargeObjectExclusion() {
    }

    public static native long getLargeObjectAllocatedBytes();

    public static native boolean nativeExcludeLOS();

    public static native void nativeLargeObjectThresholdBalance(float r100, float r101, long r102);

    public static native boolean nativeSetLargeObjectThreshold(int r100);

    public static native boolean nativeSetLargeObjectThresholdByByteSize(int r100);

    public static native void nativeShadowHookWhenVtableFail();

    public static native void nativeUseNewFree();

    public static native void needGcBlock(boolean r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}

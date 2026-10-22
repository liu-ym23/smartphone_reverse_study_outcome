package com.ss.android.ttve.nativePort;

import com.ss.android.ttve.model.VEFrame;

/* JADX INFO: loaded from: classes38.dex */
public final class TEUtils {
    public TEUtils() {
    }

    public static native long nativeCreateNativeFrame(VEFrame r100);

    public static native long nativeGetPThreadId();

    public static native void nativeHookImageCopy();

    public static native void nativeSetEncodeThreadId(long r100);

    public static native int nativeTransPixels2Bitmap(byte[] r100, int r101, int r102);

    public static native boolean nativeTryExecute(Runnable r100);
}

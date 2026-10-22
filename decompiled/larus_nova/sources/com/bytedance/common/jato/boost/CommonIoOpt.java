package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class CommonIoOpt {
    public CommonIoOpt() {
    }

    private static native int nativeGetPriority(int r100);

    private static native void nativeSetPriority(String[] r100, String[] r101, String[] r102);

    private static native void nativeSetPriorityWithTid(int[] r100, int[] r101, int[] r102);

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void setPriority(String[] r100, String[] r101, String[] r102) {
        nativeSetPriority(r100, r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}

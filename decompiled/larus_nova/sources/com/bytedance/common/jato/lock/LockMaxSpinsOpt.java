package com.bytedance.common.jato.lock;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class LockMaxSpinsOpt {
    public LockMaxSpinsOpt() {
    }

    private static native void nativeSetMaxSpins(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void setLockMaxSpins(int r100) {
        nativeSetMaxSpins(r100);
    }
}

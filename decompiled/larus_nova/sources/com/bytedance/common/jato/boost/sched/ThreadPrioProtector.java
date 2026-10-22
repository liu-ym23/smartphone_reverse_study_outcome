package com.bytedance.common.jato.boost.sched;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class ThreadPrioProtector {
    public ThreadPrioProtector() {
    }

    public static native void addThreadPrioProtect(int r100, int r101, int r102);

    public static native void nativeInit();

    public static native void setPrioProtectEnabled(boolean r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}

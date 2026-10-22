package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class YoungGcOpt {
    public YoungGcOpt() {
    }

    public static native boolean doYoungGcOpt(double r100);

    public static native void threadCpuTimeOpt();

    static {
        JatoNativeLoader.loadLibrary();
    }
}

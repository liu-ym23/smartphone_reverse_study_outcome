package com.bytedance.common.jato.scheduler;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class ClassVisiblyInitializedOpt {
    public ClassVisiblyInitializedOpt() {
    }

    public static native void enable();

    public static native void setMax(int r100);

    public static native void setUseMembarrier(boolean r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}

package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class CmcGcPageFaultOpt {
    public CmcGcPageFaultOpt() {
    }

    public static native void setBlackDenseRegionThreshold(int r100);

    public static native void setPageFaultThreadPriority(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }
}

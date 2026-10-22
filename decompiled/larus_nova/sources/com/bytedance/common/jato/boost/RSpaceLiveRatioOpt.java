package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class RSpaceLiveRatioOpt {
    public RSpaceLiveRatioOpt() {
    }

    private static native int nRegionSpaceLiveRatioOpt(int r100, int r101);

    private static native void nResetRegionSpaceLiveRatioOpt();

    static {
        JatoNativeLoader.loadLibrary();
    }
}

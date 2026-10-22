package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class PrePageFaultOpt {
    public PrePageFaultOpt() {
    }

    public static native boolean mlockCodeItem(int r100);

    public static native void munlockCodeItem();

    public static native void munlockInBackground();

    private static native boolean prePageFaultInner(int r100, int r101);

    public static native boolean reclaimCodeItem(int r100);

    public static native boolean reclaimPluginCodeItem(int r100, String r101, ClassLoader r102);

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void prePageFault(int r100, int r101) {
        prePageFaultInner(r100, r101);
    }
}

package com.bytedance.common.jato.gfx;

import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class RenderThreadPreloadOpt {
    public RenderThreadPreloadOpt() {
    }

    private static native void nativePreload(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void preload(int r100) {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        nativePreload(r100);
    }
}

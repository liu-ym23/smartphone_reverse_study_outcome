package com.bytedance.common.jato.gfx;

import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class BlastBufferQueueOpt {
    public BlastBufferQueueOpt() {
    }

    private static native void nativeHookPreload();

    public static void preload() {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        nativeHookPreload();
    }

    static {
        JatoNativeLoader.loadLibrary();
    }
}

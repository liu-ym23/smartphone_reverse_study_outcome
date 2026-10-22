package com.bytedance.common.jato.gfx;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class RenderThreadUnblockOpt {
    public RenderThreadUnblockOpt() {
    }

    private static native int nativeUnblockRenderThreadTask(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void unblockTask(int r100) {
        nativeUnblockRenderThreadTask(r100);
    }
}

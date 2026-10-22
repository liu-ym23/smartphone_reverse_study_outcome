package com.bytedance.common.jato.gfx;

import com.bytedance.common.jato.JatoNativeLoader;
import erc.a;

/* JADX INFO: loaded from: classes15.dex */
public class GLESInitBoost {
    private static boolean sInited;

    public GLESInitBoost() {
    }

    public static native int nativeBoost(boolean r100);

    public static synchronized void init(boolean r100) {
        monitor-enter(GLESInitBoost.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (sInited == false) goto L9;
        monitor-exit(GLESInitBoost.class);
        return;
    L9:
        sInited = true;     // Catch: Throwable -> L16
        if (JatoNativeLoader.loadLibrary() == true) goto L13;
        monitor-exit(GLESInitBoost.class);
        return;
    L13:
        a.a();     // Catch: Throwable -> L16
        nativeBoost(r100);     // Catch: Throwable -> L16
        monitor-exit(GLESInitBoost.class);
    }
}

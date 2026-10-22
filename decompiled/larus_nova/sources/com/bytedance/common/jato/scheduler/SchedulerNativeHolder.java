package com.bytedance.common.jato.scheduler;

import android.content.Context;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes3.dex */
class SchedulerNativeHolder {
    private static boolean sInited;

    public SchedulerNativeHolder() {
    }

    public static native int nativeInit(int r100, int r101, Context r102);

    public static synchronized boolean ensureInited() {
        monitor-enter(SchedulerNativeHolder.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sInited == false) goto L7;
    L9:
        boolean r100 = sInited;     // Catch: Throwable -> L12
        monitor-exit(SchedulerNativeHolder.class);
        return r100;
    L7:
        if (JatoNativeLoader.loadLibrary() == false) goto L9;
        sInited = true;     // Catch: Throwable -> L12
        goto L9
    }
}

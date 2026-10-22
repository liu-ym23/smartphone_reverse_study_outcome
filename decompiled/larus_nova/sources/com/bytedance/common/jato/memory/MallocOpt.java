package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;
import erc.a;

/* JADX INFO: loaded from: classes15.dex */
public class MallocOpt {
    private static final Object sJeOptLock = null;
    private static boolean sJeTcacheOptimized;
    private static final Object sScuOptLock = null;
    private static boolean sScuTcacheOptimized;
    private static final Object sTcacheGCOptLock = null;
    private static boolean sTcacheGCOptimized;

    public MallocOpt() {
    }

    private static native void nativeOptJeTcache(boolean r100);

    private static native void nativeOptScudoTsd(int r100);

    private static native void nativeOptTcacheGC(int r100, int r101);

    static {
        sJeOptLock = new Object();
        sScuTcacheOptimized = false;
        sScuOptLock = new Object();
        sTcacheGCOptimized = false;
        sTcacheGCOptLock = new Object();
    }

    public static void optJeTcache(boolean r100) {
        Object r101 = sJeOptLock;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sJeTcacheOptimized == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L8:
        sJeTcacheOptimized = true;     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        if (JatoNativeLoader.loadLibrary() == true) goto L13;
        return;
    L13:
        a.b();
        nativeOptJeTcache(r100);
    }

    public static void optScuTsd(int r100) {
        Object r101 = sScuOptLock;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sScuTcacheOptimized == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L8:
        sScuTcacheOptimized = true;     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        if (JatoNativeLoader.loadLibrary() == true) goto L13;
        return;
    L13:
        a.b();
        nativeOptScudoTsd(r100);
    }

    public static void optTcacheGC(int r100, int r101) {
        Object r102 = sTcacheGCOptLock;
        monitor-enter(r102);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sTcacheGCOptimized == false) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L15
        return;
    L8:
        sTcacheGCOptimized = true;     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        if (JatoNativeLoader.loadLibrary() == true) goto L13;
        return;
    L13:
        a.b();
        nativeOptTcacheGC(r100, r101);
    }
}

package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes22.dex */
public class ScudoMallopt {
    public static final int M_CACHE_COUNT_MAX = -200;
    public static final int M_CACHE_SIZE_MAX = -201;
    public static final int M_DECAY_TIME = -100;
    public static final int M_LOG_STATS = -205;
    public static final int M_MEMTAG_TUNING = -102;
    public static final int M_PURGE = -101;
    public static final int M_PURGE_ALL = -104;
    public static final int M_THREAD_DISABLE_MEM_INIT = -103;
    public static final int M_TSDS_COUNT_MAX = -202;
    private static final String TAG = "ScudoMallopt";

    public ScudoMallopt() {
    }

    private static native boolean is_scudo_allocator();

    private static native boolean set_option(int r100, int r101);

    public static boolean isScudoAllocator(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L11;
        return false;
    L11:
        if (is_scudo_allocator() == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public static synchronized boolean setOption(Context r100, int r101, int r102) {
        monitor-enter(ScudoMallopt.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L21;
    L12:
        monitor-exit(ScudoMallopt.class);
        return false;
    L21:
        if (set_option(r101, r102) == false) goto L12;
        monitor-exit(ScudoMallopt.class);
        return true;
        goto L12
    }
}

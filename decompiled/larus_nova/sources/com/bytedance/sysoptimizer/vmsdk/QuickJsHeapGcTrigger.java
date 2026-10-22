package com.bytedance.sysoptimizer.vmsdk;

import android.content.Context;
import com.bytedance.sysoptimizer.SysOptimizer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes22.dex */
public class QuickJsHeapGcTrigger {
    private static final String TAG = "QuickJsHeapGcTrigger";
    private static final AtomicBoolean loadedFlag = null;

    public QuickJsHeapGcTrigger() {
    }

    private static native boolean gcNative();

    static {
        loadedFlag = new AtomicBoolean(false);
    }

    private static synchronized boolean ensureLoaded(Context r100) {
        monitor-enter(QuickJsHeapGcTrigger.class);
        AtomicBoolean r101 = loadedFlag;     // Catch: Throwable -> L15
        if (r101.get() == false) goto L19;
        monitor-exit(QuickJsHeapGcTrigger.class);
        return true;
    L19:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L12;
        r101.set(true);     // Catch: Throwable -> L18
    L12:
        boolean r102 = loadedFlag.get();     // Catch: Throwable -> L15
        monitor-exit(QuickJsHeapGcTrigger.class);
        return r102;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean gc(Context r100) {
        if (ensureLoaded(null) == true) goto L7;
        return false;
    L7:
        return gcNative();
    }

    public static boolean init(Context r100) {
        return ensureLoaded(r100);
    }
}

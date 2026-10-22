package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.bytehook.ByteHook;

/* JADX INFO: loaded from: classes22.dex */
public class AcodecHandler {
    private static final String TAG = "AcodecHandler";
    private static volatile boolean mInit;

    public AcodecHandler() {
    }

    private static native void fixAcodecMessage();

    private static boolean inAndroid4x() {
        return false;
    }

    private static boolean inAndroid5x() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 != 21) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 22) goto L8;
        return false;
    }

    public static synchronized void fixAcodecMessage(Context r100) {
        monitor-enter(AcodecHandler.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (inAndroid4x() == true) goto L9;
        if (inAndroid5x() == true) goto L9;
    L11:
        monitor-exit(AcodecHandler.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L11;
        ByteHook.init();     // Catch: Throwable -> L13
        fixAcodecMessage();     // Catch: Throwable -> L13
        goto L11
    }
}

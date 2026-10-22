package com.bytedance.sysoptimizer.fake.name;

import android.content.Context;
import android.os.Build;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class SmFakeNameHandler {
    private static String TAG = "SYSOPTIMIZER";
    private static volatile boolean inited;

    public SmFakeNameHandler() {
    }

    private static native void replace(int r100);

    private static boolean inAndroid5x() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 != 22) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 21) goto L8;
        return false;
    }

    private static boolean shouldFix() {
        if (inAndroid5x() == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.MODEL.startsWith("SM-") == false) goto L7;
        return true;
    }

    public static synchronized void start(Context r100) {
        monitor-enter(SmFakeNameHandler.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (shouldFix() == true) goto L9;
        monitor-exit(SmFakeNameHandler.class);
        return;
    L9:
        if (inited == false) goto L13;
        monitor-exit(SmFakeNameHandler.class);
        return;
    L13:
        inited = true;     // Catch: Throwable -> L18
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L24;
    L16:
        monitor-exit(SmFakeNameHandler.class);
        return;
    L24:
        replace(Build.VERSION.SDK_INT);     // Catch: Throwable -> L21 Throwable -> L18
        goto L16
    }
}

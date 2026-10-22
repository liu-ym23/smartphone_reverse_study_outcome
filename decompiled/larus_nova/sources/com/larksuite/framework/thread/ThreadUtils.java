package com.larksuite.framework.thread;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes24.dex */
public class ThreadUtils {
    private static Handler sHandler;

    public ThreadUtils() {
    }

    static {
        sHandler = new w(Looper.getMainLooper());
    }

    public static void runOnUIThread(Runnable r100) {
        runOnUIThread(r100, 0);
    }

    public static void runOnUIThread(Runnable r100, long r101) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
    L7:
        sHandler.postDelayed(r100, r101);
        return;
    L5:
        if (r101 > 0) goto L7;
        r100.run();
    }
}

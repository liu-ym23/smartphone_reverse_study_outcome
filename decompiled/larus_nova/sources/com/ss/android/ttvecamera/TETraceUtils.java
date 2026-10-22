package com.ss.android.ttvecamera;

import android.os.Build;
import android.os.Trace;

/* JADX INFO: loaded from: classes38.dex */
public class TETraceUtils {
    private static boolean sEnableTrace;

    public TETraceUtils() {
    }

    public static void endSection() {
        if (sEnableTrace == true) goto L5;
        return;
    L5:
        Trace.endSection();
    }

    public static void beginSection(String r100) {
        if (sEnableTrace == true) goto L5;
        return;
    L5:
        Trace.beginSection(r100);
    }

    public static synchronized void init(boolean r100) {
        monitor-enter(TETraceUtils.class);
        sEnableTrace = r100;     // Catch: Throwable -> L7
        monitor-exit(TETraceUtils.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void beginAsyncSection(String r100, int r101) {
        if (sEnableTrace == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        Trace.beginAsyncSection(r100, r101);
        return;
    }

    public static void endAsyncSection(String r100, int r101) {
        if (sEnableTrace == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        Trace.endAsyncSection(r100, r101);
        return;
    }
}

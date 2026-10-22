package com.lynx.clay.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f380953a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Handler f380954b;

    public a() {
    }

    static {
        f380953a = new Object();
    }

    public static Handler a() {
        if (f380954b != null) goto L5;
        Looper r100 = Looper.getMainLooper();
        Object r101 = f380953a;
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L9:
        if (f380954b != null) goto L12;
        f380954b = new Handler(r100);     // Catch: Throwable -> L18
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L18
        return f380954b;
    L12:
        if (f380954b.getLooper() == r100) goto L13;
        throw new RuntimeException("UI thread looper is already set to " + f380954b.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + r100);     // Catch: Throwable -> L18
    L5:
        return f380954b;
    }
}

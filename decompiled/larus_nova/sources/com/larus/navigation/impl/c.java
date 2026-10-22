package com.larus.navigation.impl;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes30.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f359816a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f359817b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f359818c;

    public c() {
    }

    static {
        f359816a = new c();
        f359817b = new Handler(Looper.getMainLooper());
    }

    public final synchronized boolean a() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f359818c == null) goto L7;
        boolean r100 = true;
    L9:
        if (f359818c == null) goto L11;
        int r101 = com.larus.navigation.api.c.f359656a;     // Catch: Throwable -> L14
        com.larus.navigation.api.c.d("kmp_event", "arrival banner remove cancelled (was navId=" + f359818c + ')');     // Catch: Throwable -> L14
    L11:
        f359818c = null;     // Catch: Throwable -> L14
        f359817b.removeCallbacksAndMessages(null);     // Catch: Throwable -> L14
        monitor-exit(this);
        return r100;
    L7:
        r100 = false;
        goto L9
    }
}

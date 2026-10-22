package com.vivo.push;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes41.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f462619a;

    public final synchronized boolean a() {
        monitor-enter(this);
        long r100 = this.f462619a;     // Catch: Throwable -> L14
        long r101 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (r100 != (-1)) goto L6;
    L10:
        boolean r102 = false;
    L11:
        this.f462619a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r102;
    L6:
        if (r101 <= r100) goto L10;
        if (r101 >= (r100 + 2000)) goto L10;
        r102 = true;
    L14:
        th = move-exception;
        throw th;
    }

    public y() {
        this.f462619a = -1;
    }
}

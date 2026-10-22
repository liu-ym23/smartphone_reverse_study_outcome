package com.lynx.clay.embedding.android;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f380659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f380660b;

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L23;
        throw th;
    L23:
        return;
    L3:
        if (this.f380659a == this.f380660b.f380648g) goto L5;
        return;
    L5:
        if (this.f380660b.f380646e == true) goto L20;
        d r100 = this.f380660b;     // Catch: Throwable -> L13
        if (r100.f380642a != null) goto L9;
        return;
    L9:
        if (r100.f380643b == null) goto L22;
        c5a.c.d(5, "ClayViewProvider", "enableMemoryPressurePolling() was not called; enabling fallback polling.");     // Catch: Throwable -> L13
        this.f380660b.a();     // Catch: Throwable -> L13
        return;
    L22:
        return;
    }

    public e(d r100, int r101) {
        this.f380660b = r100;
        this.f380659a = r101;
    }
}

package com.lynx.clay.embedding.android;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f380681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SurfaceSnapshotController f380682b;

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceSnapshotController r100 = this.f380682b;     // Catch: Throwable -> L18
        if (r100.f380602l != this) goto L21;
        r100.f380602l = null;     // Catch: Throwable -> L18
        if (r100.f380600j == this.f380681a) goto L8;
        return;
    L8:
        if (r100.f380595e == SurfaceSnapshotController.OverlayState.FOREGROUND_VISIBLE) goto L10;
        return;
    L10:
        if (r100.f(2) == false) goto L12;
        return;
    L12:
        if (this.f380682b.f(1) == true) goto L14;
        return;
    L14:
        if (this.f380682b.f(4) == false) goto L29;
        this.f380682b.u(0);     // Catch: Throwable -> L18
        return;
    L29:
        return;
    L21:
        return;
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L30;
        throw th;
    }

    public r(SurfaceSnapshotController r100, int r101) {
        this.f380682b = r100;
        this.f380681a = r101;
    }
}

package com.lynx.animax.player;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f380387a;

    @Override // java.lang.Runnable
    public final void run() {
        h r100 = this.f380387a;     // Catch: Throwable -> L8
        boolean r101 = true;
        r100.f380349g = true;     // Catch: Throwable -> L8
        if (r100.f380348f > 0) goto L6;
        r101 = false;
    L6:
        r100.f380350h = r101;     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }

    public j(h r100) {
        this.f380387a = r100;
    }
}

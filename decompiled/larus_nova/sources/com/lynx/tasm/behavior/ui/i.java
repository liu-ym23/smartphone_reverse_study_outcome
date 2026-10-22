package com.lynx.tasm.behavior.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f382557a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f382557a.c();     // Catch: Throwable -> L4
        this.f382557a.f382534v.clear();     // Catch: Throwable -> L4
        h r100 = this.f382557a;     // Catch: Throwable -> L4
        r100.q(r100.f382536x, "disexposure");     // Catch: Throwable -> L4
        this.f382557a.f382536x.clear();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public i(h r100) {
        this.f382557a = r100;
    }
}

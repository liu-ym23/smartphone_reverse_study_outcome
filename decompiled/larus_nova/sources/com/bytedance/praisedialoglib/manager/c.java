package com.bytedance.praisedialoglib.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f266648a;

    @Override // java.lang.Runnable
    public final void run() {
        z57.b.f570113b = false;     // Catch: Throwable -> L5
        this.f266648a.f266650b.f(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L9;
        return;
    L9:
        throw th;
    }

    public c(d r100) {
        this.f266648a = r100;
    }
}

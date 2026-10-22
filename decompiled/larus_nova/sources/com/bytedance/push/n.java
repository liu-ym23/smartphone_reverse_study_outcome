package com.bytedance.push;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f266895a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f266895a.getClass();     // Catch: Throwable -> L4
        t.c();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(t r100) {
        this.f266895a = r100;
    }
}

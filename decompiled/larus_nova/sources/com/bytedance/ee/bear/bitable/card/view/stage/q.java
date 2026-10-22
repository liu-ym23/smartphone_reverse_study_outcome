package com.bytedance.ee.bear.bitable.card.view.stage;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f208763a;

    public q(o r100) {
        this.f208763a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f208763a.f208752k = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

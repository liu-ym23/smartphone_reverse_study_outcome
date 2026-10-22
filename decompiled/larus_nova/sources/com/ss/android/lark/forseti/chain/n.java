package com.ss.android.lark.forseti.chain;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiChainFragment f424420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f424421b;

    public n(ForsetiChainFragment r100) {
        this.f424420a = r100;
        this.f424421b = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f424420a.ca0().f(this.f424421b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

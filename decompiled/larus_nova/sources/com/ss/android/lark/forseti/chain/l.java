package com.ss.android.lark.forseti.chain;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiChainFragment f424416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f424417b;

    public l(ForsetiChainFragment r100, boolean r101) {
        this.f424416a = r100;
        this.f424417b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f424416a.ca0().c(this.f424417b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

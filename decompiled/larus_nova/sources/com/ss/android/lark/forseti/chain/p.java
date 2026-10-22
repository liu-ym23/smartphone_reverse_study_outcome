package com.ss.android.lark.forseti.chain;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiChainFragment f424424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f424425b;

    public p(ForsetiChainFragment r100, int r101) {
        this.f424424a = r100;
        this.f424425b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f424424a.ca0().d(this.f424425b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package com.ss.android.lark.forseti.chain;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiChainFragment f424418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f424419b;

    public m(ForsetiChainFragment r100, int r101) {
        this.f424418a = r100;
        this.f424419b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f424418a.ca0().b(this.f424419b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

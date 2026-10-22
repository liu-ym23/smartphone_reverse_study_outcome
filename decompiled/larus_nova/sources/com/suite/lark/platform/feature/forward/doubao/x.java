package com.suite.lark.platform.feature.forward.doubao;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForwardDoubaoActivity f461373a;

    public x(ForwardDoubaoActivity r100) {
        this.f461373a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ForwardDoubaoActivity r100 = this.f461373a;     // Catch: Throwable -> L4
        r100.f461266o = false;     // Catch: Throwable -> L4
        r100.B1();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

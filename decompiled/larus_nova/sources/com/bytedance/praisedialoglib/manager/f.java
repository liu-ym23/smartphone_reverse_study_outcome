package com.bytedance.praisedialoglib.manager;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.a f266653a;

    @Override // java.lang.Runnable
    public final void run() {
        g r100 = this.f266653a.f266658a;     // Catch: Throwable -> L4
        r100.f266657d.i(r100.f266655b, r100.f266656c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(g.a r100) {
        this.f266653a = r100;
    }
}

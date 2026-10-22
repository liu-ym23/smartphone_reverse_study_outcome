package com.ss.android.lark.conditional.access.auth.v2.handler;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f417817a;

    public d(e r100) {
        this.f417817a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r100 = this.f417817a;     // Catch: Throwable -> L4
        r100.f417819b.invoke(r100.f417821d);     // Catch: Throwable -> L4
        e r101 = this.f417817a;     // Catch: Throwable -> L4
        r101.getClass();     // Catch: Throwable -> L4
        r101.f417820c = System.currentTimeMillis();     // Catch: Throwable -> L4
        r101.f417821d.clear();     // Catch: Throwable -> L4
        r101.f417822e = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

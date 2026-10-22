package com.unionpay;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class j implements Runnable {
    public j() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        new wpc.b(a.f462143r, com.unionpay.utils.b.a(a.k())).b();     // Catch: Throwable -> L4 Exception -> L10
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    }
}

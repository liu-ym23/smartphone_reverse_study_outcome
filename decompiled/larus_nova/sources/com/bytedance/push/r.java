package com.bytedance.push;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        p77.b.a().b(c.O.f266761a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public r() {
    }
}

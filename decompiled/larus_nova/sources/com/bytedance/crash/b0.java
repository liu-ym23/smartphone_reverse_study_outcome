package com.bytedance.crash;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        bi4.a.d();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b0() {
    }
}

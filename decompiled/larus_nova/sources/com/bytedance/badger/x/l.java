package com.bytedance.badger.x;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements Runnable {
    public l() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((c0) p.f199395b).a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

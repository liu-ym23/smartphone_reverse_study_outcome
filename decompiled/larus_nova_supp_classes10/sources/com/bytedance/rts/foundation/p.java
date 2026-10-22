package com.bytedance.rts.foundation;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements Runnable {
    public final /* synthetic */ n a;

    public p(n r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

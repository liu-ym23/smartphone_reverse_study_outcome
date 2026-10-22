package com.bytedance.rts.foundation;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o implements Runnable {
    public final /* synthetic */ s a;

    public o(s r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.a(this.a.e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

package com.bytedance.ee.bear.drive.core.fragment;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class s implements Runnable {
    public final /* synthetic */ r a;

    public s(r r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r r0 = this.a;     // Catch: Throwable -> L6
        if (r0.k == true) goto L9;
        r0.a();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

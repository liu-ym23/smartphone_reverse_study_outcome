package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements Runnable {
    public final /* synthetic */ VisibleLogManager a;

    public i(VisibleLogManager r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VisibleLogManager.a(this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

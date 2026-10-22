package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ c.a a;

    public b(c.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.d.i.a(false, "pause");     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

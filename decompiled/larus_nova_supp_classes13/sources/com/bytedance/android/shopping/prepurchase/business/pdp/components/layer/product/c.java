package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ BaseInfoServiceSnapshotTransitionController a;
    public final /* synthetic */ int b;
    public final /* synthetic */ boolean c;

    public c(BaseInfoServiceSnapshotTransitionController r1, int r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.b;     // Catch: Throwable -> L8
        BaseInfoServiceSnapshotTransitionController r1 = this.a;     // Catch: Throwable -> L8
        if (r0 == r1.h) goto L5;
        return;
    L5:
        if (r1.i == true) goto L15;
        r1.i(this.c);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}

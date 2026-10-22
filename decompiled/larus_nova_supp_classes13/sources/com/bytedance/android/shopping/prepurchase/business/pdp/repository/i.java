package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements Runnable {
    public final /* synthetic */ PdpDataFetchService a;

    public i(PdpDataFetchService r1) {
        this.a = r1;
    }

    public final void a() {
        com.bytedance.android.shopping.anchorv4.data.k r0 = AnchorV4DataManager.a;
        AnchorV4DataManager.s(this.a.c2(), this.a);
        AnchorV4DataManager.s(this.a.c2(), new FirstScreenResponseWatcher(this.a.c2(), this.a.P1(), this.a.R1()));
        AnchorV4DataManager.t(this.a.c2(), this.a);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

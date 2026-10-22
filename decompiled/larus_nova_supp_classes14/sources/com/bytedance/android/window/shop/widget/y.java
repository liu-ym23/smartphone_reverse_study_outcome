package com.bytedance.android.window.shop.widget;

import com.bytedance.android.ec.window.base.product.lynxcard.ECLynxCardEvent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y implements Runnable {
    public final /* synthetic */ WindowTypeSeparatedAdapter a;
    public final /* synthetic */ ECLynxCardEvent b;
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.f c;

    public y(WindowTypeSeparatedAdapter r1, ECLynxCardEvent r2, com.bytedance.android.window.shop.repository.tab.entity.f r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r0 = this.a.n.get(this.b);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        com.bytedance.android.window.shop.repository.tab.entity.f r1 = this.c;     // Catch: Throwable -> L6
        WindowTypeSeparatedAdapter r2 = this.a;     // Catch: Throwable -> L6
        r0.a(r1, r2.h, r2);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

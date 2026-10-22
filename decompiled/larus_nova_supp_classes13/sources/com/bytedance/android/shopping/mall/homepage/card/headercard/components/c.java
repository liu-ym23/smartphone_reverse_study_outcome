package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.CycleActivityView41;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ CycleActivityView41 a;

    public c(CycleActivityView41 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.b r0 = this.a.j;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.cancel();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}

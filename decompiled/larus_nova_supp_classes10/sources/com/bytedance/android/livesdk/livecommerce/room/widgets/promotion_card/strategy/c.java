package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ QueryWithMsgCacheCardShowStrategy.c a;

    public c(QueryWithMsgCacheCardShowStrategy.c r1) {
        this.a = r1;
    }

    public final void a() {
        dm.a.b r0 = dm.a.a;
        String r1 = QueryWithMsgCacheCardShowStrategy.p;
        dm.a.a(r1).a(">>> [" + (System.currentTimeMillis() / 1000) + "] card " + this.a.b.getPromotionId() + " show by auto host");
        QueryWithMsgCacheCardShowStrategy.c r2 = this.a;
        r2.a.n.b(r2.b.getPromotionId());
        QueryWithMsgCacheCardShowStrategy.c r3 = this.a;
        if (r3.a.n.a(r3.b.getPromotionId()) == true) goto L8;
        dm.a.a(r1).a("times of auto display exceeds threshold of show times, stop task.");
        this.a.a.f("ShowTimesThreshold");
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r4 = this.a.a.i;
        if (r4 == null) goto L9;
        r4.cancel();
        return;
    L9:
        return;
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

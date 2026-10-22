package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements Runnable {
    public final /* synthetic */ PromotionListEventActionImplV2 a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.bytedance.android.btm.api.model.d d;

    public v(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, String r3, com.bytedance.android.btm.api.model.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        sg2.v r0 = new sg2.v("livesdk_show_auction_hot_sale", this.b);     // Catch: Throwable -> L4
        r0.c("atmosphere_type", this.c);     // Catch: Throwable -> L4
        PromotionListEventActionImplKt.a(r0, this.a.a, this.d.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}

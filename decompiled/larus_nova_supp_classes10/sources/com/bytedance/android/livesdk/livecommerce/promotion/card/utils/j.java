package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECGivenProductStruck;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ PromotionListEventActionImpl a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ int c;
    public final /* synthetic */ ECUIPromotion d;

    public j(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, int r3, ECUIPromotion r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        sg2.v r0 = new sg2.v("livesdk_ecom_gift_bar_click", this.b);
        r0.a("order", this.c);
        ECGivenProductStruck r1 = this.d.givenProduct;
        if (r1 == null) goto L7;
        Map r2 = r1.getEventParams();
        if (r2 == null) goto L7;
        r0.d(r2);
    L7:
        PromotionListEventActionImplKt.a(r0, this.a.a, null);
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

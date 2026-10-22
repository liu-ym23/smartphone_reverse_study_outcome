package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECGivenProductStruck;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l implements Runnable {
    public final /* synthetic */ PromotionListEventActionImpl a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ ECUIPromotion c;

    public l(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, ECUIPromotion r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        sg2.v r0 = new sg2.v("livesdk_ecom_gift_bar_show", this.b);
        ECGivenProductStruck r1 = this.c.givenProduct;
        if (r1 == null) goto L7;
        List r2 = r1.getProducts();
        if (r2 == null) goto L7;
        int r3 = r2.size();
    L8:
        r0.a("product_cnt", r3);
        ECGivenProductStruck r4 = this.c.givenProduct;
        if (r4 == null) goto L13;
        Map r5 = r4.getEventParams();
        if (r5 == null) goto L13;
        r0.d(r5);
    L13:
        PromotionListEventActionImplKt.a(r0, this.a.a, null);
        return;
    L7:
        r3 = 0;
        goto L8
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

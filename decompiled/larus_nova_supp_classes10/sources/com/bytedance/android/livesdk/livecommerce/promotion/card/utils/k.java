package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements Runnable {
    public final /* synthetic */ PromotionListEventActionImpl a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ ECHotAtmosphere c;
    public final /* synthetic */ ECUIPromotion d;

    public k(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, ECHotAtmosphere r3, ECUIPromotion r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        sg2.v r0 = new sg2.v("livesdk_show_hot_sale", this.b);
        ECHotAtmosphere r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.getNumInt();
    L6:
        r0.a("hot_sale_num", r2);
        ECHotAtmosphere r3 = this.c;
        if (r3 == null) goto L10;
        String r4 = r3.getTypeStr();
        if (r4 == null) goto L10;
    L11:
        r0.c("hot_sale_type", r4);
        r0.c("product_id", this.d.getProductId());
        PromotionListEventActionImplKt.a(r0, this.a.a, null);
        return;
    L10:
        r4 = this.d.getHotSaleTypeStr();
        goto L11
    L5:
        r2 = this.d.getHotAtmosphereSaleNum();
        goto L6
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

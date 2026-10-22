package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p implements Runnable {
    public final /* synthetic */ PromotionListEventActionImpl a;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    public p(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        LiveRoomParams r0 = this.b.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.g r1 = this.b;
        ECUIPromotion r2 = r1.a;
        if (r2 == null) goto L18;
        ECUIPromotion r3 = r2;
        sg2.v r4 = new sg2.v(this.c, r1);
        if (r0 == null) goto L7;
        String r5 = r0.getAuthorId();
    L8:
        String r6 = "";
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        r4.c("author_id", r5);
        r4.c("commodity_id", r3.getPromotionId());
        r4.c("commodity_type", r3.getEventItemType());
        r4.c("product_id", r3.getProductId());
        r4.a("with_sku", !r3.getSingleSku() ? 1 : 0);
        String r7 = r3.fragmentId;
        if (r7 == null) goto L15;
        r6 = r7;
    L15:
        r4.c("fragment_id", r6);
        r4.d(r3.getEventParams());
        PromotionListEventActionImplKt.a(r4, this.a.a, this.d);
        return;
    L7:
        r5 = null;
        goto L8
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
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

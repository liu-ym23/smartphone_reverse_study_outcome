package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.event.y1;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements Runnable {
    public final /* synthetic */ RoomContextController a;
    public final /* synthetic */ ECUIPromotion b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Map d;

    public n(RoomContextController r1, ECUIPromotion r2, long r3, Map r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void a() {
        y1 r0 = new y1(this.a);
        r0.f("product_id", this.b.getProductId());
        r0.f("commodity_id", this.b.getPromotionId());
        r0.f("duration", String.valueOf(this.c));
        r0.f("ecom_entrance_form", "live_popup_card");
        r0.m(this.d);
        r0.k();
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

package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.event.v;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements Runnable {
    public final /* synthetic */ RoomContextController a;
    public final /* synthetic */ ml.b b;
    public final /* synthetic */ ECUIPromotion c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Map e;

    public h(RoomContextController r1, ml.b r2, ECUIPromotion r3, boolean r4, Map r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        v r0 = new v(this.a);
        r0.f("room_id", this.b.roomId());
        r0.f("anchor_id", this.b.c());
        r0.f("product_label", this.c.getEventLabel());
        r0.f("commodity_id", this.c.getPromotionId());
        r0.f("commodity_type", this.c.getEventItemType());
        r0.f("is_groupbuying", this.c.getIsGroupBuying());
        if (this.d == false) goto L5;
        String r1 = BDLocationException.ERROR_TIMEOUT;
    L6:
        r0.f("screen_type", r1);
        r0.m(this.e);
        r0.k();
        return;
    L5:
        r1 = "1";
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

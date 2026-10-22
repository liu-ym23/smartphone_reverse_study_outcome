package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.event.r0;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements Runnable {
    public final /* synthetic */ RoomContextController a;
    public final /* synthetic */ ml.b b;
    public final /* synthetic */ ECUIPromotion c;
    public final /* synthetic */ RoomContextController d;
    public final /* synthetic */ Map e;

    public i(RoomContextController r1, ml.b r2, ECUIPromotion r3, RoomContextController r4, Map r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        r0 r0 = new r0(this.a);
        ml.b r1 = this.b;
        Integer r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.roomId();
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0.f("room_id", r3);
        ml.b r5 = this.b;
        if (r5 == null) goto L12;
        String r6 = r5.c();
    L13:
        if (r6 != null) goto L15;
        r6 = "";
    L15:
        r0.f("anchor_id", r6);
        Intrinsics.checkNotNullParameter("live_popup_card", "entranceForm");
        r0.f("ecom_entrance_form", "live_popup_card");
        r0.d("hot_sale_num", this.c.getHotAtmosphereSaleNum());
        String r7 = this.c.getHotSaleTypeStr();
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        r0.f("hot_sale_type", r7);
        String r8 = this.c.getProductId();
        if (r8 == null) goto L22;
        r4 = r8;
    L22:
        r0.f("product_id", r4);
        RoomContextController r9 = this.d;
        if (r9 == null) goto L27;
        com.bytedance.android.ec.adapter.api.state.a r10 = r9.L();
        if (r10 == null) goto L27;
        r2 = Integer.valueOf(r10.v);
    L27:
        if (r2 == null) goto L29;
        int r11 = r2.intValue();
    L30:
        r0.d("instant_type", r11);
        r0.m(this.e);
        r0.k();
        return;
    L29:
        r11 = 0;
        goto L30
    L12:
        r6 = null;
        goto L13
    L5:
        r3 = null;
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

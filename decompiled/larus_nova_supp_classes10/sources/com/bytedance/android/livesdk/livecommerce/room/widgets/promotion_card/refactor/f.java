package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotionPopHeader;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements Runnable {
    public final /* synthetic */ ECUIPromotion a;
    public final /* synthetic */ RoomContextController b;
    public final /* synthetic */ Map c;

    public f(ECUIPromotion r1, RoomContextController r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        ECPromotionPopHeader r1 = this.a.popHeader;
        Map r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getTrackName();
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        com.bytedance.android.livesdk.livecommerce.event.m r0 = new com.bytedance.android.livesdk.livecommerce.event.m(r3, this.b);
        Intrinsics.checkNotNullParameter("live_popup_card", "entranceForm");
        r0.f("ecom_entrance_form", "live_popup_card");
        String r4 = this.a.getProductId();
        Intrinsics.checkNotNullParameter(r4, "id");
        r0.f("product_id", r4);
        ECPromotionPopHeader r5 = this.a.popHeader;
        if (r5 == null) goto L11;
        r2 = r5.getTrackParam();
    L11:
        if (r2 == null) goto L16;
        Iterator r6 = r2.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        Map.Entry r7 = (Map.Entry) r6.next();
        r0.f((String) r7.getKey(), (String) r7.getValue());
    L16:
        r0.m(this.c);
        r0.k();
        return;
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

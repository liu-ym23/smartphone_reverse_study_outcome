package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements com.bytedance.android.ec.core.widget.h {
    public final /* synthetic */ a a;
    public final /* synthetic */ ECUIPromotion b;

    public final void b() {
    }

    public final void onAttachedToWindow() {
    }

    public final void onDetachedFromWindow() {
    }

    public final void a(ECHotAtmosphere r4) {
        ECUIPromotion r5 = this.b;
        if (r5 == null) goto L10;
        a r0 = this.a;
        ExplainCardViewModel r1 = r0.e;
        if (r1 == null) goto L7;
        ml.b r2 = r1.getLiveRoomInfo();
    L8:
        r0.F(r5, r2, true);
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void c(ECHotAtmosphere r3) {
        ECUIPromotion r0 = this.b;
        if (r0 == null) goto L8;
        ExplainCardViewModel r1 = this.a.e;
        if (r1 == null) goto L9;
        r1.onHotSaleChanged(r0.getPromotionId(), r3);
        return;
    L9:
        return;
    }

    public c(a r1, ECUIPromotion r2) {
        this.a = r1;
        this.b = r2;
    }
}

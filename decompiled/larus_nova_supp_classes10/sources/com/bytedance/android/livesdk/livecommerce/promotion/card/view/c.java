package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements q83.a {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final boolean onTick(long r9) {
        ECUIPromotion r0 = this.a.a;
        if (r0 == null) goto L31;
        ECUICampaign r1 = r0.getCampaign();
        if (r1 == null) goto L31;
        if (r1.isCampaignNotStarted() == false) goto L10;
        a r2 = this.a;
        r2.e(r1, r1.progressEndTime - r9, r2.e);
        this.a.f = true;
        return true;
    L10:
        String r4 = "";
        String r5 = null;
        if (r1.inCampaignTime() == false) goto L23;
        a r3 = this.a;
        r3.e(r1, r1.progressEndTime - r9, r3.e);
        a r10 = this.a;
        if (r10.f == false) goto L21;
        ILivePromotionCardContainerHandler r11 = r10.i.b;
        ECUIPromotion r12 = r10.a;
        if (r12 == null) goto L17;
        r5 = r12.getPromotionId();
    L17:
        if (r5 == null) goto L20;
        r4 = r5;
    L20:
        r11.c(r4, 40, true);
        this.a.f = false;
    L21:
        return true;
    L23:
        if (r1.shouldUpdateCampaign() == false) goto L31;
        a r13 = this.a;
        ILivePromotionCardContainerHandler r14 = r13.i.b;
        ECUIPromotion r15 = r13.a;
        if (r15 == null) goto L27;
        r5 = r15.getPromotionId();
    L27:
        if (r5 == null) goto L30;
        r4 = r5;
    L30:
        r14.c(r4, 41, false);
    L31:
        return false;
    }
}

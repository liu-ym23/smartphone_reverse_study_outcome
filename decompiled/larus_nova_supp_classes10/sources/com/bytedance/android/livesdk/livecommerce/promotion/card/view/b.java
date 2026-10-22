package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements q83.a {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final boolean onTick(long r4) {
        ECUIPromotion r0 = this.a.a;
        if (r0 == null) goto L12;
        ECUICampaign r1 = r0.getCampaign();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.isCampaignNotStarted() == false) goto L9;
    L10:
        a r2 = this.a;
        r2.d(r1, r4, r2.e);
        return true;
    L9:
        if (r1.inCampaignTime() == true) goto L10;
        return false;
    L12:
        return false;
    }
}

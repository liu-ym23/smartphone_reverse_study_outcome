package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements q83.a {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    public final boolean onTick(long r3) {
        ECUIPromotion r0 = this.a.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUICampaign r1 = r0.getCampaign();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.inCampaignTime() == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L16;
        a.c(this.a, r3);
        return true;
    L16:
        return false;
    }
}

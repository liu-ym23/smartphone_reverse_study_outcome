package com.bytedance.android.livesdk.livecommerce.playback.utils;

import android.text.TextUtils;
import cf.l;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(List r5, ECUIPromotion r6, long r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        long r8 = r7 / 1000;
        if (r5 == null) goto L20;
        int r0 = r5.size();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L28;
        ECPromotionCampaign r2 = (ECPromotionCampaign) ListProtector.get(r5, r1);
        int r3 = ECSdk.a;
        l r4 = (l) ECSdk.a(l.class);
        if (r4 == null) goto L19;
        if (r4.Ba(r2, r8) != true) goto L19;
        IECCommonService r9 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r9 == null) goto L19;
        ECUICampaign r10 = r9.convertCampaign(r2, r8);
        if (r10 == null) goto L19;
        if (TextUtils.equals(r6.getPromotionId(), r2.promotionId) == false) goto L19;
        r6.setCampaign(r10);
    L19:
        r1 = r1 + 1;
        goto L7
    L28:
        return;
    }
}

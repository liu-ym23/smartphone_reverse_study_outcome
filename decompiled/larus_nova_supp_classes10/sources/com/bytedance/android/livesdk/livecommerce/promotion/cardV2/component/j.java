package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.livesdk.livecommerce.actionrecord.node.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j extends y.d {
    public final /* synthetic */ PromotionCardImageComponent a;

    public j(PromotionCardImageComponent r1) {
        this.a = r1;
    }

    public final void onFailure(String r3, Throwable r4) {
        int r5 = zg2.a.a;
        jj2.c r6 = this.a.c;
        if (r6 == null) goto L5;
        String r0 = r6.l;
    L6:
        if (r6 == null) goto L8;
        String r7 = r6.m;
    L9:
        zg2.a.a(r0, r7, Action.SHOP_LIST_PIC_FAIL, null);
        return;
    L8:
        r7 = null;
        goto L9
    L5:
        r0 = null;
        goto L6
    }
}

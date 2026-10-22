package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import com.bytedance.android.ec.model.response.o0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.CountDownView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements q83.a {
    public final /* synthetic */ h a;

    public i(h r1) {
        this.a = r1;
    }

    public final boolean onTick(long r10) {
        o0 r0 = this.a.a;
        if (r0 == null) goto L18;
        com.bytedance.android.ec.model.response.k r1 = r0.a();
        if (r1 == null) goto L18;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r2 = this.a.c;
        if (r2 == null) goto L11;
        Long r3 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.a(r2, r1.c(), r1.a());
        if (r3 == null) goto L11;
        long r5 = r3.longValue();
    L12:
        h r4 = this.a;
        long r6 = r5 - r10;
        CountDownView r11 = (CountDownView) r4.findViewById(2131368046);
        if (r6 <= 0) goto L15;
        r11.setVisibility(0);
        r11.a(r6);
        return true;
    L15:
        r11.setVisibility(4);
        r4.d.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(r4.b);
        return true;
    L11:
        r5 = 0;
    L18:
        return false;
    }
}

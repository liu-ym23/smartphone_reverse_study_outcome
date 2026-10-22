package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ SimpleDraweeView a;
    public final /* synthetic */ AnchorV4DetailHeadView b;
    public final /* synthetic */ d c;

    public j(SimpleDraweeView r1, AnchorV4DetailHeadView r2, d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        t r0 = this.b.n;
        if (r0 == null) goto L5;
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r0, "wuyou_service_info_card_click", null, false, null, null, null, null, 254);
    L5:
        Context r1 = this.a.getContext();
        String r11 = this.c.h.getLink();
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        ECLiveHybridUtil.k(r1, r11, false, false, false, null, 252);
    }
}

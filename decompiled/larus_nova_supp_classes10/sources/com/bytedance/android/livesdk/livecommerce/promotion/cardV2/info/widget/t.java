package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements fj2.a<TextView> {
    public final /* synthetic */ ECUserRightsTagWidget a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_split_text";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r0 = new TextView(this.a.getContext());
        r0.setTag("text");
        r0.setMaxLines(1);
        r0.setTextSize(1, 12.0f);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r1 = this.a.c;
        if (r1 == null) goto L9;
        IPromotionUIConfig.d r2 = r1.a(PromotionCardModuleName.InfoAreaUserRightLabelModule);
        if (r2 == null) goto L9;
        IPromotionUIConfig.b r3 = r2.a();
        if (r3 == null) goto L9;
        UIConfigHelper.c(r0, r3);
    L9:
        return r0;
    }

    public t(ECUserRightsTagWidget r1) {
        this.a = r1;
    }
}

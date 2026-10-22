package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements fj2.a<TextView> {
    public final /* synthetic */ ECUserRightsTagWidget a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_background_text";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r0 = new TextView(this.a.getContext());
        r0.setTag("text");
        r0.setGravity(17);
        r0.setMaxLines(1);
        r0.setTextSize(1, 10.0f);
        r0.setPadding(UtilityKotlinExtentionsKt.d(4), 0, UtilityKotlinExtentionsKt.d(4), 0);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(16)));
        return r0;
    }

    public k(ECUserRightsTagWidget r1) {
        this.a = r1;
    }
}

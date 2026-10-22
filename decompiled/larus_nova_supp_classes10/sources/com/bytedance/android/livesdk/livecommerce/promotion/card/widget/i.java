package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements fj2.a<TextView> {
    public final /* synthetic */ ECUserRightsTagWidget a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_split";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r0 = new TextView(this.a.getContext());
        r0.setTag("text");
        r0.setText(" · ");
        r0.setMaxLines(1);
        r0.setTextSize(1, 12.0f);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        return r0;
    }

    public i(ECUserRightsTagWidget r1) {
        this.a = r1;
    }
}

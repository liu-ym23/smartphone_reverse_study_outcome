package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements fj2.a<TextView> {
    public final /* synthetic */ ECUserRightsTagWidget a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_text";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r0 = new TextView(this.a.getContext());
        r0.setTag("text");
        r0.setMaxLines(1);
        r0.setTextSize(12.0f);
        r0.setTextColor(th.a.a(r0.getContext(), 2131106227));
        return r0;
    }

    public j(ECUserRightsTagWidget r1) {
        this.a = r1;
    }
}

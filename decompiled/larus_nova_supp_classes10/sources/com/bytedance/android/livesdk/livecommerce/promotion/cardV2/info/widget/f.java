package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements fj2.a<TextView> {
    public final /* synthetic */ Context a;

    @Override // fj2.a
    public final String type() {
        return "label_item_text";
    }

    @Override // fj2.a
    public final TextView create() {
        TextView r0 = new TextView(this.a);
        r0.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        r0.setGravity(17);
        return r0;
    }

    public f(Context r1) {
        this.a = r1;
    }
}

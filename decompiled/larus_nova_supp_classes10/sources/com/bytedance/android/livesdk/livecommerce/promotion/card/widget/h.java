package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h implements fj2.a<View> {
    public final /* synthetic */ ECUserRightsTagWidget a;

    @Override // fj2.a
    public final String type() {
        return "tag_item_divider";
    }

    @Override // fj2.a
    public final View create() {
        View r0 = new View(this.a.getContext());
        r0.setTag("divider");
        r0.setBackgroundColor(th.a.a(r0.getContext(), 2131106229));
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(0.5f)), UtilityKotlinExtentionsKt.d(Float.valueOf(10.0f)));
        r1.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
        r1.topMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(1.0f));
        r1.gravity = 17;
        Unit r2 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        return r0;
    }

    public h(ECUserRightsTagWidget r1) {
        this.a = r1;
    }
}

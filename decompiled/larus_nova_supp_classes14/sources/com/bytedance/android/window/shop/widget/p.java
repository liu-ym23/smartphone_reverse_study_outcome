package com.bytedance.android.window.shop.widget;

import android.view.View;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.d a;
    public final /* synthetic */ ToolBarView b;

    public p(com.bytedance.android.window.shop.repository.tab.entity.d r1, ToolBarView r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        int r0 = rp.a.a;
        if (rp.a.a(r3.getId()) == false) goto L5;
        return;
    L5:
        Function2<String, Map<String, String>, Unit> r4 = this.b.getDoEventAction();
        if (r4 == null) goto L8;
        Unit r5 = (Unit) r4.invoke("win_goods_filter_button_click", MapsKt.mapOf(TuplesKt.to("button_type", this.a.b)));
    L8:
        com.bytedance.android.window.shop.repository.tab.entity.d r6 = this.a;
        r6.c = !r6.c;
        this.b.T5(r6);
        Function1<String, Unit> r7 = this.b.getFilterTypeChangeCB();
        if (r7 == null) goto L12;
        StringBuilder r1 = new StringBuilder();
        r1.append(this.a.a);
        r1.append('_');
        r1.append(this.a.c ? 1 : 0);
        Unit r8 = (Unit) r7.invoke(r1.toString());
        return;
    }
}

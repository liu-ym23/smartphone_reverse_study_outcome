package com.bytedance.android.window.shop.widget;

import android.view.View;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ ToolBarView a;
    public final /* synthetic */ e0 b;

    public o(ToolBarView r1, e0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r0 = rp.a.a;
        if (rp.a.a(r4.getId()) == false) goto L6;
        return;
    L6:
        if (this.b.k.isDoubleColumn() == false) goto L12;
        e0 r5 = this.b;
        if (r5.k.isNewLayout() == false) goto L10;
        WindowLayoutType r1 = WindowLayoutType.SINGLECOLUMN_V2;
    L11:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r5.k = r1;
    L17:
        Function2<String, Map<String, String>, Unit> r6 = this.a.getDoEventAction();
        if (r6 == null) goto L24;
        Pair[] r2 = new Pair[1];
        if (this.b.k.isSingleColumn() == false) goto L22;
        String r3 = "single_product";
    L23:
        r2[0] = TuplesKt.to("switch_type", r3);
        Unit r7 = (Unit) r6.invoke("store_product_form_switch_click", MapsKt.mutableMapOf(r2));
        goto L24
    L22:
        r3 = "double_product";
    L24:
        Function1<WindowLayoutType, Unit> r8 = this.a.getLayoutChangeCallback();
        if (r8 == null) goto L27;
        Unit r9 = (Unit) r8.invoke(this.b.k);
    L27:
        this.a.U5(this.b.k);
        return;
    L10:
        r1 = WindowLayoutType.SINGLECOLUMN;
        goto L11
    L12:
        e0 r10 = this.b;
        if (r10.k.isNewLayout() == false) goto L15;
        WindowLayoutType r11 = WindowLayoutType.DOUBLECOLUMN_V2;
    L16:
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r10.k = r11;
        goto L17
    L15:
        r11 = WindowLayoutType.DOUBLECOLUMN;
        goto L16
    }
}

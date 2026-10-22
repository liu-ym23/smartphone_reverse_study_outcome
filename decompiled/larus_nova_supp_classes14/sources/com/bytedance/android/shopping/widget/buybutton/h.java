package com.bytedance.android.shopping.widget.buybutton;

import android.view.View;
import com.bytedance.android.ec.model.ClickButtonParam;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ ClickButtonParam b;

    public h(g r1, ClickButtonParam r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        b r8 = this.a.b;
        if (r8 == null) goto L6;
        r8.b();
    L6:
        if (Intrinsics.areEqual(this.b.getEnterFrom(), "product_detail") == false) goto L10;
        b r9 = this.a.b;
        if (r9 == null) goto L15;
        r9.e();
        return;
    L15:
        return;
    L10:
        g r10 = this.a;
        c r0 = r10.e;
        String r11 = r10.a.c;
        Pair[] r2 = new Pair[1];
        String r3 = this.b.getEnterFrom();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r2[0] = TuplesKt.to("source_3d", r3);
        r0.b(r11, MapsKt.hashMapOf(r2), MapsKt.hashMapOf(new Pair[]{TuplesKt.to("entrance_info", this.b.getEntranceInfo())}));
    }
}

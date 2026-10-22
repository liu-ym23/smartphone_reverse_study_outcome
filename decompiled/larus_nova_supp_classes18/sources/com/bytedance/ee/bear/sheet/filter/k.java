package com.bytedance.ee.bear.sheet.filter;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ FilterPanelColorView.SelectColorAdapter.ColorViewHolder c;
    public final /* synthetic */ String d;
    public final /* synthetic */ FilterPanelColorView.SelectColorAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        if (this.c.c == true) goto L10;
        String r4 = this.d;
        if (r4 == null) goto L11;
        FilterPanelColorView.SelectColorAdapter r0 = this.e;
        r0.a = r0.a;
        r0.b = r4;
        r0.notifyDataSetChanged();
        FilterPanelColorView.SelectColorAdapter.a r1 = r0.c;
        if (r1 == null) goto L12;
        r1.a(r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public k(FilterPanelColorView.SelectColorAdapter.ColorViewHolder r1, String r2, FilterPanelColorView.SelectColorAdapter r3) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
    }
}

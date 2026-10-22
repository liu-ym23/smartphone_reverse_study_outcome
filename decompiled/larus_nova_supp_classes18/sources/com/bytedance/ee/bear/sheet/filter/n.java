package com.bytedance.ee.bear.sheet.filter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements FilterPanelColorView.SelectColorAdapter.a {
    public final /* synthetic */ FilterPanelColorView a;

    public n(FilterPanelColorView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterPanelColorView.SelectColorAdapter.a
    public final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "color");
        if (Intrinsics.areEqual(this.a.e, r7) == true) goto L15;
        FilterPanelColorView r0 = this.a;
        r0.e = r7;
        FilterPanelColorView.SelectColorAdapter r1 = r0.g;
        FilterPanelColorView.SelectColorAdapter r2 = null;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
        r1 = null;
    L7:
        String[] r4 = r0.d;
        String r5 = r0.e;
        r1.a = r4;
        r1.b = r5;
        r1.notifyDataSetChanged();
        FilterPanelColorView.SelectColorAdapter r3 = r0.g;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
    L11:
        r2.notifyDataSetChanged();
        FilterPanelColorView.a r6 = this.a.getColorUpdateListener();
        if (r6 == null) goto L16;
        r6.a(r7);
        return;
    L16:
        return;
    L10:
        r2 = r3;
        goto L11
    }
}

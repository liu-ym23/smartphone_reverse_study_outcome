package com.bytedance.ee.bear.sheet.filter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class n implements FilterPanelColorView.SelectColorAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterPanelColorView f237864a;

    public n(FilterPanelColorView r100) {
        this.f237864a = r100;
    }

    @Override // com.bytedance.ee.bear.sheet.filter.FilterPanelColorView.SelectColorAdapter.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        if (Intrinsics.areEqual(this.f237864a.f237699e, r100) == true) goto L15;
        FilterPanelColorView r101 = this.f237864a;
        r101.f237699e = r100;
        FilterPanelColorView.SelectColorAdapter r102 = r101.f237701g;
        FilterPanelColorView.SelectColorAdapter r103 = null;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
        r102 = null;
    L7:
        String[] r104 = r101.f237698d;
        String r105 = r101.f237699e;
        r102.f237704a = r104;
        r102.f237705b = r105;
        r102.notifyDataSetChanged();
        FilterPanelColorView.SelectColorAdapter r106 = r101.f237701g;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("colorAdapter");
    L11:
        r103.notifyDataSetChanged();
        FilterPanelColorView.a r107 = this.f237864a.getColorUpdateListener();
        if (r107 == null) goto L16;
        r107.a(r100);
        return;
    L16:
        return;
    L10:
        r103 = r106;
        goto L11
    }
}

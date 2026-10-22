package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements FilterView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterView f460979a;

    public b(FilterView r100) {
        this.f460979a = r100;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterView.b
    public final void a(cpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        FilterView.b r101 = this.f460979a.f460944e;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}

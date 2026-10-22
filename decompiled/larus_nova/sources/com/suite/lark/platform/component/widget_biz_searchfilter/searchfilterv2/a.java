package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements SearchFilterViewV2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterAdapterV2 f461027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cpc.a f461028b;

    public a(FilterAdapterV2 r100, cpc.a r101) {
        this.f461027a = r100;
        this.f461028b = r101;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.SearchFilterViewV2.a
    public final void onClick() {
        FilterViewV2.c r100 = this.f461027a.f460981h;
        if (r100 == null) goto L6;
        r100.b(this.f461028b);
        return;
    }
}

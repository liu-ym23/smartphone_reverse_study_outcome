package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements FilterViewV2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterViewV2 f461031a;

    public d(FilterViewV2 r100) {
        this.f461031a = r100;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2.b
    public final void a(cpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        FilterViewV2.b r101 = this.f461031a.f460999g;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }
}

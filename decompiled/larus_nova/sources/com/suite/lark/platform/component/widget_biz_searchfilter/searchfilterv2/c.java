package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements FilterViewV2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterViewV2 f461030a;

    public c(FilterViewV2 r100) {
        this.f461030a = r100;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2.c
    public final void a(cpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        FilterViewV2.c r101 = this.f461030a.f460998f;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2.c
    public final void b(cpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        FilterViewV2.c r101 = this.f461030a.f460998f;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}

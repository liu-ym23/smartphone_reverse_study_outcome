package com.bytedance.ee.bear.bitable.homepage.recommend;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements gqa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseHomePageDiscoveryTemplateListView f213008a;

    public d(BaseHomePageDiscoveryTemplateListView r100) {
        this.f213008a = r100;
    }

    @Override // gqa.b
    public final void O0(cqa.h r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.bytedance.ee.bear.templates.center.list.base.q.a r101 = this.f213008a.f212921e;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}

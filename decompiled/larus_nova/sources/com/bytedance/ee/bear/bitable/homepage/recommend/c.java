package com.bytedance.ee.bear.bitable.homepage.recommend;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements LoadStateView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseHomePageDiscoveryTemplateListView f213007a;

    public c(BaseHomePageDiscoveryTemplateListView r100) {
        this.f213007a = r100;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        com.bytedance.ee.bear.templates.center.list.base.q.a r100 = this.f213007a.f212921e;
        if (r100 == null) goto L6;
        r100.onLoadFailed();
        return;
    }
}

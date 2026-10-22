package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: classes18.dex */
public final class n implements LoadStateView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTemplateListView f239019a;

    public n(BaseTemplateListView r100) {
        this.f239019a = r100;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        q.a r100 = this.f239019a.f238981d;
        if (r100 == null) goto L6;
        r100.onLoadFailed();
        return;
    }
}

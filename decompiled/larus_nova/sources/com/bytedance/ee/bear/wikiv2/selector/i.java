package com.bytedance.ee.bear.wikiv2.selector;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements SwipeRefreshLayout.OnRefreshListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f241186a;

    public i(e r100) {
        this.f241186a = r100;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public final void onRefresh() {
        tt5.a.h("FolderSelectView", "onRefresh()...");
        m.a r100 = (m.a) this.f241186a.f285682a;
        if (r100 == null) goto L6;
        r100.onRefresh();
        return;
    }
}

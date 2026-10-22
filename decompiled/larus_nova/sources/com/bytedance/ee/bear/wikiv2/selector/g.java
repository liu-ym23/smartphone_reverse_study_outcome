package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements LoadStateView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f241184a;

    public g(e r100) {
        this.f241184a = r100;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        tt5.a.h("FolderSelectView", "on click failed, refresh.");
        m.a r100 = (m.a) this.f241184a.f285682a;
        if (r100 == null) goto L6;
        r100.onRefresh();
        return;
    }
}

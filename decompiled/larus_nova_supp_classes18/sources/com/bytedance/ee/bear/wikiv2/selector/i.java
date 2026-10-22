package com.bytedance.ee.bear.wikiv2.selector;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements SwipeRefreshLayout.OnRefreshListener {
    public final /* synthetic */ e a;

    public i(e r1) {
        this.a = r1;
    }

    public final void onRefresh() {
        tt5.a.h("FolderSelectView", "onRefresh()...");
        m.a r0 = (m.a) ((com.larksuite.framework.mvp.a) this.a).a;
        if (r0 == null) goto L6;
        r0.onRefresh();
        return;
    }
}

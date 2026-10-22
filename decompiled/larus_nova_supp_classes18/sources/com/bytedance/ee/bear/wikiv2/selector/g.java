package com.bytedance.ee.bear.wikiv2.selector;

import com.bytedance.ee.bear.list.loadstateview.LoadStateView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements LoadStateView.c {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.list.loadstateview.LoadStateView.c
    public final void a() {
        tt5.a.h("FolderSelectView", "on click failed, refresh.");
        m.a r0 = (m.a) ((com.larksuite.framework.mvp.a) this.a).a;
        if (r0 == null) goto L6;
        r0.onRefresh();
        return;
    }
}

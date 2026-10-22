package com.bytedance.ee.bear.list.sort;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends CommonActionPanelLayout.b {
    public final /* synthetic */ m a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        tt5.a.h("SortView", "onClick close()...");
        b.a r0 = this.a.i;
        if (r0 == null) goto L6;
        r0.onClickClose();
        return;
    }

    public k(m r1) {
        this.a = r1;
    }
}

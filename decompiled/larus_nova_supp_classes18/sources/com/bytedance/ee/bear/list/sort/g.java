package com.bytedance.ee.bear.list.sort;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends CommonActionPanelLayout.b {
    public final /* synthetic */ h a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        tt5.a.h("SortAndFilterView", "onClick close()...");
        a.InterfaceC0035a r0 = this.a.r;
        if (r0 == null) goto L6;
        r0.onClickClose();
        return;
    }

    public g(h r1) {
        this.a = r1;
    }
}

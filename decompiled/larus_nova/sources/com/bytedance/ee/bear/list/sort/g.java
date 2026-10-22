package com.bytedance.ee.bear.list.sort;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f229706a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        tt5.a.h("SortAndFilterView", "onClick close()...");
        a.InterfaceC3282a r100 = this.f229706a.f229724r;
        if (r100 == null) goto L6;
        r100.onClickClose();
        return;
    }

    public g(h r100) {
        this.f229706a = r100;
    }
}

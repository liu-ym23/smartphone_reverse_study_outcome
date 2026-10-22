package com.bytedance.ee.bear.list.sort;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class k extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f229738a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        tt5.a.h("SortView", "onClick close()...");
        b.a r100 = this.f229738a.f229748i;
        if (r100 == null) goto L6;
        r100.onClickClose();
        return;
    }

    public k(m r100) {
        this.f229738a = r100;
    }
}

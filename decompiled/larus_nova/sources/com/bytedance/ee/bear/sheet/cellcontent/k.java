package com.bytedance.ee.bear.sheet.cellcontent;

import com.bytedance.ee.bear.sheet.common.SheetDragView;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements SheetDragView.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetCellContentPanelFragment f237434a;

    @Override // com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void Q5() {
        SheetCellContentPanelFragment r100 = this.f237434a;
        r100.f237413e.setPanelHeight(r100.f237416h.getMeasuredHeight());
    }

    @Override // com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void W6() {
        SheetCellContentPanelFragment r100 = this.f237434a;
        r100.f237413e.setPanelHeight(r100.f237416h.getMeasuredHeight());
    }

    public k(SheetCellContentPanelFragment r100) {
        this.f237434a = r100;
    }
}

package com.bytedance.ee.bear.sheet.cellcontent;

import com.bytedance.ee.bear.sheet.common.SheetDragView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements SheetDragView.c {
    public final /* synthetic */ SheetCellContentPanelFragment a;

    @Override // com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void Q5() {
        SheetCellContentPanelFragment r0 = this.a;
        r0.e.setPanelHeight(r0.h.getMeasuredHeight());
    }

    @Override // com.bytedance.ee.bear.sheet.common.SheetDragView.c
    public final void W6() {
        SheetCellContentPanelFragment r0 = this.a;
        r0.e.setPanelHeight(r0.h.getMeasuredHeight());
    }

    public k(SheetCellContentPanelFragment r1) {
        this.a = r1;
    }
}

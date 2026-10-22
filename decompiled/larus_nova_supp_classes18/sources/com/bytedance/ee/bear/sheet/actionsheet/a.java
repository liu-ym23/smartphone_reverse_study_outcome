package com.bytedance.ee.bear.sheet.actionsheet;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends CommonActionPanelLayout.b {
    public final /* synthetic */ ActionSheetFragment a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        ActionSheetViewModel r0 = this.a.h;
        if (r0 == null) goto L6;
        r0.onCancel();
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void d() {
        ActionSheetViewModel r0 = this.a.h;
        if (r0 == null) goto L6;
        r0.onCancel();
        return;
    }

    public a(ActionSheetFragment r1) {
        this.a = r1;
    }
}

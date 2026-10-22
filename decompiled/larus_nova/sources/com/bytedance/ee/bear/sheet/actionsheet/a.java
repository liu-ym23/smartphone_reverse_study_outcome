package com.bytedance.ee.bear.sheet.actionsheet;

import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionSheetFragment f237298a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        ActionSheetViewModel r100 = this.f237298a.f237281h;
        if (r100 == null) goto L6;
        r100.onCancel();
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void d() {
        ActionSheetViewModel r100 = this.f237298a.f237281h;
        if (r100 == null) goto L6;
        r100.onCancel();
        return;
    }

    public a(ActionSheetFragment r100) {
        this.f237298a = r100;
    }
}

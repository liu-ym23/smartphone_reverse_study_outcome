package com.bytedance.ee.bear.bitable.card.view.cell.select;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class x extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f208187a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void a() {
        q r100 = this.f208187a.f208179q;
        if (r100 == null) goto L5;
        r100.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_EDIT_CLICK, "cancel");
    L5:
        this.f208187a.dismiss();
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void b() {
        this.f208187a.dismiss();
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void c() {
        t r100 = this.f208187a;
        t.a r101 = r100.f208177o;
        if (r101 == null) goto L5;
        r101.d(r100.f208182t.getText().toString(), this.f208187a.f208176n);
    L5:
        q r102 = this.f208187a.f208179q;
        if (r102 == null) goto L8;
        r102.y2(BitableAnalytic.SelectSceneEvent.BITABLE_OPTION_FIELD_EDIT_CLICK, BitableAnalytic.SelectSceneClickType.COMPLETE);
    L8:
        this.f208187a.dismiss();
    }

    public x(t r100) {
        this.f208187a = r100;
    }
}

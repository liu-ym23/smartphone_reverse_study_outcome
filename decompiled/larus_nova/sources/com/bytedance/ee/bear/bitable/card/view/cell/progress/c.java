package com.bytedance.ee.bear.bitable.card.view.cell.progress;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f207986a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void a() {
        b.a r100 = this.f207986a.f207983v;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void c() {
        b r100 = this.f207986a;
        boolean r101 = true;
        r100.f207985x = true;
        BitableAnalytic r102 = r100.f207963b;
        if (r102 == null) goto L9;
        String r103 = EFieldUIType.PROGRESS.getReportValue();
        if (this.f207986a.f207977p == null) goto L8;
        r101 = false;
    L8:
        HashMap r104 = new HashMap();
        r104.put("field_type", r103);
        r104.put("is_empty", Boolean.valueOf(r101));
        r104.put("click", "confirm");
        r102.t("ccm_bitable_field_input_mobile_click", r104);
    L9:
        this.f207986a.dismiss();
    }

    public c(b r100) {
        this.f207986a = r100;
    }
}

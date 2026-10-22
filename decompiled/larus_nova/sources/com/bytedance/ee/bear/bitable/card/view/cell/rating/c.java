package com.bytedance.ee.bear.bitable.card.view.cell.rating;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends CommonActionPanelLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f208026a;

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void a() {
        b.a r100 = this.f208026a.f208022h;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.b, com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout.a
    public final void c() {
        this.f208026a.dismiss();
        BitableAnalytic r100 = this.f208026a.f208016b;
        if (r100 == null) goto L10;
        String r101 = EFieldUIType.RATING.getReportValue();
        if (this.f208026a.f208021g != null) goto L7;
        boolean r102 = true;
    L8:
        HashMap r103 = new HashMap();
        r103.put("field_type", r101);
        r103.put("is_empty", Boolean.valueOf(r102));
        r103.put("click", "confirm");
        r100.t("ccm_bitable_field_input_mobile_click", r103);
        return;
    L7:
        r102 = false;
        goto L8
    }

    public c(b r100) {
        this.f208026a = r100;
    }
}

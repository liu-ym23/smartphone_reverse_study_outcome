package com.bytedance.ee.bear.templates.center.list.base;

import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.data.TemplateV4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements com.bytedance.ee.bear.templates.dto.e {
    public final /* synthetic */ TemplateV4 a;
    public final /* synthetic */ BaseTemplateListPresenter b;

    public j(TemplateV4 r1, BaseTemplateListPresenter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.templates.dto.e
    public final void onSuccess(int r3, String r4) {
        tt5.a.h("BaseTemplateListPresenter", "onSuccess: " + r3);
        TemplateReportV2 r5 = TemplateReportV2.a;
        TemplateReportV2.d(this.a, r4);
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.bitable.create.survey.disable.result") == true) goto L6;
        BaseTemplateListPresenter r6 = this.b;
        int r7 = BaseTemplateListPresenter.k;
        r6.O8().setSelectedTemplate(this.a);
        return;
    }
}

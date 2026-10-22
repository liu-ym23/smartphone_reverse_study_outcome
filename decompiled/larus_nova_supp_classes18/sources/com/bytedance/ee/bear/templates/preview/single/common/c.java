package com.bytedance.ee.bear.templates.preview.single.common;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends t {
    public final /* synthetic */ CommonPreviewTemplateView c;

    public c(CommonPreviewTemplateView r3) {
        this.c = r3;
        super(300);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r5) {
        CommonPreviewTemplateView r6 = this.c;
        CommonTemplateViewModel r0 = r6.h;
        if (r0 == null) goto L10;
        Integer r1 = (Integer) r0.getCurrTemplatePos().getValue();
        if (r1 == null) goto L11;
        Integer r2 = Integer.valueOf(r1.intValue() + 1);
        if (r0.showOtherTemplate(r2.intValue(), false) == false) goto L12;
        r6.e(r2.intValue());
        return;
    L12:
        return;
    L11:
        return;
    }
}

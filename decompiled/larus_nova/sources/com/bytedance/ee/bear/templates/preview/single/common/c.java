package com.bytedance.ee.bear.templates.preview.single.common;

import android.view.View;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CommonPreviewTemplateView f239240c;

    public c(CommonPreviewTemplateView r100) {
        this.f239240c = r100;
        super(300);
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        CommonPreviewTemplateView r101 = this.f239240c;
        CommonTemplateViewModel r102 = r101.f239204h;
        if (r102 == null) goto L10;
        Integer r103 = r102.getCurrTemplatePos().getValue();
        if (r103 == null) goto L11;
        Integer r104 = Integer.valueOf(r103.intValue() + 1);
        if (r102.showOtherTemplate(r104.intValue(), false) == false) goto L12;
        r101.e(r104.intValue());
        return;
    L12:
        return;
    L11:
        return;
    }
}

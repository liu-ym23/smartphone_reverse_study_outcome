package com.bytedance.ee.bear.templates.horizontal;

import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements TemplateAdapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f239118a;

    public i(g r100) {
        this.f239118a = r100;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r100, TemplateV4 r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.h("HorizontalTemplateView", "onTemplateClick()...");
        b.a r103 = this.f239118a.f239114d;
        if (r103 == null) goto L6;
        r103.L(r100, r101);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r100, TemplateV4 r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r104 = TemplateReportV2.f238768a;
        TemplateReportV2.i(r100, r101, sbb.e.f541294e, r102, r103);
    }
}

package com.bytedance.ee.bear.templates.recommend;

import com.bytedance.ee.bear.templates.TemplateAdapter;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements TemplateAdapter.c {
    public final /* synthetic */ i a;

    public l(i r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void w(TemplateV4 r2) {
        Intrinsics.checkNotNullParameter(r2, ThumbGlideUrl.SOURCE_TEMPLATE);
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void h(int r2, TemplateV4 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.h("NewRecommendTemplateView", "onTemplateClick()...");
        b.a r5 = this.a.e;
        if (r5 == null) goto L6;
        r5.L(r2, r3);
        return;
    }

    @Override // com.bytedance.ee.bear.templates.TemplateAdapter.c
    public final void C(String r2, TemplateV4 r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, ThumbGlideUrl.SOURCE_TEMPLATE);
        TemplateReportV2 r0 = TemplateReportV2.a;
        TemplateReportV2.i(r2, r3, sbb.e.e, r4, r5);
    }
}

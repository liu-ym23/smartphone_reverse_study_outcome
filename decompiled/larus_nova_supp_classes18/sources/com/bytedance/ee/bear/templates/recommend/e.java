package com.bytedance.ee.bear.templates.recommend;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T extends Result> implements NetService.c {
    public final /* synthetic */ NewRecommendTemplateModel a;

    public e(NewRecommendTemplateModel r1) {
        this.a = r1;
    }

    public final Result parse(String r4) {
        RecommendTemplates.Companion.getClass();
        RecommendTemplates r0 = RecommendTemplates.a.a(2, r4);
        if (((Result) r0).code != 0) goto L5;
        ((aw4.a) this.a.b.getValue()).a((String) this.a.d.getValue(), r4);
    L5:
        return r0;
    }
}

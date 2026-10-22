package com.bytedance.ee.bear.templates.recommend;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewRecommendTemplateModel f239266a;

    public e(NewRecommendTemplateModel r100) {
        this.f239266a = r100;
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        RecommendTemplates.Companion.getClass();
        RecommendTemplates r101 = RecommendTemplates.a.a(2, r100);
        if (r101.code != 0) goto L5;
        ((aw4.a) this.f239266a.f239260b.getValue()).a((String) this.f239266a.f239262d.getValue(), r100);
    L5:
        return r101;
    }
}

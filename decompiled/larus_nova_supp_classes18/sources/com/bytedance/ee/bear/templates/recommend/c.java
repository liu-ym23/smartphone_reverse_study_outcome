package com.bytedance.ee.bear.templates.recommend;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ NewRecommendTemplateModel a;

    public c(NewRecommendTemplateModel r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        String r4 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "it");
        String r5 = (String) ((aw4.a) this.a.b.getValue()).get(r4);
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        if (r5.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L13;
        RecommendTemplates.Companion.getClass();
        return Flowable.just(RecommendTemplates.a.a(1, r5));
    L13:
        return Flowable.empty();
    L8:
        r0 = false;
        goto L9
    }
}

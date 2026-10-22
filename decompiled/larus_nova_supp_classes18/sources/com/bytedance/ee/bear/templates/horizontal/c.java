package com.bytedance.ee.bear.templates.horizontal;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T, R> implements Function {
    public final /* synthetic */ HorizontalTemplateModel a;

    public c(HorizontalTemplateModel r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        HorizontalTemplates r4 = (HorizontalTemplates) ((aw4.a) this.a.e.getValue()).get(r3);
        if (r4 == null) goto L9;
        if (hu5.a.d(r4.getTemplates()) == true) goto L9;
        r4.setSource(1);
        return Flowable.just(r4);
    L9:
        return Flowable.empty();
    }
}

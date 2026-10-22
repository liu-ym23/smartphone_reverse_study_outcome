package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class i0 implements Function {
    public /* synthetic */ i0() {
    }

    public final Object apply(Object r2) {
        WikiRelation r3 = (WikiRelation) r2;
        if (r3.isValid() == false) goto L6;
        return Flowable.just(r3);
    L6:
        return Flowable.error(new Throwable("getRelationPuller, invalid relation. "));
    }
}

package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetFavoriteRelationPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.WikiRelation;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h2<T, R> implements Function {
    public final /* synthetic */ WikiRelation a;

    public h2(WikiRelation r1) {
        this.a = r1;
    }

    public final Object apply(Object r2) {
        GetFavoriteRelationPuller.Result r3 = (GetFavoriteRelationPuller.Result) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        this.a.addFavorite(r3);
        return this.a;
    }
}

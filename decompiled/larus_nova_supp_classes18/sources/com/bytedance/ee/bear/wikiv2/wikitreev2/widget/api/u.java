package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class u implements Function {
    public /* synthetic */ u() {
    }

    public final Object apply(Object r2) {
        GetFavoriteRelationPuller.Result r3 = (GetFavoriteRelationPuller.Result) r2;
        if (r3.favorite_node_list != null) goto L6;
        return Flowable.error(new Throwable("getFavoriteRelationPuller, favorite_node_list is null. "));
    L6:
        return Flowable.just(r3);
    }
}

package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class v implements Function {
    public /* synthetic */ v() {
    }

    public final Object apply(Object r1) {
        return Boolean.valueOf(((FavoritePuller.Result) r1).is_success);
    }
}

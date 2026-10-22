package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class v implements Function {
    public /* synthetic */ v() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return Boolean.valueOf(((FavoritePuller.Result) r100).is_success);
    }
}

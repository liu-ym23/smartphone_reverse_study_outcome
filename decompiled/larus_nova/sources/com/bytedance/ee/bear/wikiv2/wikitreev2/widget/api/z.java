package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class z implements Function {
    public /* synthetic */ z() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return Boolean.valueOf(((UnfavoritePuller.Result) r100).is_success);
    }
}

package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class t implements Function {
    public /* synthetic */ t() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return Boolean.valueOf(((UnStarSpacePuller.Result) r100).is_success);
    }
}

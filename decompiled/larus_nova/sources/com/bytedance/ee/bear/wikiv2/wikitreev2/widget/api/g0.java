package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class g0 implements Function {
    public /* synthetic */ g0() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return Boolean.valueOf(((StarSpacePuller.Result) r100).is_success);
    }
}

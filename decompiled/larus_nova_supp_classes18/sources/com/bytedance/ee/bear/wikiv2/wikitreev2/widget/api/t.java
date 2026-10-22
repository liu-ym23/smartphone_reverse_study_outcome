package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class t implements Function {
    public /* synthetic */ t() {
    }

    public final Object apply(Object r1) {
        return Boolean.valueOf(((UnStarSpacePuller.Result) r1).is_success);
    }
}

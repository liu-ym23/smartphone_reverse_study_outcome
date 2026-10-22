package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class g0 implements Function {
    public /* synthetic */ g0() {
    }

    public final Object apply(Object r1) {
        return Boolean.valueOf(((StarSpacePuller.Result) r1).is_success);
    }
}

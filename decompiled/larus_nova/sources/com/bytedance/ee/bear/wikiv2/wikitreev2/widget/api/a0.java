package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class a0 implements Function {
    public /* synthetic */ a0() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        return ((DelSingleNodePuller.Result) r100).task_id;
    }
}

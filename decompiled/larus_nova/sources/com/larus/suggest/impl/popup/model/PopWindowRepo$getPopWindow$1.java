package com.larus.suggest.impl.popup.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.popup.model.PopWindowRepo", f = "PopWindowRepo.kt", i = {0}, l = {20}, m = "getPopWindow", n = {"requestScene"}, s = {"L$0"})
public final class PopWindowRepo$getPopWindow$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PopWindowRepo this$0;

    public PopWindowRepo$getPopWindow$1(PopWindowRepo r100, Continuation<? super PopWindowRepo$getPopWindow$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}

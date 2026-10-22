package com.larus.suggest.impl.popup.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.popup.model.PopWindowRepo", f = "PopWindowRepo.kt", i = {}, l = {34}, m = "reportShow", n = {}, s = {})
public final class PopWindowRepo$reportShow$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PopWindowRepo this$0;

    public PopWindowRepo$reportShow$1(PopWindowRepo r100, Continuation<? super PopWindowRepo$reportShow$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}

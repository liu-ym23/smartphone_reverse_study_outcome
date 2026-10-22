package com.example.interopdemo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.example.interopdemo.SsHttpCall", f = "SsHttpCall.kt", i = {0}, l = {48}, m = "execute", n = {"this"}, s = {"L$0"})
public final class SsHttpCall$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SsHttpCall this$0;

    public SsHttpCall$execute$1(SsHttpCall r100, Continuation<? super SsHttpCall$execute$1> r101) {
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

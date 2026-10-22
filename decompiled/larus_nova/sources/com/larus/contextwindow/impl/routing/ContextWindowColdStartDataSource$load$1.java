package com.larus.contextwindow.impl.routing;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.routing.ContextWindowColdStartDataSource", f = "ContextWindowColdStartDataSource.kt", i = {0, 1}, l = {51, 65}, m = "load", n = {"request", "request"}, s = {"L$0", "L$0"})
public final class ContextWindowColdStartDataSource$load$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ContextWindowColdStartDataSource this$0;

    public ContextWindowColdStartDataSource$load$1(ContextWindowColdStartDataSource r100, Continuation<? super ContextWindowColdStartDataSource$load$1> r101) {
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

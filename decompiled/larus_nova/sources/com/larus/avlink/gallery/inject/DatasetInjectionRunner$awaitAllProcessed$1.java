package com.larus.avlink.gallery.inject;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.gallery.inject.DatasetInjectionRunner", f = "DatasetInjectionRunner.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {131, 149}, m = "awaitAllProcessed", n = {"enqueuedIds", "onAllProcessed", "terminalIds", "lastProgressMillis", "uniqId", "enqueuedIds", "onAllProcessed", "terminalIds", "lastProgressMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$2", "L$3"})
final class DatasetInjectionRunner$awaitAllProcessed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DatasetInjectionRunner this$0;

    public DatasetInjectionRunner$awaitAllProcessed$1(DatasetInjectionRunner r100, Continuation<? super DatasetInjectionRunner$awaitAllProcessed$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DatasetInjectionRunner.a(this.this$0, null, null, this);
    }
}

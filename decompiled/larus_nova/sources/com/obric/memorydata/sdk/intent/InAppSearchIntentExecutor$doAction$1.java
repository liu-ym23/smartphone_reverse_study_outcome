package com.obric.memorydata.sdk.intent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.sdk.intent.InAppSearchIntentExecutor", f = "InAppSearchIntentExecutor.kt", i = {}, l = {82}, m = "doAction", n = {}, s = {})
final class InAppSearchIntentExecutor$doAction$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppSearchIntentExecutor this$0;

    public InAppSearchIntentExecutor$doAction$1(InAppSearchIntentExecutor r100, Continuation<? super InAppSearchIntentExecutor$doAction$1> r101) {
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        throw null;
    }
}

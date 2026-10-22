package com.obric.aiagent.messenger.stub;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.SemanticHelper", f = "SemanticHelper.kt", i = {0, 0}, l = {51}, m = "preCheck", n = {"message", "latestSendMessage"}, s = {"L$0", "L$1"})
public final class SemanticHelper$preCheck$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SemanticHelper this$0;

    public SemanticHelper$preCheck$1(SemanticHelper r100, Continuation<? super SemanticHelper$preCheck$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}

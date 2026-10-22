package com.obric.assistant.state.impl.multitask.producer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer", f = "InteractionModeStateProducer.kt", i = {0, 0, 0}, l = {130}, m = "startModeInternal", n = {"state", "effectiveTimeout", "sessionId"}, s = {"L$0", "L$1", "L$2"})
final class InteractionModeStateProducer$startModeInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InteractionModeStateProducer this$0;

    public InteractionModeStateProducer$startModeInternal$1(InteractionModeStateProducer r100, Continuation<? super InteractionModeStateProducer$startModeInternal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return InteractionModeStateProducer.e(this.this$0, null, null, this);
    }
}

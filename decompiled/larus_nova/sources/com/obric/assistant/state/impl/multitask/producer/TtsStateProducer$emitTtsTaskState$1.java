package com.obric.assistant.state.impl.multitask.producer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.TtsStateProducer", f = "TtsStateProducer.kt", i = {0, 0}, l = {174}, m = "emitTtsTaskState", n = {"taskKey", "playingState"}, s = {"L$0", "L$1"})
final class TtsStateProducer$emitTtsTaskState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TtsStateProducer this$0;

    public TtsStateProducer$emitTtsTaskState$1(TtsStateProducer r100, Continuation<? super TtsStateProducer$emitTtsTaskState$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return TtsStateProducer.a(this.this$0, null, null, null, null, null, this);
    }
}

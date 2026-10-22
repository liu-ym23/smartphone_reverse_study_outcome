package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {0, 1}, l = {414, 424}, m = "stopIndependentAIInterpretationSync", n = {"language", "language"}, s = {"L$0", "L$0"})
public final class MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationStateHandler this$0;

    public MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1(MmStandaloneAIInterpretationStateHandler r100, Continuation<? super MmStandaloneAIInterpretationStateHandler$stopIndependentAIInterpretationSync$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MmStandaloneAIInterpretationStateHandler r101 = this.this$0;
        MmStandaloneAIInterpretationStateHandler.a r102 = MmStandaloneAIInterpretationStateHandler.f434565l;
        return r101.i(null, this);
    }
}

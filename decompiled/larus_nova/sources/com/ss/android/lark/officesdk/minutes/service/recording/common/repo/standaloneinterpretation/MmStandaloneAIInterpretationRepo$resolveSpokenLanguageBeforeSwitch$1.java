package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {425}, m = "resolveSpokenLanguageBeforeSwitch", n = {}, s = {})
final class MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1(MmStandaloneAIInterpretationRepo r100, Continuation<? super MmStandaloneAIInterpretationRepo$resolveSpokenLanguageBeforeSwitch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmStandaloneAIInterpretationRepo.o(this.this$0, null, null, this);
    }
}

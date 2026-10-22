package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo", f = "MmStandaloneAIInterpretationRepo.kt", i = {0, 0, 1, 2}, l = {508, TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER, 538, 544}, m = "updateSetting", n = {"language", "enabled", "updateResult", "updateResult"}, s = {"L$0", "Z$0", "L$0", "L$0"})
final class MmStandaloneAIInterpretationRepo$updateSetting$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$updateSetting$1(MmStandaloneAIInterpretationRepo r100, Continuation<? super MmStandaloneAIInterpretationRepo$updateSetting$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmStandaloneAIInterpretationRepo.r(this.this$0, null, false, null, this);
    }
}

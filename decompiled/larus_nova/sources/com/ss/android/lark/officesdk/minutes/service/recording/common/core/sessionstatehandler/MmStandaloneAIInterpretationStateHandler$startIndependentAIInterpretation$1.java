package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS}, m = "startIndependentAIInterpretation", n = {}, s = {})
final class MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationStateHandler this$0;

    public MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1(MmStandaloneAIInterpretationStateHandler r100, Continuation<? super MmStandaloneAIInterpretationStateHandler$startIndependentAIInterpretation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmStandaloneAIInterpretationStateHandler.d(this.this$0, null, this);
    }
}

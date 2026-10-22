package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo", f = "MmStandaloneAIInterpretationRepo.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS, MediaPlayer.MEDIA_PLAYER_OPTION_BYTEVC1_SW_FORBIDDEN}, m = "enqueueLanguageSwitch", n = {}, s = {})
final class MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1(MmStandaloneAIInterpretationRepo r100, Continuation<? super MmStandaloneAIInterpretationRepo$enqueueLanguageSwitch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmStandaloneAIInterpretationRepo.n(this.this$0, null, this);
    }
}

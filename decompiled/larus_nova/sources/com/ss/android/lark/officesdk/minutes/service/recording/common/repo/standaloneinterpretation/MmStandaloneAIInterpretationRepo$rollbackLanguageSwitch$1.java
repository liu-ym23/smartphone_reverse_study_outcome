package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.bduploader.UploadKeys;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo", f = "MmStandaloneAIInterpretationRepo.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 3}, l = {UploadKeys.KeyIsEnd2EndEncryptionOption, 441, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, 451}, m = "rollbackLanguageSwitch", n = {"meetingId", "previousTarget", "previousSpokenLanguage", "meetingId", "previousTarget", "closeAccepted", "closeAccepted", "sourceAccepted", "closeAccepted", "sourceAccepted", "targetAccepted"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "I$0", "I$0", "I$1", "I$0", "I$1", "I$2"})
final class MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationRepo this$0;

    public MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1(MmStandaloneAIInterpretationRepo r100, Continuation<? super MmStandaloneAIInterpretationRepo$rollbackLanguageSwitch$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmStandaloneAIInterpretationRepo.p(this.this$0, null, null, null, null, this);
    }
}

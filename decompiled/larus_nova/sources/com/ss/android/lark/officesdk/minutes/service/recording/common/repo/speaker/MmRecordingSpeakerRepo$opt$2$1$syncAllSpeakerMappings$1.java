package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo$opt$2$1", f = "MmRecordingSpeakerRepo.kt", i = {0, 0, 1, 1}, l = {163, 192}, m = "syncAllSpeakerMappings", n = {"source", "meetingId", "source", "missingSpeakerUserIds"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingSpeakerRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$1(MmRecordingSpeakerRepo$opt$2.AnonymousClass1 r100, Continuation<? super MmRecordingSpeakerRepo$opt$2$1$syncAllSpeakerMappings$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingSpeakerRepo$opt$2.AnonymousClass1.T0(this.this$0, null, this);
    }
}

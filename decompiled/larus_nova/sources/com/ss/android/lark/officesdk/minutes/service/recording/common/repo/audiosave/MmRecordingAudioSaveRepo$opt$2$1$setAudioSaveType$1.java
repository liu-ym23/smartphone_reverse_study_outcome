package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAudioSaveRepo$opt$2$1", f = "MmRecordingAudioSaveRepo.kt", i = {1}, l = {46, 76}, m = "setAudioSaveType", n = {"targetState"}, s = {"L$0"})
public final class MmRecordingAudioSaveRepo$opt$2$1$setAudioSaveType$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 this$0;

    public MmRecordingAudioSaveRepo$opt$2$1$setAudioSaveType$1(MmRecordingAudioSaveRepo$opt$2.AnonymousClass1 r100, Continuation<? super MmRecordingAudioSaveRepo$opt$2$1$setAudioSaveType$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.E0(null, false, this);
    }
}

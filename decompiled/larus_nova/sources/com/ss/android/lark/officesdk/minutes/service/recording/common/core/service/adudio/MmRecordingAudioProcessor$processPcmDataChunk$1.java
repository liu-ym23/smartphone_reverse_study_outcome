package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor", f = "MmRecordingAudioProcessor.kt", i = {0, 0, 1, 1}, l = {155, 156, 161}, m = "processPcmDataChunk", n = {"pcmData", "isEnd", "pcmData", "isEnd"}, s = {"L$0", "Z$0", "L$0", "Z$0"})
public final class MmRecordingAudioProcessor$processPcmDataChunk$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAudioProcessor this$0;

    public MmRecordingAudioProcessor$processPcmDataChunk$1(MmRecordingAudioProcessor r100, Continuation<? super MmRecordingAudioProcessor$processPcmDataChunk$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAudioProcessor r101 = this.this$0;
        int r102 = MmRecordingAudioProcessor.f434300q;
        return r101.f(null, false, this);
    }
}

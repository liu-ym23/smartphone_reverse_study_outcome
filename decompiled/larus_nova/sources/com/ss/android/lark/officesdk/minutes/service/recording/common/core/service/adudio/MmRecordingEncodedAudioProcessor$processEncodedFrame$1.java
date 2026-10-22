package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingEncodedAudioProcessor", f = "MmRecordingEncodedAudioProcessor.kt", i = {0}, l = {102, 105}, m = "processEncodedFrame", n = {"frame"}, s = {"L$0"})
final class MmRecordingEncodedAudioProcessor$processEncodedFrame$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingEncodedAudioProcessor this$0;

    public MmRecordingEncodedAudioProcessor$processEncodedFrame$1(MmRecordingEncodedAudioProcessor r100, Continuation<? super MmRecordingEncodedAudioProcessor$processEncodedFrame$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingEncodedAudioProcessor.a(this.this$0, null, this);
    }
}

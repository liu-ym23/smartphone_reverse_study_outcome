package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioProcessor", f = "MmRecordingAudioProcessor.kt", i = {0, 0, 0}, l = {230}, m = "saveOggFile", n = {"oggData", "sliceIndex", "durationSec"}, s = {"L$0", "I$0", "I$1"})
public final class MmRecordingAudioProcessor$saveOggFile$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingAudioProcessor this$0;

    public MmRecordingAudioProcessor$saveOggFile$1(MmRecordingAudioProcessor r100, Continuation<? super MmRecordingAudioProcessor$saveOggFile$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MmRecordingAudioProcessor r101 = this.this$0;
        int r102 = MmRecordingAudioProcessor.f434300q;
        return r101.g(null, 0, 0, this);
    }
}

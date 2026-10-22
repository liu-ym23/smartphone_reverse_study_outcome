package com.enroll.audio.enroll.recorder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.enroll.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr", f = "VoicePrintEnrollRecordingsMgr.kt", i = {1, 1, 2, 2, 2, 3}, l = {68, 97, 126, 156, 157}, m = "startRecording", n = {"channelConfig", "audioFormat", "channelConfig", "audioFormat", "index", "index"}, s = {"I$0", "I$1", "I$0", "I$1", "I$2", "I$0"})
public final class VoicePrintEnrollRecordingsMgr$startRecording$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoicePrintEnrollRecordingsMgr this$0;

    public VoicePrintEnrollRecordingsMgr$startRecording$1(VoicePrintEnrollRecordingsMgr r100, Continuation<? super VoicePrintEnrollRecordingsMgr$startRecording$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}

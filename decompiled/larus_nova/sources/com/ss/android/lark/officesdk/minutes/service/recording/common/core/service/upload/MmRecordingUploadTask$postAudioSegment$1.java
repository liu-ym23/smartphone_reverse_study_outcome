package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask", f = "MmRecordingUploadTask.kt", i = {}, l = {40, 44}, m = "postAudioSegment", n = {}, s = {})
final class MmRecordingUploadTask$postAudioSegment$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingUploadTask this$0;

    public MmRecordingUploadTask$postAudioSegment$1(MmRecordingUploadTask r100, Continuation<? super MmRecordingUploadTask$postAudioSegment$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmRecordingUploadTask.a(this.this$0, null, this);
    }
}

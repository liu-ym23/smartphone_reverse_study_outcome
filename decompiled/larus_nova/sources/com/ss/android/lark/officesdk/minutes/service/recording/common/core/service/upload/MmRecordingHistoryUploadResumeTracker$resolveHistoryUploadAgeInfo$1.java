package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingHistoryUploadResumeTracker", f = "MmRecordingHistoryUploadResumeTracker.kt", i = {0}, l = {64}, m = "resolveHistoryUploadAgeInfo", n = {"meetingId"}, s = {"L$0"})
public final class MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingHistoryUploadResumeTracker this$0;

    public MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1(MmRecordingHistoryUploadResumeTracker r100, Continuation<? super MmRecordingHistoryUploadResumeTracker$resolveHistoryUploadAgeInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MmRecordingHistoryUploadResumeTracker r101 = this.this$0;
        int r102 = MmRecordingHistoryUploadResumeTracker.f434470c;
        return r101.a(null, null, this);
    }
}

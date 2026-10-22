package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler$Companion", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {0}, l = {57}, m = "awaitRecordingIdForHistoryUpload", n = {"onFailure"}, s = {"L$0"})
public final class MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmSoftwareHistoryRecordingStateHandler.Companion this$0;

    public MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1(MmSoftwareHistoryRecordingStateHandler.Companion r100, Continuation<? super MmSoftwareHistoryRecordingStateHandler$Companion$awaitRecordingIdForHistoryUpload$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}

package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareHistoryRecordingStateHandler", f = "MmSoftwareHistoryRecordingStateHandler.kt", i = {}, l = {255}, m = "buildHistoryForegroundNotificationAction", n = {}, s = {})
final class MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmSoftwareHistoryRecordingStateHandler this$0;

    public MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1(MmSoftwareHistoryRecordingStateHandler r100, Continuation<? super MmSoftwareHistoryRecordingStateHandler$buildHistoryForegroundNotificationAction$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return MmSoftwareHistoryRecordingStateHandler.c(this.this$0, this);
    }
}

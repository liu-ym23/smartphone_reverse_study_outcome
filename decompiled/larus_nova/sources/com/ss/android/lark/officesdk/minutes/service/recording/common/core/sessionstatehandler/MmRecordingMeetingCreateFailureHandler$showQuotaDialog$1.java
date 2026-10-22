package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmRecordingMeetingCreateFailureHandler", f = "MmRecordingMeetingCreateFailureHandler.kt", i = {0, 0, 0, 1, 1}, l = {63, 87}, m = "showQuotaDialog$officesdk_minutes_service_release", n = {"quotaDependency", "denyType", "retryIndex", "quotaDependency", "denyType"}, s = {"L$0", "I$0", "I$3", "L$0", "I$0"})
public final class MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingMeetingCreateFailureHandler this$0;

    public MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1(MmRecordingMeetingCreateFailureHandler r100, Continuation<? super MmRecordingMeetingCreateFailureHandler$showQuotaDialog$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(0, this);
    }
}

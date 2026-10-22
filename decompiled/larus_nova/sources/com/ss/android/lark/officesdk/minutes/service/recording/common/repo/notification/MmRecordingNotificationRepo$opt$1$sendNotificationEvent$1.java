package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.MmRecordingNotificationRepo$opt$1", f = "MmRecordingNotificationRepo.kt", i = {0}, l = {15, 31}, m = "sendNotificationEvent", n = {"event"}, s = {"L$0"})
public final class MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingNotificationRepo$opt$1 this$0;

    public MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1(MmRecordingNotificationRepo$opt$1 r100, Continuation<? super MmRecordingNotificationRepo$opt$1$sendNotificationEvent$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.T0(null, this);
    }
}

package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingCreateService", f = "MmRecordingCreateService.kt", i = {0}, l = {273}, m = "createRecordObjectWithAdvancedRetry", n = {"result"}, s = {"L$0"})
public final class MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingCreateService this$0;

    public MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1(MmRecordingCreateService r100, Continuation<? super MmRecordingCreateService$createRecordObjectWithAdvancedRetry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, 0, null, null, null, null, false, this);
    }
}

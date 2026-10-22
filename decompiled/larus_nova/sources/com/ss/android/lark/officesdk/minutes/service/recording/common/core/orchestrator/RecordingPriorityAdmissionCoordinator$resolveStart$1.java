package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator.RecordingPriorityAdmissionCoordinator", f = "RecordingPriorityAdmissionCoordinator.kt", i = {0, 0, 0}, l = {44}, m = "resolveStart-BWLJW6A", n = {"scene", "decision", "shouldReserve"}, s = {"L$0", "L$1", "I$0"})
final class RecordingPriorityAdmissionCoordinator$resolveStart$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public RecordingPriorityAdmissionCoordinator$resolveStart$1(b r100, Continuation<? super RecordingPriorityAdmissionCoordinator$resolveStart$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.b(null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}

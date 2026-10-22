package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService", f = "MmMockAwareRequestService.kt", i = {0, 0, 0}, l = {29, 31}, m = "sendPbRequest-BWLJW6A", n = {"command", "respType", "input"}, s = {"L$0", "L$1", "L$2"})
public final class MmMockAwareRequestService$sendPbRequest$1<R> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmMockAwareRequestService this$0;

    public MmMockAwareRequestService$sendPbRequest$1(MmMockAwareRequestService r100, Continuation<? super MmMockAwareRequestService$sendPbRequest$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.b(null, null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}

package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.network.core.MmNetRequestHandler", f = "MmNetRequestHandler.kt", i = {}, l = {60}, m = "sendHttpRequest-0E7RQCE", n = {}, s = {})
public final class MmNetRequestHandler$sendHttpRequest$1<R> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmNetRequestHandler this$0;

    public MmNetRequestHandler$sendHttpRequest$1(MmNetRequestHandler r100, Continuation<? super MmNetRequestHandler$sendHttpRequest$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.c(null, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}

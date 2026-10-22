package com.larus.dora.impl.guide.strategy;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.strategy.BasicDoraDeviceCheckStrategy", f = "BasicDoraDeviceCheckStrategy.kt", i = {}, l = {203}, m = "checkBindStatus-gIAlu-s", n = {}, s = {})
public final class BasicDoraDeviceCheckStrategy$checkBindStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BasicDoraDeviceCheckStrategy this$0;

    public BasicDoraDeviceCheckStrategy$checkBindStatus$1(BasicDoraDeviceCheckStrategy r100, Continuation<? super BasicDoraDeviceCheckStrategy$checkBindStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        BasicDoraDeviceCheckStrategy r101 = this.this$0;
        int r102 = BasicDoraDeviceCheckStrategy.f335977d;
        Object r103 = r101.a(null, this);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Result.m9448boximpl(r103);
    }
}

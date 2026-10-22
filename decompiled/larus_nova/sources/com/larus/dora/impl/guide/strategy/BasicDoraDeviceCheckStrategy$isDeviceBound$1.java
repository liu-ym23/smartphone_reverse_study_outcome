package com.larus.dora.impl.guide.strategy;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.strategy.BasicDoraDeviceCheckStrategy", f = "BasicDoraDeviceCheckStrategy.kt", i = {0}, l = {188}, m = "isDeviceBound-0E7RQCE", n = {"device"}, s = {"L$0"})
public final class BasicDoraDeviceCheckStrategy$isDeviceBound$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BasicDoraDeviceCheckStrategy this$0;

    public BasicDoraDeviceCheckStrategy$isDeviceBound$1(BasicDoraDeviceCheckStrategy r100, Continuation<? super BasicDoraDeviceCheckStrategy$isDeviceBound$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        BasicDoraDeviceCheckStrategy r101 = this.this$0;
        int r102 = BasicDoraDeviceCheckStrategy.f335977d;
        Object r103 = r101.c(null, 0, this);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Result.m9448boximpl(r103);
    }
}

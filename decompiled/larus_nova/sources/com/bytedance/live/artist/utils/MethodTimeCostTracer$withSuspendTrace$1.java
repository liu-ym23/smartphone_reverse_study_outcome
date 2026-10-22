package com.bytedance.live.artist.utils;

import com.alipay.sdk.m.p.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@"}, d2 = {"", e.f25671s, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "block", "continuation", "withSuspendTrace"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.bytedance.live.artist.utils.MethodTimeCostTracer", f = "MethodTimeCostTracer.kt", i = {0, 0, 0}, l = {30}, m = "withSuspendTrace", n = {"this", e.f25671s, "block"}, s = {"L$0", "L$1", "L$2"})
final class MethodTimeCostTracer$withSuspendTrace$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public MethodTimeCostTracer$withSuspendTrace$1(b r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        b r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        MethodTimeCostTracer$withSuspendTrace$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L13;
        if (r105 != 1) goto L12;
        Function1 r106 = (Function1) r103.L$2;
        String r107 = (String) r103.L$1;
        b r108 = (b) r103.L$0;
        ResultKt.throwOnFailure(r104);
        r108.a(r107);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r104);
        r101.f254856a.put(null, Long.valueOf(System.nanoTime()));
        r103.L$0 = r101;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.label = 1;
        throw null;
    L5:
        r103 = new MethodTimeCostTracer$withSuspendTrace$1(r101, this);
        goto L6
    }
}

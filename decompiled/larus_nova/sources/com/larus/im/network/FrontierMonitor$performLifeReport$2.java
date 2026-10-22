package com.larus.im.network;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.network.FrontierMonitor$performLifeReport$2", f = "FrontierMonitor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FrontierMonitor$performLifeReport$2 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FrontierMonitor this$0;

    public FrontierMonitor$performLifeReport$2(FrontierMonitor r100, Continuation<? super FrontierMonitor$performLifeReport$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FrontierMonitor$performLifeReport$2(this.this$0, r101);
    }

    public final Object invoke(long r100, Continuation<? super Unit> r101) {
        return ((FrontierMonitor$performLifeReport$2) create(Long.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Long r100, Continuation<? super Unit> r101) {
        return invoke(r100.longValue(), r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        FrontierMonitor r101 = this.this$0;
        int r102 = FrontierMonitor.f350571i;
        r101.a(true);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

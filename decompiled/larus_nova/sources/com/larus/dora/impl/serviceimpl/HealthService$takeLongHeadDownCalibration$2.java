package com.larus.dora.impl.serviceimpl;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.HealthService$takeLongHeadDownCalibration$2", f = "HealthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HealthService$takeLongHeadDownCalibration$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ HealthService this$0;

    public HealthService$takeLongHeadDownCalibration$2(HealthService r100, Continuation<? super HealthService$takeLongHeadDownCalibration$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new HealthService$takeLongHeadDownCalibration$2(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Integer> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Integer> r101) {
        return ((HealthService$takeLongHeadDownCalibration$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        HealthService r101 = this.this$0;     // Catch: Throwable -> L9
        int r102 = HealthService.f337974d;     // Catch: Throwable -> L9
        r101.getClass();     // Catch: Throwable -> L9
        zj4.a r103 = HealthService.h();     // Catch: Throwable -> L9
        if (r103 == null) goto L11;
        Integer r104 = Boxing.boxInt(r103.i());     // Catch: Throwable -> L9
    L12:
        FLogger.f375446a.i("HealthService", "takeLongHeadDownCalibration: status=" + r104);
        return r104;
    L11:
        r104 = null;
    L9:
        th = move-exception;
        FLogger.f375446a.e("HealthService", "takeLongHeadDownCalibration failed", th);
        goto L11
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

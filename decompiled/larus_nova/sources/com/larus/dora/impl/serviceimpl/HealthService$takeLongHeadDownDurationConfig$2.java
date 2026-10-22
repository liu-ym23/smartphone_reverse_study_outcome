package com.larus.dora.impl.serviceimpl;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/api/model/FlowDoraLongHeadDownDurationConfig;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.HealthService$takeLongHeadDownDurationConfig$2", f = "HealthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HealthService$takeLongHeadDownDurationConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b49.i>, Object> {
    int label;
    final /* synthetic */ HealthService this$0;

    public HealthService$takeLongHeadDownDurationConfig$2(HealthService r100, Continuation<? super HealthService$takeLongHeadDownDurationConfig$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new HealthService$takeLongHeadDownDurationConfig$2(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super b49.i> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super b49.i> r101) {
        return ((HealthService$takeLongHeadDownDurationConfig$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r100);
        b49.i r101 = null;
        HealthService r102 = this.this$0;     // Catch: Throwable -> L9
        int r103 = HealthService.f337974d;     // Catch: Throwable -> L9
        r102.getClass();     // Catch: Throwable -> L9
        zj4.a r104 = HealthService.h();     // Catch: Throwable -> L9
        if (r104 == null) goto L11;
        zj4.b r105 = r104.j();     // Catch: Throwable -> L9
    L12:
        if (r105 == null) goto L14;
        r101 = new b49.i(r105.f572462a, r105.f572463b, r105.f572464c);
    L14:
        FLogger.f375446a.i("HealthService", "takeLongHeadDownDurationConfig: config=" + r101);
        return r101;
    L11:
        r105 = null;
    L9:
        th = move-exception;
        FLogger.f375446a.e("HealthService", "takeLongHeadDownDurationConfig failed", th);
        goto L11
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.HealthService$syncSedentaryDuration$2", f = "HealthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HealthService$syncSedentaryDuration$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $minutes;
    int label;
    final /* synthetic */ HealthService this$0;

    public HealthService$syncSedentaryDuration$2(HealthService r100, int r101, Continuation<? super HealthService$syncSedentaryDuration$2> r102) {
        this.this$0 = r100;
        this.$minutes = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new HealthService$syncSedentaryDuration$2(this.this$0, this.$minutes, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((HealthService$syncSedentaryDuration$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        HealthService r101 = this.this$0;     // Catch: Throwable -> L9
        int r102 = HealthService.f337974d;     // Catch: Throwable -> L9
        r101.getClass();     // Catch: Throwable -> L9
        zj4.a r103 = HealthService.h();     // Catch: Throwable -> L9
        if (r103 == null) goto L11;
        int r104 = r103.f(this.$minutes);     // Catch: Throwable -> L9
    L12:
        if (r104 != 0) goto L14;
        boolean r105 = true;
    L15:
        FLogger.f375446a.i("HealthService", "syncSedentaryDuration: minutes=" + this.$minutes + ", ret=" + r104 + ", isSuccess=" + r105);
        return Boxing.boxBoolean(r105);
    L14:
        r105 = false;
    L11:
        r104 = -1;
    L9:
        th = move-exception;
        FLogger.f375446a.e("HealthService", "syncSedentaryDuration failed", th);
        goto L11
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

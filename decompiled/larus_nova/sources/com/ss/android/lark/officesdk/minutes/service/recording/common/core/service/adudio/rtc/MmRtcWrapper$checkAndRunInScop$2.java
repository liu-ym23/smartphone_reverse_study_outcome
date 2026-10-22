package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmRtcWrapper$checkAndRunInScop$2", f = "MmRtcWrapper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRtcWrapper$checkAndRunInScop$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<nub.b, Unit> $onComplete;
    final /* synthetic */ Function1<Throwable, Unit> $onFailure;
    final /* synthetic */ nub.b $rtcService;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MmRtcWrapper$checkAndRunInScop$2(Function1<? super nub.b, Unit> r100, nub.b r101, Function1<? super Throwable, Unit> r102, Continuation<? super MmRtcWrapper$checkAndRunInScop$2> r103) {
        this.$onComplete = r100;
        this.$rtcService = r101;
        this.$onFailure = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MmRtcWrapper$checkAndRunInScop$2(this.$onComplete, this.$rtcService, this.$onFailure, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MmRtcWrapper$checkAndRunInScop$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r100);
        Function1<nub.b, Unit> r101 = this.$onComplete;
        nub.b r102 = this.$rtcService;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        r101.invoke(r102);     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Function1<Throwable, Unit> r105 = this.$onFailure;
        Throwable r106 = Result.m9452exceptionOrNullimpl(r104);
        if (r106 == null) goto L15;
        lvb.a.b("MmRtcWrapper", "runTask error: " + r106);
        if ((r106 instanceof CancellationException) == true) goto L15;
        r105.invoke(r106);
    L15:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

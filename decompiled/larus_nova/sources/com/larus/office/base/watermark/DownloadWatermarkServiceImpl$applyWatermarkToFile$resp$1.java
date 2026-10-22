package com.larus.office.base.watermark;

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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.watermark.DownloadWatermarkServiceImpl$applyWatermarkToFile$resp$1", f = "DownloadWatermarkServiceImpl.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
public final class DownloadWatermarkServiceImpl$applyWatermarkToFile$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $cleanup;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadWatermarkServiceImpl$applyWatermarkToFile$resp$1(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super DownloadWatermarkServiceImpl$applyWatermarkToFile$resp$1> r101) {
        this.$cleanup = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DownloadWatermarkServiceImpl$applyWatermarkToFile$resp$1 r102 = new DownloadWatermarkServiceImpl$applyWatermarkToFile$resp$1(this.$cleanup, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends Unit>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<Unit>> r101) {
        return ((DownloadWatermarkServiceImpl$applyWatermarkToFile$resp$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L18:
        return Result.m9448boximpl(r103);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r104 = (CoroutineScope) this.L$0;
        Function1<Continuation<? super Unit>, Object> r105 = this.$cleanup;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r105.invoke(this) != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}

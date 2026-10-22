package com.larus.drive.sdk.impl.preview;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$fallbackIfCurrent$1", f = "AiFilePreviewCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AiFilePreviewCoordinator$fallbackIfCurrent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $fallback;
    final /* synthetic */ CoroutineScope $scope;
    private /* synthetic */ Object L$0;
    int label;

    public AiFilePreviewCoordinator$fallbackIfCurrent$1(Context r100, CoroutineScope r101, String r102, Function0<Unit> r103, Continuation<? super AiFilePreviewCoordinator$fallbackIfCurrent$1> r104) {
        this.$context = r100;
        this.$scope = r101;
        this.$accountId = r102;
        this.$fallback = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AiFilePreviewCoordinator$fallbackIfCurrent$1 r102 = new AiFilePreviewCoordinator$fallbackIfCurrent$1(this.$context, this.$scope, this.$accountId, this.$fallback, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AiFilePreviewCoordinator$fallbackIfCurrent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Context r102 = this.$context;
        CoroutineScope r103 = this.$scope;
        String r104 = this.$accountId;
        Function0<Unit> r105 = this.$fallback;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        if (AiFilePreviewCoordinator.b(r102, r103, r104) == false) goto L8;
        FLogger.f375446a.i("AiFilePreview", "invoke legacy fallback");     // Catch: Throwable -> L11
        r105.invoke();     // Catch: Throwable -> L11
    L9:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        if ((r108 instanceof CancellationException) == true) goto L18;
        FLogger.f375446a.e("AiFilePreview", "fallback failed, stage=legacy, errorType=".concat(r108.getClass().getSimpleName()), r108);
        goto L20
    L18:
        throw r108;
    L20:
        return Unit.INSTANCE;
    L8:
        FLogger.f375446a.i("AiFilePreview", "skip fallback on main, reason=context_changed");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

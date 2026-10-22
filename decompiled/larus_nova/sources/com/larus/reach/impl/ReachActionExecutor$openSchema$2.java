package com.larus.reach.impl;

import android.app.Activity;
import android.content.Context;
import com.larus.platform.service.n3;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.reach.impl.ReachActionExecutor$openSchema$2", f = "ReachActionExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ReachActionExecutor$openSchema$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ns9.t $request;
    final /* synthetic */ String $validSchema;
    private /* synthetic */ Object L$0;
    int label;

    public ReachActionExecutor$openSchema$2(Context r100, String r101, ns9.t r102, Continuation<? super ReachActionExecutor$openSchema$2> r103) {
        this.$context = r100;
        this.$validSchema = r101;
        this.$request = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ReachActionExecutor$openSchema$2 r102 = new ReachActionExecutor$openSchema$2(this.$context, this.$validSchema, this.$request, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Result<? extends Unit>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Result<Unit>> r101) {
        return ((ReachActionExecutor$openSchema$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Context r102 = this.$context;
        String r103 = this.$validSchema;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        int r105 = n3.f365779a;     // Catch: Throwable -> L10
        Activity r106 = com.larus.reach.runtime.t.b();     // Catch: Throwable -> L10
        if (r106 == null) goto L8;
        r102 = r106;
    L8:
        n3.a(r102, r103);     // Catch: Throwable -> L10
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        ns9.t r108 = this.$request;
        Throwable r109 = Result.m9452exceptionOrNullimpl(r107);
        if (r109 == null) goto L16;
        FLogger.f375446a.w("ReachAction", "reach action failed, reachUniqueId=" + r108.f520408a.f520400h, r109);
    L16:
        return Result.m9448boximpl(r107);
    L10:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

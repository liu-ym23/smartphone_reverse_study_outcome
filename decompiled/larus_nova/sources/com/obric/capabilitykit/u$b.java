package com.obric.capabilitykit;

import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.logger.Logger;
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
import wia.y;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$1", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class u$b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f396318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y f396319b;

    public u$b(y r100, Continuation<? super u$b> r101) {
        this.f396319b = r100;
        super(2, r101);
    }

    public final Object a(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((u$b) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new u$b(this.f396319b, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return a(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f396318a != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        Logger.INSTANCE.e("UriFileOpener", "return failure to the receiver: " + this.f396319b.f559912c + " ---> URI " + this.f396319b.f559910a);
        y r101 = this.f396319b;
        r101.f559911b.onSessionReady(new UriFileAccessSession(4, "分享方未能开启 URI = " + r101.f559910a, 4));     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        Logger.INSTANCE.e("UriFileOpener", "cannot notify failure to the receiver; e=" + r103, r103);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

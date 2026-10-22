package com.larus.office.base.plugins.authorization;

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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.plugins.authorization.AuthorizationCookiesInjectorForLark$attachInternal$1", f = "AuthorizationCookiesInjectorForLark.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AuthorizationCookiesInjectorForLark$attachInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public AuthorizationCookiesInjectorForLark$attachInternal$1(Continuation<? super AuthorizationCookiesInjectorForLark$attachInternal$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AuthorizationCookiesInjectorForLark$attachInternal$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AuthorizationCookiesInjectorForLark$attachInternal$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        AuthorizationCookiesInjectorForLark r102 = AuthorizationCookiesInjectorForLark.f360724a;     // Catch: Throwable -> L7
        AuthorizationCookiesInjectorForLark.e();     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        FLogger r105 = FLogger.f375446a;
        AuthorizationCookiesInjectorForLark r106 = AuthorizationCookiesInjectorForLark.f360724a;
        r105.e("AuthorizationCookiesInjectorForLark", "attach updateCookies failed", r104);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

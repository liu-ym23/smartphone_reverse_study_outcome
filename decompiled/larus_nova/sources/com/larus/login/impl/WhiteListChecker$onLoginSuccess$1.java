package com.larus.login.impl;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/fragment/app/FragmentActivity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.login.impl.WhiteListChecker$onLoginSuccess$1", f = "WhiteListChecker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WhiteListChecker$onLoginSuccess$1 extends SuspendLambda implements Function2<FragmentActivity, Continuation<? super Unit>, Object> {
    int label;

    public WhiteListChecker$onLoginSuccess$1(Continuation<? super WhiteListChecker$onLoginSuccess$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new WhiteListChecker$onLoginSuccess$1(r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FragmentActivity r100, Continuation<? super Unit> r101) {
        return ((WhiteListChecker$onLoginSuccess$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FragmentActivity r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        int r101 = WhiteListChecker.f357247a;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

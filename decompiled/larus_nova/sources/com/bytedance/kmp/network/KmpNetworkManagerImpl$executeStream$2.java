package com.bytedance.kmp.network;

import com.bytedance.kmp.network.response.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 0})
@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkManagerImpl$executeStream$2", f = "KmpNetworkManagerImpl.kt", i = {}, l = {211, 230}, m = "invokeSuspend", n = {}, s = {})
final class KmpNetworkManagerImpl$executeStream$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i $callback;
    final /* synthetic */ jd6.c $request;
    int label;
    final /* synthetic */ KmpNetworkManagerImpl this$0;

    public KmpNetworkManagerImpl$executeStream$2(KmpNetworkManagerImpl r100, jd6.c r101, i r102, Continuation<? super KmpNetworkManagerImpl$executeStream$2> r103) {
        this.this$0 = r100;
        this.$request = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new KmpNetworkManagerImpl$executeStream$2(this.this$0, this.$request, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((KmpNetworkManagerImpl$executeStream$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        i r103 = this.$callback;
        KmpNetworkManagerImpl r104 = this.this$0;
        KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 r105 = new KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1(r103, r104);
        c r106 = r104.f252469a;
        this.label = 2;
        if (r106.L((jd6.c) r100, r105, this) != r101) goto L17;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        KmpNetworkManagerImpl r107 = this.this$0;
        jd6.c r108 = this.$request;
        this.label = 1;
        r100 = r107.c(r108, this);
        if (r100 != r101) goto L13;
        return r101;
    }
}

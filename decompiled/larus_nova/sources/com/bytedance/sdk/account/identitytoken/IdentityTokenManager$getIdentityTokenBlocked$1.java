package com.bytedance.sdk.account.identitytoken;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/sdk/account/identitytoken/a;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.bytedance.sdk.account.identitytoken.IdentityTokenManager$getIdentityTokenBlocked$1", f = "IdentityTokenManager.kt", i = {0}, l = {141}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
final class IdentityTokenManager$getIdentityTokenBlocked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {
    final /* synthetic */ String $enterFrom;
    final /* synthetic */ GetIdentityTokenScene $scene;
    Object L$0;
    int label;
    private CoroutineScope p$;

    public IdentityTokenManager$getIdentityTokenBlocked$1(GetIdentityTokenScene r100, String r101, Continuation r102) {
        this.$scene = r100;
        this.$enterFrom = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        IdentityTokenManager$getIdentityTokenBlocked$1 r102 = new IdentityTokenManager$getIdentityTokenBlocked$1(this.$scene, this.$enterFrom, r101);
        r102.p$ = (CoroutineScope) r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super a> r101) {
        return ((IdentityTokenManager$getIdentityTokenBlocked$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r104 = this.p$;
        IdentityTokenManager r105 = IdentityTokenManager.f268907h;
        GetIdentityTokenScene r106 = this.$scene;
        String r107 = this.$enterFrom;
        this.L$0 = r104;
        this.label = 1;
        r100 = r105.c(r106, r107, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}

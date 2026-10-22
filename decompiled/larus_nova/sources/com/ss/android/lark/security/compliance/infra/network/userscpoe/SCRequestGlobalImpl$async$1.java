package com.ss.android.lark.security.compliance.infra.network.userscpoe;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.security.compliance.infra.network.userscpoe.SCRequestGlobalImpl$async$1", f = "SCRequestGlobalImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SCRequestGlobalImpl$async$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.d<T> $callback;
    final /* synthetic */ com.ss.android.lark.security.compliance.infra.network.g $request;
    int label;
    final /* synthetic */ SCRequestGlobalImpl this$0;

    public SCRequestGlobalImpl$async$1(SCRequestGlobalImpl r100, com.ss.android.lark.security.compliance.infra.network.g r101, com.ss.android.lark.security.compliance.infra.network.d<T> r102, Continuation<? super SCRequestGlobalImpl$async$1> r103) {
        this.this$0 = r100;
        this.$request = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SCRequestGlobalImpl$async$1(this.this$0, this.$request, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SCRequestGlobalImpl$async$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.this$0.f440455b.a(this.$request, this.$callback);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

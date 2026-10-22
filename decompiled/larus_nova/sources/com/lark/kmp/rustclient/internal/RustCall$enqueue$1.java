package com.lark.kmp.rustclient.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001c\u0010\u0003\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004j\b\u0012\u0004\u0012\u0002H\u0002`\u0006H\n"}, d2 = {"<anonymous>", "", "Resp", "it", "Lcom/lark/kmp/rustclient/api/model/RustOutput;", "Lcom/suite/lark/rust/callback/AsyncCallbackData;", "Lcom/lark/kmp/rustclient/api/model/RustAsyncResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.RustCall$enqueue$1", f = "RustCall.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RustCall$enqueue$1 extends SuspendLambda implements Function2<com.lark.kmp.rustclient.api.model.g<rpc.a, Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.lark.kmp.rustclient.api.h<Object> $chain;
    /* synthetic */ Object L$0;
    int label;

    public RustCall$enqueue$1(com.lark.kmp.rustclient.api.h<Object> r100, Continuation<? super RustCall$enqueue$1> r101) {
        this.$chain = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        RustCall$enqueue$1 r102 = new RustCall$enqueue$1(this.$chain, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(com.lark.kmp.rustclient.api.model.g<rpc.a, Object> r100, Continuation<? super Unit> r101) {
        return ((RustCall$enqueue$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(com.lark.kmp.rustclient.api.model.g<rpc.a, Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        com.lark.kmp.rustclient.api.model.g r101 = (com.lark.kmp.rustclient.api.model.g) this.L$0;
        com.lark.kmp.rustclient.api.model.c<Object> r102 = this.$chain.f282460c.f282454a;
        StringBuilder r103 = new StringBuilder("async invoke return response: ");
        com.lark.kmp.rustclient.api.model.f r104 = com.lark.kmp.rustclient.api.model.i.f282481a;
        Intrinsics.checkNotNullParameter(r101, "response");
        if ((r101 instanceof com.lark.kmp.rustclient.api.model.k) == false) goto L8;
        String r105 = "succeed";
    L10:
        r103.append(r105);
        r103.append('.');
        com.lark.kmp.rustclient.a.a(r102, r103.toString());
        return Unit.INSTANCE;
    L8:
        if ((r101 instanceof com.lark.kmp.rustclient.api.model.b) == false) goto L13;
        r105 = "error";
        goto L10
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

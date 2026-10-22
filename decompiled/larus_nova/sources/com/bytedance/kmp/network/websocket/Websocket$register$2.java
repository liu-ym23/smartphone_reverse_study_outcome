package com.bytedance.kmp.network.websocket;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 0})
@DebugMetadata(c = "com.bytedance.kmp.network.websocket.Websocket$register$2", f = "Websocket.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
final class Websocket$register$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ c $info;
    final /* synthetic */ a $listener;
    int label;
    final /* synthetic */ e this$0;

    public Websocket$register$2(a r100, e r101, c r102, Continuation<? super Websocket$register$2> r103) {
        this.$listener = r100;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new Websocket$register$2(this.$listener, null, null, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Integer> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Integer> r101) {
        return ((Websocket$register$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        Intrinsics.checkNotNullParameter(this.$listener, "delegate");
        throw null;
    L5:
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        ((Number) r100).intValue();
        throw null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

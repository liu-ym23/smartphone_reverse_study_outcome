package com.larus.im.internal.trace.stable;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.trace.stable.FlowAVTraceTimer$launch$1", f = "FlowAVTraceTimer.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
public final class FlowAVTraceTimer$launch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowAVTraceTimer$launch$1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super FlowAVTraceTimer$launch$1> r101) {
        this.$block = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FlowAVTraceTimer$launch$1 r102 = new FlowAVTraceTimer$launch$1(this.$block, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowAVTraceTimer$launch$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L11;
        if (r102 != 1) goto L10;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L7
    L20:
    L19:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        Function2<CoroutineScope, Continuation<? super Unit>, Object> r104 = this.$block;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r104.invoke(r103, this) != r101) goto L20;
        return r101;
    L7:
        th = move-exception;
        if ((th instanceof CancellationException) == true) goto L19;
        fe9.a.f476620a.b("FlowAVTraceTimer", "[scope] launch exception: " + th.getMessage());
        goto L19
    }
}

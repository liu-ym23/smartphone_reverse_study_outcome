package com.larus.ui.arch.vm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, "Lcom/larus/ui/arch/vm/external/ComponentState;", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$onEachDelay$1", f = "ComponentStateOperator.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$onEachDelay$1<S> extends SuspendLambda implements Function2<FlowCollector<? super S>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    int label;

    public ComponentStateOperator$onEachDelay$1(long r100, Continuation<? super ComponentStateOperator$onEachDelay$1> r101) {
        this.$delayMs = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ComponentStateOperator$onEachDelay$1(this.$delayMs, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
        return invoke((FlowCollector) r100, r101);
    }

    public final Object invoke(FlowCollector<? super S> r100, Continuation<? super Unit> r101) {
        return ((ComponentStateOperator$onEachDelay$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        long r103 = this.$delayMs;
        this.label = 1;
        if (DelayKt.delay(r103, this) != r101) goto L12;
        return r101;
    }
}

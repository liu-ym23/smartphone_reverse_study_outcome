package com.larus.bot.impl.common.util;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.SharedFlowThrottleLatest$emitAt$2$1", f = "FlowExt.kt", i = {}, l = {96, 97}, m = "invokeSuspend", n = {}, s = {})
final class SharedFlowThrottleLatest$emitAt$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f.a<Object> $it;
    final /* synthetic */ long $timeSinceLastEmit;
    int label;
    final /* synthetic */ f<Object> this$0;

    public SharedFlowThrottleLatest$emitAt$2$1(f<Object> r100, long r101, f.a<Object> r102, Continuation<? super SharedFlowThrottleLatest$emitAt$2$1> r103) {
        this.this$0 = r100;
        this.$timeSinceLastEmit = r101;
        this.$it = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SharedFlowThrottleLatest$emitAt$2$1(this.this$0, this.$timeSinceLastEmit, this.$it, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SharedFlowThrottleLatest$emitAt$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        f<Object> r103 = this.this$0;
        Object r104 = this.$it.f317685a;
        this.label = 2;
        r103.f317684f = null;
        r103.f317683e = System.currentTimeMillis();
        Object r105 = r103.f317681c.emit(r104, this);
        if (r105 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        r105 = Unit.INSTANCE;
    L17:
        if (r105 != r101) goto L20;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        long r106 = this.this$0.f317680b - this.$timeSinceLastEmit;
        this.label = 1;
        if (DelayKt.delay(r106, this) != r101) goto L13;
        return r101;
    }
}

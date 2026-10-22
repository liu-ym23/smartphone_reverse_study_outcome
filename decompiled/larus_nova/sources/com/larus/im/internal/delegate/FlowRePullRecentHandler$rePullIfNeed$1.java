package com.larus.im.internal.delegate;

import com.larus.im.constant.CompensateScene;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.delegate.FlowRePullRecentHandler$rePullIfNeed$1", f = "FlowRePullRecentHandler.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
final class FlowRePullRecentHandler$rePullIfNeed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public FlowRePullRecentHandler$rePullIfNeed$1(Continuation<? super FlowRePullRecentHandler$rePullIfNeed$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowRePullRecentHandler$rePullIfNeed$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowRePullRecentHandler$rePullIfNeed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L11:
        a r111 = a.f348188b;
        r111.i("FlowRePullRecentHandler", "rePullIfNeed trigger pull recent");
        int r102 = com.larus.im.internal.core.conversation.group.j.f347627a;
        com.larus.im.internal.core.conversation.group.j.b(CompensateScene.DOWNGRADE_REFORM);
        r111.i("FlowRePullRecentHandler", "rePullIfNeed finish");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        Random r112 = com.larus.im.internal.utils.w.f350562a;
        Lazy r113 = u0.f348260a;
        int r103 = ((Number) r113.getValue()).intValue();
        Lazy r104 = u0.f348261b;
        long r105 = ((long) com.larus.im.internal.utils.w.f350562a.nextInt(r103, ((Number) r104.getValue()).intValue())) * 1000;
        a.f348188b.i("FlowRePullRecentHandler", "rePullIfNeed, delayTime:" + r105 + ",minDelayTime:" + ((Number) r113.getValue()).intValue() + ",maxDelayTime:" + ((Number) r104.getValue()).intValue());
        this.label = 1;
        if (DelayKt.delay(r105, this) != r100) goto L11;
        return r100;
    }
}

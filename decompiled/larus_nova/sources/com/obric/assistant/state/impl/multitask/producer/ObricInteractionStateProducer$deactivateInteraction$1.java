package com.obric.assistant.state.impl.multitask.producer;

import aha.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricInteractionStateProducer$deactivateInteraction$1", f = "ObricInteractionStateProducer.kt", i = {0}, l = {124}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class ObricInteractionStateProducer$deactivateInteraction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $snapshotExt;
    final /* synthetic */ jha.g<n> $taskId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ObricInteractionStateProducer this$0;

    public ObricInteractionStateProducer$deactivateInteraction$1(ObricInteractionStateProducer r100, jha.g<n> r101, Map<String, ? extends Object> r102, Continuation<? super ObricInteractionStateProducer$deactivateInteraction$1> r103) {
        this.this$0 = r100;
        this.$taskId = r101;
        this.$snapshotExt = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricInteractionStateProducer$deactivateInteraction$1(this.this$0, this.$taskId, this.$snapshotExt, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricInteractionStateProducer$deactivateInteraction$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Map<String, Object> r103 = (Map) this.L$3;
        jha.g<n> r104 = (jha.g) this.L$2;
        ObricInteractionStateProducer r105 = (ObricInteractionStateProducer) this.L$1;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r100);
    L18:
        ObricInteractionStateProducer.d(r105, r104, r103);     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r106.unlock(null);
        return Unit.INSTANCE;
    L15:
        th = move-exception;
        r106.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ObricInteractionStateProducer r108 = this.this$0;
        r106 = r108.f393101c;
        r104 = this.$taskId;
        Map<String, Object> r109 = this.$snapshotExt;
        this.L$0 = r106;
        this.L$1 = r108;
        this.L$2 = r104;
        this.L$3 = r109;
        this.label = 1;
        if (r106.a(null, this) != r101) goto L11;
        return r101;
    L11:
        r105 = r108;
        r103 = r109;
        goto L18
    }
}

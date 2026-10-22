package com.obric.assistant.state.impl.multitask.producer;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer$onMajorStateChanged$1", f = "RealtimeCallStateProducer.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallStateProducer$onMajorStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callId;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ int $currentState;
    final /* synthetic */ int $prevState;
    int label;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$onMajorStateChanged$1(RealtimeCallStateProducer r100, String r101, String r102, int r103, int r104, Continuation<? super RealtimeCallStateProducer$onMajorStateChanged$1> r105) {
        this.this$0 = r100;
        this.$callId = r101;
        this.$conversationId = r102;
        this.$prevState = r103;
        this.$currentState = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RealtimeCallStateProducer$onMajorStateChanged$1(this.this$0, this.$callId, this.$conversationId, this.$prevState, this.$currentState, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RealtimeCallStateProducer$onMajorStateChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L15:
        RealtimeCallStateProducer.a r103 = (RealtimeCallStateProducer.a) r100;
        if (r103 != null) goto L25;
        RealtimeCallStateProducer r104 = this.this$0;
        String r105 = this.$callId;
        int r106 = this.$prevState;
        int r107 = this.$currentState;
        LinkedHashMap r108 = (LinkedHashMap) r104.f393115e;
        Object r109 = r108.get(r105);
        if (r109 != null) goto L20;
        r109 = new ArrayDeque();
        r108.put(r105, r109);
    L20:
        ArrayDeque r110 = (ArrayDeque) r109;
        if (r110.size() != 16) goto L23;
        r110.removeFirst();
    L23:
        r110.addLast(new RealtimeCallStateProducer.c(r106, r107));
        return Unit.INSTANCE;
    L25:
        RealtimeCallStateProducer r111 = this.this$0;
        int r112 = this.$prevState;
        int r113 = this.$currentState;
        int r114 = RealtimeCallStateProducer.f393110j;
        r111.i(r103, r112, r113);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        if (this.this$0.f393117g.contains(this.$callId) == true) goto L11;
        RealtimeCallStateProducer r115 = this.this$0;
        String r116 = this.$callId;
        String r117 = this.$conversationId;
        this.label = 1;
        r100 = RealtimeCallStateProducer.h(r115, r116, r117, this);
        if (r100 != r101) goto L15;
        return r101;
    L11:
        return Unit.INSTANCE;
    }
}

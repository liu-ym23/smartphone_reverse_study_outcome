package com.obric.assistant.state.impl.multitask.producer;

import java.util.LinkedHashMap;
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
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer$onPluginStarted$1", f = "RealtimeCallStateProducer.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallStateProducer$onPluginStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callId;
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$onPluginStarted$1(RealtimeCallStateProducer r100, String r101, String r102, Continuation<? super RealtimeCallStateProducer$onPluginStarted$1> r103) {
        this.this$0 = r100;
        this.$callId = r101;
        this.$conversationId = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RealtimeCallStateProducer$onPluginStarted$1(this.this$0, this.$callId, this.$conversationId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RealtimeCallStateProducer$onPluginStarted$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        if (this.this$0.f393117g.contains(this.$callId) == true) goto L11;
        Map<String, RealtimeCallStateProducer.a> r103 = this.this$0.f393112b;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        RealtimeCallStateProducer.a r105 = (RealtimeCallStateProducer.a) r104.get(this.$conversationId);
        if (r105 != null) goto L16;
        this.this$0.f393114d.put(this.$conversationId, this.$callId);
        return Unit.INSTANCE;
    L16:
        RealtimeCallStateProducer r106 = this.this$0;
        String r107 = this.$callId;
        this.label = 1;
        if (r106.j(r105, r107, this) != r101) goto L20;
        return r101;
    L11:
        return Unit.INSTANCE;
    }
}

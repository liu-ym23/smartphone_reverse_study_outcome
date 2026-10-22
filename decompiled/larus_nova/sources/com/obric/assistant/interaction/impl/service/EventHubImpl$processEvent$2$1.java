package com.obric.assistant.interaction.impl.service;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.obric.assistant.interaction.impl.event.processor.base.IEventProcessor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.service.EventHubImpl$processEvent$2$1", f = "EventHubImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EventHubImpl$processEvent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InteractionEvent $event;
    final /* synthetic */ IEventProcessor $it;
    int label;

    public EventHubImpl$processEvent$2$1(IEventProcessor r100, InteractionEvent r101, Continuation<? super EventHubImpl$processEvent$2$1> r102) {
        this.$it = r100;
        this.$event = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new EventHubImpl$processEvent$2$1(this.$it, this.$event, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EventHubImpl$processEvent$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        FLogger.f375446a.d("EventHubImpl", "processEvent: final with processor " + this.$it + " and event " + this.$event);
        this.$it.process(this.$event);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

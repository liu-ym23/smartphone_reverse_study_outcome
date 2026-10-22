package com.obric.assistant.interaction.impl.service;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IEventHub;
import com.obric.assistant.interaction.base.model.InteractionEvent;
import com.obric.assistant.interaction.impl.event.annotation.EventProcessor;
import com.obric.assistant.interaction.impl.event.processor.AssistantActivityEventProcessor;
import com.obric.assistant.interaction.impl.event.processor.CommonEventProcessor;
import com.obric.assistant.interaction.impl.event.processor.KeyguardLockEventProcessor;
import com.obric.assistant.interaction.impl.event.processor.MicMuteEventProcessor;
import com.obric.assistant.interaction.impl.event.processor.SessionLifecycleEventProcessor;
import com.obric.assistant.interaction.impl.event.processor.base.IEventProcessor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.w1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0012\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/assistant/interaction/impl/service/EventHubImpl;", "Lcom/obric/assistant/interaction/api/service/IEventHub;", "<init>", "()V", "TAG", "", "defaultProcessors", "", "Lcom/obric/assistant/interaction/impl/event/processor/base/IEventProcessor;", "getDefaultProcessors", "()[Lcom/obric/assistant/interaction/impl/event/processor/base/IEventProcessor;", "defaultProcessors$delegate", "Lkotlin/Lazy;", "_eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "eventFlow", "getEventFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "scopeContext", "Lkotlin/coroutines/CoroutineContext;", "eventHubEmitScope", "Lkotlinx/coroutines/CoroutineScope;", "serviceHandleScopeContext", "eventHubHandleScope", "serviceJob", "Lkotlinx/coroutines/Job;", "onEvent", "", "event", "eventProcessors", "", "init", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "start", "processEvent", "stop", "release", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventHubImpl implements IEventHub {
    public static final EventHubImpl INSTANCE = null;
    private static final String TAG = "EventHubImpl";
    private static final MutableSharedFlow<InteractionEvent> _eventFlow = null;
    private static final Lazy defaultProcessors$delegate = null;
    private static final CoroutineScope eventHubEmitScope = null;
    private static final CoroutineScope eventHubHandleScope = null;
    private static final List<IEventProcessor> eventProcessors = null;
    private static final CoroutineContext scopeContext = null;
    private static final CoroutineContext serviceHandleScopeContext = null;
    private static Job serviceJob;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.service.EventHubImpl$onEvent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.service.EventHubImpl$onEvent$1", f = "EventHubImpl.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InteractionEvent $event;
        int label;

        public AnonymousClass1(InteractionEvent r100, Continuation<? super AnonymousClass1> r101) {
            this.$event = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$event, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            FLogger.f375446a.d(EventHubImpl.TAG, "emit event: " + this.$event);
            MutableSharedFlow r103 = EventHubImpl.access$get_eventFlow$p();
            InteractionEvent r104 = this.$event;
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.service.EventHubImpl$start$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.service.EventHubImpl$start$1", f = "EventHubImpl.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    public static final class C116251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C116251(Continuation<? super C116251> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C116251(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C116251) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MutableSharedFlow r103 = EventHubImpl.access$get_eventFlow$p();
            FlowCollector r104 = C46101.INSTANCE;
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    private EventHubImpl() {
    }

    public static /* synthetic */ IEventProcessor[] a() {
        return defaultProcessors_delegate$lambda$0();
    }

    private static final IEventProcessor[] defaultProcessors_delegate$lambda$0() {
        return new IEventProcessor[]{SessionLifecycleEventProcessor.INSTANCE, AssistantActivityEventProcessor.INSTANCE, KeyguardLockEventProcessor.INSTANCE, CommonEventProcessor.INSTANCE, MicMuteEventProcessor.INSTANCE};
    }

    static {
        INSTANCE = new EventHubImpl();
        defaultProcessors$delegate = LazyKt.lazy(new a());
        _eventFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        ExecutorCoroutineDispatcher r100 = w1.a(1, "EventHubEmitContext");
        scopeContext = r100;
        eventHubEmitScope = CoroutineScopeKt.CoroutineScope(r100.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        ExecutorCoroutineDispatcher r101 = w1.a(1, "serviceHandleScopeContext");
        serviceHandleScopeContext = r101;
        eventHubHandleScope = CoroutineScopeKt.CoroutineScope(r101.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        eventProcessors = new ArrayList();
    }

    private final IEventProcessor[] getDefaultProcessors() {
        return (IEventProcessor[]) defaultProcessors$delegate.getValue();
    }

    @Override // com.obric.assistant.interaction.api.lifecycle.ILifecycleService
    public void release() {
        FLogger.f375446a.d(TAG, "release");
        stop();
        eventProcessors.clear();
    }

    @Override // com.obric.assistant.interaction.api.lifecycle.ILifecycleService
    public void start() {
        FLogger.f375446a.d(TAG, "start");
        serviceJob = BuildersKt.launch$default(eventHubHandleScope, null, null, new C116251(null), 3, null);
    }

    @Override // com.obric.assistant.interaction.api.lifecycle.ILifecycleService
    public void stop() {
        FLogger.f375446a.d(TAG, "stop");
        Job r100 = serviceJob;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        serviceJob = null;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_eventFlow$p() {
        return _eventFlow;
    }

    @Override // com.obric.assistant.interaction.api.service.IEventHub
    public MutableSharedFlow<InteractionEvent> getEventFlow() {
        return _eventFlow;
    }

    private final void processEvent(InteractionEvent r110) {
        FLogger.f375446a.d(TAG, "processEvent: " + r110 + " with class " + Reflection.getOrCreateKotlinClass(r110.getClass()));
        List<IEventProcessor> r100 = eventProcessors;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        KClass r103 = null;
        if (r102.hasNext() == false) goto L30;
        Object r104 = r102.next();
        EventProcessor r105 = (EventProcessor) ((IEventProcessor) r104).getClass().getAnnotation(EventProcessor.class);
        boolean r106 = true;
        if (r105 == null) goto L25;
        KClass[] r107 = Reflection.getOrCreateKotlinClasses(r105.clazzes());
        if (r107 == null) goto L25;
        int r108 = r107.length;
        int r109 = 0;
    L10:
        if (r109 >= r108) goto L25;
        KClass r111 = r107[r109];
        Collection<KClass<?>> r112 = r111.getNestedClasses();
        if ((r112 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r113 = r112.iterator();
    L18:
        if (r113.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(((KClass) r113.next()).getQualifiedName(), Reflection.getOrCreateKotlinClass(r110.getClass()).getQualifiedName()) == false) goto L18;
        boolean r114 = true;
    L22:
        if (r114 == true) goto L23;
        r109 = r109 + 1;
        goto L10
    L23:
        r103 = r111;
    L15:
        r114 = false;
        goto L22
    L14:
        if (r112.isEmpty() == false) goto L16;
    L25:
        if (r103 != null) goto L28;
        r106 = false;
    L28:
        if (r106 == false) goto L3;
        r101.add(r104);
        goto L3
    L30:
        Iterator r115 = r101.iterator();
    L32:
        if (r115.hasNext() == false) goto L34;
        IEventProcessor r116 = (IEventProcessor) r115.next();
        BuildersKt.launch$default(r116.scope(), null, null, new EventHubImpl$processEvent$2$1(r116, r110, null), 3, null);
        goto L32
    }

    @Override // com.obric.assistant.interaction.api.lifecycle.ILifecycleService
    public void init(Context r100) {
        FLogger.f375446a.d(TAG, "init");
        List<IEventProcessor> r101 = eventProcessors;
        r101.clear();
        CollectionsKt.addAll(r101, getDefaultProcessors());
    }

    @Override // com.obric.assistant.interaction.api.service.IEventHub
    public void onEvent(InteractionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        BuildersKt.launch$default(eventHubEmitScope, null, null, new AnonymousClass1(r100, null), 3, null);
    }

    public static final /* synthetic */ void access$processEvent(EventHubImpl r100, InteractionEvent r101) {
        r100.processEvent(r101);
    }
}

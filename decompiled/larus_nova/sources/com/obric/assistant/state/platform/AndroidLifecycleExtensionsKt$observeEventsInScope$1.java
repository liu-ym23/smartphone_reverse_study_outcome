package com.obric.assistant.state.platform;

import com.obric.assistant.state.multitask.TaskFlowManager;
import jha.g;
import jha.k;
import jha.o;
import jha.q;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 176)
@DebugMetadata(c = "com.obric.assistant.state.platform.AndroidLifecycleExtensionsKt$observeEventsInScope$1", f = "AndroidLifecycleExtensions.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidLifecycleExtensionsKt$observeEventsInScope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<g<o>, q<o>, Unit> $onEvent;
    final /* synthetic */ TaskFlowManager $this_observeEventsInScope;
    final /* synthetic */ k<o> $type;
    int label;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<g<o>, q<o>, Unit> f393327a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super g<o>, ? super q<o>, Unit> r100) {
            this.f393327a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            Pair r102 = (Pair) r100;
            g<o> r103 = (g) r102.component1();
            q<o> r104 = (q) r102.component2();
            this.f393327a.invoke(r103, r104);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Flow<Pair<? extends g<?>, ? extends q<?>>> {
        @Override // kotlinx.coroutines.flow.Flow
        public final Object collect(FlowCollector<? super Pair<? extends g<?>, ? extends q<?>>> r100, Continuation r101) {
            throw null;
        }
    }

    public static final class c implements Flow<Pair<? extends g<o>, ? extends q<o>>> {
        @Override // kotlinx.coroutines.flow.Flow
        public final Object collect(FlowCollector<? super Pair<? extends g<o>, ? extends q<o>>> r100, Continuation r101) {
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidLifecycleExtensionsKt$observeEventsInScope$1(TaskFlowManager r100, k<o> r101, Function2<? super g<o>, ? super q<o>, Unit> r102, Continuation<? super AndroidLifecycleExtensionsKt$observeEventsInScope$1> r103) {
        this.$this_observeEventsInScope = r100;
        this.$type = r101;
        this.$onEvent = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AndroidLifecycleExtensionsKt$observeEventsInScope$1(this.$this_observeEventsInScope, this.$type, this.$onEvent, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AndroidLifecycleExtensionsKt$observeEventsInScope$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        TaskFlowManager r103 = this.$this_observeEventsInScope;
        k<o> r104 = this.$type;
        r103.getClass();
        Flow r105 = e.c(TaskFlowManager.f393254h, 128, BufferOverflow.DROP_OLDEST);
        Intrinsics.needClassReification();
        a r106 = new a(this.$onEvent);
        this.label = 1;
        Object r107 = r105.collect(new AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$1$2(new AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2(r106), r104), this);
        if (r107 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        r107 = Unit.INSTANCE;
    L13:
        if (r107 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        r107 = Unit.INSTANCE;
    L16:
        if (r107 != r101) goto L19;
        return r101;
    }

    public final Object invokeSuspend$$forInline(Object r100) {
        TaskFlowManager r101 = this.$this_observeEventsInScope;
        k<o> r102 = this.$type;
        r101.getClass();
        Flow r103 = e.c(TaskFlowManager.f393254h, 128, BufferOverflow.DROP_OLDEST);
        Intrinsics.needClassReification();
        a r104 = new a(this.$onEvent);
        InlineMarker.mark(0);
        Object r105 = r103.collect(new AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$1$2(new AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2(r104), r102), this);
        if (r105 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        r105 = Unit.INSTANCE;
    L7:
        if (r105 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        Unit r106 = Unit.INSTANCE;
    L10:
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}

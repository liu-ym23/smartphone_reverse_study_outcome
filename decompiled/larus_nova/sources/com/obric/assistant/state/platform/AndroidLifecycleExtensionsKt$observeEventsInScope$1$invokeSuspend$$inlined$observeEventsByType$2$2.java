package com.obric.assistant.state.platform;

import jha.g;
import jha.q;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes33.dex */
public final class AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowCollector f393330a;

    /* JADX INFO: renamed from: com.obric.assistant.state.platform.AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "com.obric.assistant.state.platform.AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2", f = "AndroidLifecycleExtensions.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2 this$0;

        public AnonymousClass1(AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2 r100, Continuation r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2(FlowCollector r100) {
        this.f393330a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L18:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        FlowCollector r107 = this.f393330a;
        Pair r108 = (Pair) r100;
        g r109 = (g) r108.component1();
        q r110 = (q) r108.component2();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.obric.assistant.state.multitask.core.TaskFlowId<S of com.obric.assistant.state.multitask.ext.TaskFlowExtensionsKt.observeEventsByType>");
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.obric.assistant.state.multitask.core.TaskStateEvent<S of com.obric.assistant.state.multitask.ext.TaskFlowExtensionsKt.observeEventsByType>");
        Pair r111 = TuplesKt.to(r109, r110);
        r102.label = 1;
        if (r107.emit(r111, r102) != r105) goto L18;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}

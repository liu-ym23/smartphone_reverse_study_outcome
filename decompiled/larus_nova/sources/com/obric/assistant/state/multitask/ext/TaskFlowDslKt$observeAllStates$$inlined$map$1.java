package com.obric.assistant.state.multitask.ext;

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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes33.dex */
public final class TaskFlowDslKt$observeAllStates$$inlined$map$1 implements Flow<Pair<? extends jha.g<Object>, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f393294a;

    /* JADX INFO: renamed from: com.obric.assistant.state.multitask.ext.TaskFlowDslKt$observeAllStates$$inlined$map$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowCollector f393295a;

        /* JADX INFO: renamed from: com.obric.assistant.state.multitask.ext.TaskFlowDslKt$observeAllStates$$inlined$map$1$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.assistant.state.multitask.ext.TaskFlowDslKt$observeAllStates$$inlined$map$1$2", f = "TaskFlowDsl.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ AnonymousClass2 this$0;

            public AnonymousClass1(AnonymousClass2 r100, Continuation r101) {
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

        public AnonymousClass2(FlowCollector r100) {
            this.f393295a = r100;
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
            FlowCollector r107 = this.f393295a;
            Pair r108 = (Pair) r100;
            Object r109 = r108.getFirst();
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.obric.assistant.state.multitask.core.TaskFlowId<S of com.obric.assistant.state.multitask.ext.TaskFlowDslKt.observeAllStates>");
            S r110 = ((q) r108.getSecond()).a().f499148b;
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type S of com.obric.assistant.state.multitask.ext.TaskFlowDslKt.observeAllStates");
            Pair r111 = TuplesKt.to((jha.g) r109, r110);
            r102.label = 1;
            if (r107.emit(r111, r102) != r105) goto L18;
            return r105;
        L7:
            r102 = new AnonymousClass1(this, r101);
            goto L8
        }
    }

    public TaskFlowDslKt$observeAllStates$$inlined$map$1(TaskFlowDslKt$observeAllStates$$inlined$filter$1 r100) {
        this.f393294a = r100;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Pair<? extends jha.g<Object>, Object>> r100, Continuation r101) {
        Object r102 = this.f393294a.collect(new AnonymousClass2(r100), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }
}

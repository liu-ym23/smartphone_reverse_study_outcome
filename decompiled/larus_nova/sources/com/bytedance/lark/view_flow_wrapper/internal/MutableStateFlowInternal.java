package com.bytedance.lark.view_flow_wrapper.internal;

import buc.b;
import com.larus.bmhome.share.panel.ShareChannel;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes20.dex */
public final class MutableStateFlowInternal<T> implements z0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0<T> f254433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final buc.a f254434b;

    public static final class a implements FlowCollector<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MutableStateFlowInternal<T> f254435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FlowCollector<T> f254436b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(MutableStateFlowInternal<T> r100, FlowCollector<? super T> r101) {
            this.f254435a = r100;
            this.f254436b = r101;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r100, Continuation<? super Unit> r101) {
            if (this.f254435a.f254434b.c() == false) goto L5;
            Object r102 = this.f254436b.emit(r100, r101);
            if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
            return r102;
        L10:
            return Unit.INSTANCE;
        L5:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.lark.view_flow_wrapper.internal.MutableStateFlowInternal$collect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.lark.view_flow_wrapper.internal.MutableStateFlowInternal", f = "MutableStateFlowInternal.kt", i = {}, l = {38}, m = ShareChannel.COLLECT, n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MutableStateFlowInternal<T> this$0;

        public AnonymousClass1(MutableStateFlowInternal<T> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.z0
    public final boolean compareAndSet(T r100, T r101) {
        return this.f254433a.compareAndSet(r100, r101);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r100, Continuation<? super Unit> r101) {
        return this.f254433a.emit(r100, r101);
    }

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.MutableSharedFlow
    public final List<T> getReplayCache() {
        return this.f254433a.getReplayCache();
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final i1<Integer> getSubscriptionCount() {
        return this.f254433a.getSubscriptionCount();
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() {
        this.f254433a.resetReplayCache();
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(T r100) {
        return this.f254433a.tryEmit(r100);
    }

    @Override // kotlinx.coroutines.flow.z0, kotlinx.coroutines.flow.i1
    public final T getValue() {
        return this.f254433a.getValue();
    }

    public MutableStateFlowInternal(StateFlowImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        this.f254433a = r100;
        this.f254434b = b.a(false);
    }

    @Override // kotlinx.coroutines.flow.z0
    public final void setValue(T r100) {
        this.f254434b.a(false, true);
        this.f254433a.setValue(r100);
    }

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super T> r100, Continuation<?> r101) {
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
        if (r106 != 1) goto L12;
        ResultKt.throwOnFailure(r104);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        a r107 = new a(this, r100);
        z0<T> r108 = this.f254433a;
        r102.label = 1;
        if (r108.collect(r107, r102) != r105) goto L18;
        return r105;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}

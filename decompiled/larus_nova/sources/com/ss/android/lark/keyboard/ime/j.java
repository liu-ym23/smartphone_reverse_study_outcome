package com.ss.android.lark.keyboard.ime;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements z0<ImeStateDetail> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StateFlowImpl f429395a;

    public final ImeStateDetail b() {
        return (ImeStateDetail) this.f429395a.getValue();
    }

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super ImeStateDetail> r100, Continuation<?> r101) {
        return this.f429395a.collect(r100, r101);
    }

    @Override // kotlinx.coroutines.flow.d1, kotlinx.coroutines.flow.MutableSharedFlow
    public final List<ImeStateDetail> getReplayCache() {
        return this.f429395a.getReplayCache();
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final i1<Integer> getSubscriptionCount() {
        return this.f429395a.getSubscriptionCount();
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final void resetReplayCache() {
        this.f429395a.resetReplayCache();
        throw null;
    }

    @Override // kotlinx.coroutines.flow.z0, kotlinx.coroutines.flow.i1
    public final /* bridge */ /* synthetic */ Object getValue() {
        return b();
    }

    public j(ImeStateDetail r100) {
        Intrinsics.checkNotNullParameter(r100, "initialState");
        this.f429395a = j1.a(r100);
    }

    @Override // kotlinx.coroutines.flow.z0
    public final void setValue(ImeStateDetail r100) {
        ImeStateDetail r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f429395a.setValue(r101);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public final boolean tryEmit(Object r100) {
        ImeStateDetail r101 = (ImeStateDetail) r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f429395a.setValue(r101);
        return true;
    }

    @Override // kotlinx.coroutines.flow.z0
    public final boolean compareAndSet(ImeStateDetail r100, ImeStateDetail r101) {
        ImeStateDetail r102 = r100;
        ImeStateDetail r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "expect");
        Intrinsics.checkNotNullParameter(r103, "update");
        return this.f429395a.compareAndSet(r102, r103);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        StateFlowImpl r102 = this.f429395a;
        r102.setValue((ImeStateDetail) r100);
        return Unit.INSTANCE;
    }
}

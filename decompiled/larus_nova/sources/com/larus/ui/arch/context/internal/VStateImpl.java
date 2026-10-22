package com.larus.ui.arch.context.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import t1a.c;
import t1a.e;

/* JADX INFO: loaded from: classes31.dex */
public final class VStateImpl<T extends c> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f375172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableSharedFlow<T> f375173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a1 f375174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f375175d;

    @Override // t1a.e
    public final void destroy() {
        CoroutineScopeKt.cancel$default(this.f375175d, null, 1, null);
    }

    @Override // t1a.e
    public final T getSource() {
        return this.f375172a;
    }

    public VStateImpl(T r100) {
        Intrinsics.checkNotNullParameter(r100, "initialSource");
        this.f375172a = r100;
        MutableSharedFlow<T> r101 = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        this.f375173b = r101;
        this.f375174c = kotlinx.coroutines.flow.e.a(r101);
        this.f375175d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        r101.tryEmit(r100);
    }

    @Override // t1a.e
    public final void a(Function1<? super T, ? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "reducer");
        BuildersKt.launch$default(this.f375175d, null, null, new VStateImpl$setState$1(r100, this, null), 3, null);
    }

    @Override // t1a.e
    public final void b(Function2<? super T, ? super T, Boolean> r110, boolean r111, Function1<? super T, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "compare");
        Intrinsics.checkNotNullParameter(r112, "action");
        BuildersKt.launch$default(this.f375175d, null, null, new VStateImpl$onEach$1(this, r111, r110, r112, null), 3, null);
    }
}

package com.larus.ui.arch.vm.internal;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.w;
import w1a.b;

/* JADX INFO: loaded from: classes31.dex */
public final class ComponentStateOperator<S extends w1a.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f375187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f375188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final S f375189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f375190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f375191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f375192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f375193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final v1a.b<S> f375194h;

    public final Flow<S> a() {
        return (Flow) this.f375191e.getValue();
    }

    public final n<S> b() {
        return (n) this.f375190d.getValue();
    }

    public ComponentStateOperator(LifecycleOwner r100, CoroutineScope r101, S r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "componentVMScope");
        Intrinsics.checkNotNullParameter(r102, "initialState");
        this.f375187a = r100;
        this.f375188b = r101;
        this.f375189c = r102;
        this.f375190d = LazyKt.lazy(new d(this));
        this.f375191e = LazyKt.lazy(new e(this));
        this.f375192f = LazyKt.lazy(new f());
        this.f375193g = LazyKt.lazy(new g());
        boolean r103 = x1a.a.f562150a;
        if (x1a.a.f562150a == false) goto L5;
        v1a.b<S> r104 = new v1a.b(r102);
    L6:
        this.f375194h = r104;
        return;
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Job c(KProperty1<S, ? extends w1a.a<? extends T>> r100, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> r101, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "asyncProp");
        ComponentStateOperator$onAsync$1 r103 = new ComponentStateOperator$onAsync$1(r102, r101, null);
        return h(r100, new w1a.h(0), r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A> Job h(final KProperty1<S, ? extends A> r100, w1a.d r101, Function2<? super A, ? super Continuation<? super Unit>, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "deliveryMode");
        Intrinsics.checkNotNullParameter(r102, "action");
        final Flow<S> r103 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$1(r103, r100)), this.f375187a, r101.a(new KProperty1[]{r100}), new ComponentStateOperator$onEach$2(r102, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B> Job g(final KProperty1<S, ? extends A> r100, final KProperty1<S, ? extends B> r101, w1a.d r102, Function3<? super A, ? super B, ? super Continuation<? super Unit>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "prop2");
        Intrinsics.checkNotNullParameter(r102, "deliveryMode");
        Intrinsics.checkNotNullParameter(r103, "action");
        final Flow<S> r104 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$2(r104, r100, r101)), this.f375187a, r102.a(new KProperty1[]{r100, r101}), new ComponentStateOperator$onEach$4(r103, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A> Job i(long r100, final KProperty1<S, ? extends A> r101, w1a.d r102, Function2<? super A, ? super Continuation<? super Unit>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r101, "prop1");
        Intrinsics.checkNotNullParameter(r102, "deliveryMode");
        Intrinsics.checkNotNullParameter(r103, "action");
        final FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r104 = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(new ComponentStateOperator$onEachDelay$1(r100, null), a());
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEachDelay$$inlined$map$1(r104, r101)), this.f375187a, r102.a(new KProperty1[]{r101}), new ComponentStateOperator$onEachDelay$3(r103, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.lifecycle.LifecycleObserver, com.larus.ui.arch.vm.internal.ComponentStateOperator$assertOneActiveSubscription$observer$1] */
    public final <T> Job j(Flow<? extends T> r110, LifecycleOwner r111, w1a.d r112, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r113) {
        ConcurrentHashMap r100 = (ConcurrentHashMap) this.f375192f.getValue();
        final Set r101 = (Set) this.f375193g.getValue();
        if ((r112 instanceof w1a.h) == false) goto L5;
        final String r102 = ((w1a.h) r112).f557950a;
        ?? r103 = new ComponentStateOperator$assertOneActiveSubscription$observer$1(r101, r102, this);
        r111.getLifecycle().addObserver(r103);
        Flow r114 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(kotlinx.coroutines.flow.e.n(kotlinx.coroutines.flow.e.g(new ComponentStateOperator$flowWhenStarted$1(this, r111, new w(new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(r110, new ComponentStateOperator$assertOneActiveSubscription$1(r101, r102, r111, r103, null)), new ComponentStateOperator$collectLatest$flow$1(r100, r112, null)), null))), new ComponentStateOperator$collectLatest$flow$2(r100, r112, null));
    L7:
        return BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r111), null, CoroutineStart.UNDISPATCHED, new ComponentStateOperator$collectLatest$1(r114, r111, r113, null), 1, null);
    L5:
        r114 = kotlinx.coroutines.flow.e.g(new ComponentStateOperator$flowWhenStarted$1(this, r111, r110, null));
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C> Job f(final KProperty1<S, ? extends A> r100, final KProperty1<S, ? extends B> r101, final KProperty1<S, ? extends C> r102, w1a.d r103, Function4<? super A, ? super B, ? super C, ? super Continuation<? super Unit>, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "prop2");
        Intrinsics.checkNotNullParameter(r102, "prop3");
        Intrinsics.checkNotNullParameter(r103, "deliveryMode");
        Intrinsics.checkNotNullParameter(r104, "action");
        final Flow<S> r105 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$3(r105, r100, r101, r102)), this.f375187a, r103.a(new KProperty1[]{r100, r101}), new ComponentStateOperator$onEach$6(r104, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C, D> Job e(final KProperty1<S, ? extends A> r100, final KProperty1<S, ? extends B> r101, final KProperty1<S, ? extends C> r110, final KProperty1<S, ? extends D> r111, w1a.d r112, Function5<? super A, ? super B, ? super C, ? super D, ? super Continuation<? super Unit>, ? extends Object> r113) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r101, "prop2");
        Intrinsics.checkNotNullParameter(r110, "prop3");
        Intrinsics.checkNotNullParameter(r111, "prop4");
        Intrinsics.checkNotNullParameter(r112, "deliveryMode");
        Intrinsics.checkNotNullParameter(r113, "action");
        final Flow<S> r102 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$4(r102, r100, r101, r110, r111)), this.f375187a, r112.a(new KProperty1[]{r100, r101}), new ComponentStateOperator$onEach$8(r113, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C, D, E> Job d(final KProperty1<S, ? extends A> r100, final KProperty1<S, ? extends B> r110, final KProperty1<S, ? extends C> r111, final KProperty1<S, ? extends D> r112, final KProperty1<S, ? extends E> r113, w1a.d r114, Function6<? super A, ? super B, ? super C, ? super D, ? super E, ? super Continuation<? super Unit>, ? extends Object> r115) {
        Intrinsics.checkNotNullParameter(r100, "prop1");
        Intrinsics.checkNotNullParameter(r110, "prop2");
        Intrinsics.checkNotNullParameter(r111, "prop3");
        Intrinsics.checkNotNullParameter(r112, "prop4");
        Intrinsics.checkNotNullParameter(r113, "prop5");
        Intrinsics.checkNotNullParameter(r114, "deliveryMode");
        Intrinsics.checkNotNullParameter(r115, "action");
        final Flow<S> r101 = a();
        return j(kotlinx.coroutines.flow.e.n(new ComponentStateOperator$onEach$$inlined$map$5(r101, r100, r110, r111, r112, r113)), this.f375187a, r114.a(new KProperty1[]{r100, r110}), new ComponentStateOperator$onEach$10(r115, null));
    }
}

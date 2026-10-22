package com.obric.assistant.state.multitask.internal;

import com.obric.assistant.state.multitask.b;
import jha.i;
import jha.o;
import jha.q;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.g1;

/* JADX INFO: loaded from: classes33.dex */
public final class DefaultTaskFlowStateMachine<S extends o> implements i<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f393300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile q<S> f393301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f393302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableSharedFlow<q<S>> f393303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a1 f393304e;

    @Override // jha.i
    public final void destroy() {
        this.f393300a = true;
        CoroutineScopeKt.cancel$default(this.f393302c, "State machine destroyed, all subscriptions terminated", null, 2, null);
    }

    @Override // jha.i
    public final q<S> a() {
        return this.f393301b;
    }

    @Override // jha.i
    public final a1 getEvents() {
        return this.f393304e;
    }

    public DefaultTaskFlowStateMachine(q<S> r100) {
        Intrinsics.checkNotNullParameter(r100, "initialStateEvent");
        this.f393301b = r100;
        CoroutineScope r101 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.f393302c = r101;
        MutableSharedFlow<q<S>> r102 = SharedFlowKt.MutableSharedFlow$default(0, 8, BufferOverflow.DROP_OLDEST, 1, null);
        this.f393303d = r102;
        this.f393304e = e.D(new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(new DefaultTaskFlowStateMachine$events$1(this, null), r102), r101, g1.a.a(g1.f504854a, 0, 3), 0);
    }

    @Override // jha.i
    public final Object b(final q<S> r100, final Long r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof DefaultTaskFlowStateMachine$transitionTo$1) == false) goto L7;
        DefaultTaskFlowStateMachine$transitionTo$1 r103 = (DefaultTaskFlowStateMachine$transitionTo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L42:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if (this.f393300a == true) goto L17;
        final q<S> r108 = this.f393301b;
        b.a r109 = b.f393276a;
        Function0 r110 = new a(r108, r100, r101);
        r109.getClass();
        b.a.a(r110);
        if (r100.a().f499149c == true) goto L22;
        this.f393303d.tryEmit(r100);
        return Boxing.boxBoolean(true);
    L22:
        q<S> r111 = this.f393301b;
        if ((r100 instanceof q.c) == false) goto L26;
    L34:
        boolean r112 = false;
    L35:
        if (r112 == true) goto L37;
        this.f393301b = r100;
        MutableSharedFlow<q<S>> r113 = this.f393303d;
        r103.label = 1;
        if (r113.emit(r100, r103) != r106) goto L42;
        return r106;
    L37:
        return Boxing.boxBoolean(false);
    L26:
        if (r111.getClass() != r100.getClass()) goto L34;
        if (Intrinsics.areEqual(r111.a().f499147a, r100.a().f499147a) == false) goto L34;
        if (r111.a().f499149c != r100.a().f499149c) goto L34;
        if (r111.a().f499148b.getClass() != r100.a().f499148b.getClass()) goto L34;
        r112 = true;
        goto L35
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r103 = new DefaultTaskFlowStateMachine$transitionTo$1(this, r102);
        goto L8
    }
}

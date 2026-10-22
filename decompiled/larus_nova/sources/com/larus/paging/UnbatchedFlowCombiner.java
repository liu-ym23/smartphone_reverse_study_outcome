package com.larus.paging;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes29.dex */
public final class UnbatchedFlowCombiner<T1, T2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> f363746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompletableDeferred<Unit> f363747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutexImpl f363748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompletableDeferred<Unit>[] f363749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object[] f363750e;

    /* JADX WARN: Multi-variable type inference failed */
    public UnbatchedFlowCombiner(Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "send");
        this.f363746a = r100;
        this.f363747b = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.f363748c = kotlinx.coroutines.sync.b.a();
        CompletableDeferred<Unit>[] r101 = new CompletableDeferred[2];
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= 2) goto L5;
        r101[r103] = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r103 = r103 + 1;
        goto L3
    L5:
        this.f363749d = r101;
        Object[] r104 = new Object[2];
    L6:
        if (r102 >= 2) goto L8;
        r104[r102] = FlowExtKt.f363652a;
        r102 = r102 + 1;
        goto L6
    L8:
        this.f363750e = r104;
    }

    public final Object a(int r110, Object r111, Continuation<? super Unit> r112) {
        int r100 = r110;
        if ((r112 instanceof UnbatchedFlowCombiner$onNext$1) == false) goto L7;
        UnbatchedFlowCombiner$onNext$1 r101 = (UnbatchedFlowCombiner$onNext$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L22;
        if (r105 == 1) goto L21;
        if (r105 == 2) goto L20;
        if (r105 != 3) goto L19;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$1;
        UnbatchedFlowCombiner<T1, T2> r107 = (UnbatchedFlowCombiner) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L16
    L63:
        r107.f363747b.complete(Unit.INSTANCE);     // Catch: Throwable -> L16
    L65:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r106.unlock(null);
        return Unit.INSTANCE;
    L16:
        th = th;
        kotlinx.coroutines.sync.a r109 = r106;
    L70:
        r109.unlock(null);
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        r100 = r101.I$0;
        r109 = (kotlinx.coroutines.sync.a) r101.L$2;
        Object r113 = r101.L$1;
        UnbatchedFlowCombiner<T1, T2> r114 = (UnbatchedFlowCombiner) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L74:
        Object[] r115 = r114.f363750e;     // Catch: Throwable -> L69
        int r116 = r115.length;     // Catch: Throwable -> L69
        int r117 = 0;
    L34:
        if (r117 >= r116) goto L42;
        if (r115[r117] != FlowExtKt.f363652a) goto L38;
        boolean r118 = true;
    L39:
        if (r118 == true) goto L40;
        r117 = r117 + 1;     // Catch: Throwable -> L69
        goto L34
    L40:
        boolean r119 = true;
    L43:
        Object[] r120 = r114.f363750e;     // Catch: Throwable -> L69
        r120[r100] = r113;     // Catch: Throwable -> L69
        int r121 = r120.length;     // Catch: Throwable -> L69
        int r122 = 0;
    L44:
        if (r122 >= r121) goto L52;
        if (r120[r122] != FlowExtKt.f363652a) goto L48;
        boolean r123 = true;
    L49:
        if (r123 == true) goto L50;
        r122 = r122 + 1;     // Catch: Throwable -> L69
        goto L44
    L50:
        boolean r124 = false;
    L53:
        if (r124 == false) goto L64;
        if (r119 == false) goto L56;
        CombineSource r125 = CombineSource.INITIAL;     // Catch: Throwable -> L69
    L59:
        Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> r126 = r114.f363746a;     // Catch: Throwable -> L69
        Object[] r127 = r114.f363750e;     // Catch: Throwable -> L69
        Object r128 = r127[0];     // Catch: Throwable -> L69
        Object r129 = r127[1];     // Catch: Throwable -> L69
        r101.L$0 = r114;     // Catch: Throwable -> L69
        r101.L$1 = r109;     // Catch: Throwable -> L69
        r101.L$2 = null;     // Catch: Throwable -> L69
        r101.label = 3;     // Catch: Throwable -> L69
        if (r126.invoke((T1) r128, (T2) r129, r125, r101) != r104) goto L62;
        return r104;
    L62:
        r106 = r109;
        r107 = r114;
        goto L63
    L56:
        if (r100 != 0) goto L58;
        r125 = CombineSource.RECEIVER;     // Catch: Throwable -> L69
        goto L59
    L58:
        r125 = CombineSource.OTHER;     // Catch: Throwable -> L69
        goto L59
    L64:
        r106 = r109;
        goto L65
    L48:
        r123 = false;
        goto L49
    L52:
        r124 = true;
        goto L53
    L38:
        r118 = false;
        goto L39
    L42:
        r119 = false;
    L69:
        th = th;
        goto L70
    L21:
        r100 = r101.I$0;
        Object r130 = r101.L$1;
        r114 = (UnbatchedFlowCombiner) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L29:
        MutexImpl r131 = r114.f363748c;
        r101.L$0 = r114;
        r101.L$1 = r130;
        r101.L$2 = r131;
        r101.I$0 = r100;
        r101.label = 2;
        if (r131.a(null, r101) != r104) goto L32;
        return r104;
    L32:
        r113 = r130;
        r109 = r131;
        goto L74
    L22:
        ResultKt.throwOnFailure(r103);
        if (this.f363749d[r100].isCompleted() == false) goto L27;
        CompletableDeferred<Unit> r132 = this.f363747b;
        r101.L$0 = this;
        r130 = r111;
        r101.L$1 = r130;
        r101.I$0 = r100;
        r101.label = 1;
        if (r132.await(r101) != r104) goto L28;
        return r104;
    L28:
        r114 = this;
        goto L29
    L27:
        r130 = r111;
        this.f363749d[r100].complete(Unit.INSTANCE);
    L7:
        r101 = new UnbatchedFlowCombiner$onNext$1(this, r112);
        goto L8
    }
}

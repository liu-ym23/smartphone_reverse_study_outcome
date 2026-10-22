package com.larus.paging;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes29.dex */
public abstract class n0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f363889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineDispatcher f363890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0<T> f363891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e1 f363892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x f363893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function0<Unit>> f363894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SingleRunner f363895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f363896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f363897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m0 f363898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1 f363899k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableSharedFlow<Unit> f363900l;

    public abstract Object c(f0 r100, f0 r101, int r102, Function0 r103, Continuation r104);

    public final T b(int r100) {
        this.f363896h = true;
        this.f363897i = r100;
        e1 r101 = this.f363892d;
        if (r101 == null) goto L5;
        r101.a(this.f363891c.b(r100));
    L5:
        f0<T> r102 = this.f363891c;
        if (r100 >= 0) goto L8;
        r102.getClass();
    L19:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Size: " + r102.getSize());
    L8:
        if (r100 >= r102.getSize()) goto L19;
        int r103 = r100 - r102.f363838c;
        if (r103 >= 0) goto L12;
    L15:
        return null;
    L12:
        if (r103 >= r102.f363837b) goto L15;
        return r102.c(r103);
    }

    public n0(d r100, CoroutineDispatcher r101) {
        Intrinsics.checkNotNullParameter(r100, "differCallback");
        Intrinsics.checkNotNullParameter(r101, "mainDispatcher");
        this.f363889a = r100;
        this.f363890b = r101;
        f0<T> r102 = (f0<T>) f0.f363835e;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larus.paging.PagePresenter<T of com.larus.paging.PagePresenter.Companion.initial>");
        this.f363891c = r102;
        x r103 = new x();
        this.f363893e = r103;
        CopyOnWriteArrayList<Function0<Unit>> r104 = new CopyOnWriteArrayList();
        this.f363894f = r104;
        this.f363895g = new SingleRunner(true);
        this.f363898j = new m0(this);
        this.f363899k = r103.f363944i;
        this.f363900l = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.DROP_OLDEST);
        Function0<Unit> r105 = new PagingDataDiffer$1(this);
        Intrinsics.checkNotNullParameter(r105, "listener");
        r104.add(r105);
    }

    public final void a(v r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (Intrinsics.areEqual(this.f363893e.f363941f, r100) == true) goto L5;
    L7:
        x r102 = this.f363893e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "sourceLoadStates");
        r102.f363936a = true;
        r102.f363941f = r100;
        r102.f363942g = r101;
        r102.b();
        return;
    L5:
        if (Intrinsics.areEqual(this.f363893e.f363942g, r101) == false) goto L7;
    }
}

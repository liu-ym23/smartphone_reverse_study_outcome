package com.bytedance.lark.view_flow_wrapper;

import java.lang.AutoCloseable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes20.dex */
public abstract class MoltenService<S extends AutoCloseable> implements AutoCloseable, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SuspendLazyImpl f254401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f254402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final buc.a f254403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<AutoCloseable> f254404d;

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f254403c.a(false, true) == true) goto L5;
        return;
    L5:
        Iterator r100 = ((ArrayList) this.f254404d).iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        ((AutoCloseable) r100.next()).close();
        goto L7
    L9:
        Object r101 = this.f254401a.f254406b.c();
        if (r101 == w.f254470a) goto L12;
        if (r101 == null) goto L12;
    L13:
        AutoCloseable r102 = (AutoCloseable) r101;
        if (r102 == null) goto L16;
        r102.close();
    L16:
        y r103 = ViewFlowPlugin.f254409a;
        if (r103 == null) goto L21;
        r103.a(new d0((String) this.f254402b.getValue()));
        return;
    L21:
        return;
    L12:
        r101 = null;
        goto L13
    }

    public MoltenService(Function1<? super Continuation<? super S>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceProvider");
        MoltenService$serviceLazy$1 r101 = new MoltenService$serviceLazy$1(r100, this, null);
        Intrinsics.checkNotNullParameter(r101, "initializer");
        this.f254401a = new SuspendLazyImpl(r101);
        this.f254402b = LazyKt.lazy(new MoltenService$identity$2(this));
        this.f254403c = buc.b.a(false);
        this.f254404d = new ArrayList();
    }

    public static final String a(MoltenService r100) {
        return (String) r100.f254402b.getValue();
    }

    public final void b(MoltenService r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (this.f254403c.c() == true) goto L5;
        ((ArrayList) this.f254404d).add(r100);
        return;
    L5:
        r100.close();
    }

    public final <R> Object c(Function2<? super S, ? super Continuation<? super R>, ? extends Object> r100, Continuation<? super Result<? extends R>> r101) {
        if ((r101 instanceof MoltenService$withService$1) == false) goto L7;
        MoltenService$withService$1 r102 = (MoltenService$withService$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
    L19:
        Object r107 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L21
    L23:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L28;
        JobKt.ensureActive(r102.getContext());
        c0 r109 = new c0((String) this.f254402b.getValue(), r108);
        y r110 = ViewFlowPlugin.f254409a;
        if (r110 == null) goto L28;
        r110.a(r109);
    L28:
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L21
        SuspendLazyImpl r112 = this.f254401a;     // Catch: Throwable -> L21
        MoltenService$withService$2$1 r113 = new MoltenService$withService$2$1(r100, null);     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        r104 = r112.a(r113, r102);     // Catch: Throwable -> L21
        if (r104 != r105) goto L19;
        return r105;
    L21:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new MoltenService$withService$1(this, r101);
        goto L8
    }

    public final <R> Object d(Function2<? super S, ? super Continuation<? super R>, ? extends Object> r100, Continuation<? super R> r101) {
        if ((r101 instanceof MoltenService$withServiceOrThrow$1) == false) goto L7;
        MoltenService$withServiceOrThrow$1 r102 = (MoltenService$withServiceOrThrow$1) r101;
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
        Object r107 = ((Result) r104).m9458unboximpl();
    L17:
        ResultKt.throwOnFailure(r107);
        return r107;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        r107 = c(r100, r102);
        if (r107 != r105) goto L17;
        return r105;
    L7:
        r102 = new MoltenService$withServiceOrThrow$1(this, r101);
        goto L8
    }
}

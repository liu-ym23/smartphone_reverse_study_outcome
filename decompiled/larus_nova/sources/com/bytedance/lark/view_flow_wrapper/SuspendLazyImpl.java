package com.bytedance.lark.view_flow_wrapper;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes20.dex */
public final class SuspendLazyImpl<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Continuation<? super T>, ? extends Object> f254405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final buc.e<Object> f254406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final buc.e<Throwable> f254407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutexImpl f254408d;

    public final String toString() {
        Object r100 = this.f254406b.c();
        w r101 = w.f254470a;
        if (r100 == r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L12;
        Object r103 = this.f254406b.c();
        if (r103 == r101) goto L10;
        if (r103 == null) goto L10;
    L14:
        return String.valueOf(r103);
    L10:
        r103 = null;
        goto L14
    L12:
        return "Lazy value not initialized yet.";
    L5:
        r102 = false;
        goto L6
    }

    public SuspendLazyImpl(Function1<? super Continuation<? super T>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "initializer");
        this.f254405a = r100;
        this.f254406b = buc.b.d(w.f254470a);
        this.f254407c = buc.b.d(null);
        this.f254408d = kotlinx.coroutines.sync.b.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object>, kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r10v1, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final <R> Object a(Function2<? super T, ? super Continuation<? super R>, ? extends Object> r110, Continuation<? super R> r111) {
        if ((r111 instanceof SuspendLazyImpl$withValue$1) == false) goto L7;
        SuspendLazyImpl$withValue$1 r100 = (SuspendLazyImpl$withValue$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L24;
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L18;
        if (r103 == 3) goto L17;
        if (r103 != 4) goto L16;
        ResultKt.throwOnFailure(r112);
    L68:
        return r112;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r112);
    L57:
        if (r112 == null) goto L60;
        return r112;
    L60:
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 4;
        kotlinx.coroutines.j r113 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r113.C();
        Throwable r114 = this.f254407c.c();
        if (r114 != null) goto L63;
        r114 = new IllegalStateException("Lazy value wasn't created properly");
    L63:
        Result.Companion r104 = Result.Companion;
        r113.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r114)));
        r112 = r113.B();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L66;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L66:
        if (r112 != r102) goto L68;
        return r102;
    L18:
        kotlinx.coroutines.sync.a r115 = (Function2<? super T, ? super Continuation<? super R>, ? extends Object>) ((kotlinx.coroutines.sync.a) r100.L$1);
        Function2 r105 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L21
        ?? r106 = r105;
        kotlinx.coroutines.sync.a r116 = r115;
    L41:
        Object r117 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L21
        ?? r107 = r106;
        ?? r118 = r116;
    L45:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r117);     // Catch: Throwable -> L48
        if (r108 != null) goto L50;
        this.f254406b.d(r117);     // Catch: Throwable -> L48
    L51:
        this.f254405a = null;     // Catch: Throwable -> L48
        ?? r109 = r107;
        ?? r119 = r118;
    L52:
        r119.unlock(null);
        ?? r120 = (Function2<? super T, ? super Continuation<? super R>, ? extends Object>) r109;
    L53:
        if (r117 == null) goto L60;
        r100.L$0 = null;
        r100.L$1 = null;
        r100.label = 3;
        r112 = r120.invoke(r117, r100);
        if (r112 != r102) goto L57;
        return r102;
    L50:
        this.f254406b.d(null);     // Catch: Throwable -> L48
        this.f254407c.d(r108);     // Catch: Throwable -> L48
        r117 = null;
        goto L51
    L23:
        kotlinx.coroutines.sync.a r121 = (kotlinx.coroutines.sync.a) r100.L$1;
        Function2 r122 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r112);
        ?? r123 = r122;
        kotlinx.coroutines.sync.a r124 = r121;
    L32:
        r117 = this.f254406b.c();     // Catch: Throwable -> L48
        r109 = r123;
        r119 = r124;
        if (r117 == w.f254470a) goto L36;
        if (r117 != null) goto L52;
        r117 = null;
        r109 = r123;
        r119 = r124;
        goto L52
    L36:
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L21
        Function1<? super Continuation<? super T>, ? extends Object> r126 = this.f254405a;     // Catch: Throwable -> L21
        if (r126 == null) goto L43;
        r100.L$0 = r123;     // Catch: Throwable -> L21
        r100.L$1 = r124;     // Catch: Throwable -> L21
        r100.label = 2;     // Catch: Throwable -> L21
        r112 = r126.invoke(r100);     // Catch: Throwable -> L21
        r106 = r123;
        r116 = r124;
        if (r112 != r102) goto L41;
        return r102;
    L43:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L21
    L24:
        ResultKt.throwOnFailure(r112);
        r117 = this.f254406b.c();
        r120 = r110;
        if (r117 == w.f254470a) goto L28;
        if (r117 != null) goto L53;
        r117 = null;
        r120 = r110;
        goto L53
    L28:
        MutexImpl r127 = this.f254408d;
        r100.L$0 = r110;
        r100.L$1 = r127;
        r100.label = 1;
        if (r127.a(null, r100) != r102) goto L31;
        return r102;
    L31:
        r123 = r110;
        r124 = r127;
    L48:
        th = move-exception;
        r110.unlock(null);
        throw th;
    L21:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L48
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L48
        r107 = r103;
        r118 = r110;
    L7:
        r100 = new SuspendLazyImpl$withValue$1(this, r111);
        goto L8
    }
}

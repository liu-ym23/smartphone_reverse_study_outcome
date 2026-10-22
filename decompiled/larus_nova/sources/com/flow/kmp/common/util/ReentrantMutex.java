package com.flow.kmp.common.util;

import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes3.dex */
public final class ReentrantMutex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<h, Job> f274145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f274146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutexImpl f274147c;

    public static final class a implements CoroutineContext.Element {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoroutineContext.Key<?> f274148a;

        @Override // kotlin.coroutines.CoroutineContext.Element
        public final CoroutineContext.Key<?> getKey() {
            return this.f274148a;
        }

        public a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.f274148a = r100;
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
            return (E) CoroutineContext.Element.DefaultImpls.get(this, r100);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public final CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
            return CoroutineContext.Element.DefaultImpls.minusKey(this, r100);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public final CoroutineContext plus(CoroutineContext r100) {
            return CoroutineContext.Element.DefaultImpls.plus(this, r100);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public final <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(this, r100, r101);
        }
    }

    public static final class b implements CoroutineContext.Key<a> {
        public b() {
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public static final class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f274149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f274150b;

        @Override // com.flow.kmp.common.util.h
        public final boolean a() {
            return this.f274150b.element;
        }

        @Override // com.flow.kmp.common.util.h
        public final String b() {
            return ExceptionsKt.stackTraceToString(new Throwable());
        }

        @Override // com.flow.kmp.common.util.h
        public final boolean c() {
            return this.f274149a.element;
        }

        public c(Ref.BooleanRef r100, Ref.BooleanRef r101) {
            this.f274149a = r100;
            this.f274150b = r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReentrantMutex(Function1<? super h, ? extends Job> r100) {
        this.f274145a = r100;
        this.f274146b = new a(new b());
        this.f274147c = kotlinx.coroutines.sync.b.a();
    }

    public final <R> Object a(Function1<? super Continuation<? super R>, ? extends Object> r110, Continuation<? super R> r111) {
        if ((r111 instanceof ReentrantMutex$withLock$1) == false) goto L7;
        ReentrantMutex$withLock$1 r100 = (ReentrantMutex$withLock$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L21;
        if (r103 == 2) goto L20;
        if (r103 != 3) goto L19;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$2;
        Job r104 = (Job) r100.L$1;
        Ref.BooleanRef r105 = (Ref.BooleanRef) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L16
    L39:
        r113.unlock(null);
        if (r104 == null) goto L42;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L42:
        r105.element = true;
        return r112;
    L16:
        Throwable th10 = th;
    L46:
        r113.unlock(null);
        throw th10;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        kotlinx.coroutines.sync.a r114 = (kotlinx.coroutines.sync.a) r100.L$4;
        Job r106 = (Job) r100.L$3;
        Ref.BooleanRef r107 = (Ref.BooleanRef) r100.L$2;
        Ref.BooleanRef r108 = (Ref.BooleanRef) r100.L$1;
        Function1<? super Continuation<? super R>, ? extends Object> r109 = (Function1) r100.L$0;
        ResultKt.throwOnFailure(r112);
        Ref.BooleanRef r115 = r107;
        kotlinx.coroutines.sync.a r116 = r114;
        r110 = r109;
    L48:
        r108.element = true;     // Catch: Throwable -> L44
        CoroutineContext r117 = r100.getContext().plus(this.f274146b);     // Catch: Throwable -> L44
        ReentrantMutex$withLock$ans$1$1 r118 = new ReentrantMutex$withLock$ans$1$1(r110, null);     // Catch: Throwable -> L44
        r100.L$0 = r115;     // Catch: Throwable -> L44
        r100.L$1 = r106;     // Catch: Throwable -> L44
        r100.L$2 = r116;     // Catch: Throwable -> L44
        r100.L$3 = null;     // Catch: Throwable -> L44
        r100.L$4 = null;     // Catch: Throwable -> L44
        r100.label = 3;     // Catch: Throwable -> L44
        Object r119 = BuildersKt.withContext(r117, r118, r100);     // Catch: Throwable -> L44
        if (r119 != r102) goto L38;
        return r102;
    L38:
        r105 = r115;
        r104 = r106;
        r112 = r119;
        r113 = r116;
    L44:
        th = move-exception;
        th10 = th;
        r113 = r116;
        goto L46
    L21:
        ResultKt.throwOnFailure(r112);
    L27:
        return r112;
    L22:
        ResultKt.throwOnFailure(r112);
        if (r100.getContext().get(this.f274146b.f274148a) == null) goto L28;
        r100.label = 1;
        r112 = r110.invoke(r100);
        if (r112 != r102) goto L27;
        return r102;
    L28:
        r108 = new Ref.BooleanRef();
        r115 = new Ref.BooleanRef();
        Function1<h, Job> r120 = this.f274145a;
        if (r120 == null) goto L31;
        r106 = r120.invoke(new c(r108, r115));
    L32:
        r116 = this.f274147c;
        r100.L$0 = r110;
        r100.L$1 = r108;
        r100.L$2 = r115;
        r100.L$3 = r106;
        r100.L$4 = r116;
        r100.label = 2;
        if (r116.a(null, r100) != r102) goto L48;
        return r102;
    L31:
        r106 = null;
    L7:
        r100 = new ReentrantMutex$withLock$1(this, r111);
        goto L8
    }
}

package com.larus.im.internal.memory.cache;

import androidx.collection.LruCache;
import com.flow.kmp.common.util.ReentrantMutex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public abstract class MemoryCache<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f348950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f348951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LruCache<String, T> f348952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReentrantMutex f348953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f348954i;

    /* JADX INFO: renamed from: com.larus.im.internal.memory.cache.MemoryCache$update$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.memory.cache.MemoryCache", f = "MemoryCache.kt", i = {0, 0, 0}, l = {69}, m = "update$suspendImpl", n = {"$this", "key", "transformer"}, s = {"L$0", "L$1", "L$2"})
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryCache<T> this$0;

        public AnonymousClass1(MemoryCache<T> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return MemoryCache.V(this.this$0, null, null, this);
        }
    }

    public abstract String M(T r100);

    public abstract Object N(String r100, Continuation<? super T> r101);

    public Object update(String r100, Function1<? super T, ? extends T> r101, Continuation<? super Unit> r102) {
        return V(this, r100, r101, r102);
    }

    public final void I() {
        this.f348952g.evictAll();
    }

    public final long L() {
        int r100 = this.f348952g.hitCount();
        long r101 = 0;
        if (r100 <= 0) goto L5;
        long r102 = r100;
    L6:
        int r103 = this.f348952g.missCount();
        if (r103 <= 0) goto L10;
        r101 = r103;
    L10:
        return r102 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public int S() {
        return this.f348952g.size();
    }

    public MemoryCache(int r100) {
        this.f348950e = r100;
        this.f348951f = com.larus.im.internal.memory.d.f349008a;
        this.f348952g = new LruCache(r100);
        this.f348953h = new ReentrantMutex(null);
        String r101 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f348954i = r101;
    }

    public final T K(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f348952g.get(r100);
    }

    public final T P(T r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        return this.f348952g.put(M(r100), r100);
    }

    public final void Q(Collection<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        T r102 = r101.next();
        this.f348952g.put(M(r102), r102);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R(Function1<? super T, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "predicate");
        Collection<T> r101 = this.f348952g.snapshot().values();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        T r104 = r103.next();
        if (r100.invoke(r104).booleanValue() == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        this.f348952g.remove(M(r106));
        goto L10
    }

    public static List T(List r100, int r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        if (r100 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r100.size() <= r101) goto L10;
        r100 = r100.subList(0, r101);     // Catch: Throwable -> L12
    L10:
        Object r103 = Result.m9449constructorimpl(r100);     // Catch: Throwable -> L12
    L15:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L19;
        r103 = CollectionsKt.emptyList();
    L19:
        return (List) r103;
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public final void J(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "message");
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L6;
        O(r100, r101);
        return;
    }

    public final void O(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "message");
        com.larus.im.internal.delegate.a.f348188b.i(this.f348954i, "#" + r100 + "# " + r101);
    }

    public Object U(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Unit> r101) {
        Lazy r102 = com.larus.im.internal.memory.c.f348938a;
        if (com.larus.im.internal.memory.c.a().f348584b == false) goto L5;
        BuildersKt.launch$default(this.f348951f, null, null, new MemoryCache$syncOrAsync$2(r100, null), 3, null);
        return Unit.INSTANCE;
    L5:
        Object r103 = r100.invoke(r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r103;
    L9:
        return Unit.INSTANCE;
    }

    public final <R> Object W(Function1<? super Continuation<? super R>, ? extends Object> r100, Continuation<? super R> r101) {
        return this.f348953h.a(new MemoryCache$withLock$2(r100, null), r101);
    }

    public static /* synthetic */ <T> Object V(MemoryCache<T> r100, String r101, Function1<? super T, ? extends T> r102, Continuation<? super Unit> r103) {
        if ((r103 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r104 = (AnonymousClass1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r102 = (Function1) r104.L$2;
        r101 = (String) r104.L$1;
        r100 = (MemoryCache) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L19:
        if (r106 == null) goto L21;
    L22:
        T r109 = r102.invoke(r106);
        r100.f348952g.put(r101, r109);
        return Unit.INSTANCE;
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        r106 = r100.f348952g.get(r101);
        if (r106 != null) goto L22;
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        r104.label = 1;
        r106 = r100.N(r101, r104);
        if (r106 != r107) goto L19;
        return r107;
    L7:
        r104 = new AnonymousClass1(r100, r103);
        goto L8
    }
}

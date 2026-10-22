package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import java.lang.Throwable;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class CatchChain<R, M extends Throwable> extends m<Object, R> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Class<M> f200660j;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CatchChain f200661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f200662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f200663c;

        public a(CatchChain r100, f r101, Throwable r102) {
            this.f200661a = r100;
            this.f200662b = r101;
            this.f200663c = r102;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.concurrent.Callable
        public final R call() {
            return this.f200661a.f200753i.invoke(this.f200662b, (T) this.f200663c);
        }
    }

    @Override // com.bytedance.bdp.appbase.chain.m
    public final boolean e(f r100) {
        if (r100.f200699e != null) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.bdp.appbase.chain.m
    public final m<?, ?> f(f r100) {
        e r101 = r100.f200699e;
        if (r101 != null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        if (r101 == null) goto L35;
    L11:
        Throwable r103 = r101.f200692a;     // Catch: Throwable -> L32
        if (this.f200660j.isAssignableFrom(r103.getClass()) == false) goto L31;
        String r104 = m.h(r100);     // Catch: Throwable -> L32
        if (r104 == null) goto L16;
        Object r105 = BdpPool.directRun(r104, new a(this, r100, r103));     // Catch: Throwable -> L32
    L17:
        r100.f200698d = r105;     // Catch: Throwable -> L32
        e r106 = r100.f200699e;     // Catch: Throwable -> L32
        r100.f200699e = null;     // Catch: Throwable -> L32
        if (r100.f200705k == false) goto L30;
        if (r106 == null) goto L28;
        Throwable r107 = r106.f200692a;     // Catch: Throwable -> L32
        if (r107 == null) goto L28;
        if ((r107 instanceof CancelEvent) == true) goto L26;
        r107 = null;
    L26:
        if (r107 == null) goto L28;
        throw r107;     // Catch: Throwable -> L32
    L28:
        throw new CancelEvent(null, 1, null);     // Catch: Throwable -> L32
    L30:
        return g(r100);
    L16:
        r105 = this.f200753i.invoke(r100, (T) r103);     // Catch: Throwable -> L32
        goto L17
    L31:
        throw r103;     // Catch: Throwable -> L32
    L35:
        Intrinsics.throwNpe();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        return d(th, r100);
    L8:
        return g(r100);
    L5:
        r102 = false;
        goto L6
    }

    public CatchChain(Class<M> r100, final Function2<? super f, ? super M, ? extends R> r101) {
        super(new AnonymousClass1(r101));
        this.f200660j = r100;
    }
}

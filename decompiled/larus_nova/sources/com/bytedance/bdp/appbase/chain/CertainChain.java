package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes11.dex */
public final class CertainChain<T, R> extends m<Object, R> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function3<f, T, Throwable, R> f200664j;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CertainChain f200665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f200666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f200667c;

        public a(CertainChain r100, e r101, f r102) {
            this.f200665a = r100;
            this.f200666b = r101;
            this.f200667c = r102;
        }

        @Override // java.util.concurrent.Callable
        public final R call() {
            e r100 = this.f200666b;
            if (r100 == null) goto L5;
            R r101 = this.f200665a.f200664j.invoke(this.f200667c, null, r100.f200692a);
            this.f200667c.f200699e = null;
            return r101;
        L5:
            Function3<f, T, Throwable, R> r102 = this.f200665a.f200664j;
            f r103 = this.f200667c;
            return r102.invoke(r103, (T) r103.f200698d, null);
        }
    }

    @Override // com.bytedance.bdp.appbase.chain.m
    public final boolean e(f r100) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CertainChain(Function3<? super f, ? super T, ? super Throwable, ? extends R> r100) {
        super(AnonymousClass1.INSTANCE);
        this.f200664j = r100;
    }

    @Override // com.bytedance.bdp.appbase.chain.m
    public final m<?, ?> f(f r100) {
        e r101 = r100.f200699e;     // Catch: Throwable -> L21
        String r102 = m.h(r100);     // Catch: Throwable -> L21
        a r103 = new a(this, r101, r100);     // Catch: Throwable -> L21
        if (r102 == null) goto L5;
        r100.f200698d = BdpPool.directRun(r102, r103);     // Catch: Throwable -> L21
    L7:
        if (r100.f200705k == false) goto L20;
        if (r101 == null) goto L18;
        Throwable r104 = r101.f200692a;     // Catch: Throwable -> L21
        if (r104 == null) goto L18;
        if ((r104 instanceof CancelEvent) == true) goto L16;
        r104 = null;
    L16:
        if (r104 == null) goto L18;
        throw r104;     // Catch: Throwable -> L21
    L18:
        throw new CancelEvent(null, 1, null);     // Catch: Throwable -> L21
    L20:
        return g(r100);
    L5:
        r100.f200698d = r103.call();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        return d(th, r100);
    }
}

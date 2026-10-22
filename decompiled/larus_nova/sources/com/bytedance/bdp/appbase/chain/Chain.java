package com.bytedance.bdp.appbase.chain;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class Chain<R> extends m<Object, R> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicInteger f200668k = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<m<?, ?>> f200669j;

    public static final class Companion {
        @JvmStatic
        public static Chain a() {
            return new Chain().o(Chain$Companion$create$1.INSTANCE);
        }
    }

    static {
        f200668k = new AtomicInteger(0);
    }

    public Chain() {
        super(AnonymousClass1.INSTANCE);
        this.f200669j = new ArrayList();
    }

    @Override // com.bytedance.bdp.appbase.chain.m
    public final m<?, ?> j() {
        int r100 = this.f200746b;
        m<?, ?> r101 = this.f200747c;
        ArrayList<m<?, ?>> r102 = this.f200669j;
        if (r102.size() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = null;
    L9:
        if (r102 != null) goto L11;
        return r101;
    L11:
        if (r102.isEmpty() == true) goto L17;
        ListIterator<m<?, ?>> r104 = r102.listIterator(r102.size());
    L14:
        if (r104.hasPrevious() == false) goto L17;
        m<?, ?> r105 = r104.previous();
        r105.f200747c = r101;
        r105.f200746b = r100;
        r101 = r105;
    L17:
        return (m) ListProtector.get(r102, 0);
    L5:
        r103 = false;
        goto L6
    }

    public final m<?, ?> l() {
        ArrayList<m<?, ?>> r100 = this.f200669j;
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L11;
        m<?, ?> r101 = (m) ListProtector.get(r100, CollectionsKt.getLastIndex(r100));
        if (r101 == null) goto L11;
        return r101;
    L11:
        throw new IllegalStateException("can not option empty chain!");
    }

    public final void q() {
        m<?, ?> r100 = l();
        r100.f200752h = i0.b.f200743a;
        l().f200751g = 0;
        l().i().onOWN();
    }

    @Override // com.bytedance.bdp.appbase.chain.m
    public final m<?, ?> f(f r100) {
        return g(r100);
    }

    public final <N> Chain<N> m(m<? super R, N> r100) {
        Chain<N> r101 = new Chain();
        r101.f200669j.addAll(this.f200669j);
        r101.f200669j.add(r100);
        return r101;
    }

    public final void n(Object r100) {
        m<?, ?> r101 = l();
        if (Intrinsics.areEqual(r101.f200749e, r100) == false) goto L5;
        r101.f200749e = null;
    L5:
        r101.f200748d = new p(r100, Math.max(1, 1));
    }

    public final <N> Chain<N> o(Function2<? super f, ? super R, ? extends N> r100) {
        return m(new m(r100));
    }

    public final void p(long r100) {
        m<?, ?> r101 = l();
        r101.f200752h = i0.a.f200742a;
        l().f200751g = r100;
        l().i().onIO();
    }
}

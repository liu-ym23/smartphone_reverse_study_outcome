package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.bdptask.BdpTask;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class FlatChain<T, R> extends m<List<? extends T>, List<? extends R>> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f200678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Chain<R> f200679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function2<f, T, R> f200680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f200681m;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f200682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f200683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f200684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f200685d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final T f200686e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f200687f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L18;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f200682a, r101.f200682a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f200683b, r101.f200683b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f200684c, r101.f200684c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f200685d, r101.f200685d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f200686e, r101.f200686e) == true) goto L16;
            return false;
        L16:
            if (this.f200687f == r101.f200687f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            Object[] r100 = this.f200682a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = Arrays.hashCode(r100);
        L6:
            int r103 = r102 * 31;
            AtomicInteger r104 = this.f200683b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            f r107 = this.f200684c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            AtomicBoolean r110 = this.f200685d;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            T r113 = this.f200686e;
            if (r113 == null) goto L22;
            r101 = r113.hashCode();
        L22:
            return ((r112 + r101) * 31) + this.f200687f;
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Info(results=" + Arrays.toString(this.f200682a) + ", count=" + this.f200683b + ", parentData=" + this.f200684c + ", error=" + this.f200685d + ", input=" + this.f200686e + ", index=" + this.f200687f + ")";
        }

        public a(Object[] r100, AtomicInteger r101, f r102, AtomicBoolean r103, T r104, int r105) {
            this.f200682a = r100;
            this.f200683b = r101;
            this.f200684c = r102;
            this.f200685d = r103;
            this.f200686e = r104;
            this.f200687f = r105;
        }
    }

    public FlatChain(Function2 r100) {
        super(AnonymousClass1.INSTANCE);
        this.f200680l = r100;
        this.f200681m = true;
        this.f200678j = this.f200745a + "_#f-info#_";
    }

    @Override // com.bytedance.bdp.appbase.chain.m
    public final m<?, ?> f(final f r110) {
        final f r100 = r110;
        if (r100.f200699e == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        Object r102 = r100.f200698d;
        if (r102 == null) goto L35;
        List r103 = (List) r102;
        final Object[] r111 = new Object[r103.size()];
        if (r103.isEmpty() == false) goto L15;
        r100.f200698d = ArraysKt.toList(r111);
        return g(r110);
    L15:
        AtomicInteger r104 = Chain.f200668k;
        r100.a(Chain.Companion.a().m(new CatchChain(Throwable.class, new Chain$catchJava$1(new c(FlatChain$doTask$1.INSTANCE)))));
        final AtomicBoolean r112 = new AtomicBoolean(false);
        final AtomicInteger r113 = new AtomicInteger(r103.size());
        final Map<String, Object> r114 = r110.d();
        Iterator<T> r115 = r103.iterator();
        int r105 = 0;
    L17:
        if (r115.hasNext() == false) goto L33;
        T r106 = r115.next();
        int r116 = r105 + 1;
        if (r105 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        if (r112.get() == true) goto L23;
        final a r117 = new a(r111, r113, r110, r112, r106, r105);
        Chain<R> r107 = this.f200679k;
        if (r107 != null) goto L32;
        AtomicInteger r108 = Chain.f200668k;
        Chain r109 = Chain.Companion.a();
        if (this.f200681m == false) goto L31;
        BdpTask.Builder r118 = r100.f200712r;
        if (r118 == null) goto L31;
        BdpTask.Builder r119 = r118.build().newBuilder().delayedMillis(0).stageListener(null).trace("FlatChain Post Task");
        m<?, ?> r120 = r109.l();
        r120.f200752h = i0.a.f200742a;
        m<?, ?> r121 = r109.l();
        r121.f200751g = r119.build().delayMillis;
        r109.l().f200750f = r119;
    L31:
        r107 = r109.o(new FlatChain$getNodeHandle$$inlined$run$lambda$1(this, r100)).m(new CatchChain(Throwable.class, new Chain$catchJava$1(new c(new FlatChain$getNodeHandle$$inlined$run$lambda$2(this, r100))))).o(new FlatChain$getNodeHandle$$inlined$run$lambda$3(this, r100));
        this.f200679k = r107;
    L32:
        Chain<R> r122 = r107;
        Function1<f, Unit> r123 = new FlatChain$doTask$$inlined$forEachIndexed$lambda$1(r117, this, r112, r111, r113, r110, r114);
        BdpPool.directRun("", new n(new f(), r122, r123));
        r100 = r110;
        r105 = r116;
        goto L17
    L23:
        return null;
    L33:
        return null;
    L35:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<T>");
    L8:
        return g(r110);
    L5:
        r101 = false;
        goto L6
    }

    public static final void l(FlatChain r100, a r101, e r102) {
        r100.getClass();
        f r103 = r101.f200684c;
        monitor-enter(r103);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (r101.f200685d.get() == false) goto L8;
        monitor-exit(r103);
        return;
    L8:
        r101.f200685d.set(true);     // Catch: Throwable -> L21
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r103);
        f r105 = r101.f200684c;
        r105.f200698d = r102;
        r105.f200699e = r102;
        if (r105.f200705k == true) goto L13;
        r105.c();
    L13:
        m<?, ?> r106 = r100.g(r101.f200684c);
        if (r106 == null) goto L20;
        m<?, ?> r107 = r100.c(r101.f200684c, r106);
        if (r107 == null) goto L26;
        r107.b(r101.f200684c);
        return;
    L26:
        return;
    L20:
        throw new IllegalArgumentException("error!", r102.f200692a);
    }
}

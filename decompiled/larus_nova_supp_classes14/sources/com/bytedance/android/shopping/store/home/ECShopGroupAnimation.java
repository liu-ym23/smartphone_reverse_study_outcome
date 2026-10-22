package com.bytedance.android.shopping.store.home;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopGroupAnimation {
    public final ValueAnimator a;
    public boolean b;
    public int c;
    public int d;
    public final SortedMap<Integer, a> e;
    public final ConcurrentHashMap<Integer, Pair<Integer, Integer>> f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ECShopGroupAnimation$Direction;", "", "FORWARD", "REVERSE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Direction extends Enum<Direction> {
        public static final Direction FORWARD = null;
        public static final Direction REVERSE = null;
        public static final /* synthetic */ Direction[] a = null;

        static {
            Direction r1 = new Direction("FORWARD", 0);
            FORWARD = r1;
            Direction r2 = new Direction("REVERSE", 1);
            REVERSE = r2;
            a = new Direction[]{r1, r2};
        }

        public static Direction valueOf(String r1) {
            return (Direction) r27.a.a(Direction.class, r1);
        }

        public static Direction[] values() {
            return (Direction[]) a.clone();
        }

        public Direction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        int a();

        int b();

        void c(Direction r1);

        void onChange(int r1, float r2);
    }

    public static final class b<T, U> implements BiConsumer {
        public final /* synthetic */ int a;
        public final /* synthetic */ Ref.IntRef b;

        public b(int r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.util.function.BiConsumer
        public final void accept(Object r2, Object r3) {
            a r4 = (a) r3;
            if (Intrinsics.compare(((Integer) r2).intValue(), this.a) >= 0) goto L6;
            this.b.element += r4.a();
            return;
        }
    }

    public final void b() {
        boolean r0 = false;
        this.b = false;
        if (this.a.getValues() != null) goto L5;
        return;
    L5:
        if (this.a.getValues().length != 0) goto L7;
        r0 = true;
    L7:
        if (r0 == true) goto L12;
        this.a.start();
        return;
    }

    public ECShopGroupAnimation() {
        AccelerateDecelerateInterpolator r0 = new AccelerateDecelerateInterpolator();
        Intrinsics.checkNotNullParameter(r0, "interpolator");
        ValueAnimator r1 = new ValueAnimator();
        this.a = r1;
        r1.setDuration(400);
        r1.setInterpolator(r0);
        r1.addUpdateListener(new n(this));
        r1.addListener(new o(this));
        this.e = Collections.synchronizedSortedMap(new TreeMap());
        this.f = new ConcurrentHashMap();
    }

    public final void a(int r5, a r6) {
        Intrinsics.checkNotNullParameter(r6, "listener");
        if (this.e.containsKey(Integer.valueOf(r5)) == false) goto L13;
        int r0 = this.c;
        a r2 = this.e.get(Integer.valueOf(r5));
        if (r2 == null) goto L7;
        int r3 = r2.a();
    L8:
        this.c = r0 - r3;
        int r1 = this.d;
        a r4 = this.e.get(Integer.valueOf(r5));
        if (r4 == null) goto L11;
        int r7 = r4.b();
    L12:
        this.d = r1 - r7;
        this.e.remove(Integer.valueOf(r5));
        goto L13
    L11:
        r7 = 0;
        goto L12
    L7:
        r3 = 0;
    L13:
        this.e.put(Integer.valueOf(r5), r6);
        this.c += r6.a();
        this.d += r6.b();
        Ref.IntRef r8 = new Ref.IntRef();
        r8.element = 0;
        this.e.forEach(new b(r5, r8));
        this.f.put(Integer.valueOf(r5), TuplesKt.to(Integer.valueOf(r8.element), Integer.valueOf(r8.element + r6.a())));
        this.a.setIntValues(new int[]{this.c, this.d});
    }
}

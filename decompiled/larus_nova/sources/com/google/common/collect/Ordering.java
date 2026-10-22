package com.google.common.collect;

import com.amap.api.col.s.ce;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    public static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        public IncomparableValueException(Object r100) {
            super("Cannot compare value: " + r100);
            this.value = r100;
        }
    }

    public static class a extends Ordering<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f275287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap<Object, Integer> f275288b;

        public final String toString() {
            return "Ordering.arbitrary()";
        }

        public a() {
            this.f275287a = new AtomicInteger(0);
            MapMaker r100 = new MapMaker();
            r100.d(MapMakerInternalMap.Strength.WEAK);
            this.f275288b = r100.c();
        }

        public final Integer a(Object r100) {
            Integer r101 = this.f275288b.get(r100);
            if (r101 != null) goto L8;
            Integer r102 = Integer.valueOf(this.f275287a.getAndIncrement());
            Integer r103 = this.f275288b.putIfAbsent(r100, r102);
            if (r103 != null) goto L7;
            return r102;
        L7:
            return r103;
        L8:
            return r101;
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public final int compare(@CheckForNull Object r100, @CheckForNull Object r101) {
            if (r100 != r101) goto L6;
            return 0;
        L6:
            if (r100 != null) goto L9;
            return -1;
        L9:
            if (r101 != null) goto L11;
            return 1;
        L11:
            int r102 = System.identityHashCode(r100);
            int r103 = System.identityHashCode(r101);
            if (r102 == r103) goto L17;
            if (r102 < r103) goto L22;
            return 1;
        L22:
            return -1;
        L17:
            int r104 = a(r100).compareTo(a(r101));
            if (r104 == 0) goto L21;
            return r104;
        L21:
            throw new AssertionError();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f275289a = null;

        static {
            f275289a = new a();
        }
    }

    public Ordering() {
    }

    @Override // java.util.Comparator
    public abstract int compare(@ParametricNullness T r100, @ParametricNullness T r101);

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    public <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.EntryFunction.KEY);
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return b.f275289a;
    }

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public static <T> Ordering<T> explicit(List<T> r100) {
        return new ExplicitOrdering(r100);
    }

    public static <T> Ordering<T> from(Comparator<T> r100) {
        if ((r100 instanceof Ordering) == false) goto L6;
        return (Ordering) r100;
    L6:
        return new ComparatorOrdering(r100);
    }

    public <U extends T> Ordering<U> compound(Comparator<? super U> r100) {
        r100.getClass();
        return new CompoundOrdering(this, r100);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> r100) {
        return ImmutableList.sortedCopyOf(this, r100);
    }

    public boolean isOrdered(Iterable<? extends T> r100) {
        Iterator<? extends T> r101 = r100.iterator();
        if (r101.hasNext() == false) goto L12;
        T r102 = r101.next();
    L6:
        if (r101.hasNext() == false) goto L16;
        T r103 = r101.next();
        if (compare(r102, r103) > 0) goto L9;
        r102 = r103;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> r100) {
        Iterator<? extends T> r101 = r100.iterator();
        if (r101.hasNext() == false) goto L12;
        T r102 = r101.next();
    L6:
        if (r101.hasNext() == false) goto L16;
        T r103 = r101.next();
        if (compare(r102, r103) >= 0) goto L9;
        r102 = r103;
        goto L6
    L9:
        return false;
    L16:
        return true;
    L12:
        return true;
    }

    @ParametricNullness
    public <E extends T> E max(Iterator<E> r100) {
        E r101 = r100.next();
    L4:
        if (r100.hasNext() == false) goto L6;
        E r102 = r101;
        r101 = (E) max(r102, r100.next());
        goto L4
    L6:
        return r101;
    }

    @ParametricNullness
    public <E extends T> E min(Iterator<E> r100) {
        E r101 = r100.next();
    L4:
        if (r100.hasNext() == false) goto L6;
        E r102 = r101;
        r101 = (E) min(r102, r100.next());
        goto L4
    L6:
        return r101;
    }

    public <F> Ordering<F> onResultOf(com.google.common.base.g<F, ? extends T> r100) {
        return new ByFunctionOrdering(r100, this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> r100) {
        if ((r100 instanceof Collection) == false) goto L5;
        Collection r101 = (Collection) r100;
    L6:
        Object[] r102 = r101.toArray();
        Arrays.sort(r102, this);
        return Lists.b(Arrays.asList(r102));
    L5:
        r101 = Lists.c(r100.iterator());
        goto L6
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> r100) {
        return new CompoundOrdering(r100);
    }

    public static <T> Ordering<T> from(Ordering<T> r100) {
        r100.getClass();
        return r100;
    }

    @ParametricNullness
    public <E extends T> E max(Iterable<E> r100) {
        return (E) max(r100.iterator());
    }

    @ParametricNullness
    public <E extends T> E min(Iterable<E> r100) {
        return (E) min(r100.iterator());
    }

    public static <T> Ordering<T> explicit(T r100, T... r101) {
        return explicit(new Lists.OnePlusArrayList(r100, r101));
    }

    public int binarySearch(List<? extends T> r100, @ParametricNullness T r101) {
        return Collections.binarySearch(r100, r101, this);
    }

    public <E extends T> List<E> greatestOf(Iterable<E> r100, int r101) {
        return reverse().leastOf(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> List<E> leastOf(Iterator<E> r110, int r111) {
        r110.getClass();
        o.b(r111, ce.f26396k);
        if (r111 == 0) goto L59;
        if (r110.hasNext() == false) goto L59;
        if (r111 < 1073741823) goto L14;
        ArrayList r112 = Lists.c(r110);
        Collections.sort(r112, this);
        if (r112.size() <= r111) goto L12;
        r112.subList(r111, r112.size()).clear();
    L12:
        r112.trimToSize();
        return Collections.unmodifiableList(r112);
    L14:
        u2 r100 = new u2(this, r111);
    L15:
        int r101 = 0;
        if (r110.hasNext() == false) goto L53;
        E r113 = r110.next();
        int r102 = r100.f275514a;
        if (r102 == 0) goto L15;
        int r103 = r100.f275517d;
        if (r103 == 0) goto L22;
        if (r103 < r102) goto L24;
        if (r100.f275515b.compare(r113, r100.f275518e) >= 0) goto L15;
        T[] r104 = r100.f275516c;
        int r105 = r100.f275517d;
        int r106 = r105 + 1;
        r100.f275517d = r106;
        r104[r105] = r113;
        int r114 = r100.f275514a * 2;
        if (r106 != r114) goto L15;
        int r115 = r114 - 1;
        int r107 = com.google.common.math.c.d(r115 + 0, RoundingMode.CEILING) * 3;
        int r108 = 0;
        int r109 = 0;
    L32:
        if (r101 >= r115) goto L47;
        int r116 = ((r101 + r115) + 1) >>> 1;
        T[] r117 = r100.f275516c;
        T r118 = r117[r116];
        r117[r116] = r117[r115];
        int r119 = r101;
        int r120 = r119;
    L34:
        if (r119 >= r115) goto L39;
        if (r100.f275515b.compare(r100.f275516c[r119], r118) >= 0) goto L38;
        T[] r121 = r100.f275516c;
        T r122 = r121[r120];
        r121[r120] = r121[r119];
        r121[r119] = r122;
        r120 = r120 + 1;
    L38:
        r119 = r119 + 1;
        goto L34
    L39:
        T[] r123 = r100.f275516c;
        r123[r115] = r123[r120];
        r123[r120] = r118;
        int r124 = r100.f275514a;
        if (r120 <= r124) goto L42;
        r115 = r120 - 1;
    L44:
        r108 = r108 + 1;
        if (r108 < r107) goto L32;
        Arrays.sort(r100.f275516c, r101, r115 + 1, r100.f275515b);
        goto L47
    L42:
        if (r120 >= r124) goto L47;
        r101 = Math.max(r120, r101 + 1);
        r109 = r120;
    L47:
        r100.f275517d = r100.f275514a;
        r100.f275518e = r100.f275516c[r109];
    L48:
        r109 = r109 + 1;
        if (r109 >= r100.f275514a) goto L15;
        if (r100.f275515b.compare(r100.f275516c[r109], r100.f275518e) <= 0) goto L48;
        r100.f275518e = r100.f275516c[r109];
        goto L48
    L24:
        T[] r125 = r100.f275516c;
        r100.f275517d = r103 + 1;
        r125[r103] = r113;
        if (r100.f275515b.compare(r113, r100.f275518e) <= 0) goto L15;
        r100.f275518e = r113;
        goto L15
    L22:
        r100.f275516c[0] = r113;
        r100.f275518e = r113;
        r100.f275517d = 1;
        goto L15
    L53:
        T[] r126 = r100.f275516c;
        Arrays.sort(r126, 0, r100.f275517d, r100.f275515b);
        int r127 = r100.f275517d;
        int r128 = r100.f275514a;
        if (r127 <= r128) goto L57;
        T[] r129 = r100.f275516c;
        Arrays.fill(r129, r128, r129.length, null);
        int r130 = r100.f275514a;
        r100.f275517d = r130;
        r100.f275518e = r100.f275516c[r130 - 1];
    L57:
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(r126, r100.f275517d)));
    L59:
        return Collections.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    public <E extends T> E max(@ParametricNullness E r100, @ParametricNullness E r101) {
        if (compare(r100, r101) < 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    public <E extends T> E min(@ParametricNullness E r100, @ParametricNullness E r101) {
        if (compare(r100, r101) > 0) goto L6;
        return r100;
    L6:
        return r101;
    }

    public <E extends T> List<E> greatestOf(Iterator<E> r100, int r101) {
        return reverse().leastOf(r100, r101);
    }

    public <E extends T> List<E> leastOf(Iterable<E> r100, int r101) {
        if ((r100 instanceof Collection) == false) goto L12;
        Collection r102 = (Collection) r100;
        if (r102.size() > (((long) r101) * 2)) goto L12;
        Object[] r103 = r102.toArray();
        Arrays.sort(r103, this);
        if (r103.length <= r101) goto L10;
        r103 = Arrays.copyOf(r103, r101);
    L10:
        return Collections.unmodifiableList(Arrays.asList(r103));
    L12:
        return leastOf(r100.iterator(), r101);
    }

    @ParametricNullness
    public <E extends T> E max(@ParametricNullness E r100, @ParametricNullness E r101, @ParametricNullness E r102, E... r103) {
        E r104 = (E) max(max(r100, r101), r102);
        int r105 = r103.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        E r107 = r104;
        r104 = (E) max(r107, r103[r106]);
        r106 = r106 + 1;
        goto L3
    L5:
        return r104;
    }

    @ParametricNullness
    public <E extends T> E min(@ParametricNullness E r100, @ParametricNullness E r101, @ParametricNullness E r102, E... r103) {
        E r104 = (E) min(min(r100, r101), r102);
        int r105 = r103.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        E r107 = r104;
        r104 = (E) min(r107, r103[r106]);
        r106 = r106 + 1;
        goto L3
    L5:
        return r104;
    }
}

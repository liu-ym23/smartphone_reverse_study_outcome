package com.google.common.collect;

import com.google.errorprone.annotations.Immutable;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@Immutable(containerOf = {"C"})
@ElementTypesAreNonnullByDefault
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements com.google.common.base.n<C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Range<Comparable> f275290a = null;
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    public static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new RangeLexOrdering();
        }

        private RangeLexOrdering() {
        }

        public int compare(Range<?> r100, Range<?> r101) {
            return r.f275495a.a(r100.lowerBound, r101.lowerBound).a(r100.upperBound, r101.upperBound).b();
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r100, Object r101) {
            return compare((Range) r100, (Range) r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275291a = null;

        static {
            int[] r100 = new int[BoundType.values().length];
            f275291a = r100;
            r100[BoundType.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f275291a[BoundType.CLOSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class b implements com.google.common.base.g<Range, Cut> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f275292a = null;

        public b() {
        }

        static {
            f275292a = new b();
        }

        @Override // com.google.common.base.g
        public final Cut apply(Range r100) {
            return r100.lowerBound;
        }
    }

    public static class c implements com.google.common.base.g<Range, Cut> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f275293a = null;

        public c() {
        }

        static {
            f275293a = new c();
        }

        @Override // com.google.common.base.g
        public final Cut apply(Range r100) {
            return r100.upperBound;
        }
    }

    static {
        f275290a = new Range(Cut.belowAll(), Cut.aboveAll());
    }

    public boolean hasLowerBound() {
        if (this.lowerBound == Cut.belowAll()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasUpperBound() {
        if (this.upperBound == Cut.aboveAll()) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return (C) this.lowerBound.endpoint();
    }

    public Object readResolve() {
        if (equals(f275290a) == true) goto L5;
        return this;
    L5:
        return all();
    }

    public String toString() {
        Cut<C> r100 = this.lowerBound;
        Cut<C> r101 = this.upperBound;
        StringBuilder r102 = new StringBuilder(16);
        r100.describeAsLowerBound(r102);
        r102.append(DownloadConstants.VULNERABILITY_PATH);
        r101.describeAsUpperBound(r102);
        return r102.toString();
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return (C) this.upperBound.endpoint();
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) f275290a;
    }

    public static <C extends Comparable<?>> com.google.common.base.g<Range<C>, Cut<C>> lowerBoundFn() {
        return b.f275292a;
    }

    public static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    public static <C extends Comparable<?>> com.google.common.base.g<Range<C>, Cut<C>> upperBoundFn() {
        return c.f275293a;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C r100) {
        return create(Cut.belowValue(r100), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C r100) {
        return create(Cut.belowAll(), Cut.aboveValue(r100));
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> r100) {
        r100.getClass();
        if ((r100 instanceof SortedSet) == false) goto L9;
        SortedSet r101 = (SortedSet) r100;
        Comparator r102 = r101.comparator();
        if (Ordering.natural().equals(r102) == true) goto L8;
        if (r102 != null) goto L9;
    L8:
        return closed((Comparable) r101.first(), (Comparable) r101.last());
    L9:
        Iterator<C> r103 = r100.iterator();
        C r104 = r103.next();
        r104.getClass();
        Comparable r105 = r104;
    L11:
        if (r103.hasNext() == false) goto L14;
        C r106 = r103.next();
        r106.getClass();
        r104 = (Comparable) Ordering.natural().min(r104, r106);
        r105 = (Comparable) Ordering.natural().max(r105, r106);
        goto L11
    L14:
        return closed(r104, r105);
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C r100) {
        return create(Cut.aboveValue(r100), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C r100) {
        return create(Cut.belowAll(), Cut.belowValue(r100));
    }

    public static <C extends Comparable<?>> Range<C> singleton(C r100) {
        return closed(r100, r100);
    }

    @Override // com.google.common.base.n
    public /* bridge */ /* synthetic */ boolean apply(Object r100) {
        return apply((Comparable) r100);
    }

    public Range<C> canonical(DiscreteDomain<C> r100) {
        r100.getClass();
        Cut<C> r101 = this.lowerBound.canonical(r100);
        Cut<C> r102 = this.upperBound.canonical(r100);
        if (r101 != this.lowerBound) goto L8;
        if (r102 != this.upperBound) goto L8;
        return this;
    L8:
        return create(r101, r102);
    }

    public boolean contains(C r100) {
        r100.getClass();
        if (this.lowerBound.isLessThan(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.isLessThan(r100) == true) goto L7;
        return true;
    }

    public boolean containsAll(Iterable<? extends C> r100) {
        if ((r100 instanceof Collection) == false) goto L5;
        boolean r101 = ((Collection) r100).isEmpty();
    L6:
        if (r101 == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof SortedSet) == false) goto L20;
        SortedSet r102 = (SortedSet) r100;
        Comparator r103 = r102.comparator();
        if (Ordering.natural().equals(r103) == true) goto L14;
        if (r103 != null) goto L20;
    L14:
        if (contains((Comparable) r102.first()) == true) goto L16;
    L18:
        return false;
    L16:
        if (contains((Comparable) r102.last()) == false) goto L18;
        return true;
    L20:
        Iterator<? extends C> r104 = r100.iterator();
    L22:
        if (r104.hasNext() == false) goto L26;
        if (contains(r104.next()) == true) goto L22;
        return false;
    L26:
        return true;
    L5:
        r101 = !r100.iterator().hasNext();
        goto L6
    }

    public boolean encloses(Range<C> r100) {
        if (this.lowerBound.compareTo(r100.lowerBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (this.upperBound.compareTo(r100.upperBound) < 0) goto L7;
        return true;
    }

    @Override // com.google.common.base.n
    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Range) == false) goto L10;
        Range r101 = (Range) r100;
        if (this.lowerBound.equals(r101.lowerBound) == true) goto L7;
        return false;
    L7:
        if (this.upperBound.equals(r101.upperBound) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public Range<C> gap(Range<C> r100) {
        if (this.lowerBound.compareTo(r100.upperBound) >= 0) goto L10;
        if (r100.lowerBound.compareTo(this.upperBound) >= 0) goto L10;
        throw new IllegalArgumentException("Ranges have a nonempty intersection: " + this + ", " + r100);
    L10:
        if (this.lowerBound.compareTo(r100.lowerBound) >= 0) goto L12;
        boolean r101 = true;
    L13:
        if (r101 == false) goto L15;
        Range<C> r102 = this;
    L16:
        if (r101 == true) goto L20;
        r100 = this;
    L20:
        return create(r102.upperBound, r100.lowerBound);
    L15:
        r102 = r100;
        goto L16
    L12:
        r101 = false;
        goto L13
    }

    public Range<C> intersection(Range<C> r100) {
        int r101 = this.lowerBound.compareTo(r100.lowerBound);
        int r102 = this.upperBound.compareTo(r100.upperBound);
        if (r101 < 0) goto L6;
        if (r102 > 0) goto L6;
        return this;
    L6:
        if (r101 > 0) goto L9;
        if (r102 < 0) goto L9;
        return r100;
    L9:
        if (r101 < 0) goto L11;
        Cut<C> r103 = this.lowerBound;
    L12:
        if (r102 > 0) goto L14;
        Cut<C> r104 = this.upperBound;
    L16:
        if (r103.compareTo(r104) > 0) goto L18;
        boolean r105 = true;
    L19:
        com.google.common.base.m.i(r105, "intersection is undefined for disconnected ranges %s and %s", this, r100);
        return create(r103, r104);
    L18:
        r105 = false;
        goto L19
    L14:
        r104 = r100.upperBound;
        goto L16
    L11:
        r103 = r100.lowerBound;
        goto L12
    }

    public boolean isConnected(Range<C> r100) {
        if (this.lowerBound.compareTo(r100.upperBound) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (r100.lowerBound.compareTo(this.upperBound) > 0) goto L7;
        return true;
    }

    public Range<C> span(Range<C> r100) {
        int r101 = this.lowerBound.compareTo(r100.lowerBound);
        int r102 = this.upperBound.compareTo(r100.upperBound);
        if (r101 > 0) goto L6;
        if (r102 < 0) goto L6;
        return this;
    L6:
        if (r101 < 0) goto L9;
        if (r102 > 0) goto L9;
        return r100;
    L9:
        if (r101 > 0) goto L11;
        Cut<C> r103 = this.lowerBound;
    L12:
        if (r102 < 0) goto L14;
        Cut<C> r104 = this.upperBound;
    L16:
        return create(r103, r104);
    L14:
        r104 = r100.upperBound;
        goto L16
    L11:
        r103 = r100.lowerBound;
        goto L12
    }

    public boolean apply(C r100) {
        return contains(r100);
    }

    public Range(Cut<C> r100, Cut<C> r101) {
        r100.getClass();
        this.lowerBound = r100;
        r101.getClass();
        this.upperBound = r101;
        if (r100.compareTo(r101) <= 0) goto L5;
    L9:
        StringBuilder r102 = new StringBuilder("Invalid range: ");
        StringBuilder r103 = new StringBuilder(16);
        r100.describeAsLowerBound(r103);
        r103.append(DownloadConstants.VULNERABILITY_PATH);
        r101.describeAsUpperBound(r103);
        r102.append(r103.toString());
        throw new IllegalArgumentException(r102.toString());
    L5:
        if (r100 == Cut.aboveAll()) goto L9;
        if (r101 == Cut.belowAll()) goto L9;
    }

    public static <C extends Comparable<?>> Range<C> closed(C r100, C r101) {
        return create(Cut.belowValue(r100), Cut.aboveValue(r101));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C r100, C r101) {
        return create(Cut.belowValue(r100), Cut.belowValue(r101));
    }

    public static int compareOrThrow(Comparable r100, Comparable r101) {
        return r100.compareTo(r101);
    }

    public static <C extends Comparable<?>> Range<C> create(Cut<C> r100, Cut<C> r101) {
        return new Range(r100, r101);
    }

    public static <C extends Comparable<?>> Range<C> downTo(C r100, BoundType r101) {
        int r102 = a.f275291a[r101.ordinal()];
        if (r102 == 1) goto L11;
        if (r102 != 2) goto L9;
        return atLeast(r100);
    L9:
        throw new AssertionError();
    L11:
        return greaterThan(r100);
    }

    public static <C extends Comparable<?>> Range<C> open(C r100, C r101) {
        return create(Cut.aboveValue(r100), Cut.belowValue(r101));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C r100, C r101) {
        return create(Cut.aboveValue(r100), Cut.aboveValue(r101));
    }

    public static <C extends Comparable<?>> Range<C> upTo(C r100, BoundType r101) {
        int r102 = a.f275291a[r101.ordinal()];
        if (r102 == 1) goto L11;
        if (r102 != 2) goto L9;
        return atMost(r100);
    L9:
        throw new AssertionError();
    L11:
        return lessThan(r100);
    }

    public static <C extends Comparable<?>> Range<C> range(C r100, BoundType r101, C r102, BoundType r103) {
        r101.getClass();
        r103.getClass();
        BoundType r104 = BoundType.OPEN;
        if (r101 != r104) goto L5;
        Cut r105 = Cut.aboveValue(r100);
    L6:
        if (r103 != r104) goto L8;
        Cut r106 = Cut.belowValue(r102);
    L10:
        return create(r105, r106);
    L8:
        r106 = Cut.aboveValue(r102);
        goto L10
    L5:
        r105 = Cut.belowValue(r100);
        goto L6
    }
}

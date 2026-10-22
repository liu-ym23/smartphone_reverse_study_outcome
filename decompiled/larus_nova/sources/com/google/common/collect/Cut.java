package com.google.common.collect;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.Serializable;
import java.lang.Comparable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;
    final C endpoint;

    public static final class AboveAll extends Cut<Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AboveAll f275002a = null;
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> r100) {
            if (r100 != this) goto L4;
            return 0;
        L4:
            return 1;
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> r100) {
            return false;
        }

        public String toString() {
            return "+∞";
        }

        static {
            f275002a = new AboveAll();
        }

        private AboveAll() {
            super("");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        public static /* synthetic */ AboveAll access$100() {
            return f275002a;
        }

        private Object readResolve() {
            return f275002a;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r100) {
            return compareTo((Cut) r100);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r100) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r100) {
            r100.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> r100) {
            return r100.maxValue();
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> r100) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType r100, DiscreteDomain<Comparable<?>> r101) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType r100, DiscreteDomain<Comparable<?>> r101) {
            throw new IllegalStateException();
        }
    }

    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        public String toString() {
            return HTTP.URL_DEFAULT + this.endpoint + "\\";
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }

        public AboveValue(C r100) {
            r100.getClass();
            super(r100);
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> canonical(DiscreteDomain<C> r100) {
            Comparable r101 = leastValueAbove(r100);
            if (r101 == null) goto L6;
            return Cut.belowValue(r101);
        L6:
            return Cut.aboveAll();
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r100) {
            return super.compareTo((Cut) r100);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r100) {
            r100.append('(');
            r100.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r100) {
            r100.append(this.endpoint);
            r100.append(']');
        }

        @Override // com.google.common.collect.Cut
        public C greatestValueBelow(DiscreteDomain<C> r100) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C r100) {
            if (Range.compareOrThrow(this.endpoint, r100) >= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Cut
        @CheckForNull
        public C leastValueAbove(DiscreteDomain<C> r100) {
            return (C) r100.next(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType r100, DiscreteDomain<C> r101) {
            int r102 = a.f275004a[r100.ordinal()];
            if (r102 != 1) goto L5;
            Comparable r103 = r101.next(this.endpoint);
            if (r103 != null) goto L13;
            return Cut.belowAll();
        L13:
            return Cut.belowValue(r103);
        L5:
            if (r102 != 2) goto L8;
            return this;
        L8:
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType r100, DiscreteDomain<C> r101) {
            int r102 = a.f275004a[r100.ordinal()];
            if (r102 != 1) goto L5;
            return this;
        L5:
            if (r102 != 2) goto L12;
            Comparable r103 = r101.next(this.endpoint);
            if (r103 != null) goto L10;
            return Cut.aboveAll();
        L10:
            return Cut.belowValue(r103);
        L12:
            throw new AssertionError();
        }
    }

    public static final class BelowAll extends Cut<Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BelowAll f275003a = null;
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Cut
        public int compareTo(Cut<Comparable<?>> r100) {
            if (r100 != this) goto L4;
            return 0;
        L4:
            return -1;
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(Comparable<?> r100) {
            return true;
        }

        public String toString() {
            return "-∞";
        }

        static {
            f275003a = new BelowAll();
        }

        private BelowAll() {
            super("");
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        public static /* synthetic */ BelowAll access$000() {
            return f275003a;
        }

        private Object readResolve() {
            return f275003a;
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> r100) {
            return Cut.belowValue(r100.minValue());
        L4:
            return this;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r100) {
            return compareTo((Cut) r100);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r100) {
            r100.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r100) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> r100) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> r100) {
            return r100.minValue();
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withLowerBoundType(BoundType r100, DiscreteDomain<Comparable<?>> r101) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        public Cut<Comparable<?>> withUpperBoundType(BoundType r100, DiscreteDomain<Comparable<?>> r101) {
            throw new AssertionError("this statement should be unreachable");
        }
    }

    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        public String toString() {
            return "\\" + this.endpoint + HTTP.URL_DEFAULT;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        public BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }

        public BelowValue(C r100) {
            r100.getClass();
            super(r100);
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r100) {
            return super.compareTo((Cut) r100);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsLowerBound(StringBuilder r100) {
            r100.append('[');
            r100.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public void describeAsUpperBound(StringBuilder r100) {
            r100.append(this.endpoint);
            r100.append(')');
        }

        @Override // com.google.common.collect.Cut
        @CheckForNull
        public C greatestValueBelow(DiscreteDomain<C> r100) {
            return (C) r100.previous(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public boolean isLessThan(C r100) {
            if (Range.compareOrThrow(this.endpoint, r100) > 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.Cut
        public C leastValueAbove(DiscreteDomain<C> r100) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withLowerBoundType(BoundType r100, DiscreteDomain<C> r101) {
            int r102 = a.f275004a[r100.ordinal()];
            if (r102 != 1) goto L5;
            return this;
        L5:
            if (r102 != 2) goto L12;
            Comparable r103 = r101.previous(this.endpoint);
            if (r103 != null) goto L10;
            return Cut.belowAll();
        L10:
            return new AboveValue(r103);
        L12:
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public Cut<C> withUpperBoundType(BoundType r100, DiscreteDomain<C> r101) {
            int r102 = a.f275004a[r100.ordinal()];
            if (r102 != 1) goto L5;
            Comparable r103 = r101.previous(this.endpoint);
            if (r103 != null) goto L13;
            return Cut.aboveAll();
        L13:
            return new AboveValue(r103);
        L5:
            if (r102 != 2) goto L8;
            return this;
        L8:
            throw new AssertionError();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275004a = null;

        static {
            int[] r100 = new int[BoundType.values().length];
            f275004a = r100;
            r100[BoundType.CLOSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f275004a[BoundType.OPEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public Cut<C> canonical(DiscreteDomain<C> r100) {
        return this;
    }

    public abstract void describeAsLowerBound(StringBuilder r100);

    public abstract void describeAsUpperBound(StringBuilder r100);

    @CheckForNull
    public abstract C greatestValueBelow(DiscreteDomain<C> r100);

    public abstract int hashCode();

    public abstract boolean isLessThan(C r100);

    @CheckForNull
    public abstract C leastValueAbove(DiscreteDomain<C> r100);

    public abstract BoundType typeAsLowerBound();

    public abstract BoundType typeAsUpperBound();

    public abstract Cut<C> withLowerBoundType(BoundType r100, DiscreteDomain<C> r101);

    public abstract Cut<C> withUpperBoundType(BoundType r100, DiscreteDomain<C> r101);

    public static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.access$100();
    }

    public static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.access$000();
    }

    public C endpoint() {
        return this.endpoint;
    }

    public Cut(C r100) {
        this.endpoint = r100;
    }

    public static <C extends Comparable> Cut<C> aboveValue(C r100) {
        return new AboveValue(r100);
    }

    public static <C extends Comparable> Cut<C> belowValue(C r100) {
        return new BelowValue(r100);
    }

    public int compareTo(Cut<C> r100) {
        if (r100 != belowAll()) goto L6;
        return 1;
    L6:
        if (r100 != aboveAll()) goto L8;
        return -1;
    L8:
        int r101 = Range.compareOrThrow(this.endpoint, r100.endpoint);
        if (r101 == 0) goto L11;
        return r101;
    L11:
        boolean r102 = this instanceof AboveValue;
        if (r102 != (r100 instanceof AboveValue)) goto L14;
        return 0;
    L14:
        if (r102 == true) goto L19;
        return -1;
    L19:
        return 1;
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Cut) == true) goto L10;
        return false;
    L10:
        if (compareTo((Cut) r100) != 0) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r100) {
        return compareTo((Cut) r100);
    }
}

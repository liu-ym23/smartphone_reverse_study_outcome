package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class GeneralRange<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public transient GeneralRange<T> f275024a;
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;

    @CheckForNull
    private final T lowerEndpoint;
    private final BoundType upperBoundType;

    @CheckForNull
    private final T upperEndpoint;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType()});
    }

    public GeneralRange<T> reverse() {
        GeneralRange<T> r100 = this.f275024a;
        if (r100 != null) goto L6;
        GeneralRange<T> r101 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        r101.f275024a = this;
        this.f275024a = r101;
        return r101;
    L6:
        return r100;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.comparator);
        r100.append(":");
        BoundType r101 = this.lowerBoundType;
        BoundType r102 = BoundType.CLOSED;
        if (r101 != r102) goto L5;
        char r103 = '[';
    L6:
        r100.append(r103);
        if (this.hasLowerBound == false) goto L9;
        Object r104 = this.lowerEndpoint;
    L10:
        r100.append(r104);
        r100.append(',');
        if (this.hasUpperBound == false) goto L13;
        Object r105 = this.upperEndpoint;
    L14:
        r100.append(r105);
        if (this.upperBoundType != r102) goto L17;
        char r106 = ']';
    L18:
        r100.append(r106);
        return r100.toString();
    L17:
        r106 = ')';
        goto L18
    L13:
        r105 = "∞";
        goto L14
    L9:
        r104 = "-∞";
        goto L10
    L5:
        r103 = '(';
        goto L6
    }

    public boolean isEmpty() {
        if (hasUpperBound() == false) goto L7;
        if (tooLow(getUpperEndpoint()) == false) goto L7;
    L10:
        return true;
    L7:
        if (hasLowerBound() == true) goto L9;
    L11:
        return false;
    L9:
        if (tooHigh(getLowerEndpoint()) == false) goto L11;
        goto L10
    }

    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    public BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    @CheckForNull
    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public BoundType getUpperBoundType() {
        return this.upperBoundType;
    }

    @CheckForNull
    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public static <T> GeneralRange<T> all(Comparator<? super T> r100) {
        BoundType r101 = BoundType.OPEN;
        return new GeneralRange(r100, false, null, r101, false, null, r101);
    }

    public static <T extends Comparable> GeneralRange<T> from(Range<T> r110) {
        Comparable r100 = null;
        if (r110.hasLowerBound() == false) goto L5;
        Comparable r101 = r110.lowerEndpoint();
    L7:
        if (r110.hasLowerBound() == false) goto L9;
        BoundType r102 = r110.lowerBoundType();
    L10:
        BoundType r103 = r102;
        if (r110.hasUpperBound() == false) goto L13;
        r100 = r110.upperEndpoint();
    L13:
        Comparable r104 = r100;
        if (r110.hasUpperBound() == false) goto L16;
        BoundType r105 = r110.upperBoundType();
    L18:
        return new GeneralRange(Ordering.natural(), r110.hasLowerBound(), r101, r103, r110.hasUpperBound(), r104, r105);
    L16:
        r105 = BoundType.OPEN;
        goto L18
    L9:
        r102 = BoundType.OPEN;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    public boolean contains(@ParametricNullness T r100) {
        if (tooLow(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (tooHigh(r100) == true) goto L7;
        return true;
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof GeneralRange) == false) goto L20;
        GeneralRange r101 = (GeneralRange) r100;
        if (this.comparator.equals(r101.comparator) == true) goto L7;
        return false;
    L7:
        if (this.hasLowerBound == r101.hasLowerBound) goto L9;
        return false;
    L9:
        if (this.hasUpperBound == r101.hasUpperBound) goto L11;
        return false;
    L11:
        if (getLowerBoundType().equals(r101.getLowerBoundType()) == true) goto L13;
        return false;
    L13:
        if (getUpperBoundType().equals(r101.getUpperBoundType()) == true) goto L15;
        return false;
    L15:
        if (com.google.common.base.k.a(getLowerEndpoint(), r101.getLowerEndpoint()) == true) goto L17;
        return false;
    L17:
        if (com.google.common.base.k.a(getUpperEndpoint(), r101.getUpperEndpoint()) == false) goto L27;
        return true;
    L27:
        return false;
    L20:
        return false;
    }

    public GeneralRange<T> intersect(GeneralRange<T> r110) {
        r110.getClass();
        com.google.common.base.m.b(this.comparator.equals(r110.comparator));
        boolean r100 = this.hasLowerBound;
        T r101 = getLowerEndpoint();
        BoundType r102 = getLowerBoundType();
        if (hasLowerBound() == true) goto L6;
        r100 = r110.hasLowerBound;
        r101 = r110.getLowerEndpoint();
        r102 = r110.getLowerBoundType();
    L13:
        boolean r103 = r100;
        boolean r104 = this.hasUpperBound;
        T r105 = getUpperEndpoint();
        BoundType r106 = getUpperBoundType();
        if (hasUpperBound() == true) goto L17;
        r104 = r110.hasUpperBound;
        r105 = r110.getUpperEndpoint();
        r106 = r110.getUpperBoundType();
    L24:
        boolean r107 = r104;
        T r108 = r105;
        if (r103 == false) goto L34;
        if (r107 == false) goto L34;
        int r111 = this.comparator.compare(r101, r108);
        if (r111 > 0) goto L33;
        if (r111 != 0) goto L34;
        BoundType r112 = BoundType.OPEN;
        if (r102 != r112) goto L34;
        if (r106 != r112) goto L34;
    L33:
        BoundType r113 = BoundType.OPEN;
        BoundType r109 = r113;
        BoundType r114 = BoundType.CLOSED;
        T r115 = r108;
    L36:
        return new GeneralRange(this.comparator, r103, r115, r109, r107, r108, r114);
    L34:
        r115 = r101;
        r109 = r102;
        r114 = r106;
        goto L36
    L17:
        if (r110.hasUpperBound() == false) goto L24;
        int r116 = this.comparator.compare(getUpperEndpoint(), r110.getUpperEndpoint());
        if (r116 > 0) goto L23;
        if (r116 != 0) goto L24;
        if (r110.getUpperBoundType() != BoundType.OPEN) goto L24;
    L23:
        r105 = r110.getUpperEndpoint();
        r106 = r110.getUpperBoundType();
        goto L24
    L6:
        if (r110.hasLowerBound() == false) goto L13;
        int r117 = this.comparator.compare(getLowerEndpoint(), r110.getLowerEndpoint());
        if (r117 < 0) goto L12;
        if (r117 != 0) goto L13;
        if (r110.getLowerBoundType() != BoundType.OPEN) goto L13;
    L12:
        r101 = r110.getLowerEndpoint();
        r102 = r110.getLowerBoundType();
        goto L13
    }

    public boolean tooHigh(@ParametricNullness T r100) {
        boolean r101 = false;
        if (hasUpperBound() == true) goto L5;
        return false;
    L5:
        T r102 = getUpperEndpoint();
        int r103 = this.comparator.compare(r100, r102);
        if (r103 <= 0) goto L8;
        boolean r104 = true;
    L9:
        if (r103 != 0) goto L11;
        boolean r105 = true;
    L13:
        if (getUpperBoundType() != BoundType.OPEN) goto L16;
        r101 = true;
    L16:
        return (r105 & r101) | r104;
    L11:
        r105 = false;
        goto L13
    L8:
        r104 = false;
        goto L9
    }

    public boolean tooLow(@ParametricNullness T r100) {
        boolean r101 = false;
        if (hasLowerBound() == true) goto L5;
        return false;
    L5:
        T r102 = getLowerEndpoint();
        int r103 = this.comparator.compare(r100, r102);
        if (r103 >= 0) goto L8;
        boolean r104 = true;
    L9:
        if (r103 != 0) goto L11;
        boolean r105 = true;
    L13:
        if (getLowerBoundType() != BoundType.OPEN) goto L16;
        r101 = true;
    L16:
        return (r105 & r101) | r104;
    L11:
        r105 = false;
        goto L13
    L8:
        r104 = false;
        goto L9
    }

    public static <T> GeneralRange<T> downTo(Comparator<? super T> r100, @ParametricNullness T r110, BoundType r111) {
        return new GeneralRange(r100, true, r110, r111, false, null, BoundType.OPEN);
    }

    public static <T> GeneralRange<T> upTo(Comparator<? super T> r100, @ParametricNullness T r110, BoundType r111) {
        return new GeneralRange(r100, false, null, BoundType.OPEN, true, r110, r111);
    }

    public static <T> GeneralRange<T> range(Comparator<? super T> r100, @ParametricNullness T r110, BoundType r111, @ParametricNullness T r112, BoundType r113) {
        return new GeneralRange(r100, true, r110, r111, true, r112, r113);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GeneralRange(Comparator<? super T> r100, boolean r101, @CheckForNull T r102, BoundType r103, boolean r104, @CheckForNull T r105, BoundType r106) {
        r100.getClass();
        this.comparator = r100;
        this.hasLowerBound = r101;
        this.hasUpperBound = r104;
        this.lowerEndpoint = r102;
        r103.getClass();
        this.lowerBoundType = r103;
        this.upperEndpoint = r105;
        r106.getClass();
        this.upperBoundType = r106;
        if (r101 == false) goto L5;
        r100.compare(r102, r102);
    L5:
        if (r104 == false) goto L7;
        r100.compare(r105, r105);
    L7:
        if (r101 == false) goto L22;
        if (r104 == false) goto L23;
        int r107 = r100.compare(r102, r105);
        boolean r108 = true;
        if (r107 > 0) goto L12;
        boolean r109 = true;
    L13:
        com.google.common.base.m.i(r109, "lowerEndpoint (%s) > upperEndpoint (%s)", r102, r105);
        if (r107 != 0) goto L24;
        BoundType r110 = BoundType.OPEN;
        if (r103 != r110) goto L20;
        if (r106 != r110) goto L20;
        r108 = false;
    L20:
        com.google.common.base.m.b(r108);
        return;
    L24:
        return;
    L12:
        r109 = false;
        goto L13
    L23:
        return;
    }
}

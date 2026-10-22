package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class ApproximationBounds<T> {
    private final T lower;
    private final T upper;

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ApproximationBounds) == true) goto L8;
        return false;
    L8:
        ApproximationBounds r101 = (ApproximationBounds) r100;
        if (Intrinsics.areEqual(this.lower, r101.lower) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.upper, r101.upper) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        T r100 = this.lower;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        T r104 = this.upper;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + ')';
    }

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }

    public ApproximationBounds(T r100, T r101) {
        this.lower = r100;
        this.upper = r101;
    }
}

package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    private static final long serialVersionUID = 1;

    public Triple() {
    }

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public String toString() {
        return "(" + getLeft() + "," + getMiddle() + "," + getRight() + ")";
    }

    public int hashCode() {
        int r100 = 0;
        if (getLeft() != null) goto L5;
        int r101 = 0;
    L7:
        if (getMiddle() != null) goto L9;
        int r102 = 0;
    L10:
        int r103 = r101 ^ r102;
        if (getRight() == null) goto L15;
        r100 = getRight().hashCode();
    L15:
        return r103 ^ r100;
    L9:
        r102 = getMiddle().hashCode();
        goto L10
    L5:
        r101 = getLeft().hashCode();
        goto L7
    }

    public int compareTo(Triple<L, M, R> r100) {
        return new CompareToBuilder().append(getLeft(), r100.getLeft()).append(getMiddle(), r100.getMiddle()).append(getRight(), r100.getRight()).toComparison();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Triple) == false) goto L16;
        Triple r101 = (Triple) r100;
        if (Objects.equals(getLeft(), r101.getLeft()) == true) goto L10;
    L14:
        return false;
    L10:
        if (Objects.equals(getMiddle(), r101.getMiddle()) == false) goto L14;
        if (Objects.equals(getRight(), r101.getRight()) == false) goto L14;
        return true;
    L16:
        return false;
    }

    public String toString(String r100) {
        return String.format(r100, new Object[]{getLeft(), getMiddle(), getRight()});
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r100) {
        return compareTo((Triple) r100);
    }

    public static <L, M, R> Triple<L, M, R> of(L r100, M r101, R r102) {
        return new ImmutableTriple(r100, r101, r102);
    }
}

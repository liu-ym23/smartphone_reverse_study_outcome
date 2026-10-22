package com.ss.android.push;

import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    private static final long serialVersionUID = 1;

    public Triple() {
    }

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public String toString() {
        return "(" + getLeft() + ',' + getMiddle() + ',' + getRight() + ')';
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
        int r101 = ((Comparable) getLeft()).compareTo(r100.getLeft());
        if (r101 == 0) goto L5;
        return r101;
    L5:
        int r102 = ((Comparable) getMiddle()).compareTo(r100.getMiddle());
        if (r102 == 0) goto L9;
        return r102;
    L9:
        return ((Comparable) getRight()).compareTo(r100.getRight());
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100 != this) goto L9;
        return true;
    L9:
        if ((r100 instanceof Triple) == false) goto L39;
        Triple r101 = (Triple) r100;
        L r102 = getLeft();
        Object r103 = r101.getLeft();
        if (r102 == null) goto L17;
        if (r103 == null) goto L17;
        if (r102 != r103) goto L15;
    L16:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L40;
        M r105 = getMiddle();
        Object r106 = r101.getMiddle();
        if (r105 == null) goto L26;
        if (r106 == null) goto L26;
        if (r105 != r106) goto L24;
    L25:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L41;
        R r108 = getRight();
        Object r109 = r101.getRight();
        if (r108 == null) goto L35;
        if (r109 == null) goto L35;
        if (r108 != r109) goto L33;
    L34:
        boolean r110 = true;
    L36:
        if (r110 == false) goto L42;
        return true;
    L42:
        return false;
    L33:
        if (r108.equals(r109) == true) goto L34;
    L35:
        r110 = false;
        goto L36
    L41:
        return false;
    L24:
        if (r105.equals(r106) == true) goto L25;
    L26:
        r107 = false;
        goto L27
    L40:
        return false;
    L15:
        if (r102.equals(r103) == true) goto L16;
    L17:
        r104 = false;
        goto L18
    L39:
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

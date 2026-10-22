package org.apache.commons.lang3.tuple;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Pair<L, R> implements Map.Entry<L, R>, Comparable<Pair<L, R>>, Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    public Pair() {
    }

    public abstract L getLeft();

    public abstract R getRight();

    public String toString() {
        return "(" + getLeft() + ',' + getRight() + ')';
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        return getLeft();
    }

    @Override // java.util.Map.Entry
    public R getValue() {
        return getRight();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        int r100 = 0;
        if (getKey() != null) goto L5;
        int r101 = 0;
    L7:
        if (getValue() == null) goto L11;
        r100 = getValue().hashCode();
    L11:
        return r101 ^ r100;
    L5:
        r101 = getKey().hashCode();
        goto L7
    }

    public int compareTo(Pair<L, R> r100) {
        return new CompareToBuilder().append(getLeft(), r100.getLeft()).append(getRight(), r100.getRight()).toComparison();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Map.Entry) == false) goto L14;
        Map.Entry r101 = (Map.Entry) r100;
        if (Objects.equals(getKey(), r101.getKey()) == true) goto L10;
    L12:
        return false;
    L10:
        if (Objects.equals(getValue(), r101.getValue()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public String toString(String r100) {
        return String.format(r100, new Object[]{getLeft(), getRight()});
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r100) {
        return compareTo((Pair) r100);
    }

    public static <L, R> Pair<L, R> of(L r100, R r101) {
        return new ImmutablePair(r100, r101);
    }
}

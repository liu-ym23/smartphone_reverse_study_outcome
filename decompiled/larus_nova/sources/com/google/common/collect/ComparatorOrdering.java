package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }

    public ComparatorOrdering(Comparator<T> r100) {
        r100.getClass();
        this.comparator = r100;
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ComparatorOrdering) == true) goto L8;
        return false;
    L8:
        return this.comparator.equals(((ComparatorOrdering) r100).comparator);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@ParametricNullness T r100, @ParametricNullness T r101) {
        return this.comparator.compare(r100, r101);
    }
}

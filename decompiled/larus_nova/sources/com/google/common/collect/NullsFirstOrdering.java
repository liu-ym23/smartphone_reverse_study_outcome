package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> ordering;

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsFirst() {
        return this;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> nullsLast() {
        return this.ordering.nullsLast();
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.ordering.reverse().nullsLast();
    }

    public String toString() {
        return this.ordering + ".nullsFirst()";
    }

    public NullsFirstOrdering(Ordering<? super T> r100) {
        this.ordering = r100;
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof NullsFirstOrdering) == true) goto L8;
        return false;
    L8:
        return this.ordering.equals(((NullsFirstOrdering) r100).ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@CheckForNull T r100, @CheckForNull T r101) {
        if (r100 != r101) goto L5;
        return 0;
    L5:
        if (r100 != null) goto L8;
        return -1;
    L8:
        if (r101 != null) goto L12;
        return 1;
    L12:
        return this.ordering.compare(r100, r101);
    }
}

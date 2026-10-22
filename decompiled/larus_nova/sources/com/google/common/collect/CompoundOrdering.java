package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T>[] comparators;

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.comparators) + ")";
    }

    public CompoundOrdering(Iterable<? extends Comparator<? super T>> r100) {
        Comparator[] r101 = new Comparator[0];
        if ((r100 instanceof Collection) == false) goto L5;
        Collection r102 = (Collection) r100;
    L6:
        this.comparators = (Comparator[]) r102.toArray(r101);
        return;
    L5:
        r102 = Lists.c(r100.iterator());
        goto L6
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CompoundOrdering) == true) goto L8;
        return false;
    L8:
        return Arrays.equals(this.comparators, ((CompoundOrdering) r100).comparators);
    }

    public CompoundOrdering(Comparator<? super T> r100, Comparator<? super T> r101) {
        this.comparators = new Comparator[]{r100, r101};
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@ParametricNullness T r100, @ParametricNullness T r101) {
        int r102 = 0;
    L3:
        Comparator<? super T>[] r103 = this.comparators;
        if (r102 >= r103.length) goto L9;
        int r104 = r103[r102].compare(r100, r101);
        if (r104 != 0) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return r104;
    L9:
        return 0;
    }
}

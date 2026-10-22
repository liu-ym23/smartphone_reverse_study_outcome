package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T> elementOrder;

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        return this.elementOrder + ".lexicographical()";
    }

    public LexicographicalOrdering(Comparator<? super T> r100) {
        this.elementOrder = r100;
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof LexicographicalOrdering) == true) goto L8;
        return false;
    L8:
        return this.elementOrder.equals(((LexicographicalOrdering) r100).elementOrder);
    }

    public int compare(Iterable<T> r100, Iterable<T> r101) {
        Iterator<T> r102 = r100.iterator();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        if (r103.hasNext() == false) goto L7;
        int r104 = this.elementOrder.compare(r102.next(), r103.next());
        if (r104 == 0) goto L4;
        return r104;
    L7:
        return 1;
    L13:
        if (r103.hasNext() == false) goto L16;
        return -1;
    L16:
        return 0;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Object r100, Object r101) {
        return compare((Iterable) r100, (Iterable) r101);
    }
}

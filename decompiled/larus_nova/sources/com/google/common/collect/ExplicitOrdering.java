package com.google.common.collect;

import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }

    public ExplicitOrdering(List<T> r100) {
        this(Maps.d(r100));
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof ExplicitOrdering) == true) goto L5;
        return false;
    L5:
        return this.rankMap.equals(((ExplicitOrdering) r100).rankMap);
    }

    public ExplicitOrdering(ImmutableMap<T, Integer> r100) {
        this.rankMap = r100;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T r100, T r101) {
        Integer r102 = this.rankMap.get(r100);
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
        Integer r104 = this.rankMap.get(r101);
        if (r104 == null) goto L9;
        return r103 - r104.intValue();
    L9:
        throw new Ordering.IncomparableValueException(r101);
    L11:
        throw new Ordering.IncomparableValueException(r100);
    }
}

package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.base.g<F, ? extends T> function;
    final Ordering<T> ordering;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.ordering});
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ByFunctionOrdering) == false) goto L14;
        ByFunctionOrdering r101 = (ByFunctionOrdering) r100;
        if (this.function.equals(r101.function) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.ordering.equals(r101.ordering) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public ByFunctionOrdering(com.google.common.base.g<F, ? extends T> r100, Ordering<T> r101) {
        r100.getClass();
        this.function = r100;
        r101.getClass();
        this.ordering = r101;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(@ParametricNullness F r100, @ParametricNullness F r101) {
        return this.ordering.compare(this.function.apply(r100), this.function.apply(r101));
    }
}

package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final g<? super F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.resultEquivalence});
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(F r100) {
        return this.resultEquivalence.hash(this.function.apply(r100));
    }

    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof FunctionalEquivalence) == false) goto L14;
        FunctionalEquivalence r101 = (FunctionalEquivalence) r100;
        if (this.function.equals(r101.function) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.resultEquivalence.equals(r101.resultEquivalence) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public FunctionalEquivalence(g<? super F, ? extends T> r100, Equivalence<T> r101) {
        r100.getClass();
        this.function = r100;
        r101.getClass();
        this.resultEquivalence = r101;
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(F r100, F r101) {
        return this.resultEquivalence.equivalent(this.function.apply(r100), this.function.apply(r101));
    }
}

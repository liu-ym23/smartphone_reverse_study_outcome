package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class PairwiseEquivalence<E, T extends E> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    final Equivalence<E> elementEquivalence;

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }

    public PairwiseEquivalence(Equivalence<E> r100) {
        r100.getClass();
        this.elementEquivalence = r100;
    }

    public int doHash(Iterable<T> r100) {
        Iterator<T> r101 = r100.iterator();
        int r102 = 78721;
    L4:
        if (r101.hasNext() == false) goto L6;
        T r103 = r101.next();
        r102 = (r102 * 24943) + this.elementEquivalence.hash(r103);
        goto L4
    L6:
        return r102;
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof PairwiseEquivalence) == true) goto L5;
        return false;
    L5:
        return this.elementEquivalence.equals(((PairwiseEquivalence) r100).elementEquivalence);
    }

    @Override // com.google.common.base.Equivalence
    public /* bridge */ /* synthetic */ int doHash(Object r100) {
        return doHash((Iterable) r100);
    }

    public boolean doEquivalent(Iterable<T> r100, Iterable<T> r101) {
        Iterator<T> r102 = r100.iterator();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        if (r103.hasNext() == false) goto L11;
        if (this.elementEquivalence.equivalent(r102.next(), r103.next()) == true) goto L4;
        return false;
    L11:
        if (r102.hasNext() == false) goto L13;
        return false;
    L13:
        if (r103.hasNext() == true) goto L21;
        return true;
    L21:
        return false;
    }

    @Override // com.google.common.base.Equivalence
    public /* bridge */ /* synthetic */ boolean doEquivalent(Object r100, Object r101) {
        return doEquivalent((Iterable) r100, (Iterable) r101);
    }
}

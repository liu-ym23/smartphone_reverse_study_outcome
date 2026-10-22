package com.google.common.hash;

import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
class Funnels$SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
    private final Funnel<E> elementFunnel;

    public int hashCode() {
        return Funnels$SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
    }

    public String toString() {
        return "Funnels.sequentialFunnel(" + this.elementFunnel + ")";
    }

    public Funnels$SequentialFunnel(Funnel<E> r100) {
        r100.getClass();
        this.elementFunnel = r100;
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Funnels$SequentialFunnel) == true) goto L5;
        return false;
    L5:
        return this.elementFunnel.equals(((Funnels$SequentialFunnel) r100).elementFunnel);
    }

    public void funnel(Iterable<? extends E> r100, k r101) {
        Iterator<? extends E> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        E r103 = r102.next();
        this.elementFunnel.funnel(r103, r101);
        goto L4
    }

    @Override // com.google.common.hash.Funnel
    public /* bridge */ /* synthetic */ void funnel(Object r100, k r101) {
        funnel((Iterable) r100, r101);
    }
}

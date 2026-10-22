package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public interface y1<E> extends Collection<E> {

    public interface a<E> {
        int getCount();

        @ParametricNullness
        E getElement();

        String toString();
    }

    int add(@ParametricNullness E r100, int r101);

    boolean contains(@CheckForNull Object r100);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> r100);

    int count(@CheckForNull Object r100);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    boolean equals(@CheckForNull Object r100);

    int hashCode();

    Iterator<E> iterator();

    int remove(@CheckForNull Object r100, int r101);

    boolean remove(@CheckForNull Object r100);

    int setCount(@ParametricNullness E r100, int r101);

    boolean setCount(@ParametricNullness E r100, int r101, int r102);

    int size();
}

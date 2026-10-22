package com.google.common.collect;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class j0<E> extends f0<E> implements List<E> {
    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        return Collections.emptyList().hashCode();
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator() {
        return Collections.emptyList().listIterator();
    }

    public j0() {
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L4;
    L7:
        return true;
    L4:
        if (Collections.emptyList().equals(r100) == true) goto L7;
        return false;
    }

    @Override // java.util.List
    @ParametricNullness
    public final E get(int r100) {
        return (E) ListProtector.get(Collections.emptyList(), r100);
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object r100) {
        return Collections.emptyList().indexOf(r100);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object r100) {
        return Collections.emptyList().lastIndexOf(r100);
    }

    @Override // java.util.List
    public final ListIterator<E> listIterator(int r100) {
        return Collections.emptyList().listIterator(r100);
    }

    @Override // java.util.List
    @ParametricNullness
    public final E remove(int r100) {
        return (E) ListProtector.remove(Collections.emptyList(), r100);
    }

    @Override // java.util.List
    @ParametricNullness
    public final E set(int r100, @ParametricNullness E r101) {
        return (E) ListProtector.set(Collections.emptyList(), r100, r101);
    }

    @Override // java.util.List
    public final List<E> subList(int r100, int r101) {
        return Collections.emptyList().subList(r100, r101);
    }
}

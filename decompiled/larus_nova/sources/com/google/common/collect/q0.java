package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class q0<E> extends f0<E> implements Set<E> {
    @Override // com.google.common.collect.f0, com.google.common.collect.o0
    public abstract Set<E> delegate();

    @Override // com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public int standardHashCode() {
        return Sets.c(this);
    }

    public q0() {
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.o0
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r100) == true) goto L7;
        return false;
    }

    public boolean standardEquals(@CheckForNull Object r100) {
        return Sets.a(this, r100);
    }

    @Override // com.google.common.collect.f0
    public boolean standardRemoveAll(Collection<?> r100) {
        r100.getClass();
        return Sets.d(this, r100);
    }
}

package com.google.common.base;

import java.util.Collections;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T reference;

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return this.reference.hashCode() + 1502476572;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    public Present(T r100) {
        this.reference = r100;
    }

    @Override // com.google.common.base.Optional
    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Present) == true) goto L5;
        return false;
    L5:
        return this.reference.equals(((Present) r100).reference);
    }

    @Override // com.google.common.base.Optional
    public T or(T r100) {
        m.l(r100, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(g<? super T, V> r100) {
        V r101 = r100.apply(this.reference);
        m.l(r101, "the Function passed to Optional.transform() must not return null.");
        return new Present(r101);
    }

    @Override // com.google.common.base.Optional
    public T or(t<? extends T> r100) {
        r100.getClass();
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> r100) {
        r100.getClass();
        return this;
    }
}

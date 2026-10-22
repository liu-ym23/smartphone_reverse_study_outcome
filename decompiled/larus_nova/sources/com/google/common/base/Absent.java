package com.google.common.base;

import java.util.Collections;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class Absent<T> extends Optional<T> {
    static final Absent<Object> INSTANCE = null;
    private static final long serialVersionUID = 0;

    @Override // com.google.common.base.Optional
    public boolean equals(@CheckForNull Object r100) {
        if (r100 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.google.common.base.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // com.google.common.base.Optional
    @CheckForNull
    public T orNull() {
        return null;
    }

    @Override // com.google.common.base.Optional
    public String toString() {
        return "Optional.absent()";
    }

    static {
        INSTANCE = new Absent();
    }

    @Override // com.google.common.base.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.emptySet();
    }

    private Absent() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public static <T> Optional<T> withType() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Optional
    public T or(t<? extends T> r100) {
        T r101 = r100.get();
        m.l(r101, "use Optional.orNull() instead of a Supplier that returns null");
        return r101;
    }

    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(g<? super T, V> r100) {
        r100.getClass();
        return Optional.absent();
    }

    @Override // com.google.common.base.Optional
    public T or(T r100) {
        m.l(r100, "use Optional.orNull() instead of Optional.or(null)");
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Optional
    public Optional<T> or(Optional<? extends T> r100) {
        r100.getClass();
        return r100;
    }
}

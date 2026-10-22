package androidx.camera.core.impl.utils;

import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class Absent<T> extends Optional<T> {
    static final Absent<Object> sInstance = null;
    private static final long serialVersionUID = 0;

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public int hashCode() {
        return 2040732332;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean isPresent() {
        return false;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T orNull() {
        return null;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public String toString() {
        return "Optional.absent()";
    }

    static {
        sInstance = new Absent();
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    private Absent() {
    }

    private Object readResolve() {
        return sInstance;
    }

    public static <T> Optional<T> withType() {
        return sInstance;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T or(Supplier<? extends T> r2) {
        return (T) Preconditions.checkNotNull(r2.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public Optional<T> or(Optional<? extends T> r1) {
        return (Optional) Preconditions.checkNotNull(r1);
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T or(T r2) {
        return (T) Preconditions.checkNotNull(r2, "use Optional.orNull() instead of Optional.or(null)");
    }
}

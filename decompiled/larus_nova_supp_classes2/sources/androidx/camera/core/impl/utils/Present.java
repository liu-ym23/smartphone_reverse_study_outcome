package androidx.camera.core.impl.utils;

import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class Present<T> extends Optional<T> {
    private static final long serialVersionUID = 0;
    private final T mReference;

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public int hashCode() {
        return this.mReference.hashCode() + 1502476572;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public String toString() {
        return "Optional.of(" + this.mReference + ")";
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T get() {
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T orNull() {
        return this.mReference;
    }

    public Present(T r1) {
        this.mReference = r1;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public boolean equals(Object r2) {
        if ((r2 instanceof Present) == true) goto L5;
        return false;
    L5:
        return this.mReference.equals(((Present) r2).mReference);
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T or(T r2) {
        Preconditions.checkNotNull(r2, "use Optional.orNull() instead of Optional.or(null)");
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public T or(Supplier<? extends T> r1) {
        Preconditions.checkNotNull(r1);
        return this.mReference;
    }

    @Override // androidx.camera.core.impl.utils.Optional
    public Optional<T> or(Optional<? extends T> r1) {
        Preconditions.checkNotNull(r1);
        return this;
    }
}

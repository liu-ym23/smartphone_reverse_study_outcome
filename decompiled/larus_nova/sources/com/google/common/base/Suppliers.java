package com.google.common.base;

import com.google.common.cache.CacheBuilder;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Suppliers {

    public static class ExpiringMemoizingSupplier<T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;
        final t<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;

        @CheckForNull
        volatile transient T value;

        @Override // com.google.common.base.t
        @ParametricNullness
        public T get() {
            long r100 = this.expirationNanos;
            long r101 = System.nanoTime();
            if (r100 != 0) goto L5;
        L6:
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L8:
            if (r100 != this.expirationNanos) goto L15;
            T r102 = this.delegate.get();     // Catch: Throwable -> L18
            this.value = r102;     // Catch: Throwable -> L18
            long r103 = r101 + this.durationNanos;     // Catch: Throwable -> L18
            if (r103 != 0) goto L12;
            r103 = 1;
        L12:
            this.expirationNanos = r103;     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            return r102;
        L15:
            monitor-exit(this);     // Catch: Throwable -> L18
        L17:
            return this.value;
        L5:
            if ((r101 - r100) < 0) goto L17;
            goto L6
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
        }

        public ExpiringMemoizingSupplier(t<T> r100, long r101, TimeUnit r102) {
            r100.getClass();
            this.delegate = r100;
            this.durationNanos = r102.toNanos(r101);
            if (r101 <= 0) goto L5;
            boolean r103 = true;
        L6:
            m.g(r103, "duration (%s %s) must be > 0", r101, r102);
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    public static class MemoizingSupplier<T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;
        final t<T> delegate;
        volatile transient boolean initialized;

        @CheckForNull
        transient T value;

        @Override // com.google.common.base.t
        @ParametricNullness
        public T get() {
            if (this.initialized == true) goto L16;
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (this.initialized == true) goto L10;
            T r100 = this.delegate.get();     // Catch: Throwable -> L12
            this.value = r100;     // Catch: Throwable -> L12
            this.initialized = true;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            return r100;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
        L16:
            return this.value;
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("Suppliers.memoize(");
            if (this.initialized == false) goto L5;
            Object r101 = "<supplier that returned " + this.value + ">";
        L6:
            r100.append(r101);
            r100.append(")");
            return r100.toString();
        L5:
            r101 = this.delegate;
            goto L6
        }

        public MemoizingSupplier(t<T> r100) {
            r100.getClass();
            this.delegate = r100;
        }
    }

    public static class SupplierComposition<F, T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;
        final g<? super F, T> function;
        final t<F> supplier;

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.function, this.supplier});
        }

        @Override // com.google.common.base.t
        @ParametricNullness
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
        }

        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof SupplierComposition) == false) goto L10;
            SupplierComposition r101 = (SupplierComposition) r100;
            if (this.function.equals(r101.function) == true) goto L7;
            return false;
        L7:
            if (this.supplier.equals(r101.supplier) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public SupplierComposition(g<? super F, T> r100, t<F> r101) {
            r100.getClass();
            this.function = r100;
            r101.getClass();
            this.supplier = r101;
        }
    }

    public static final enum SupplierFunctionImpl extends Enum<SupplierFunctionImpl> implements g {
        public static final SupplierFunctionImpl INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SupplierFunctionImpl[] f274707a = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        static {
            SupplierFunctionImpl r100 = new SupplierFunctionImpl();
            INSTANCE = r100;
            f274707a = new SupplierFunctionImpl[]{r100};
        }

        public SupplierFunctionImpl() {
            super("INSTANCE", 0);
        }

        public static SupplierFunctionImpl[] values() {
            return (SupplierFunctionImpl[]) f274707a.clone();
        }

        public static SupplierFunctionImpl valueOf(String r100) {
            return (SupplierFunctionImpl) r27.a.a(SupplierFunctionImpl.class, r100);
        }

        @Override // com.google.common.base.g
        @CheckForNull
        public /* bridge */ /* synthetic */ Object apply(Object r100) {
            return apply((t) r100);
        }

        @CheckForNull
        public Object apply(t<Object> r100) {
            return r100.get();
        }
    }

    public static class SupplierOfInstance<T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final T instance;

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.instance});
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }

        @Override // com.google.common.base.t
        @ParametricNullness
        public T get() {
            return this.instance;
        }

        public SupplierOfInstance(@ParametricNullness T r100) {
            this.instance = r100;
        }

        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof SupplierOfInstance) == true) goto L5;
            return false;
        L5:
            return k.a(this.instance, ((SupplierOfInstance) r100).instance);
        }
    }

    public static class ThreadSafeSupplier<T> implements t<T>, Serializable {
        private static final long serialVersionUID = 0;
        final t<T> delegate;

        @Override // com.google.common.base.t
        @ParametricNullness
        public T get() {
            t<T> r100 = this.delegate;
            monitor-enter(r100);
            T r101 = this.delegate.get();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return r101;
        L7:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }

        public ThreadSafeSupplier(t<T> r100) {
            r100.getClass();
            this.delegate = r100;
        }
    }

    public static t a(@ParametricNullness CacheBuilder.a r100) {
        return new SupplierOfInstance(r100);
    }
}

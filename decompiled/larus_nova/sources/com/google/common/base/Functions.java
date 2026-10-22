package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Functions {

    public static class ConstantFunction<E> implements g<Object, E>, Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        private final E value;

        public int hashCode() {
            E r100 = this.value;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "Functions.constant(" + this.value + ")";
        }

        public ConstantFunction(@ParametricNullness E r100) {
            this.value = r100;
        }

        @Override // com.google.common.base.g
        @ParametricNullness
        public E apply(@CheckForNull Object r100) {
            return this.value;
        }

        @Override // com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof ConstantFunction) == true) goto L5;
            return false;
        L5:
            return k.a(this.value, ((ConstantFunction) r100).value);
        }
    }

    public static class ForMapWithDefault<K, V> implements g<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final V defaultValue;
        final Map<K, ? extends V> map;

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.map, this.defaultValue});
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + ")";
        }

        @Override // com.google.common.base.g
        @ParametricNullness
        public V apply(@ParametricNullness K r100) {
            V r101 = this.map.get(r100);
            if (r101 == null) goto L5;
            return r101;
        L5:
            if (this.map.containsKey(r100) == false) goto L8;
            return r101;
        L8:
            return this.defaultValue;
        }

        @Override // com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof ForMapWithDefault) == false) goto L10;
            ForMapWithDefault r101 = (ForMapWithDefault) r100;
            if (this.map.equals(r101.map) == true) goto L7;
            return false;
        L7:
            if (k.a(this.defaultValue, r101.defaultValue) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public ForMapWithDefault(Map<K, ? extends V> r100, @ParametricNullness V r101) {
            r100.getClass();
            this.map = r100;
            this.defaultValue = r101;
        }
    }

    public static class FunctionComposition<A, B, C> implements g<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final g<A, ? extends B> f274696f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final g<B, C> f274697g;

        public int hashCode() {
            return this.f274696f.hashCode() ^ this.f274697g.hashCode();
        }

        public String toString() {
            return this.f274697g + "(" + this.f274696f + ")";
        }

        @Override // com.google.common.base.g
        @ParametricNullness
        public C apply(@ParametricNullness A r100) {
            return (C) this.f274697g.apply(this.f274696f.apply(r100));
        }

        @Override // com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof FunctionComposition) == false) goto L10;
            FunctionComposition r101 = (FunctionComposition) r100;
            if (this.f274696f.equals(r101.f274696f) == true) goto L7;
            return false;
        L7:
            if (this.f274697g.equals(r101.f274697g) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public FunctionComposition(g<B, C> r100, g<A, ? extends B> r101) {
            r100.getClass();
            this.f274697g = r100;
            r101.getClass();
            this.f274696f = r101;
        }
    }

    public static class FunctionForMapNoDefault<K, V> implements g<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ")";
        }

        public FunctionForMapNoDefault(Map<K, V> r100) {
            r100.getClass();
            this.map = r100;
        }

        @Override // com.google.common.base.g
        @ParametricNullness
        public V apply(@ParametricNullness K r100) {
            V r101 = this.map.get(r100);
            if (r101 == null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            m.h(r102, "Key '%s' not present in map", r100);
            return r101;
        L5:
            if (this.map.containsKey(r100) == true) goto L8;
            r102 = false;
            goto L9
        }

        @Override // com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof FunctionForMapNoDefault) == true) goto L5;
            return false;
        L5:
            return this.map.equals(((FunctionForMapNoDefault) r100).map);
        }
    }

    public static final enum IdentityFunction extends Enum<IdentityFunction> implements g<Object, Object> {
        public static final IdentityFunction INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ IdentityFunction[] f274698a = null;

        @Override // com.google.common.base.g
        @CheckForNull
        public Object apply(@CheckForNull Object r100) {
            return r100;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }

        static {
            IdentityFunction r100 = new IdentityFunction();
            INSTANCE = r100;
            f274698a = new IdentityFunction[]{r100};
        }

        public IdentityFunction() {
            super("INSTANCE", 0);
        }

        public static IdentityFunction[] values() {
            return (IdentityFunction[]) f274698a.clone();
        }

        public static IdentityFunction valueOf(String r100) {
            return (IdentityFunction) r27.a.a(IdentityFunction.class, r100);
        }
    }

    public static class PredicateFunction<T> implements g<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final n<T> predicate;

        public PredicateFunction() {
            throw null;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.predicate + ")";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.g
        public Boolean apply(@ParametricNullness T r100) {
            return Boolean.valueOf(this.predicate.apply(r100));
        }

        @Override // com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof PredicateFunction) == true) goto L5;
            return false;
        L5:
            return this.predicate.equals(((PredicateFunction) r100).predicate);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.g
        public /* bridge */ /* synthetic */ Boolean apply(@ParametricNullness Object r100) {
            return apply(r100);
        }

        public PredicateFunction(n r100, a r101) {
            r100.getClass();
            this.predicate = r100;
        }
    }

    public static class SupplierFunction<F, T> implements g<F, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final t<T> supplier;

        public SupplierFunction() {
            throw null;
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.supplier + ")";
        }

        @Override // com.google.common.base.g
        @ParametricNullness
        public T apply(@ParametricNullness F r100) {
            return this.supplier.get();
        }

        @Override // com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof SupplierFunction) == true) goto L5;
            return false;
        L5:
            return this.supplier.equals(((SupplierFunction) r100).supplier);
        }

        public SupplierFunction(t r100, a r101) {
            r100.getClass();
            this.supplier = r100;
        }
    }

    public static final enum ToStringFunction extends Enum<ToStringFunction> implements g<Object, String> {
        public static final ToStringFunction INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ToStringFunction[] f274699a = null;

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }

        static {
            ToStringFunction r100 = new ToStringFunction();
            INSTANCE = r100;
            f274699a = new ToStringFunction[]{r100};
        }

        public ToStringFunction() {
            super("INSTANCE", 0);
        }

        public static ToStringFunction[] values() {
            return (ToStringFunction[]) f274699a.clone();
        }

        public static ToStringFunction valueOf(String r100) {
            return (ToStringFunction) r27.a.a(ToStringFunction.class, r100);
        }

        @Override // com.google.common.base.g
        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public String apply2(Object r100) {
            r100.getClass();
            return r100.toString();
        }

        @Override // com.google.common.base.g
        public /* bridge */ /* synthetic */ String apply(Object r100) {
            return apply2(r100);
        }
    }

    public static /* synthetic */ class a {
    }

    public static g a() {
        return new ConstantFunction(null);
    }
}

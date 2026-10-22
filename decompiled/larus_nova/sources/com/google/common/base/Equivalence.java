package com.google.common.base;

import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class Equivalence<T> {

    public static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new Equals();
        }

        public Equals() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object r100) {
            return r100.hashCode();
        }

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object r100, Object r101) {
            return r100.equals(r101);
        }
    }

    public static final class EquivalentToPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;

        @CheckForNull
        private final T target;

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.equivalence, this.target});
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }

        @Override // com.google.common.base.n
        public boolean apply(@CheckForNull T r100) {
            return this.equivalence.equivalent(r100, this.target);
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof EquivalentToPredicate) == false) goto L14;
            EquivalentToPredicate r101 = (EquivalentToPredicate) r100;
            if (this.equivalence.equals(r101.equivalence) == true) goto L10;
        L12:
            return false;
        L10:
            if (k.a(this.target, r101.target) == false) goto L12;
            return true;
        L14:
            return false;
        }

        public EquivalentToPredicate(Equivalence<T> r100, @CheckForNull T r101) {
            r100.getClass();
            this.equivalence = r100;
            this.target = r101;
        }
    }

    public static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = null;
        private static final long serialVersionUID = 1;

        @Override // com.google.common.base.Equivalence
        public boolean doEquivalent(Object r100, Object r101) {
            return false;
        }

        static {
            INSTANCE = new Identity();
        }

        public Identity() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        public int doHash(Object r100) {
            return System.identityHashCode(r100);
        }
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;

        @ParametricNullness
        private final T reference;

        public Wrapper() {
            throw null;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }

        @ParametricNullness
        public T get() {
            return this.reference;
        }

        public boolean equals(@CheckForNull Object r100) {
            if (r100 != this) goto L6;
            return true;
        L6:
            if ((r100 instanceof Wrapper) == false) goto L11;
            Wrapper r101 = (Wrapper) r100;
            if (this.equivalence.equals(r101.equivalence) == true) goto L10;
            return false;
        L10:
            return this.equivalence.equivalent(this.reference, r101.reference);
        L11:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Wrapper(Equivalence r100, Object r101, a r102) {
            r100.getClass();
            this.equivalence = r100;
            this.reference = r101;
        }
    }

    public static /* synthetic */ class a {
    }

    public Equivalence() {
    }

    public abstract boolean doEquivalent(T r100, T r101);

    public abstract int doHash(T r100);

    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    public final n<T> equivalentTo(@CheckForNull T r100) {
        return new EquivalentToPredicate(this, r100);
    }

    public final int hash(@CheckForNull T r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return doHash(r100);
    }

    public final <F> Equivalence<F> onResultOf(g<? super F, ? extends T> r100) {
        return new FunctionalEquivalence(r100, this);
    }

    public final <S extends T> Wrapper<S> wrap(@ParametricNullness S r100) {
        return new Wrapper(this, r100, null);
    }

    public final boolean equivalent(@CheckForNull T r100, @CheckForNull T r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        if (r100 == null) goto L10;
        if (r101 != null) goto L9;
        return false;
    L9:
        return doEquivalent(r100, r101);
    L10:
        return false;
    }
}

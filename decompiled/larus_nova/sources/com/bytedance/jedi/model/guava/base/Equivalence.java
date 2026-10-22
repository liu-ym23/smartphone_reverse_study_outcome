package com.bytedance.jedi.model.guava.base;

import com.bytedance.jedi.model.guava.annotations.NullableDecl;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes19.dex */
public abstract class Equivalence<T> {

    /* JADX INFO: renamed from: com.bytedance.jedi.model.guava.base.Equivalence$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

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

        @Override // com.bytedance.jedi.model.guava.base.Equivalence
        public int doHash(Object r100) {
            return r100.hashCode();
        }

        @Override // com.bytedance.jedi.model.guava.base.Equivalence
        public boolean doEquivalent(Object r100, Object r101) {
            return r100.equals(r101);
        }
    }

    public static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;

        @NullableDecl
        private final T target;

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.equivalence, this.target});
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.target + ")";
        }

        public boolean apply(@NullableDecl T r100) {
            return this.equivalence.equivalent(r100, this.target);
        }

        public boolean equals(@NullableDecl Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof EquivalentToPredicate) == false) goto L21;
            EquivalentToPredicate r101 = (EquivalentToPredicate) r100;
            if (this.equivalence.equals(r101.equivalence) == false) goto L19;
            T r102 = this.target;
            T r103 = r101.target;
            if (r102 == r103) goto L16;
            if (r102 != null) goto L13;
        L15:
            boolean r104 = false;
        L17:
            if (r104 == false) goto L19;
            return true;
        L13:
            if (r102.equals(r103) == false) goto L15;
        L16:
            r104 = true;
        L19:
            return false;
        L21:
            return false;
        }

        public EquivalentToPredicate(Equivalence<T> r100, @NullableDecl T r101) {
            r100.getClass();
            this.equivalence = r100;
            this.target = r101;
        }
    }

    public static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = null;
        private static final long serialVersionUID = 1;

        @Override // com.bytedance.jedi.model.guava.base.Equivalence
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

        @Override // com.bytedance.jedi.model.guava.base.Equivalence
        public int doHash(Object r100) {
            return System.identityHashCode(r100);
        }
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;

        @NullableDecl
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

        @NullableDecl
        public T get() {
            return this.reference;
        }

        public boolean equals(@NullableDecl Object r100) {
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
        public Wrapper(Equivalence r100, Object r101, AnonymousClass1 r102) {
            r100.getClass();
            this.equivalence = r100;
            this.reference = r101;
        }
    }

    public Equivalence() {
    }

    public abstract boolean doEquivalent(T r100, T r101);

    public abstract int doHash(T r100);

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    public final Predicate<T> equivalentTo(@NullableDecl T r100) {
        return new EquivalentToPredicate(this, r100);
    }

    public final int hash(@NullableDecl T r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        return doHash(r100);
    }

    public final <S extends T> Wrapper<S> wrap(@NullableDecl S r100) {
        return new Wrapper(this, r100, null);
    }

    public final boolean equivalent(@NullableDecl T r100, @NullableDecl T r101) {
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

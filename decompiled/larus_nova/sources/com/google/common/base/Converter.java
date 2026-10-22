package com.google.common.base;

import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class Converter<A, B> implements g<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Converter<B, A> f274691a;
    private final boolean handleNullAutomatically;

    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        public A correctedDoBackward(@CheckForNull C r100) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(r100));
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        public C correctedDoForward(@CheckForNull A r100) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(r100));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C r100) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A r100) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof ConverterComposition) == false) goto L10;
            ConverterComposition r101 = (ConverterComposition) r100;
            if (this.first.equals(r101.first) == true) goto L7;
            return false;
        L7:
            if (this.second.equals(r101.second) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public ConverterComposition(Converter<A, B> r100, Converter<B, C> r101) {
            this.first = r100;
            this.second = r101;
        }
    }

    public static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final g<? super B, ? extends A> backwardFunction;
        private final g<? super A, ? extends B> forwardFunction;

        public FunctionBasedConverter() {
            throw null;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B r100) {
            return this.backwardFunction.apply(r100);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A r100) {
            return this.forwardFunction.apply(r100);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof FunctionBasedConverter) == false) goto L10;
            FunctionBasedConverter r101 = (FunctionBasedConverter) r100;
            if (this.forwardFunction.equals(r101.forwardFunction) == true) goto L7;
            return false;
        L7:
            if (this.backwardFunction.equals(r101.backwardFunction) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public FunctionBasedConverter(g r100, g r101, a r102) {
            r100.getClass();
            this.forwardFunction = r100;
            r101.getClass();
            this.backwardFunction = r101;
        }
    }

    public static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter<?> INSTANCE = null;
        private static final long serialVersionUID = 0;

        @Override // com.google.common.base.Converter
        public T doBackward(T r100) {
            return r100;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T r100) {
            return r100;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }

        static {
            INSTANCE = new IdentityConverter();
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Converter reverse() {
            return reverse();
        }

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> r100) {
            m.l(r100, "otherConverter");
            return r100;
        }
    }

    public static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        public int hashCode() {
            return ~this.original.hashCode();
        }

        public String toString() {
            return this.original + ".reverse()";
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public ReverseConverter(Converter<A, B> r100) {
            this.original = r100;
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        public B correctedDoBackward(@CheckForNull A r100) {
            return this.original.correctedDoForward(r100);
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        public A correctedDoForward(@CheckForNull B r100) {
            return this.original.correctedDoBackward(r100);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A r100) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B r100) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof ReverseConverter) == true) goto L5;
            return false;
        L5:
            return this.original.equals(((ReverseConverter) r100).original);
        }
    }

    public class a implements Iterable<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f274692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Converter f274693b;

        /* JADX INFO: renamed from: com.google.common.base.Converter$a$a, reason: collision with other inner class name */
        public class C3845a implements Iterator<B> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<? extends A> f274694a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f274695b;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f274694a.hasNext();
            }

            @Override // java.util.Iterator
            public final B next() {
                return (B) this.f274695b.f274693b.convert(this.f274694a.next());
            }

            @Override // java.util.Iterator
            public final void remove() {
                this.f274694a.remove();
            }

            public C3845a(a r100) {
                this.f274695b = r100;
                this.f274694a = r100.f274692a.iterator();
            }
        }

        @Override // java.lang.Iterable
        public final Iterator<B> iterator() {
            return new C3845a(this);
        }

        public a(Converter r100, Iterable r101) {
            this.f274693b = r100;
            this.f274692a = r101;
        }
    }

    public Converter() {
        this(true);
    }

    public abstract A doBackward(B r100);

    public abstract B doForward(A r100);

    @CheckReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> r100 = this.f274691a;
        if (r100 != null) goto L6;
        ReverseConverter r101 = new ReverseConverter(this);
        this.f274691a = r101;
        return r101;
    L6:
        return r100;
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    public Converter(boolean r100) {
        this.handleNullAutomatically = r100;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> r100) {
        return doAndThen(r100);
    }

    @Override // com.google.common.base.g
    public final B apply(A r100) {
        return convert(r100);
    }

    @CheckForNull
    public final B convert(@CheckForNull A r100) {
        return correctedDoForward(r100);
    }

    public Iterable<B> convertAll(Iterable<? extends A> r100) {
        m.l(r100, "fromIterable");
        return new a(this, r100);
    }

    @CheckForNull
    public A correctedDoBackward(@CheckForNull B r100) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r100 != null) goto L6;
        return null;
    L6:
        A r101 = doBackward(r100);
        r101.getClass();
        return r101;
    L9:
        return doBackward(r100);
    }

    @CheckForNull
    public B correctedDoForward(@CheckForNull A r100) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r100 != null) goto L6;
        return null;
    L6:
        B r101 = doForward(r100);
        r101.getClass();
        return r101;
    L9:
        return doForward(r100);
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> r100) {
        r100.getClass();
        return new ConverterComposition(this, r100);
    }

    @Override // com.google.common.base.g
    public boolean equals(@CheckForNull Object r100) {
        return super.equals(r100);
    }

    public static <A, B> Converter<A, B> from(g<? super A, ? extends B> r100, g<? super B, ? extends A> r101) {
        return new FunctionBasedConverter(r100, r101, null);
    }
}

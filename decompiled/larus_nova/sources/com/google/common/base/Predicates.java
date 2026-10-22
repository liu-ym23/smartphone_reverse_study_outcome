package com.google.common.base;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Predicates {

    public static class AndPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends n<? super T>> components;

        public AndPredicate() {
            throw null;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.a("and", this.components);
        }

        @Override // com.google.common.base.n
        public boolean apply(@ParametricNullness T r100) {
            int r101 = 0;
        L4:
            if (r101 >= this.components.size()) goto L9;
            if (((n) ListProtector.get(this.components, r101)).apply(r100) == false) goto L7;
            r101 = r101 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof AndPredicate) == true) goto L5;
            return false;
        L5:
            return this.components.equals(((AndPredicate) r100).components);
        }

        public AndPredicate(List r100, a r101) {
            this.components = r100;
        }
    }

    public static class CompositionPredicate<A, B> implements n<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final g<A, ? extends B> f274703f;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final n<B> f274704p;

        public CompositionPredicate() {
            throw null;
        }

        public int hashCode() {
            return this.f274703f.hashCode() ^ this.f274704p.hashCode();
        }

        public String toString() {
            return this.f274704p + "(" + this.f274703f + ")";
        }

        @Override // com.google.common.base.n
        public boolean apply(@ParametricNullness A r100) {
            return this.f274704p.apply(this.f274703f.apply(r100));
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof CompositionPredicate) == false) goto L10;
            CompositionPredicate r101 = (CompositionPredicate) r100;
            if (this.f274703f.equals(r101.f274703f) == true) goto L7;
            return false;
        L7:
            if (this.f274704p.equals(r101.f274704p) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public CompositionPredicate(n r100, g r101, a r102) {
            r100.getClass();
            this.f274704p = r100;
            r101.getClass();
            this.f274703f = r101;
        }
    }

    public static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + ")";
        }

        public ContainsPatternFromStringPredicate(String r100) {
            l.a r101 = l.f274724a;
            r100.getClass();
            l.f274724a.getClass();
            super(new JdkPattern(PatternProtector.compile(r100)));
        }
    }

    public static class ContainsPatternPredicate implements n<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final e pattern;

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.pattern.pattern(), Integer.valueOf(this.pattern.flags())});
        }

        public String toString() {
            j.a r100 = j.b(this.pattern);
            r100.b("pattern", this.pattern.pattern());
            r100.c("pattern.flags", String.valueOf(this.pattern.flags()));
            return "Predicates.contains(" + r100.toString() + ")";
        }

        public ContainsPatternPredicate(e r100) {
            r100.getClass();
            this.pattern = r100;
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(CharSequence r100) {
            return ((JdkPattern.a) this.pattern.matcher(r100)).f274700a.find();
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof ContainsPatternPredicate) == false) goto L10;
            ContainsPatternPredicate r101 = (ContainsPatternPredicate) r100;
            if (k.a(this.pattern.pattern(), r101.pattern.pattern()) == true) goto L7;
            return false;
        L7:
            if (this.pattern.flags() != r101.pattern.flags()) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(CharSequence r100) {
            return apply2(r100);
        }
    }

    public static class InPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        public InPredicate() {
            throw null;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }

        @Override // com.google.common.base.n
        public boolean apply(@ParametricNullness T r100) {
            return this.target.contains(r100);
        L4:
            return false;
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof InPredicate) == true) goto L5;
            return false;
        L5:
            return this.target.equals(((InPredicate) r100).target);
        }

        public InPredicate(Collection r100, a r101) {
            r100.getClass();
            this.target = r100;
        }
    }

    public static class InstanceOfPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        public InstanceOfPredicate() {
            throw null;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }

        @Override // com.google.common.base.n
        public boolean apply(@ParametricNullness T r100) {
            return this.clazz.isInstance(r100);
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof InstanceOfPredicate) == true) goto L5;
            return false;
        L5:
            if (this.clazz != ((InstanceOfPredicate) r100).clazz) goto L9;
            return true;
        L9:
            return false;
        }

        public InstanceOfPredicate(Class r100, a r101) {
            r100.getClass();
            this.clazz = r100;
        }
    }

    public static class IsEqualToPredicate implements n<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Object target;

        public <T> n<T> withNarrowedType() {
            return this;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }

        @Override // com.google.common.base.n
        public boolean apply(@CheckForNull Object r100) {
            return this.target.equals(r100);
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof IsEqualToPredicate) == true) goto L5;
            return false;
        L5:
            return this.target.equals(((IsEqualToPredicate) r100).target);
        }

        public IsEqualToPredicate(Object r100, a r101) {
            this.target = r100;
        }
    }

    public static class NotPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        final n<T> predicate;

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }

        public NotPredicate(n<T> r100) {
            r100.getClass();
            this.predicate = r100;
        }

        @Override // com.google.common.base.n
        public boolean apply(@ParametricNullness T r100) {
            return !this.predicate.apply(r100);
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof NotPredicate) == true) goto L5;
            return false;
        L5:
            return this.predicate.equals(((NotPredicate) r100).predicate);
        }
    }

    public static abstract enum ObjectPredicate extends Enum<ObjectPredicate> implements n<Object> {
        public static final ObjectPredicate ALWAYS_FALSE = null;
        public static final ObjectPredicate ALWAYS_TRUE = null;
        public static final ObjectPredicate IS_NULL = null;
        public static final ObjectPredicate NOT_NULL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ObjectPredicate[] f274705a = null;

        public ObjectPredicate() {
            throw null;
        }

        @Override // com.google.common.base.n
        public abstract /* synthetic */ boolean apply(@ParametricNullness Object r100);

        public <T> n<T> withNarrowedType() {
            return this;
        }

        static {
            final String r100 = "ALWAYS_TRUE";
            final int r101 = 0;
            ObjectPredicate r102 = new AnonymousClass1(r100, r101);
            ALWAYS_TRUE = r102;
            final String r103 = "ALWAYS_FALSE";
            final int r104 = 1;
            ObjectPredicate r105 = new AnonymousClass2(r103, r104);
            ALWAYS_FALSE = r105;
            final String r106 = "IS_NULL";
            final int r107 = 2;
            ObjectPredicate r108 = new AnonymousClass3(r106, r107);
            IS_NULL = r108;
            final String r109 = "NOT_NULL";
            final int r110 = 3;
            ObjectPredicate r111 = new AnonymousClass4(r109, r110);
            NOT_NULL = r111;
            f274705a = new ObjectPredicate[]{r102, r105, r108, r111};
        }

        public static ObjectPredicate[] values() {
            return (ObjectPredicate[]) f274705a.clone();
        }

        public static ObjectPredicate valueOf(String r100) {
            return (ObjectPredicate) r27.a.a(ObjectPredicate.class, r100);
        }

        public ObjectPredicate(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static class OrPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends n<? super T>> components;

        public OrPredicate() {
            throw null;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.a(SRStrategy.KEY_ORIGIN_RESOLUTION, this.components);
        }

        @Override // com.google.common.base.n
        public boolean apply(@ParametricNullness T r100) {
            int r101 = 0;
        L4:
            if (r101 >= this.components.size()) goto L10;
            if (((n) ListProtector.get(this.components, r101)).apply(r100) == true) goto L7;
            r101 = r101 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof OrPredicate) == true) goto L5;
            return false;
        L5:
            return this.components.equals(((OrPredicate) r100).components);
        }

        public OrPredicate(List r100, a r101) {
            this.components = r100;
        }
    }

    public static class SubtypeOfPredicate implements n<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        public SubtypeOfPredicate() {
            throw null;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.clazz.getName() + ")";
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(Class<?> r100) {
            return this.clazz.isAssignableFrom(r100);
        }

        @Override // com.google.common.base.n
        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof SubtypeOfPredicate) == true) goto L5;
            return false;
        L5:
            if (this.clazz != ((SubtypeOfPredicate) r100).clazz) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Class<?> r100) {
            return apply2(r100);
        }

        public SubtypeOfPredicate(Class r100, a r101) {
            r100.getClass();
            this.clazz = r100;
        }
    }

    public static /* synthetic */ class a {
    }

    public static <T> n<T> b() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> n<T> e(@ParametricNullness T r100) {
        if (r100 != null) goto L5;
        return ObjectPredicate.IS_NULL.withNarrowedType();
    L5:
        return new IsEqualToPredicate(r100, null).withNarrowedType();
    }

    public static <T> n<T> f(Collection<? extends T> r100) {
        return new InPredicate(r100, null);
    }

    public static <T> n<T> g(Class<?> r100) {
        return new InstanceOfPredicate(r100, null);
    }

    public static <T> n<T> h(n<T> r100) {
        return new NotPredicate(r100);
    }

    public static String a(String r100, Iterable r101) {
        StringBuilder r102 = new StringBuilder("Predicates.");
        r102.append(r100);
        r102.append('(');
        Iterator r103 = r101.iterator();
        boolean r104 = true;
    L4:
        if (r103.hasNext() == false) goto L9;
        Object r105 = r103.next();
        if (r104 == true) goto L8;
        r102.append(',');
    L8:
        r102.append(r105);
        r104 = false;
        goto L4
    L9:
        r102.append(')');
        return r102.toString();
    }

    public static <T> n<T> c(n<? super T> r100, n<? super T> r101) {
        r100.getClass();
        r101.getClass();
        return new AndPredicate(Arrays.asList(new n[]{r100, r101}), null);
    }

    public static <A, B> n<A> d(n<B> r100, g<A, ? extends B> r101) {
        return new CompositionPredicate(r100, r101, null);
    }
}

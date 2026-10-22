package com.google.common.reflect;

import com.google.common.base.n;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.d0;
import com.google.common.collect.q0;
import com.google.common.collect.z2;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class TypeToken<T> extends com.google.common.reflect.b<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public transient com.google.common.reflect.d f275662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @CheckForNull
    public transient com.google.common.reflect.d f275663b;
    private final Type runtimeType;

    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @CheckForNull
        public transient ImmutableSet<TypeToken<? super T>> f275664b;
        final /* synthetic */ TypeToken this$0;

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        private Object readResolve() {
            return this.this$0.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r100 = this.f275664b;
            if (r100 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r101 = ImmutableSet.copyOf(d0.c(new h(e.f275673a).b(ImmutableList.of(this.this$0))).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).d());
            this.f275664b = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(new h(e.f275674b).b(TypeToken.access$300(this.this$0)));
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        public ClassSet(TypeToken r100) {
            this.this$0 = r100;
            super(r100);
        }

        public /* synthetic */ ClassSet(TypeToken r100, a r101) {
            this(r100);
        }
    }

    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final transient TypeToken<T>.TypeSet f275665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @CheckForNull
        public transient ImmutableSet<TypeToken<? super T>> f275666c;
        final /* synthetic */ TypeToken this$0;

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        private Object readResolve() {
            return this.this$0.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r100 = this.f275666c;
            if (r100 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r101 = ImmutableSet.copyOf(d0.c(this.f275665b).a(TypeFilter.INTERFACE_ONLY).d());
            this.f275666c = r101;
            return r101;
        L6:
            return r100;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(d0.c(e.f275674b.b(TypeToken.access$300(this.this$0))).a(new g()).d());
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        public InterfaceSet(TypeToken r100, TypeToken<T>.TypeSet r101) {
            this.this$0 = r100;
            super(r100);
            this.f275665b = r101;
        }
    }

    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        public SimpleTypeToken(Type r100) {
            super(r100, null);
        }
    }

    public static abstract enum TypeFilter extends Enum<TypeFilter> implements n<TypeToken<?>> {
        public static final TypeFilter IGNORE_TYPE_VARIABLE_OR_WILDCARD = null;
        public static final TypeFilter INTERFACE_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TypeFilter[] f275667a = null;

        public TypeFilter() {
            throw null;
        }

        @Override // com.google.common.base.n
        public abstract /* synthetic */ boolean apply(@com.google.common.base.ParametricNullness T r100);

        static {
            final String r100 = "IGNORE_TYPE_VARIABLE_OR_WILDCARD";
            final int r101 = 0;
            TypeFilter r102 = new AnonymousClass1(r100, r101);
            IGNORE_TYPE_VARIABLE_OR_WILDCARD = r102;
            final String r103 = "INTERFACE_ONLY";
            final int r104 = 1;
            TypeFilter r105 = new AnonymousClass2(r103, r104);
            INTERFACE_ONLY = r105;
            f275667a = new TypeFilter[]{r102, r105};
        }

        public static TypeFilter[] values() {
            return (TypeFilter[]) f275667a.clone();
        }

        public static TypeFilter valueOf(String r100) {
            return (TypeFilter) r27.a.a(TypeFilter.class, r100);
        }

        public TypeFilter(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public class TypeSet extends q0<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public transient ImmutableSet<TypeToken<? super T>> f275668a;
        final /* synthetic */ TypeToken this$0;

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(this.this$0, null);
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> r100 = this.f275668a;
            if (r100 != null) goto L6;
            ImmutableSet<TypeToken<? super T>> r101 = ImmutableSet.copyOf(d0.c(e.f275673a.b(ImmutableList.of(this.this$0))).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).d());
            this.f275668a = r101;
            return r101;
        L6:
            return r100;
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this.this$0, this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf(e.f275674b.b(TypeToken.access$300(this.this$0)));
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.q0, com.google.common.collect.f0, com.google.common.collect.o0
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        public TypeSet(TypeToken r100) {
            this.this$0 = r100;
        }
    }

    public class a extends com.google.common.reflect.a.b<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TypeToken f275669c;

        @Override // com.google.common.reflect.a
        public final String toString() {
            return this.f275669c + "." + super.toString();
        }

        @Override // com.google.common.reflect.a
        public final TypeToken<T> b() {
            return this.f275669c;
        }

        public a(TypeToken r100, Method r101) {
            this.f275669c = r100;
            super(r101);
        }
    }

    public class b extends com.google.common.reflect.a.C3860a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TypeToken f275670d;

        @Override // com.google.common.reflect.a
        public final String toString() {
            StringBuilder r100 = new StringBuilder();
            r100.append(this.f275670d);
            r100.append("(");
            com.google.common.base.i r101 = new com.google.common.base.i(", ");
            com.google.common.reflect.d r102 = TypeToken.access$100(this.f275670d);
            Type[] r103 = this.f275688c.getGenericParameterTypes();
            int r104 = 0;
            if (r103.length <= 0) goto L22;
            Class<?> r105 = this.f275688c.getDeclaringClass();
            if (r105.getEnclosingConstructor() != null) goto L14;
            Method r106 = r105.getEnclosingMethod();
            if (r106 == null) goto L11;
            boolean r107 = !Modifier.isStatic(r106.getModifiers());
        L16:
            if (r107 == false) goto L22;
            Class<?>[] r108 = this.f275688c.getParameterTypes();
            if (r103.length != r108.length) goto L22;
            if (r108[0] != getDeclaringClass().getEnclosingClass()) goto L22;
            r103 = (Type[]) Arrays.copyOfRange(r103, 1, r103.length);
            goto L22
        L11:
            if (r105.getEnclosingClass() != null) goto L13;
        L15:
            r107 = false;
            goto L16
        L13:
            if (Modifier.isStatic(r105.getModifiers()) == true) goto L15;
        L14:
            r107 = true;
        L22:
            r102.getClass();
        L24:
            if (r104 >= r103.length) goto L26;
            r103[r104] = r102.b(r103[r104]);
            r104 = r104 + 1;
            goto L24
        L26:
            r100.append(r101.b(Arrays.asList(r103)));
            r100.append(")");
            return r100.toString();
        }

        @Override // com.google.common.reflect.a
        public final TypeToken<T> b() {
            return this.f275670d;
        }

        public b(TypeToken r100, Constructor r101) {
            this.f275670d = r100;
            super(r101);
        }
    }

    public class c extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TypeToken f275671b;

        public c(TypeToken r100) {
            this.f275671b = r100;
        }

        @Override // com.google.common.reflect.j
        public final void c(GenericArrayType r100) {
            a(new Type[]{r100.getGenericComponentType()});
        }

        @Override // com.google.common.reflect.j
        public final void d(ParameterizedType r100) {
            a(r100.getActualTypeArguments());
            a(new Type[]{r100.getOwnerType()});
        }

        @Override // com.google.common.reflect.j
        public final void e(TypeVariable<?> r100) {
            throw new IllegalArgumentException(TypeToken.access$500(this.f275671b) + "contains a type variable and is not safe for the operation");
        }

        @Override // com.google.common.reflect.j
        public final void f(WildcardType r100) {
            a(r100.getLowerBounds());
            a(r100.getUpperBounds());
        }
    }

    public class d extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImmutableSet.a f275672b;

        public d(ImmutableSet.a r100) {
            this.f275672b = r100;
        }

        @Override // com.google.common.reflect.j
        public final void b(Class<?> r100) {
            this.f275672b.d(r100);
        }

        @Override // com.google.common.reflect.j
        public final void c(GenericArrayType r100) {
            ImmutableSet.a r101 = this.f275672b;
            Class<? super Object> r102 = TypeToken.of(r100.getGenericComponentType()).getRawType();
            com.google.common.base.h r103 = Types.f275676a;
            r101.d(Array.newInstance(r102, 0).getClass());
        }

        @Override // com.google.common.reflect.j
        public final void d(ParameterizedType r100) {
            this.f275672b.d((Class) r100.getRawType());
        }

        @Override // com.google.common.reflect.j
        public final void e(TypeVariable<?> r100) {
            a(r100.getBounds());
        }

        @Override // com.google.common.reflect.j
        public final void f(WildcardType r100) {
            a(r100.getUpperBounds());
        }
    }

    public static abstract class e<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f275673a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f275674b = null;

        public class a extends e<TypeToken<?>> {
            public a() {
            }

            @Override // com.google.common.reflect.TypeToken.e
            public final Iterable<? extends TypeToken<?>> c(TypeToken<?> r100) {
                return r100.getGenericInterfaces();
            }

            @Override // com.google.common.reflect.TypeToken.e
            public final Class d(TypeToken<?> r100) {
                return r100.getRawType();
            }

            @Override // com.google.common.reflect.TypeToken.e
            @CheckForNull
            public final TypeToken<?> e(TypeToken<?> r100) {
                return r100.getGenericSuperclass();
            }
        }

        public class b extends e<Class<?>> {
            public b() {
            }

            @Override // com.google.common.reflect.TypeToken.e
            public final Iterable<? extends Class<?>> c(Class<?> r100) {
                return Arrays.asList(r100.getInterfaces());
            }

            @Override // com.google.common.reflect.TypeToken.e
            public final Class d(Class<?> r100) {
                return r100;
            }

            @Override // com.google.common.reflect.TypeToken.e
            @CheckForNull
            public final Class<?> e(Class<?> r100) {
                return r100.getSuperclass();
            }
        }

        public static class c<K> extends e<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final e<K> f275675c;

            public c(e<K> r100) {
                this.f275675c = r100;
            }

            @Override // com.google.common.reflect.TypeToken.e
            public final Class<?> d(K r100) {
                return this.f275675c.d(r100);
            }

            @Override // com.google.common.reflect.TypeToken.e
            @CheckForNull
            public final K e(K r100) {
                return this.f275675c.e(r100);
            }
        }

        public abstract Iterable<? extends K> c(K r100);

        public abstract Class<?> d(K r100);

        @CheckForNull
        public abstract K e(K r100);

        static {
            f275673a = new a();
            f275674b = new b();
        }

        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ImmutableList b(ImmutableCollection r100) {
            HashMap r101 = new HashMap();
            Iterator<E> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L7;
            a(r102.next(), r101);
            goto L4
        L7:
            return new i(Ordering.natural().reverse(), r101).immutableSortedCopy(r101.keySet());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int a(K r100, Map<? super K, Integer> r101) {
            HashMap r102 = (HashMap) r101;
            Integer r103 = (Integer) r102.get(r100);
            if (r103 != null) goto L5;
            boolean r104 = d(r100).isInterface();
            Iterator<? extends K> r105 = c(r100).iterator();
            int r106 = r104;
        L8:
            if (r105.hasNext() == false) goto L10;
            r106 = Math.max(r106, a(r105.next(), r101));
            goto L8
        L10:
            K r107 = e(r100);
            int r108 = r106;
            if (r107 == null) goto L13;
            r108 = Math.max(r106, a(r107, r101));
        L13:
            int r109 = r108 + 1;
            r102.put(r100, Integer.valueOf(r109));
            return r109;
        L5:
            return r103.intValue();
        }
    }

    @CheckForNull
    public final TypeToken<?> getComponentType() {
        Type r100 = Types.c(this.runtimeType);
        if (r100 != null) goto L7;
        return null;
    L7:
        return of(r100);
    }

    public final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type r100 = this.runtimeType;
        if ((r100 instanceof TypeVariable) == false) goto L7;
        return a(((TypeVariable) r100).getBounds());
    L7:
        if ((r100 instanceof WildcardType) == true) goto L9;
        ImmutableList.a r101 = ImmutableList.builder();
        Type[] r102 = getRawType().getGenericInterfaces();
        int r103 = r102.length;
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L14;
        r101.b(g(r102[r104]));
        r104 = r104 + 1;
        goto L11
    L14:
        return r101.e();
    L9:
        return a(((WildcardType) r100).getUpperBounds());
    }

    @CheckForNull
    public final TypeToken<? super T> getGenericSuperclass() {
        Type r100 = this.runtimeType;
        if ((r100 instanceof TypeVariable) == false) goto L10;
        TypeToken<? super T> r101 = (TypeToken<? super T>) of(((TypeVariable) r100).getBounds()[0]);
        if (r101.getRawType().isInterface() == false) goto L8;
        return null;
    L8:
        return r101;
    L10:
        if ((r100 instanceof WildcardType) == false) goto L16;
        TypeToken<? super T> r102 = (TypeToken<? super T>) of(((WildcardType) r100).getUpperBounds()[0]);
        if (r102.getRawType().isInterface() == false) goto L15;
        return null;
    L15:
        return r102;
    L16:
        Type r103 = getRawType().getGenericSuperclass();
        if (r103 != null) goto L20;
        return null;
    L20:
        return (TypeToken<? super T>) g(r103);
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet(this);
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isPrimitive() {
        Type r100 = this.runtimeType;
        if ((r100 instanceof Class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Class) r100).isPrimitive() == false) goto L7;
        return true;
    }

    public final TypeToken<T> rejectTypeVariables() {
        new c(this).a(new Type[]{this.runtimeType});
        return this;
    }

    public String toString() {
        Type r100 = this.runtimeType;
        com.google.common.base.h r101 = Types.f275676a;
        if ((r100 instanceof Class) == false) goto L6;
        return ((Class) r100).getName();
    L6:
        return r100.toString();
    }

    public final TypeToken<T> unwrap() {
        Map<Class<?>, Class<?>> r100 = com.google.common.primitives.c.f275661b;
        if (r100.keySet().contains(this.runtimeType) == false) goto L10;
        Class<?> r101 = (Class) this.runtimeType;
        r101.getClass();
        Class<?> r102 = r100.get(r101);
        if (r102 == null) goto L9;
        r101 = r102;
    L9:
        return of(r101);
    L10:
        return this;
    }

    public Object writeReplace() {
        return of(new com.google.common.reflect.d().b(this.runtimeType));
    }

    public TypeToken() {
        Type r100 = capture();
        this.runtimeType = r100;
        com.google.common.base.m.s(!(r100 instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", r100);
    }

    public final ImmutableSet<Class<? super T>> e() {
        ImmutableSet.a r100 = ImmutableSet.builder();
        new d(r100).a(new Type[]{this.runtimeType});
        return r100.f();
    }

    public final Class<? super T> getRawType() {
        return e().iterator().next();
    }

    public final boolean isArray() {
        if (getComponentType() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive() == true) goto L5;
        return this;
    L5:
        return of(com.google.common.primitives.c.a((Class) this.runtimeType));
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public TypeToken(Class<?> r100) {
        Type r101 = super.capture();
        if ((r101 instanceof Class) == false) goto L5;
        this.runtimeType = r101;
        return;
    L5:
        com.google.common.reflect.d r102 = new com.google.common.reflect.d();
        r100.getClass();
        com.google.common.reflect.d.b r103 = new com.google.common.reflect.d.b();
        r103.a(new Type[]{r100});
        this.runtimeType = r102.d(ImmutableMap.copyOf(r103.f275692b)).b(r101);
    }

    public static ImmutableList a(Type[] r100) {
        ImmutableList.a r101 = ImmutableList.builder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        TypeToken<?> r104 = of(r100[r103]);
        if (r104.getRawType().isInterface() == false) goto L7;
        r101.b(r104);
    L7:
        r103 = r103 + 1;
        goto L3
    L9:
        return r101.e();
    }

    public static com.google.common.reflect.d access$000(TypeToken r100) {
        com.google.common.reflect.d r101 = r100.f275663b;
        if (r101 != null) goto L6;
        Type r102 = r100.runtimeType;
        com.google.common.reflect.d r103 = new com.google.common.reflect.d();
        r102.getClass();
        com.google.common.reflect.d.b r104 = new com.google.common.reflect.d.b();
        r104.a(new Type[]{r102});
        com.google.common.reflect.d r105 = r103.d(ImmutableMap.copyOf(r104.f275692b));
        r100.f275663b = r105;
        return r105;
    L6:
        return r101;
    }

    public static com.google.common.reflect.d access$100(TypeToken r100) {
        com.google.common.reflect.d r101 = r100.f275662a;
        if (r101 != null) goto L6;
        Type r102 = com.google.common.reflect.d.e.f275695b.a(r100.runtimeType);
        com.google.common.reflect.d r103 = new com.google.common.reflect.d();
        r102.getClass();
        com.google.common.reflect.d.b r104 = new com.google.common.reflect.d.b();
        r104.a(new Type[]{r102});
        com.google.common.reflect.d r105 = r103.d(ImmutableMap.copyOf(r104.f275692b));
        r100.f275662a = r105;
        return r105;
    L6:
        return r101;
    }

    public static /* synthetic */ ImmutableSet access$300(TypeToken r100) {
        return r100.e();
    }

    public static /* synthetic */ Type access$500(TypeToken r100) {
        return r100.runtimeType;
    }

    public static Type d(Type r100) {
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r101 = (ParameterizedType) r100;
        Class r102 = (Class) r101.getRawType();
        TypeVariable<Class<T>>[] r103 = r102.getTypeParameters();
        Type[] r104 = r101.getActualTypeArguments();
        int r105 = 0;
    L6:
        if (r105 >= r104.length) goto L9;
        r104[r105] = b(r103[r105], r104[r105]);
        r105 = r105 + 1;
        goto L6
    L9:
        return Types.f(r101.getOwnerType(), r102, r104);
    L11:
        if ((r100 instanceof GenericArrayType) == true) goto L13;
        return r100;
    L13:
        return Types.d(d(((GenericArrayType) r100).getGenericComponentType()));
    }

    public static <T> TypeToken<T> of(Class<T> r100) {
        return new SimpleTypeToken(r100);
    }

    public static <T> TypeToken<? extends T> toGenericType(Class<T> r100) {
        if (r100.isArray() == true) goto L5;
        TypeVariable<Class<T>>[] r101 = r100.getTypeParameters();
        if (r100.isMemberClass() == true) goto L9;
    L11:
        Type r102 = null;
    L13:
        if (r101.length > 0) goto L21;
        if (r102 == null) goto L19;
        if (r102 != r100.getEnclosingClass()) goto L21;
    L19:
        return of(r100);
    L21:
        return (TypeToken<? extends T>) of(Types.f(r102, r100, r101));
    L9:
        if (Modifier.isStatic(r100.getModifiers()) == true) goto L11;
        r102 = toGenericType(r100.getEnclosingClass()).runtimeType;
        goto L13
    L5:
        return (TypeToken<? extends T>) of(Types.d(toGenericType(r100.getComponentType()).runtimeType));
    }

    public final com.google.common.reflect.a<T, T> constructor(Constructor<?> r100) {
        if (r100.getDeclaringClass() != getRawType()) goto L5;
        boolean r101 = true;
    L6:
        com.google.common.base.m.i(r101, "%s not declared by %s", r100, getRawType());
        return new b(this, r100);
    L5:
        r101 = false;
        goto L6
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof TypeToken) == true) goto L5;
        return false;
    L5:
        return this.runtimeType.equals(((TypeToken) r100).runtimeType);
    }

    public final TypeToken<?> g(Type r100) {
        com.google.common.reflect.d r101 = this.f275663b;
        if (r101 != null) goto L5;
        Type r102 = this.runtimeType;
        com.google.common.reflect.d r103 = new com.google.common.reflect.d();
        r102.getClass();
        com.google.common.reflect.d.b r104 = new com.google.common.reflect.d.b();
        r104.a(new Type[]{r102});
        r101 = r103.d(ImmutableMap.copyOf(r104.f275692b));
        this.f275663b = r101;
    L5:
        TypeToken<?> r105 = of(r101.b(r100));
        r105.f275663b = this.f275663b;
        r105.f275662a = this.f275662a;
        return r105;
    }

    public final TypeToken<? extends T> getSubtype(Class<?> r100) {
        com.google.common.base.m.h(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type r101 = this.runtimeType;
        if ((r101 instanceof WildcardType) == false) goto L11;
        Type[] r102 = ((WildcardType) r101).getLowerBounds();
        if (r102.length <= 0) goto L9;
        return (TypeToken<? extends T>) of(r102[0]).getSubtype(r100);
    L9:
        throw new IllegalArgumentException(r100 + " isn't a subclass of " + this);
    L11:
        if (isArray() == false) goto L18;
        Class<?> r103 = r100.getComponentType();
        if (r103 == null) goto L17;
        TypeToken<?> r104 = getComponentType();
        Objects.requireNonNull(r104);
        return (TypeToken<? extends T>) of(Types.JavaVersion.JAVA7.newArrayType(r104.getSubtype(r103).runtimeType));
    L17:
        throw new IllegalArgumentException(r100 + " does not appear to be a subtype of " + this);
    L18:
        com.google.common.base.m.i(getRawType().isAssignableFrom(r100), "%s isn't a subclass of %s", r100, this);
        if ((this.runtimeType instanceof Class) == false) goto L25;
        int r105 = r100.getTypeParameters().length;
        Type r106 = r100;
        if (r105 == 0) goto L26;
        r106 = r100;
        if (getRawType().getTypeParameters().length == 0) goto L25;
    L26:
        TypeToken<? extends T> r107 = (TypeToken<? extends T>) of(r106);
        com.google.common.base.m.i(r107.isSubtypeOf(this), "%s does not appear to be a subtype of %s", r107, this);
        return r107;
    L25:
        TypeToken r108 = toGenericType(r100);
        Type r109 = r108.getSupertype(getRawType()).runtimeType;
        com.google.common.reflect.d r110 = new com.google.common.reflect.d();
        Type r111 = this.runtimeType;
        HashMap r112 = new HashMap();
        r109.getClass();
        r111.getClass();
        com.google.common.reflect.d.a(r112, r109, r111);
        r106 = r110.d(r112).b(r108.runtimeType);
        goto L26
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TypeToken<? super T> getSupertype(Class<? super T> r100) {
        com.google.common.base.m.i(h(r100), "%s is not a super class of %s", r100, this);
        Type r101 = this.runtimeType;
        if ((r101 instanceof TypeVariable) == false) goto L7;
        return f(r100, ((TypeVariable) r101).getBounds());
    L7:
        if ((r101 instanceof WildcardType) == false) goto L11;
        return f(r100, ((WildcardType) r101).getUpperBounds());
    L11:
        if (r100.isArray() == false) goto L19;
        TypeToken<?> r102 = getComponentType();
        if (r102 == 0) goto L17;
        Class<?> r103 = r100.getComponentType();
        Objects.requireNonNull(r103);
        return (TypeToken<? super T>) of(Types.JavaVersion.JAVA7.newArrayType(r102.getSupertype(r103).runtimeType));
    L17:
        throw new IllegalArgumentException(r100 + " isn't a super type of " + this);
    L19:
        return (TypeToken<? super T>) g(toGenericType(r100).runtimeType);
    }

    public final boolean h(Class<?> r100) {
        z2<Class<? super T>> r101 = e().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        if (r100.isAssignableFrom(r101.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final boolean isSubtypeOf(Type r110) {
        r110.getClass();
        int r100 = 0;
        if ((r110 instanceof WildcardType) == false) goto L12;
        Type[] r111 = ((WildcardType) r110).getLowerBounds();
        TypeToken<?> r101 = of(this.runtimeType);
        int r102 = r111.length;
    L5:
        if (r100 >= r102) goto L11;
        if (r101.isSubtypeOf(r111[r100]) == true) goto L147;
        r100 = r100 + 1;
        goto L5
    L147:
        return true;
    L11:
        return !true;
    L12:
        Type r103 = this.runtimeType;
        if ((r103 instanceof WildcardType) == false) goto L23;
        Type[] r104 = ((WildcardType) r103).getUpperBounds();
        int r105 = r104.length;
    L15:
        if (r100 >= r105) goto L21;
        if (of(r104[r100]).isSubtypeOf(r110) == true) goto L148;
        r100 = r100 + 1;
        goto L15
    L148:
        return true;
    L21:
        return !true;
    L23:
        if ((r103 instanceof TypeVariable) == true) goto L25;
        boolean r106 = r103 instanceof GenericArrayType;
        if (r106 == false) goto L49;
        TypeToken<?> r112 = of(r110);
        GenericArrayType r107 = (GenericArrayType) this.runtimeType;
        Type r108 = r112.runtimeType;
        if ((r108 instanceof Class) == false) goto L45;
        Class r109 = (Class) r108;
        if (r109.isArray() == true) goto L151;
        return r109.isAssignableFrom(Object[].class);
    L151:
        return of(r107.getGenericComponentType()).isSubtypeOf(r109.getComponentType());
    L45:
        if ((r108 instanceof GenericArrayType) == true) goto L47;
        return false;
    L47:
        return of(r107.getGenericComponentType()).isSubtypeOf(((GenericArrayType) r112.runtimeType).getGenericComponentType());
    L49:
        if ((r110 instanceof Class) == false) goto L53;
        return h((Class) r110);
    L53:
        if ((r110 instanceof ParameterizedType) == false) goto L113;
        ParameterizedType r113 = (ParameterizedType) r110;
        Class<? super Object> r114 = of(r113).getRawType();
        if (h(r114) == false) goto L154;
        TypeVariable<Class<? super Object>>[] r115 = r114.getTypeParameters();
        Type[] r116 = r113.getActualTypeArguments();
        int r117 = 0;
    L59:
        if (r117 >= r115.length) goto L91;
        com.google.common.reflect.d r118 = this.f275663b;
        if (r118 != null) goto L63;
        Type r119 = this.runtimeType;
        com.google.common.reflect.d r120 = new com.google.common.reflect.d();
        r119.getClass();
        com.google.common.reflect.d.b r121 = new com.google.common.reflect.d.b();
        r121.a(new Type[]{r119});
        r118 = r120.d(ImmutableMap.copyOf(r121.f275692b));
        this.f275663b = r118;
    L63:
        TypeToken<?> r122 = of(r118.b(r115[r117]));
        Type r123 = r116[r117];
        TypeVariable<Class<? super Object>> r124 = r115[r117];
        if (r122.runtimeType.equals(r123) == false) goto L67;
    L84:
        boolean r125 = true;
    L87:
        if (r125 == false) goto L155;
        r117 = r117 + 1;
        goto L59
    L155:
        return false;
    L67:
        if ((r123 instanceof WildcardType) == false) goto L86;
        WildcardType r126 = c(r124, (WildcardType) r123);
        Type[] r127 = r126.getUpperBounds();
        TypeToken<?> r128 = of(r122.runtimeType);
        int r129 = r127.length;
        int r130 = 0;
    L69:
        if (r130 >= r129) goto L74;
        if (r128.isSubtypeOf(r127[r130]) == false) goto L72;
        r130 = r130 + 1;
        goto L69
    L72:
        boolean r131 = false;
    L75:
        if (r131 == false) goto L85;
        Type[] r132 = r126.getLowerBounds();
        Type r133 = r122.runtimeType;
        int r134 = r132.length;
        int r135 = 0;
    L77:
        if (r135 >= r134) goto L82;
        if (of(r132[r135]).isSubtypeOf(r133) == false) goto L80;
        r135 = r135 + 1;
        goto L77
    L80:
        boolean r136 = false;
    L83:
        if (r136 == false) goto L85;
    L82:
        r136 = !false;
    L85:
        r125 = false;
        goto L87
    L74:
        r131 = !false;
        goto L75
    L86:
        r125 = d(r122.runtimeType).equals(d(r123));
        goto L87
    L91:
        if (Modifier.isStatic(((Class) r113.getRawType()).getModifiers()) == false) goto L93;
    L110:
        return true;
    L93:
        if (r113.getOwnerType() == null) goto L110;
        Type r137 = r113.getOwnerType();
        Iterator<TypeToken<? super T>> r138 = getTypes().iterator();
    L96:
        if (r138.hasNext() == false) goto L108;
        Type r139 = r138.next().runtimeType;
        if ((r139 instanceof ParameterizedType) == false) goto L101;
        Type r140 = ((ParameterizedType) r139).getOwnerType();
    L104:
        if (r140 == null) goto L96;
        if (of(r140).isSubtypeOf(r137) == false) goto L96;
        boolean r141 = true;
    L109:
        if (r141 == true) goto L110;
        return false;
    L101:
        if ((r139 instanceof Class) == false) goto L103;
        r140 = ((Class) r139).getEnclosingClass();
        goto L104
    L103:
        r140 = null;
        goto L104
    L108:
        r141 = false;
        goto L109
    L154:
        return false;
    L113:
        if ((r110 instanceof GenericArrayType) == false) goto L126;
        GenericArrayType r142 = (GenericArrayType) r110;
        if ((r103 instanceof Class) == false) goto L120;
        Class r143 = (Class) r103;
        if (r143.isArray() == true) goto L156;
        return false;
    L156:
        return of(r143.getComponentType()).isSubtypeOf(r142.getGenericComponentType());
    L120:
        if (r106 == true) goto L127;
        return false;
    L127:
        return of(((GenericArrayType) r103).getGenericComponentType()).isSubtypeOf(r142.getGenericComponentType());
    L124:
        th = move-exception;
        throw th;
    L126:
        return false;
    L25:
        if (r103.equals(r110) == true) goto L34;
        Type[] r144 = ((TypeVariable) this.runtimeType).getBounds();
        int r145 = r144.length;
        int r146 = 0;
    L27:
        if (r146 >= r145) goto L32;
        if (of(r144[r146]).isSubtypeOf(r110) == true) goto L30;
        r146 = r146 + 1;
        goto L27
    L30:
        boolean r147 = true;
    L33:
        if (r147 == true) goto L34;
        return false;
    L32:
        r147 = !true;
    L34:
        return true;
    }

    public final boolean isSupertypeOf(Type r100) {
        return of(r100).isSubtypeOf(getType());
    }

    public final com.google.common.reflect.a<T, Object> method(Method r100) {
        com.google.common.base.m.i(h(r100.getDeclaringClass()), "%s not declared by %s", r100, this);
        return new a(this, r100);
    }

    public final TypeToken<?> resolveType(Type r100) {
        r100.getClass();
        com.google.common.reflect.d r101 = this.f275662a;
        if (r101 != null) goto L6;
        Type r102 = com.google.common.reflect.d.e.f275695b.a(this.runtimeType);
        com.google.common.reflect.d r103 = new com.google.common.reflect.d();
        r102.getClass();
        com.google.common.reflect.d.b r104 = new com.google.common.reflect.d.b();
        r104.a(new Type[]{r102});
        r101 = r103.d(ImmutableMap.copyOf(r104.f275692b));
        this.f275662a = r101;
    L6:
        return of(r101.b(r100));
    }

    public static TypeToken<?> of(Type r100) {
        return new SimpleTypeToken(r100);
    }

    public final boolean isSubtypeOf(TypeToken<?> r100) {
        return isSubtypeOf(r100.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> r100) {
        return r100.isSubtypeOf(getType());
    }

    public TypeToken(Type r100, a r101) {
        r100.getClass();
        this.runtimeType = r100;
    }

    public static Type b(TypeVariable<?> r100, Type r101) {
        if ((r101 instanceof WildcardType) == false) goto L6;
        return c(r100, (WildcardType) r101);
    L6:
        return d(r101);
    }

    public static WildcardType c(TypeVariable<?> r110, WildcardType r111) {
        Type[] r112 = r110.getBounds();
        ArrayList r100 = new ArrayList();
        Type[] r101 = r111.getUpperBounds();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L16;
        Type r104 = r101[r103];
        int r105 = r112.length;
        int r106 = 0;
    L5:
        boolean r107 = true;
        if (r106 >= r105) goto L11;
        if (of(r112[r106]).isSubtypeOf(r104) == true) goto L12;
        r106 = r106 + 1;
    L12:
        if (r107 == true) goto L14;
        r100.add(d(r104));
    L14:
        r103 = r103 + 1;
        goto L3
    L11:
        r107 = !true;
        goto L12
    L16:
        return new Types.WildcardTypeImpl(r111.getLowerBounds(), (Type[]) r100.toArray(new Type[0]));
    }

    public final TypeToken<? super T> f(Class<? super T> r100, Type[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        TypeToken<?> r104 = of(r101[r103]);
        if (r104.isSubtypeOf(r100) == true) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return (TypeToken<? super T>) r104.getSupertype(r100);
    L10:
        throw new IllegalArgumentException(r100 + " isn't a super type of " + this);
    }

    public final <X> TypeToken<T> where(com.google.common.reflect.c<X> r100, Class<X> r101) {
        return where(r100, of(r101));
    }

    public final <X> TypeToken<T> where(com.google.common.reflect.c<X> r100, TypeToken<X> r101) {
        new com.google.common.reflect.d.c();
        throw null;
    }
}

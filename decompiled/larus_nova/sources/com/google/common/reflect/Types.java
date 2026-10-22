package com.google.common.reflect;

import com.google.common.base.Predicates;
import com.google.common.base.n;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.x0;
import com.google.common.collect.y0;
import com.google.common.collect.z2;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Types {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.common.base.h f275676a = null;

    public static abstract enum ClassOwnership extends Enum<ClassOwnership> {
        static final ClassOwnership JVM_BEHAVIOR = null;
        public static final ClassOwnership LOCAL_CLASS_HAS_NO_OWNER = null;
        public static final ClassOwnership OWNED_BY_ENCLOSING_CLASS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ClassOwnership[] f275677a = null;

        public ClassOwnership() {
            throw null;
        }

        @CheckForNull
        public abstract Class<?> getOwnerType(Class<?> r100);

        static {
            final String r100 = "OWNED_BY_ENCLOSING_CLASS";
            final int r101 = 0;
            ClassOwnership r102 = new AnonymousClass1(r100, r101);
            OWNED_BY_ENCLOSING_CLASS = r102;
            final String r103 = "LOCAL_CLASS_HAS_NO_OWNER";
            final int r104 = 1;
            ClassOwnership r105 = new AnonymousClass2(r103, r104);
            LOCAL_CLASS_HAS_NO_OWNER = r105;
            f275677a = new ClassOwnership[]{r102, r105};
            new l();
            ParameterizedType r106 = (ParameterizedType) l.class.getGenericSuperclass();
            Objects.requireNonNull(r106);
            ClassOwnership[] r107 = values();
            int r108 = r107.length;
        L3:
            if (r101 >= r108) goto L10;
            ClassOwnership r109 = r107[r101];
            if (r109.getOwnerType(k.class) == r106.getOwnerType()) goto L6;
            r101 = r101 + 1;
            goto L3
        L6:
            JVM_BEHAVIOR = r109;
            return;
        L10:
            throw new AssertionError();
        }

        public static ClassOwnership[] values() {
            return (ClassOwnership[]) f275677a.clone();
        }

        public static ClassOwnership valueOf(String r100) {
            return (ClassOwnership) r27.a.a(ClassOwnership.class, r100);
        }

        public ClassOwnership(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder();
            Type r101 = this.componentType;
            com.google.common.base.h r102 = Types.f275676a;
            if ((r101 instanceof Class) == false) goto L5;
            String r103 = ((Class) r101).getName();
        L6:
            r100.append(r103);
            r100.append("[]");
            return r100.toString();
        L5:
            r103 = r101.toString();
            goto L6
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public GenericArrayTypeImpl(Type r100) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(r100);
        }

        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof GenericArrayType) == true) goto L5;
            return false;
        L5:
            return com.google.common.base.k.a(getGenericComponentType(), ((GenericArrayType) r100).getGenericComponentType());
        }
    }

    public static abstract enum JavaVersion extends Enum<JavaVersion> {
        static final JavaVersion CURRENT = null;
        public static final JavaVersion JAVA6 = null;
        public static final JavaVersion JAVA7 = null;
        public static final JavaVersion JAVA8 = null;
        public static final JavaVersion JAVA9 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ JavaVersion[] f275678a = null;

        public class a extends com.google.common.reflect.b<Map.Entry<String, int[][]>> {
            public a() {
            }
        }

        public class b extends com.google.common.reflect.b<int[]> {
            public b() {
            }
        }

        public JavaVersion() {
            throw null;
        }

        public boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        public abstract Type newArrayType(Type r100);

        public abstract Type usedInGenericType(Type r100);

        static {
            final String r100 = "JAVA6";
            final int r101 = 0;
            JavaVersion r102 = new AnonymousClass1(r100, r101);
            JAVA6 = r102;
            final String r103 = "JAVA7";
            final int r104 = 1;
            JavaVersion r105 = new AnonymousClass2(r103, r104);
            JAVA7 = r105;
            final String r106 = "JAVA8";
            final int r107 = 2;
            JavaVersion r108 = new AnonymousClass3(r106, r107);
            JAVA8 = r108;
            final String r109 = "JAVA9";
            final int r110 = 3;
            JavaVersion r111 = new AnonymousClass4(r109, r110);
            JAVA9 = r111;
            f275678a = new JavaVersion[]{r102, r105, r108, r111};
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class) == false) goto L9;
            if (new a().capture().toString().contains("java.util.Map.java.util.Map") == false) goto L7;
            CURRENT = r108;
            return;
        L7:
            CURRENT = r111;
            return;
        L9:
            if ((new b().capture() instanceof Class) == false) goto L11;
            CURRENT = r105;
            return;
        L11:
            CURRENT = r102;
        }

        public static JavaVersion[] values() {
            return (JavaVersion[]) f275678a.clone();
        }

        public static JavaVersion valueOf(String r100) {
            return (JavaVersion) r27.a.a(JavaVersion.class, r100);
        }

        public String typeName(Type r100) {
            com.google.common.base.h r101 = Types.f275676a;
            if ((r100 instanceof Class) == false) goto L6;
            return ((Class) r100).getName();
        L6:
            return r100.toString();
        }

        public final ImmutableList<Type> usedInGenericType(Type[] r100) {
            ImmutableList.a r101 = ImmutableList.builder();
            int r102 = r100.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L6;
            r101.b(usedInGenericType(r100[r103]));
            r103 = r103 + 1;
            goto L3
        L6:
            return r101.e();
        }

        public JavaVersion(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;

        @CheckForNull
        private final Type ownerType;
        private final Class<?> rawType;

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            ImmutableList<Type> r100 = this.argumentsList;
            com.google.common.base.h r101 = Types.f275676a;
            return (Type[]) r100.toArray(new Type[0]);
        }

        public int hashCode() {
            Type r100 = this.ownerType;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder();
            if (this.ownerType == null) goto L7;
            JavaVersion r101 = JavaVersion.CURRENT;
            if (r101.jdkTypeDuplicatesOwnerName() == false) goto L7;
            r100.append(r101.typeName(this.ownerType));
            r100.append('.');
        L7:
            r100.append(this.rawType.getName());
            r100.append(Typography.less);
            com.google.common.base.h r102 = Types.f275676a;
            ImmutableList<Type> r103 = this.argumentsList;
            final JavaVersion r104 = JavaVersion.CURRENT;
            Objects.requireNonNull(r104);
            com.google.common.base.g r105 = new m(r104);
            r103.getClass();
            r100.append(r102.b(new y0(r103, r105)));
            r100.append(Typography.greater);
            return r100.toString();
        }

        @Override // java.lang.reflect.ParameterizedType
        @CheckForNull
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof ParameterizedType) == true) goto L5;
            return false;
        L5:
            ParameterizedType r101 = (ParameterizedType) r100;
            if (getRawType().equals(r101.getRawType()) == true) goto L8;
            return false;
        L8:
            if (com.google.common.base.k.a(getOwnerType(), r101.getOwnerType()) == true) goto L10;
            return false;
        L10:
            if (Arrays.equals(getActualTypeArguments(), r101.getActualTypeArguments()) == false) goto L15;
            return true;
        L15:
            return false;
        }

        public ParameterizedTypeImpl(@CheckForNull Type r100, Class<?> r101, Type[] r102) {
            r101.getClass();
            if (r102.length != r101.getTypeParameters().length) goto L5;
            boolean r103 = true;
        L6:
            com.google.common.base.m.b(r103);
            Types.b(r102, "type parameter");
            this.ownerType = r100;
            this.rawType = r101;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(r102);
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            ImmutableList<Type> r100 = this.lowerBounds;
            com.google.common.base.h r101 = Types.f275676a;
            return (Type[]) r100.toArray(new Type[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            ImmutableList<Type> r100 = this.upperBounds;
            com.google.common.base.h r101 = Types.f275676a;
            return (Type[]) r100.toArray(new Type[0]);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("?");
            z2<Type> r101 = this.lowerBounds.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            Type r102 = r101.next();
            r100.append(" super ");
            r100.append(JavaVersion.CURRENT.typeName(r102));
            goto L4
        L6:
            ImmutableList<Type> r103 = this.upperBounds;
            com.google.common.base.h r104 = Types.f275676a;
            n r105 = Predicates.h(Predicates.e(Object.class));
            r103.getClass();
            Iterator<Object> r106 = new x0(r103, r105).iterator();
        L7:
            AbstractIterator r107 = (AbstractIterator) r106;
            if (r107.hasNext() == false) goto L11;
            Type r108 = (Type) r107.next();
            r100.append(" extends ");
            r100.append(JavaVersion.CURRENT.typeName(r108));
            goto L7
        L11:
            return r100.toString();
        }

        public boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof WildcardType) == false) goto L10;
            WildcardType r101 = (WildcardType) r100;
            if (this.lowerBounds.equals(Arrays.asList(r101.getLowerBounds())) == true) goto L7;
            return false;
        L7:
            if (this.upperBounds.equals(Arrays.asList(r101.getUpperBounds())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public WildcardTypeImpl(Type[] r100, Type[] r101) {
            Types.b(r100, "lower bound for wildcard");
            Types.b(r101, "upper bound for wildcard");
            JavaVersion r102 = JavaVersion.CURRENT;
            this.lowerBounds = r102.usedInGenericType(r100);
            this.upperBounds = r102.usedInGenericType(r101);
        }
    }

    public class a extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f275679b;

        public a(AtomicReference r100) {
            this.f275679b = r100;
        }

        @Override // com.google.common.reflect.j
        public final void b(Class<?> r100) {
            this.f275679b.set(r100.getComponentType());
        }

        @Override // com.google.common.reflect.j
        public final void c(GenericArrayType r100) {
            this.f275679b.set(r100.getGenericComponentType());
        }

        @Override // com.google.common.reflect.j
        public final void e(TypeVariable<?> r100) {
            this.f275679b.set(Types.a(r100.getBounds()));
        }

        @Override // com.google.common.reflect.j
        public final void f(WildcardType r100) {
            this.f275679b.set(Types.a(r100.getUpperBounds()));
        }
    }

    public static final class b<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final boolean f275680a = false;

        public b() {
        }

        static {
            f275680a = !b.class.getTypeParameters()[0].equals(Types.e(b.class, "X", new Type[0]));
        }
    }

    public static final class c<D extends GenericDeclaration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final D f275681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f275682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImmutableList<Type> f275683c;

        public final int hashCode() {
            return this.f275681a.hashCode() ^ this.f275682b.hashCode();
        }

        public final String toString() {
            return this.f275682b;
        }

        public final boolean equals(@CheckForNull Object r100) {
            if (b.f275680a == false) goto L20;
            if (r100 != null) goto L6;
        L18:
            return false;
        L6:
            if (Proxy.isProxyClass(r100.getClass()) == false) goto L18;
            if ((Proxy.getInvocationHandler(r100) instanceof d) == false) goto L18;
            c<?> r101 = ((d) Proxy.getInvocationHandler(r100)).f275685a;
            if (this.f275682b.equals(r101.f275682b) == true) goto L12;
        L16:
            return false;
        L12:
            if (this.f275681a.equals(r101.f275681a) == false) goto L16;
            if (this.f275683c.equals(r101.f275683c) == false) goto L16;
            return true;
        L20:
            if ((r100 instanceof TypeVariable) == false) goto L28;
            TypeVariable r102 = (TypeVariable) r100;
            if (this.f275682b.equals(r102.getName()) == true) goto L24;
        L26:
            return false;
        L24:
            if (this.f275681a.equals(r102.getGenericDeclaration()) == false) goto L26;
            return true;
        L28:
            return false;
        }

        public c(D r100, String r101, Type[] r102) {
            Types.b(r102, "bound for type variable");
            r100.getClass();
            this.f275681a = r100;
            r101.getClass();
            this.f275682b = r101;
            this.f275683c = ImmutableList.copyOf(r102);
        }
    }

    public static final class d implements InvocationHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ImmutableMap<String, Method> f275684b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c<?> f275685a;

        static {
            ImmutableMap.b r100 = ImmutableMap.builder();
            Method[] r101 = c.class.getMethods();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L10;
            Method r104 = r101[r103];
            if (r104.getDeclaringClass().equals(c.class) == false) goto L9;
            r104.setAccessible(true);     // Catch: AccessControlException -> L12
        L8:
            r100.e(r104.getName(), r104);
        L9:
            r103 = r103 + 1;
            goto L3
        L10:
            f275684b = r100.c();
        }

        public d(c<?> r100) {
            this.f275685a = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        @CheckForNull
        public final Object invoke(Object r100, Method r101, @CheckForNull Object[] r102) throws Throwable {
            String r103 = r101.getName();
            Method r104 = f275684b.get(r103);
            if (r104 == null) goto L10;
            return r104.invoke(this.f275685a, r102);
        L6:
            e = move-exception;
            throw e.getCause();
        L10:
            throw new UnsupportedOperationException(r103);
        }
    }

    static {
        com.google.common.base.i r100 = new com.google.common.base.i(", ");
        f275676a = new com.google.common.base.h(r100, r100);
    }

    public static Type a(Type[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L13;
        Type r103 = c(r100[r102]);
        if (r103 != null) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        if ((r103 instanceof Class) == false) goto L17;
        Class r104 = (Class) r103;
        if (r104.isPrimitive() == false) goto L17;
        return r104;
    L17:
        return new WildcardTypeImpl(new Type[0], new Type[]{r103});
    L13:
        return null;
    }

    @CheckForNull
    public static Type c(Type r100) {
        r100.getClass();
        AtomicReference r101 = new AtomicReference();
        new a(r101).a(new Type[]{r100});
        return (Type) r101.get();
    }

    public static Type d(Type r100) {
        if ((r100 instanceof WildcardType) == false) goto L19;
        WildcardType r101 = (WildcardType) r100;
        Type[] r102 = r101.getLowerBounds();
        if (r102.length > 1) goto L7;
        boolean r103 = true;
    L8:
        com.google.common.base.m.c(r103, "Wildcard cannot have more than one lower bounds.");
        if (r102.length == 1) goto L11;
        Type[] r104 = r101.getUpperBounds();
        if (r104.length != 1) goto L15;
        boolean r105 = true;
    L16:
        com.google.common.base.m.c(r105, "Wildcard should have only one upper bound.");
        return new WildcardTypeImpl(new Type[0], new Type[]{d(r104[0])});
    L15:
        r105 = false;
        goto L16
    L11:
        return new WildcardTypeImpl(new Type[]{d(r102[0])}, new Type[]{Object.class});
    L7:
        r103 = false;
        goto L8
    L19:
        return JavaVersion.CURRENT.newArrayType(r100);
    }

    public static void b(Type[] r100, String r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Type r104 = r100[r103];
        if ((r104 instanceof Class) == false) goto L7;
        Class r105 = (Class) r104;
        com.google.common.base.m.i(!r105.isPrimitive(), "Primitive type '%s' used as %s", r105, r101);
    L7:
        r103 = r103 + 1;
        goto L3
    }

    public static <D extends GenericDeclaration> TypeVariable<D> e(D r100, String r101, Type... r102) {
        if (r102.length != 0) goto L5;
        r102 = new Type[]{Object.class};
    L5:
        d r103 = new d(new c(r100, r101, r102));
        com.google.common.base.m.h(TypeVariable.class.isInterface(), "%s is not an interface", TypeVariable.class);
        return (TypeVariable) TypeVariable.class.cast(Proxy.newProxyInstance(TypeVariable.class.getClassLoader(), new Class[]{TypeVariable.class}, r103));
    }

    public static ParameterizedType f(@CheckForNull Type r100, Class<?> r101, Type... r102) {
        if (r100 == null) goto L4;
        r102.getClass();
        if (r101.getEnclosingClass() == null) goto L8;
        boolean r103 = true;
    L9:
        com.google.common.base.m.h(r103, "Owner type for unenclosed %s", r101);
        return new ParameterizedTypeImpl(r100, r101, r102);
    L8:
        r103 = false;
        goto L9
    L4:
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(r101), r101, r102);
    }
}

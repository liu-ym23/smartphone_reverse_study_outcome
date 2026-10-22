package retrofit2;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f537598a = null;

    public static final class a implements GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f537599a;

        public final int hashCode() {
            return this.f537599a.hashCode();
        }

        public final String toString() {
            return u.m(this.f537599a) + "[]";
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.f537599a;
        }

        public a(Type r100) {
            this.f537599a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (u.c(this, (GenericArrayType) r100) == false) goto L7;
            return true;
        }
    }

    public static final class b implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f537600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f537601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Type[] f537602c;

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.f537602c.clone();
        }

        public final int hashCode() {
            int r100 = Arrays.hashCode(this.f537602c) ^ this.f537601b.hashCode();
            Type r101 = this.f537600a;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 ^ r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            Type[] r100 = this.f537602c;
            if (r100.length == 0) goto L5;
            int r101 = 1;
            StringBuilder r102 = new StringBuilder((r100.length + 1) * 30);
            r102.append(u.m(this.f537601b));
            r102.append("<");
            r102.append(u.m(this.f537602c[0]));
        L8:
            if (r101 >= this.f537602c.length) goto L10;
            r102.append(", ");
            r102.append(u.m(this.f537602c[r101]));
            r101 = r101 + 1;
            goto L8
        L10:
            r102.append(">");
            return r102.toString();
        L5:
            return u.m(this.f537601b);
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.f537600a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.f537601b;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (u.c(this, (ParameterizedType) r100) == false) goto L7;
            return true;
        }

        public b(@Nullable Type r100, Type r101, Type... r102) {
            int r103 = 0;
            if ((r101 instanceof Class) == false) goto L16;
            boolean r104 = true;
            if (r100 != null) goto L7;
            boolean r105 = true;
        L9:
            if (((Class) r101).getEnclosingClass() == null) goto L12;
            r104 = false;
        L12:
            if (r105 == r104) goto L16;
            throw new IllegalArgumentException();
        L7:
            r105 = false;
        L16:
            int r106 = r102.length;
        L17:
            if (r103 >= r106) goto L19;
            Type r107 = r102[r103];
            u.a(r107, "typeArgument == null");
            u.b(r107);
            r103 = r103 + 1;
            goto L17
        L19:
            this.f537600a = r100;
            this.f537601b = r101;
            this.f537602c = (Type[]) r102.clone();
        }
    }

    public static final class c implements WildcardType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f537603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f537604b;

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.f537603a};
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            Type r100 = this.f537604b;
            if (r100 == null) goto L6;
            return new Type[]{r100};
        L6:
            return u.f537598a;
        }

        public final int hashCode() {
            Type r100 = this.f537604b;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode() + 31;
        L7:
            return r101 ^ (this.f537603a.hashCode() + 31);
        L5:
            r101 = 1;
            goto L7
        }

        public final String toString() {
            if (this.f537604b == null) goto L7;
            return "? super " + u.m(this.f537604b);
        L7:
            if (this.f537603a != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + u.m(this.f537603a);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (u.c(this, (WildcardType) r100) == false) goto L7;
            return true;
        }

        public c(Type[] r100, Type[] r101) {
            if (r101.length > 1) goto L18;
            if (r100.length != 1) goto L16;
            if (r101.length != 1) goto L13;
            Type r102 = r101[0];
            r102.getClass();
            u.b(r102);
            if (r100[0] != Object.class) goto L12;
            this.f537604b = r101[0];
            this.f537603a = Object.class;
            return;
        L12:
            throw new IllegalArgumentException();
        L13:
            Type r103 = r100[0];
            r103.getClass();
            u.b(r103);
            this.f537604b = null;
            this.f537603a = r100[0];
            return;
        L16:
            throw new IllegalArgumentException();
        L18:
            throw new IllegalArgumentException();
        }
    }

    static {
        f537598a = new Type[0];
    }

    public static void b(Type r100) {
        if ((r100 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r100).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static Class<?> f(Type r100) {
        a(r100, "type == null");
        if ((r100 instanceof Class) == false) goto L7;
        return (Class) r100;
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L15;
        Type r101 = ((ParameterizedType) r100).getRawType();
        if ((r101 instanceof Class) == false) goto L13;
        return (Class) r101;
    L13:
        throw new IllegalArgumentException();
    L15:
        if ((r100 instanceof GenericArrayType) == false) goto L19;
        return Array.newInstance(f(((GenericArrayType) r100).getGenericComponentType()), 0).getClass();
    L19:
        if ((r100 instanceof TypeVariable) == false) goto L23;
        return Object.class;
    L23:
        if ((r100 instanceof WildcardType) == false) goto L27;
        return f(((WildcardType) r100).getUpperBounds()[0]);
    L27:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r100 + "> is of type " + r100.getClass().getName());
    }

    public static boolean h(@Nullable Type r100) {
        if ((r100 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r100 instanceof ParameterizedType) == false) goto L15;
        Type[] r101 = ((ParameterizedType) r100).getActualTypeArguments();
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        if (h(r101[r103]) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r100 instanceof GenericArrayType) == false) goto L19;
        return h(((GenericArrayType) r100).getGenericComponentType());
    L19:
        if ((r100 instanceof TypeVariable) == false) goto L22;
        return true;
    L22:
        if ((r100 instanceof WildcardType) == false) goto L24;
        return true;
    L24:
        if (r100 != null) goto L26;
        String r104 = "null";
    L28:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r100 + "> is of type " + r104);
    L26:
        r104 = r100.getClass().getName();
        goto L28
    }

    public static void l(Throwable r100) {
        if ((r100 instanceof VirtualMachineError) == true) goto L14;
        if ((r100 instanceof ThreadDeath) == true) goto L12;
        if ((r100 instanceof LinkageError) == true) goto L10;
        return;
    L10:
        throw ((LinkageError) r100);
    L12:
        throw ((ThreadDeath) r100);
    L14:
        throw ((VirtualMachineError) r100);
    }

    public static String m(Type r100) {
        if ((r100 instanceof Class) == false) goto L6;
        return ((Class) r100).getName();
    L6:
        return r100.toString();
    }

    public static void a(@Nullable Object r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new NullPointerException(r101);
    }

    public static boolean c(Type r100, Type r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if ((r100 instanceof Class) == false) goto L10;
        return r100.equals(r101);
    L10:
        if ((r100 instanceof ParameterizedType) == false) goto L27;
        if ((r101 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r102 = (ParameterizedType) r100;
        ParameterizedType r103 = (ParameterizedType) r101;
        Type r104 = r102.getOwnerType();
        Type r105 = r103.getOwnerType();
        if (r104 == r105) goto L20;
        if (r104 != null) goto L18;
    L24:
        return false;
    L18:
        if (r104.equals(r105) == false) goto L24;
    L20:
        if (r102.getRawType().equals(r103.getRawType()) == false) goto L24;
        if (Arrays.equals(r102.getActualTypeArguments(), r103.getActualTypeArguments()) == false) goto L24;
        return true;
    L27:
        if ((r100 instanceof GenericArrayType) == false) goto L34;
        if ((r101 instanceof GenericArrayType) == true) goto L32;
        return false;
    L32:
        return c(((GenericArrayType) r100).getGenericComponentType(), ((GenericArrayType) r101).getGenericComponentType());
    L34:
        if ((r100 instanceof WildcardType) == false) goto L46;
        if ((r101 instanceof WildcardType) == true) goto L38;
        return false;
    L38:
        WildcardType r106 = (WildcardType) r100;
        WildcardType r107 = (WildcardType) r101;
        if (Arrays.equals(r106.getUpperBounds(), r107.getUpperBounds()) == true) goto L41;
    L43:
        return false;
    L41:
        if (Arrays.equals(r106.getLowerBounds(), r107.getLowerBounds()) == false) goto L43;
        return true;
    L46:
        if ((r100 instanceof TypeVariable) == true) goto L48;
        return false;
    L48:
        if ((r101 instanceof TypeVariable) == true) goto L50;
        return false;
    L50:
        TypeVariable r108 = (TypeVariable) r100;
        TypeVariable r109 = (TypeVariable) r101;
        if (r108.getGenericDeclaration() == r109.getGenericDeclaration()) goto L53;
    L55:
        return false;
    L53:
        if (r108.getName().equals(r109.getName()) == false) goto L55;
        return true;
    }

    public static Type e(int r100, ParameterizedType r101) {
        Type[] r102 = r101.getActualTypeArguments();
        if (r100 < 0) goto L11;
        if (r100 >= r102.length) goto L11;
        Type r103 = r102[r100];
        if ((r103 instanceof WildcardType) == true) goto L9;
        return r103;
    L9:
        return ((WildcardType) r103).getUpperBounds()[0];
    L11:
        throw new IllegalArgumentException("Index " + r100 + " not in range [0," + r102.length + ") for " + r101);
    }

    public static Type d(Type r100, Class<?> r101, Class<?> r102) {
        if (r102 != r101) goto L5;
        return r100;
    L5:
        if (r102.isInterface() == false) goto L18;
        Class<?>[] r103 = r101.getInterfaces();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L18;
        Class<?> r106 = r103[r105];
        if (r106 == r102) goto L11;
        if (r102.isAssignableFrom(r106) == true) goto L15;
        r105 = r105 + 1;
        goto L7
    L15:
        return d(r101.getGenericInterfaces()[r105], r103[r105], r102);
    L11:
        return r101.getGenericInterfaces()[r105];
    L18:
        if (r101.isInterface() == false) goto L20;
    L30:
        return r102;
    L20:
        if (r101 == Object.class) goto L30;
        Class<? super Object> r107 = r101.getSuperclass();
        if (r107 == r102) goto L24;
        if (r102.isAssignableFrom(r107) == true) goto L28;
        r101 = r107;
        goto L20
    L28:
        return d(r101.getGenericSuperclass(), r107, r102);
    L24:
        return r101.getGenericSuperclass();
    }

    public static Type g(Type r100, Class<?> r101, Class<?> r102) {
        if (r102.isAssignableFrom(r101) == false) goto L7;
        return k(r100, r101, d(r100, r101, r102));
    L7:
        throw new IllegalArgumentException();
    }

    public static Type k(Type r100, Class<?> r101, Type r110) {
    L2:
        int r102 = 0;
        if ((r10 instanceof TypeVariable) == false) goto L26;
        TypeVariable r111 = (TypeVariable) r10;
        GenericDeclaration r103 = r111.getGenericDeclaration();
        if ((r103 instanceof Class) == false) goto L7;
        Class r104 = (Class) r103;
    L8:
        if (r104 == null) goto L21;
        Type r105 = d(r100, r101, r104);
        if ((r105 instanceof ParameterizedType) == false) goto L21;
        TypeVariable[] r106 = r104.getTypeParameters();
    L14:
        if (r102 >= r106.length) goto L20;
        if (r111.equals(r106[r102]) == true) goto L17;
        r102 = r102 + 1;
        goto L14
    L17:
        Type r107 = ((ParameterizedType) r105).getActualTypeArguments()[r102];
    L22:
        if (r107 == r111) goto L23;
        Type r112 = r107;
        goto L2
    L23:
        return r107;
    L20:
        throw new NoSuchElementException();
    L21:
        r107 = r111;
        goto L22
    L7:
        r104 = null;
        goto L8
    L26:
        if ((r112 instanceof Class) == false) goto L35;
        Class r108 = (Class) r112;
        if (r108.isArray() == false) goto L35;
        Class<?> r113 = r108.getComponentType();
        Type r109 = k(r100, r101, r113);
        if (r113 != r109) goto L33;
        return r108;
    L33:
        return new a(r109);
    L35:
        if ((r112 instanceof GenericArrayType) == false) goto L42;
        GenericArrayType r114 = (GenericArrayType) r112;
        Type r115 = r114.getGenericComponentType();
        Type r116 = k(r100, r101, r115);
        if (r115 != r116) goto L40;
        return r114;
    L40:
        return new a(r116);
    L42:
        if ((r112 instanceof ParameterizedType) == false) goto L58;
        ParameterizedType r117 = (ParameterizedType) r112;
        Type r118 = r117.getOwnerType();
        Type r119 = k(r100, r101, r118);
        if (r119 == r118) goto L46;
        boolean r120 = true;
    L47:
        Type[] r121 = r117.getActualTypeArguments();
        int r122 = r121.length;
    L48:
        if (r102 >= r122) goto L55;
        Type r123 = k(r100, r101, r121[r102]);
        if (r123 == r121[r102]) goto L54;
        if (r120 == true) goto L53;
        r121 = (Type[]) r121.clone();
        r120 = true;
    L53:
        r121[r102] = r123;
    L54:
        r102 = r102 + 1;
        goto L48
    L55:
        if (r120 == true) goto L57;
        return r117;
    L57:
        return new b(r119, r117.getRawType(), r121);
    L46:
        r120 = false;
        goto L47
    L58:
        boolean r124 = r112 instanceof WildcardType;
        Type r125 = r112;
        if (r124 == false) goto L76;
        WildcardType r126 = (WildcardType) r112;
        Type[] r127 = r126.getLowerBounds();
        Type[] r128 = r126.getUpperBounds();
        if (r127.length != 1) goto L66;
        Type r129 = k(r100, r101, r127[0]);
        r125 = r126;
        if (r129 == r127[0]) goto L76;
        return new c(new Type[]{Object.class}, new Type[]{r129});
    L66:
        r125 = r126;
        if (r128.length != 1) goto L76;
        Type r130 = k(r100, r101, r128[0]);     // Catch: Throwable -> L74
        r125 = r126;
        if (r130 == r128[0]) goto L76;
        return new c(new Type[]{r130}, f537598a);
    L74:
        th = move-exception;
        throw th;
    L76:
        return r125;
    }

    public static RuntimeException i(Method r100, @Nullable Throwable r101, String r102, Object... r103) {
        return new IllegalArgumentException(String.format(r102, r103) + "\n    for method " + r100.getDeclaringClass().getSimpleName() + "." + r100.getName(), r101);
    }

    public static RuntimeException j(Method r100, int r101, String r102, Object... r103) {
        return i(r100, null, r102 + " (parameter #" + (r101 + 1) + ")", r103);
    }
}

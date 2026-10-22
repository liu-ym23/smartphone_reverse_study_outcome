package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

/* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$Gson$Types {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final Type[] EMPTY_TYPE_ARRAY = null;

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl */
    /* JADX INFO: loaded from: classes3.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return C$Gson$Types.typeToString(this.componentType) + "[]";
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public GenericArrayTypeImpl(Type r100) {
            Objects.requireNonNull(r100);
            this.componentType = C$Gson$Types.canonicalize(r100);
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (GenericArrayType) r100) == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl */
    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            int r100 = this.typeArguments.length;
            if (r100 == 0) goto L5;
            StringBuilder r101 = new StringBuilder((r100 + 1) * 30);
            r101.append(C$Gson$Types.typeToString(this.rawType));
            r101.append("<");
            r101.append(C$Gson$Types.typeToString(this.typeArguments[0]));
            int r102 = 1;
        L7:
            if (r102 >= r100) goto L9;
            r101.append(", ");
            r101.append(C$Gson$Types.typeToString(this.typeArguments[r102]));
            r102 = r102 + 1;
            goto L7
        L9:
            r101.append(">");
            return r101.toString();
        L5:
            return C$Gson$Types.typeToString(this.rawType);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        private static int hashCodeOrZero(Object r100) {
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (ParameterizedType) r100) == false) goto L7;
            return true;
        }

        public ParameterizedTypeImpl(Type r100, Type r101, Type... r102) {
            Objects.requireNonNull(r101);
            int r103 = 0;
            if ((r101 instanceof Class) == false) goto L16;
            Class r104 = (Class) r101;
            boolean r105 = true;
            if (Modifier.isStatic(r104.getModifiers()) == false) goto L7;
        L10:
            boolean r106 = true;
        L11:
            if (r100 != null) goto L15;
            if (r106 == true) goto L15;
            r105 = false;
        L15:
            C$Gson$Preconditions.checkArgument(r105);
            goto L16
        L7:
            if (r104.getEnclosingClass() == null) goto L10;
            r106 = false;
        L16:
            if (r100 != null) goto L18;
            Type r107 = null;
        L19:
            this.ownerType = r107;
            this.rawType = C$Gson$Types.canonicalize(r101);
            Type[] r108 = (Type[]) r102.clone();
            this.typeArguments = r108;
            int r109 = r108.length;
        L20:
            if (r103 >= r109) goto L22;
            Objects.requireNonNull(this.typeArguments[r103]);
            C$Gson$Types.checkNotPrimitive(this.typeArguments[r103]);
            Type[] r110 = this.typeArguments;
            r110[r103] = C$Gson$Types.canonicalize(r110[r103]);
            r103 = r103 + 1;
            goto L20
        L22:
            return;
        L18:
            r107 = C$Gson$Types.canonicalize(r100);
            goto L19
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.$Gson$Types$WildcardTypeImpl */
    public static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type r100 = this.lowerBound;
            if (r100 == null) goto L6;
            return new Type[]{r100};
        L6:
            return C$Gson$Types.EMPTY_TYPE_ARRAY;
        }

        public int hashCode() {
            Type r100 = this.lowerBound;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode() + 31;
        L7:
            return r101 ^ (this.upperBound.hashCode() + 31);
        L5:
            r101 = 1;
            goto L7
        }

        public String toString() {
            if (this.lowerBound == null) goto L7;
            return "? super " + C$Gson$Types.typeToString(this.lowerBound);
        L7:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + C$Gson$Types.typeToString(this.upperBound);
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (C$Gson$Types.equals(this, (WildcardType) r100) == false) goto L7;
            return true;
        }

        public WildcardTypeImpl(Type[] r100, Type[] r101) {
            boolean r102 = true;
            if (r101.length > 1) goto L5;
            boolean r103 = true;
        L6:
            C$Gson$Preconditions.checkArgument(r103);
            if (r100.length != 1) goto L9;
            boolean r104 = true;
        L10:
            C$Gson$Preconditions.checkArgument(r104);
            if (r101.length != 1) goto L17;
            Objects.requireNonNull(r101[0]);
            C$Gson$Types.checkNotPrimitive(r101[0]);
            if (r100[0] == Object.class) goto L16;
            r102 = false;
        L16:
            C$Gson$Preconditions.checkArgument(r102);
            this.lowerBound = C$Gson$Types.canonicalize(r101[0]);
            this.upperBound = Object.class;
            return;
        L17:
            Objects.requireNonNull(r100[0]);
            C$Gson$Types.checkNotPrimitive(r100[0]);
            this.lowerBound = null;
            this.upperBound = C$Gson$Types.canonicalize(r100[0]);
            return;
        L9:
            r104 = false;
            goto L10
        L5:
            r103 = false;
            goto L6
        }
    }

    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private C$Gson$Types() {
        throw new UnsupportedOperationException();
    }

    public static GenericArrayType arrayOf(Type r100) {
        return new GenericArrayTypeImpl(r100);
    }

    public static Type canonicalize(Type r100) {
        if ((r100 instanceof Class) == false) goto L10;
        Class r101 = (Class) r100;
        boolean r102 = r101.isArray();
        Type r103 = r101;
        if (r102 == false) goto L8;
        r103 = new GenericArrayTypeImpl(canonicalize(r101.getComponentType()));
    L8:
        return r103;
    L10:
        if ((r100 instanceof ParameterizedType) == false) goto L14;
        ParameterizedType r104 = (ParameterizedType) r100;
        return new ParameterizedTypeImpl(r104.getOwnerType(), r104.getRawType(), r104.getActualTypeArguments());
    L14:
        if ((r100 instanceof GenericArrayType) == false) goto L18;
        return new GenericArrayTypeImpl(((GenericArrayType) r100).getGenericComponentType());
    L18:
        if ((r100 instanceof WildcardType) == false) goto L21;
        WildcardType r105 = (WildcardType) r100;
        return new WildcardTypeImpl(r105.getUpperBounds(), r105.getLowerBounds());
    L21:
        return r100;
    }

    public static void checkNotPrimitive(Type r100) {
        if ((r100 instanceof Class) == true) goto L5;
    L8:
        boolean r101 = true;
    L9:
        C$Gson$Preconditions.checkArgument(r101);
        return;
    L5:
        if (((Class) r100).isPrimitive() == false) goto L8;
        r101 = false;
        goto L9
    }

    private static Class<?> declaringClassOf(TypeVariable<?> r100) {
        GenericDeclaration r101 = r100.getGenericDeclaration();
        if ((r101 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r101;
    }

    public static Type getArrayComponentType(Type r100) {
        if ((r100 instanceof GenericArrayType) == false) goto L6;
        return ((GenericArrayType) r100).getGenericComponentType();
    L6:
        return ((Class) r100).getComponentType();
    }

    public static Class<?> getRawType(Type r100) {
        if ((r100 instanceof Class) == false) goto L7;
        return (Class) r100;
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        Type r101 = ((ParameterizedType) r100).getRawType();
        C$Gson$Preconditions.checkArgument(r101 instanceof Class);
        return (Class) r101;
    L11:
        if ((r100 instanceof GenericArrayType) == false) goto L15;
        return Array.newInstance(getRawType(((GenericArrayType) r100).getGenericComponentType()), 0).getClass();
    L15:
        if ((r100 instanceof TypeVariable) == false) goto L19;
        return Object.class;
    L19:
        if ((r100 instanceof WildcardType) == true) goto L21;
        if (r100 != null) goto L24;
        String r102 = "null";
    L26:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r100 + "> is of type " + r102);
    L24:
        r102 = r100.getClass().getName();
        goto L26
    L21:
        return getRawType(((WildcardType) r100).getUpperBounds()[0]);
    }

    public static WildcardType subtypeOf(Type r100) {
        if ((r100 instanceof WildcardType) == false) goto L5;
        Type[] r101 = ((WildcardType) r100).getUpperBounds();
    L7:
        return new WildcardTypeImpl(r101, EMPTY_TYPE_ARRAY);
    L5:
        r101 = new Type[]{r100};
        goto L7
    }

    public static WildcardType supertypeOf(Type r100) {
        if ((r100 instanceof WildcardType) == false) goto L5;
        Type[] r101 = ((WildcardType) r100).getLowerBounds();
    L7:
        return new WildcardTypeImpl(new Type[]{Object.class}, r101);
    L5:
        r101 = new Type[]{r100};
        goto L7
    }

    public static String typeToString(Type r100) {
        if ((r100 instanceof Class) == false) goto L6;
        return ((Class) r100).getName();
    L6:
        return r100.toString();
    }

    private static boolean equal(Object r100, Object r101) {
        return Objects.equals(r100, r101);
    }

    public static boolean equals(Type r100, Type r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if ((r100 instanceof Class) == false) goto L10;
        return r100.equals(r101);
    L10:
        if ((r100 instanceof ParameterizedType) == false) goto L24;
        if ((r101 instanceof ParameterizedType) == true) goto L14;
        return false;
    L14:
        ParameterizedType r102 = (ParameterizedType) r100;
        ParameterizedType r103 = (ParameterizedType) r101;
        if (equal(r102.getOwnerType(), r103.getOwnerType()) == true) goto L17;
    L21:
        return false;
    L17:
        if (r102.getRawType().equals(r103.getRawType()) == false) goto L21;
        if (Arrays.equals(r102.getActualTypeArguments(), r103.getActualTypeArguments()) == false) goto L21;
        return true;
    L24:
        if ((r100 instanceof GenericArrayType) == false) goto L31;
        if ((r101 instanceof GenericArrayType) == true) goto L29;
        return false;
    L29:
        return equals(((GenericArrayType) r100).getGenericComponentType(), ((GenericArrayType) r101).getGenericComponentType());
    L31:
        if ((r100 instanceof WildcardType) == false) goto L43;
        if ((r101 instanceof WildcardType) == true) goto L35;
        return false;
    L35:
        WildcardType r104 = (WildcardType) r100;
        WildcardType r105 = (WildcardType) r101;
        if (Arrays.equals(r104.getUpperBounds(), r105.getUpperBounds()) == true) goto L38;
    L40:
        return false;
    L38:
        if (Arrays.equals(r104.getLowerBounds(), r105.getLowerBounds()) == false) goto L40;
        return true;
    L43:
        if ((r100 instanceof TypeVariable) == true) goto L45;
        return false;
    L45:
        if ((r101 instanceof TypeVariable) == true) goto L47;
        return false;
    L47:
        TypeVariable r106 = (TypeVariable) r100;
        TypeVariable r107 = (TypeVariable) r101;
        if (r106.getGenericDeclaration() == r107.getGenericDeclaration()) goto L50;
    L52:
        return false;
    L50:
        if (r106.getName().equals(r107.getName()) == false) goto L52;
        return true;
    }

    public static Type getCollectionElementType(Type r100, Class<?> r101) {
        Type r102 = getSupertype(r100, r101, Collection.class);
        if ((r102 instanceof ParameterizedType) == true) goto L5;
        return Object.class;
    L5:
        return ((ParameterizedType) r102).getActualTypeArguments()[0];
    }

    public static Type[] getMapKeyAndValueTypes(Type r100, Class<?> r101) {
        if (r100 == Properties.class) goto L5;
        Type r102 = getSupertype(r100, r101, Map.class);
        if ((r102 instanceof ParameterizedType) == false) goto L11;
        return ((ParameterizedType) r102).getActualTypeArguments();
    L11:
        return new Type[]{Object.class, Object.class};
    L5:
        return new Type[]{String.class, String.class};
    }

    private static int indexOf(Object[] r100, Object r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101.equals(r100[r103]) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r103;
    L9:
        throw new NoSuchElementException();
    }

    private static Type getGenericSupertype(Type r100, Class<?> r101, Class<?> r102) {
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
        return getGenericSupertype(r101.getGenericInterfaces()[r105], r103[r105], r102);
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
        return getGenericSupertype(r101.getGenericSuperclass(), r107, r102);
    L24:
        return r101.getGenericSuperclass();
    }

    private static Type getSupertype(Type r100, Class<?> r101, Class<?> r102) {
        if ((r100 instanceof WildcardType) == false) goto L5;
        r100 = ((WildcardType) r100).getUpperBounds()[0];
    L5:
        C$Gson$Preconditions.checkArgument(r102.isAssignableFrom(r101));
        return resolve(r100, r101, getGenericSupertype(r100, r101, r102));
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type r100, Type r101, Type... r102) {
        return new ParameterizedTypeImpl(r100, r101, r102);
    }

    public static Type resolve(Type r100, Class<?> r101, Type r102) {
        return resolve(r100, r101, r102, new HashMap());
    }

    private static Type resolveTypeVariable(Type r100, Class<?> r101, TypeVariable<?> r102) {
        Class<?> r103 = declaringClassOf(r102);
        if (r103 != null) goto L5;
        return r102;
    L5:
        Type r104 = getGenericSupertype(r100, r101, r103);
        if ((r104 instanceof ParameterizedType) == false) goto L9;
        int r105 = indexOf(r103.getTypeParameters(), r102);
        return ((ParameterizedType) r104).getActualTypeArguments()[r105];
    L9:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v13, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.Map, java.util.Map<java.lang.reflect.TypeVariable<?>, java.lang.reflect.Type>] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    private static Type resolve(Type r100, Class<?> r110, Type r111, Map<TypeVariable<?>, Type> r112) {
        TypeVariable r101 = null;
    L4:
        if ((r111 instanceof TypeVariable) == false) goto L19;
        TypeVariable r102 = (TypeVariable) r111;
        Type r103 = (Type) r112.get(r102);
        if (r103 != null) goto L8;
        r112.put(r102, Void.TYPE);
        if (r101 != null) goto L15;
        r101 = r102;
    L15:
        r111 = resolveTypeVariable(r100, r110, r102);
        if (r111 != r102) goto L4;
    L59:
        if (r101 == null) goto L61;
        r112.put(r101, r111);
    L61:
        return r111;
    L8:
        if (r103 != Void.TYPE) goto L11;
        return r111;
    L11:
        return r103;
    L19:
        if ((r111 instanceof Class) == false) goto L28;
        Class r104 = (Class) r111;
        if (r104.isArray() == false) goto L28;
        Class<?> r113 = r104.getComponentType();
        Type r105 = resolve(r100, r110, r113, r112);
        if (equal(r113, r105) == false) goto L25;
        r111 = r104;
        goto L59
    L25:
        Type r106 = arrayOf(r105);
    L26:
        r111 = r106;
    L28:
        if ((r111 instanceof GenericArrayType) == false) goto L33;
        r111 = (GenericArrayType) r111;
        Type r107 = r111.getGenericComponentType();
        Type r108 = resolve(r100, r110, r107, r112);
        if (equal(r107, r108) == true) goto L59;
        r106 = arrayOf(r108);
        goto L26
    L33:
        int r109 = 0;
        if ((r111 instanceof ParameterizedType) == false) goto L46;
        r111 = (ParameterizedType) r111;
        Type r114 = r111.getOwnerType();
        Type r115 = resolve(r100, r110, r114, r112);
        boolean r116 = !equal(r115, r114);
        Type[] r117 = r111.getActualTypeArguments();
        int r118 = r117.length;
    L36:
        if (r109 >= r118) goto L43;
        Type r119 = resolve(r100, r110, r117[r109], r112);
        if (equal(r119, r117[r109]) == true) goto L42;
        if (r116 == true) goto L41;
        r117 = (Type[]) r117.clone();
        r116 = true;
    L41:
        r117[r109] = r119;
    L42:
        r109 = r109 + 1;
        goto L36
    L43:
        if (r116 == false) goto L59;
        r106 = newParameterizedTypeWithOwner(r115, r111.getRawType(), r117);
        goto L26
    L46:
        if ((r111 instanceof WildcardType) == false) goto L59;
        r111 = (WildcardType) r111;
        Type[] r120 = r111.getLowerBounds();
        Type[] r121 = r111.getUpperBounds();
        if (r120.length != 1) goto L53;
        Type r122 = resolve(r100, r110, r120[0], r112);
        if (r122 == r120[0]) goto L59;
        r111 = supertypeOf(r122);
        goto L59
    L53:
        if (r121.length != 1) goto L59;
        Type r123 = resolve(r100, r110, r121[0], r112);     // Catch: Throwable -> L62
        if (r123 == r121[0]) goto L59;
        r111 = subtypeOf(r123);
    L62:
        th = move-exception;
        throw th;
    }
}

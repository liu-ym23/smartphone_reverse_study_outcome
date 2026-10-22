package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class TypeToken<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }

    public TypeToken() {
        Type r100 = getTypeTokenTypeArgument();
        this.type = r100;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r100);
        this.hashCode = r100.hashCode();
    }

    private Type getTypeTokenTypeArgument() {
        Type r100 = getClass().getGenericSuperclass();
        if ((r100 instanceof ParameterizedType) == false) goto L9;
        ParameterizedType r101 = (ParameterizedType) r100;
        if (r101.getRawType() != TypeToken.class) goto L13;
        return C$Gson$Types.canonicalize(r101.getActualTypeArguments()[0]);
    L13:
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    L9:
        if (r100 != TypeToken.class) goto L13;
        throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    private TypeToken(Type r100) {
        Objects.requireNonNull(r100);
        Type r101 = C$Gson$Types.canonicalize(r100);
        this.type = r101;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r101);
        this.hashCode = r101.hashCode();
    }

    public static <T> TypeToken<T> get(Class<T> r100) {
        return new TypeToken(r100);
    }

    public static TypeToken<?> getArray(Type r100) {
        return new TypeToken(C$Gson$Types.arrayOf(r100));
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof TypeToken) == true) goto L5;
    L7:
        return false;
    L5:
        if (C$Gson$Types.equals(this.type, ((TypeToken) r100).type) == false) goto L7;
        return true;
    }

    public boolean isAssignableFrom(Type r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.type.equals(r100) == false) goto L8;
        return true;
    L8:
        Type r101 = this.type;
        if ((r101 instanceof Class) == false) goto L13;
        return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r100));
    L13:
        if ((r101 instanceof ParameterizedType) == false) goto L17;
        return isAssignableFrom(r100, (ParameterizedType) r101, new HashMap());
    L17:
        if ((r101 instanceof GenericArrayType) == false) goto L25;
        if (this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r100)) == true) goto L21;
        return false;
    L21:
        if (isAssignableFrom(r100, (GenericArrayType) this.type) == false) goto L27;
        return true;
    L27:
        return false;
    L25:
        throw buildUnexpectedTypeError(r101, new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
    }

    public static TypeToken<?> get(Type r100) {
        return new TypeToken(r100);
    }

    public boolean isAssignableFrom(TypeToken<?> r100) {
        return isAssignableFrom(r100.getType());
    }

    public boolean isAssignableFrom(Class<?> r100) {
        return isAssignableFrom(r100);
    }

    private static AssertionError buildUnexpectedTypeError(Type r100, Class<?>... r101) {
        StringBuilder r102 = new StringBuilder("Unexpected type. Expected one of: ");
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.append(r101[r104].getName());
        r102.append(", ");
        r104 = r104 + 1;
        goto L3
    L5:
        r102.append("but got: ");
        r102.append(r100.getClass().getName());
        r102.append(", for type token: ");
        r102.append(r100.toString());
        r102.append('.');
        return new AssertionError(r102.toString());
    }

    public static TypeToken<?> getParameterized(Type r110, Type... r111) {
        Objects.requireNonNull(r110);
        Objects.requireNonNull(r111);
        if ((r110 instanceof Class) == false) goto L21;
        Class r100 = (Class) r110;
        TypeVariable<Class<T>>[] r101 = r100.getTypeParameters();
        int r102 = r101.length;
        int r103 = r111.length;
        if (r103 != r102) goto L19;
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L17;
        Type r105 = r111[r104];
        Class<?> r106 = C$Gson$Types.getRawType(r105);
        TypeVariable<Class<T>> r107 = r101[r104];
        Type[] r108 = r107.getBounds();
        int r109 = r108.length;
        int r112 = 0;
    L9:
        if (r112 >= r109) goto L15;
        if (C$Gson$Types.getRawType(r108[r112]).isAssignableFrom(r106) == false) goto L14;
        r112 = r112 + 1;
        goto L9
    L14:
        throw new IllegalArgumentException("Type argument " + r105 + " does not satisfy bounds for type variable " + r107 + " declared by " + r110);
    L15:
        r104 = r104 + 1;
        goto L7
    L17:
        return new TypeToken(C$Gson$Types.newParameterizedTypeWithOwner(null, r110, r111));
    L19:
        throw new IllegalArgumentException(r100.getName() + " requires " + r102 + " type arguments, but got " + r103);
    L21:
        throw new IllegalArgumentException("rawType must be of type Class, but was " + r110);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isAssignableFrom(Type r100, GenericArrayType r101) {
        Type r102 = r101.getGenericComponentType();
        if ((r102 instanceof ParameterizedType) == true) goto L5;
        return true;
    L5:
        if ((r100 instanceof GenericArrayType) == false) goto L8;
        r100 = ((GenericArrayType) r100).getGenericComponentType();
    L14:
        return isAssignableFrom(r100, (ParameterizedType) r102, new HashMap());
    L8:
        if ((r100 instanceof Class) == false) goto L14;
        r100 = (Class) r100;
    L11:
        if (r100.isArray() == false) goto L14;
        r100 = r100.getComponentType();
        goto L11
    }

    private static boolean isAssignableFrom(Type r100, ParameterizedType r110, Map<String, Type> r111) {
        int r101 = 0;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r110.equals(r100) == false) goto L8;
        return true;
    L8:
        Class<?> r102 = C$Gson$Types.getRawType(r100);
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r103 = (ParameterizedType) r100;
    L12:
        if (r103 == null) goto L24;
        Type[] r104 = r103.getActualTypeArguments();
        TypeVariable<Class<?>>[] r105 = r102.getTypeParameters();
        int r106 = 0;
    L15:
        if (r106 >= r104.length) goto L22;
        Type r107 = r104[r106];
        TypeVariable<Class<?>> r108 = r105[r106];
    L18:
        if ((r107 instanceof TypeVariable) == false) goto L20;
        r107 = r111.get(((TypeVariable) r107).getName());
        goto L18
    L20:
        r111.put(r108.getName(), r107);
        r106 = r106 + 1;
        goto L15
    L22:
        if (typeEquals(r103, r110, r111) == false) goto L24;
        return true;
    L24:
        Type[] r109 = r102.getGenericInterfaces();
        int r112 = r109.length;
    L25:
        if (r101 >= r112) goto L31;
        if (isAssignableFrom(r109[r101], r110, new HashMap(r111)) == true) goto L28;
        r101 = r101 + 1;
        goto L25
    L28:
        return true;
    L31:
        return isAssignableFrom(r102.getGenericSuperclass(), r110, new HashMap(r111));
    L11:
        r103 = null;
        goto L12
    }

    private static boolean matches(Type r100, Type r101, Map<String, Type> r102) {
        if (r101.equals(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r100 instanceof TypeVariable) == true) goto L7;
    L9:
        return false;
    L7:
        if (r101.equals(r102.get(((TypeVariable) r100).getName())) == false) goto L9;
        goto L9
    }

    private static boolean typeEquals(ParameterizedType r100, ParameterizedType r101, Map<String, Type> r102) {
        if (r100.getRawType().equals(r101.getRawType()) == false) goto L13;
        Type[] r103 = r100.getActualTypeArguments();
        Type[] r104 = r101.getActualTypeArguments();
        int r105 = 0;
    L6:
        if (r105 >= r103.length) goto L11;
        if (matches(r103[r105], r104[r105], r102) == false) goto L9;
        r105 = r105 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }
}

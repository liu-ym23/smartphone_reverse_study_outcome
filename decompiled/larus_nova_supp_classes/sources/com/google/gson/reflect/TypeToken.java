package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class TypeToken<T> {
    private final int hashCode;
    private final Class<? super T> rawType;
    private final Type type;

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }

    public TypeToken() {
        Type r0 = getTypeTokenTypeArgument();
        this.type = r0;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r0);
        this.hashCode = r0.hashCode();
    }

    private Type getTypeTokenTypeArgument() {
        Type r0 = getClass().getGenericSuperclass();
        if ((r0 instanceof ParameterizedType) == false) goto L9;
        ParameterizedType r1 = (ParameterizedType) r0;
        if (r1.getRawType() != TypeToken.class) goto L13;
        return C$Gson$Types.canonicalize(r1.getActualTypeArguments()[0]);
    L13:
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    L9:
        if (r0 != TypeToken.class) goto L13;
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

    private TypeToken(Type r2) {
        Objects.requireNonNull(r2);
        Type r3 = C$Gson$Types.canonicalize(r2);
        this.type = r3;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(r3);
        this.hashCode = r3.hashCode();
    }

    public static <T> TypeToken<T> get(Class<T> r1) {
        return new TypeToken(r1);
    }

    public static TypeToken<?> getArray(Type r1) {
        return new TypeToken(C$Gson$Types.arrayOf(r1));
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof TypeToken) == true) goto L5;
    L7:
        return false;
    L5:
        if (C$Gson$Types.equals(this.type, ((TypeToken) r2).type) == false) goto L7;
        return true;
    }

    public boolean isAssignableFrom(Type r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this.type.equals(r5) == false) goto L8;
        return true;
    L8:
        Type r1 = this.type;
        if ((r1 instanceof Class) == false) goto L13;
        return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r5));
    L13:
        if ((r1 instanceof ParameterizedType) == false) goto L17;
        return isAssignableFrom(r5, (ParameterizedType) r1, new HashMap());
    L17:
        if ((r1 instanceof GenericArrayType) == false) goto L25;
        if (this.rawType.isAssignableFrom(C$Gson$Types.getRawType(r5)) == true) goto L21;
        return false;
    L21:
        if (isAssignableFrom(r5, (GenericArrayType) this.type) == false) goto L27;
        return true;
    L27:
        return false;
    L25:
        throw buildUnexpectedTypeError(r1, new Class[]{Class.class, ParameterizedType.class, GenericArrayType.class});
    }

    public static TypeToken<?> get(Type r1) {
        return new TypeToken(r1);
    }

    public boolean isAssignableFrom(TypeToken<?> r1) {
        return isAssignableFrom(r1.getType());
    }

    public boolean isAssignableFrom(Class<?> r1) {
        return isAssignableFrom(r1);
    }

    private static AssertionError buildUnexpectedTypeError(Type r4, Class<?>... r5) {
        StringBuilder r0 = new StringBuilder("Unexpected type. Expected one of: ");
        int r1 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.append(r5[r2].getName());
        r0.append(", ");
        r2 = r2 + 1;
        goto L3
    L5:
        r0.append("but got: ");
        r0.append(r4.getClass().getName());
        r0.append(", for type token: ");
        r0.append(r4.toString());
        r0.append('.');
        return new AssertionError(r0.toString());
    }

    public static TypeToken<?> getParameterized(Type r11, Type... r12) {
        Objects.requireNonNull(r11);
        Objects.requireNonNull(r12);
        if ((r11 instanceof Class) == false) goto L21;
        Class r0 = (Class) r11;
        TypeVariable<Class<T>>[] r1 = r0.getTypeParameters();
        int r2 = r1.length;
        int r3 = r12.length;
        if (r3 != r2) goto L19;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L17;
        Type r5 = r12[r4];
        Class<?> r6 = C$Gson$Types.getRawType(r5);
        TypeVariable<Class<T>> r7 = r1[r4];
        Type[] r8 = r7.getBounds();
        int r9 = r8.length;
        int r10 = 0;
    L9:
        if (r10 >= r9) goto L15;
        if (C$Gson$Types.getRawType(r8[r10]).isAssignableFrom(r6) == false) goto L14;
        r10 = r10 + 1;
        goto L9
    L14:
        throw new IllegalArgumentException("Type argument " + r5 + " does not satisfy bounds for type variable " + r7 + " declared by " + r11);
    L15:
        r4 = r4 + 1;
        goto L7
    L17:
        return new TypeToken(C$Gson$Types.newParameterizedTypeWithOwner(null, r11, r12));
    L19:
        throw new IllegalArgumentException(r0.getName() + " requires " + r2 + " type arguments, but got " + r3);
    L21:
        throw new IllegalArgumentException("rawType must be of type Class, but was " + r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r1v9 */
    private static boolean isAssignableFrom(Type r1, GenericArrayType r2) {
        Type r3 = r2.getGenericComponentType();
        if ((r3 instanceof ParameterizedType) == true) goto L5;
        return true;
    L5:
        if ((r1 instanceof GenericArrayType) == false) goto L8;
        r1 = ((GenericArrayType) r1).getGenericComponentType();
    L14:
        return isAssignableFrom(r1, (ParameterizedType) r3, new HashMap());
    L8:
        if ((r1 instanceof Class) == false) goto L14;
        r1 = (Class) r1;
    L11:
        if (r1.isArray() == false) goto L14;
        r1 = r1.getComponentType();
        goto L11
    }

    private static boolean isAssignableFrom(Type r9, ParameterizedType r10, Map<String, Type> r11) {
        int r0 = 0;
        if (r9 != null) goto L6;
        return false;
    L6:
        if (r10.equals(r9) == false) goto L8;
        return true;
    L8:
        Class<?> r1 = C$Gson$Types.getRawType(r9);
        if ((r9 instanceof ParameterizedType) == false) goto L11;
        ParameterizedType r12 = (ParameterizedType) r9;
    L12:
        if (r12 == null) goto L24;
        Type[] r3 = r12.getActualTypeArguments();
        TypeVariable<Class<?>>[] r4 = r1.getTypeParameters();
        int r5 = 0;
    L15:
        if (r5 >= r3.length) goto L22;
        Type r6 = r3[r5];
        TypeVariable<Class<?>> r7 = r4[r5];
    L18:
        if ((r6 instanceof TypeVariable) == false) goto L20;
        r6 = r11.get(((TypeVariable) r6).getName());
        goto L18
    L20:
        r11.put(r7.getName(), r6);
        r5 = r5 + 1;
        goto L15
    L22:
        if (typeEquals(r12, r10, r11) == false) goto L24;
        return true;
    L24:
        Type[] r13 = r1.getGenericInterfaces();
        int r8 = r13.length;
    L25:
        if (r0 >= r8) goto L31;
        if (isAssignableFrom(r13[r0], r10, new HashMap(r11)) == true) goto L28;
        r0 = r0 + 1;
        goto L25
    L28:
        return true;
    L31:
        return isAssignableFrom(r1.getGenericSuperclass(), r10, new HashMap(r11));
    L11:
        r12 = null;
        goto L12
    }

    private static boolean matches(Type r1, Type r2, Map<String, Type> r3) {
        if (r2.equals(r1) == false) goto L5;
    L10:
        return true;
    L5:
        if ((r1 instanceof TypeVariable) == true) goto L7;
    L9:
        return false;
    L7:
        if (r2.equals(r3.get(((TypeVariable) r1).getName())) == false) goto L9;
        goto L9
    }

    private static boolean typeEquals(ParameterizedType r4, ParameterizedType r5, Map<String, Type> r6) {
        if (r4.getRawType().equals(r5.getRawType()) == false) goto L13;
        Type[] r7 = r4.getActualTypeArguments();
        Type[] r8 = r5.getActualTypeArguments();
        int r0 = 0;
    L6:
        if (r0 >= r7.length) goto L11;
        if (matches(r7[r0], r8[r0], r6) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }
}

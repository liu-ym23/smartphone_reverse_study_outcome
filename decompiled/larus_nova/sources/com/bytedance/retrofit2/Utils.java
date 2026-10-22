package com.bytedance.retrofit2;

import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
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
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
public final class Utils {
    private static final int BUFFER_SIZE = 4096;
    static final Type[] EMPTY_TYPE_ARRAY = null;

    /* JADX INFO: loaded from: classes6.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Utils.typeToString(this.componentType) + "[]";
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public GenericArrayTypeImpl(Type r100) {
            this.componentType = r100;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof GenericArrayType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (GenericArrayType) r100) == false) goto L7;
            return true;
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {

        @Nullable
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public int hashCode() {
            int r100 = Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode();
            Type r101 = this.ownerType;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 ^ r102;
        L5:
            r102 = 0;
            goto L7
        }

        public String toString() {
            int r100 = 1;
            StringBuilder r101 = new StringBuilder((this.typeArguments.length + 1) * 30);
            r101.append(Utils.typeToString(this.rawType));
            if (this.typeArguments.length == 0) goto L5;
            r101.append("<");
            r101.append(Utils.typeToString(this.typeArguments[0]));
        L8:
            if (r100 >= this.typeArguments.length) goto L10;
            r101.append(", ");
            r101.append(Utils.typeToString(this.typeArguments[r100]));
            r100 = r100 + 1;
            goto L8
        L10:
            r101.append(">");
            return r101.toString();
        L5:
            return r101.toString();
        }

        @Override // java.lang.reflect.ParameterizedType
        @Nullable
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof ParameterizedType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (ParameterizedType) r100) == false) goto L7;
            return true;
        }

        public ParameterizedTypeImpl(@Nullable Type r100, Type r101, Type... r102) {
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
            this.ownerType = r100;
            this.rawType = r101;
            this.typeArguments = (Type[]) r102.clone();
            int r106 = r102.length;
        L17:
            if (r103 >= r106) goto L19;
            Type r107 = r102[r103];
            Utils.checkNotNull(r107, "typeArgument == null");
            Utils.checkNotPrimitive(r107);
            r103 = r103 + 1;
            goto L17
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class WildcardTypeImpl implements WildcardType {

        @Nullable
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
            return Utils.EMPTY_TYPE_ARRAY;
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
            return "? super " + Utils.typeToString(this.lowerBound);
        L7:
            if (this.upperBound != Object.class) goto L11;
            return "?";
        L11:
            return "? extends " + Utils.typeToString(this.upperBound);
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof WildcardType) == true) goto L5;
        L7:
            return false;
        L5:
            if (Utils.equals(this, (WildcardType) r100) == false) goto L7;
            return true;
        }

        public WildcardTypeImpl(Type[] r100, Type[] r101) {
            if (r101.length > 1) goto L24;
            if (r100.length != 1) goto L22;
            if (r101.length != 1) goto L16;
            Type r102 = r101[0];
            if (r102 == null) goto L15;
            Utils.checkNotPrimitive(r102);
            if (r100[0] != Object.class) goto L14;
            this.lowerBound = r101[0];
            this.upperBound = Object.class;
            return;
        L14:
            throw new IllegalArgumentException();
        L15:
            throw null;
        L16:
            Type r103 = r100[0];
            if (r103 == null) goto L20;
            Utils.checkNotPrimitive(r103);
            this.lowerBound = null;
            this.upperBound = r100[0];
            return;
        L20:
            throw null;
        L22:
            throw new IllegalArgumentException();
        L24:
            throw new IllegalArgumentException();
        }
    }

    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private Utils() {
    }

    public static void checkNotPrimitive(Type r100) {
        if ((r100 instanceof Class) == true) goto L5;
        return;
    L5:
        if (((Class) r100).isPrimitive() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException();
    }

    public static TypedOutput convert(final RequestBody r100) {
        return new AnonymousClass1(r100);
    }

    @Nullable
    private static Class<?> declaringClassOf(TypeVariable<?> r100) {
        GenericDeclaration r101 = r100.getGenericDeclaration();
        if ((r101 instanceof Class) == true) goto L7;
        return null;
    L7:
        return (Class) r101;
    }

    public static Type getCallResponseType(Type r100) {
        if ((r100 instanceof ParameterizedType) == false) goto L7;
        return getParameterUpperBound(0, (ParameterizedType) r100);
    L7:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }

    public static Class<?> getRawType(Type r100) {
        checkNotNull(r100, "type == null");
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
        return Array.newInstance(getRawType(((GenericArrayType) r100).getGenericComponentType()), 0).getClass();
    L19:
        if ((r100 instanceof TypeVariable) == false) goto L23;
        return Object.class;
    L23:
        if ((r100 instanceof WildcardType) == false) goto L27;
        return getRawType(((WildcardType) r100).getUpperBounds()[0]);
    L27:
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + r100 + "> is of type " + r100.getClass().getName());
    }

    public static boolean hasUnresolvableType(@Nullable Type r100) {
        if ((r100 instanceof Class) == false) goto L6;
        return false;
    L6:
        if ((r100 instanceof ParameterizedType) == false) goto L15;
        Type[] r101 = ((ParameterizedType) r100).getActualTypeArguments();
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L13;
        if (hasUnresolvableType(r101[r103]) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    L13:
        return false;
    L15:
        if ((r100 instanceof GenericArrayType) == false) goto L19;
        return hasUnresolvableType(((GenericArrayType) r100).getGenericComponentType());
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

    public static boolean permitsRequestBody(String r100) {
        if (requiresRequestBody(r100) == false) goto L5;
    L16:
        return true;
    L5:
        if (r100.equals("OPTIONS") == true) goto L16;
        if (r100.equals("DELETE") == true) goto L16;
        if (r100.equals(OpenNetMethod.PROPFIND) == true) goto L16;
        if (r100.equals(OpenNetMethod.MKCOL) == true) goto L16;
        if (r100.equals(OpenNetMethod.LOCK) == true) goto L16;
        return false;
    }

    public static boolean requiresRequestBody(String r100) {
        if (r100.equals("POST") == false) goto L5;
    L14:
        return true;
    L5:
        if (r100.equals("PUT") == true) goto L14;
        if (r100.equals("PATCH") == true) goto L14;
        if (r100.equals(OpenNetMethod.PROPPATCH) == true) goto L14;
        if (r100.equals(OpenNetMethod.REPORT) == true) goto L14;
        return false;
    }

    public static byte[] streamToBytes(@Nullable InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        if (r100 == null) goto L9;
        byte[] r102 = new byte[4096];
    L5:
        int r103 = r100.read(r102);
        if (r103 == (-1)) goto L9;
        r101.write(r102, 0, r103);
    L9:
        return r101.toByteArray();
    }

    public static void throwIfFatal(Throwable r100) {
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

    public static String typeToString(Type r100) {
        if ((r100 instanceof Class) == false) goto L6;
        return ((Class) r100).getName();
    L6:
        return r100.toString();
    }

    public static <T> void validateServiceInterface(Class<T> r100) {
        if (r100.isInterface() == false) goto L10;
        if (r100.getInterfaces().length > 0) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
    L10:
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public static <T> T checkNotNull(@Nullable T r100, String r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(r101);
    }

    public static boolean equals(Type r100, Type r101) {
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
        return equals(((GenericArrayType) r100).getGenericComponentType(), ((GenericArrayType) r101).getGenericComponentType());
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

    public static Type getParameterLowerBound(int r100, ParameterizedType r101) {
        Type r102 = r101.getActualTypeArguments()[r100];
        if ((r102 instanceof WildcardType) == true) goto L5;
        return r102;
    L5:
        return ((WildcardType) r102).getLowerBounds()[0];
    }

    public static Type getParameterUpperBound(int r100, ParameterizedType r101) {
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

    private static int indexOf(Object[] r100, Object r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        if (r101.equals(r100[r102]) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return r102;
    L10:
        throw new NoSuchElementException();
    }

    public static boolean isAnnotationPresent(Annotation[] r100, Class<? extends Annotation> r101) {
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101.isInstance(r100[r103]) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static Type getGenericSupertype(Type r100, Class<?> r101, Class<?> r102) {
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

    public static Type getSupertype(Type r100, Class<?> r101, Class<?> r102) {
        if (r102.isAssignableFrom(r101) == false) goto L7;
        return resolve(r100, r101, getGenericSupertype(r100, r101, r102));
    L7:
        throw new IllegalArgumentException();
    }

    public static RuntimeException methodError(Method r100, String r101, Object... r102) {
        return methodError(r100, null, r101, r102);
    }

    public static Type resolve(Type r100, Class<?> r101, Type r110) {
    L3:
        if ((r10 instanceof TypeVariable) == false) goto L9;
        TypeVariable r111 = (TypeVariable) r10;
        Type r102 = resolveTypeVariable(r100, r101, r111);
        if (r102 == r111) goto L6;
        Type r112 = r102;
        goto L3
    L6:
        return r102;
    L9:
        if ((r112 instanceof Class) == false) goto L18;
        Class r103 = (Class) r112;
        if (r103.isArray() == false) goto L18;
        Class<?> r113 = r103.getComponentType();
        Type r104 = resolve(r100, r101, r113);
        if (r113 != r104) goto L16;
        return r103;
    L16:
        return new GenericArrayTypeImpl(r104);
    L18:
        if ((r112 instanceof GenericArrayType) == false) goto L24;
        GenericArrayType r114 = (GenericArrayType) r112;
        Type r105 = r114.getGenericComponentType();
        Type r106 = resolve(r100, r101, r105);
        if (r105 != r106) goto L23;
        return r114;
    L23:
        return new GenericArrayTypeImpl(r106);
    L24:
        int r107 = 0;
        if ((r112 instanceof ParameterizedType) == false) goto L41;
        ParameterizedType r115 = (ParameterizedType) r112;
        Type r108 = r115.getOwnerType();
        Type r109 = resolve(r100, r101, r108);
        if (r109 == r108) goto L29;
        boolean r116 = true;
    L30:
        Type[] r117 = r115.getActualTypeArguments();
        int r118 = r117.length;
    L31:
        if (r107 >= r118) goto L38;
        Type r119 = resolve(r100, r101, r117[r107]);
        if (r119 == r117[r107]) goto L37;
        if (r116 == true) goto L36;
        r117 = (Type[]) r117.clone();
        r116 = true;
    L36:
        r117[r107] = r119;
    L37:
        r107 = r107 + 1;
        goto L31
    L38:
        if (r116 == true) goto L40;
        return r115;
    L40:
        return new ParameterizedTypeImpl(r109, r115.getRawType(), r117);
    L29:
        r116 = false;
        goto L30
    L41:
        boolean r120 = r112 instanceof WildcardType;
        Type r121 = r112;
        if (r120 == false) goto L57;
        WildcardType r122 = (WildcardType) r112;
        Type[] r123 = r122.getLowerBounds();
        Type[] r124 = r122.getUpperBounds();
        if (r123.length != 1) goto L49;
        Type r125 = resolve(r100, r101, r123[0]);
        r121 = r122;
        if (r125 == r123[0]) goto L57;
        return new WildcardTypeImpl(new Type[]{Object.class}, new Type[]{r125});
    L49:
        r121 = r122;
        if (r124.length != 1) goto L57;
        Type r126 = resolve(r100, r101, r124[0]);     // Catch: Throwable -> L58
        r121 = r122;
        if (r126 == r124[0]) goto L57;
        return new WildcardTypeImpl(new Type[]{r126}, EMPTY_TYPE_ARRAY);
    L58:
        th = move-exception;
        throw th;
    L57:
        return r121;
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

    public static RuntimeException methodError(Method r100, @Nullable Throwable r101, String r102, Object... r103) {
        return new IllegalArgumentException(String.format(r102, r103) + "\n    for method " + r100.getDeclaringClass().getSimpleName() + "." + r100.getName(), r101);
    }

    public static RuntimeException parameterError(Method r100, int r101, String r102, Object... r103) {
        return methodError(r100, r102 + " (parameter #" + (r101 + 1) + ")", r103);
    }

    public static RuntimeException parameterError(Method r100, Throwable r101, int r102, String r103, Object... r104) {
        return methodError(r100, r101, r103 + " (parameter #" + (r102 + 1) + ")", r104);
    }
}

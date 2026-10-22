package org.apache.commons.lang3.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.text.Typography;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes42.dex */
public class TypeUtils {
    public static final WildcardType WILDCARD_ALL = null;

    /* JADX INFO: renamed from: org.apache.commons.lang3.reflect.TypeUtils$1, reason: invalid class name */
    final class AnonymousClass1 implements Typed<Object> {
        final /* synthetic */ Type val$type;

        @Override // org.apache.commons.lang3.reflect.Typed
        public Type getType() {
            return this.val$type;
        }
    }

    public static class WildcardTypeBuilder {
        private Type[] lowerBounds;
        private Type[] upperBounds;

        public WildcardType build() {
            return new WildcardTypeImpl(this.upperBounds, this.lowerBounds, null);
        }

        private WildcardTypeBuilder() {
        }

        public /* synthetic */ WildcardTypeBuilder(AnonymousClass1 r100) {
            this();
        }

        public WildcardTypeBuilder withUpperBounds(Type... r100) {
            this.upperBounds = r100;
            return this;
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {
        private static final Type[] EMPTY_BOUNDS = null;
        private final Type[] lowerBounds;
        private final Type[] upperBounds;

        static {
            EMPTY_BOUNDS = new Type[0];
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return (Type[]) this.lowerBounds.clone();
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return (Type[]) this.upperBounds.clone();
        }

        public int hashCode() {
            return ((Arrays.hashCode(this.upperBounds) | 18688) << 8) | Arrays.hashCode(this.lowerBounds);
        }

        public String toString() {
            return TypeUtils.toString(this);
        }

        public boolean equals(Object r100) {
            if (r100 != this) goto L4;
        L9:
            return true;
        L4:
            if ((r100 instanceof WildcardType) == true) goto L6;
        L8:
            return false;
        L6:
            if (TypeUtils.access$300(this, (WildcardType) r100) == false) goto L8;
            goto L8
        }

        private WildcardTypeImpl(Type[] r100, Type[] r101) {
            Type[] r102 = EMPTY_BOUNDS;
            this.upperBounds = (Type[]) ObjectUtils.defaultIfNull(r100, r102);
            this.lowerBounds = (Type[]) ObjectUtils.defaultIfNull(r101, r102);
        }

        public /* synthetic */ WildcardTypeImpl(Type[] r100, Type[] r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static WildcardTypeBuilder wildcardType() {
        return new WildcardTypeBuilder(null);
    }

    static {
        WILDCARD_ALL = wildcardType().withUpperBounds(new Type[]{Object.class}).build();
    }

    private static String classToString(Class<?> r100) {
        if (r100.isArray() == true) goto L5;
        StringBuilder r101 = new StringBuilder();
        if (r100.getEnclosingClass() == null) goto L9;
        r101.append(classToString(r100.getEnclosingClass()));
        r101.append('.');
        r101.append(r100.getSimpleName());
    L11:
        if (r100.getTypeParameters().length <= 0) goto L14;
        r101.append(Typography.less);
        appendAllTo(r101, ", ", r100.getTypeParameters());
        r101.append(Typography.greater);
    L14:
        return r101.toString();
    L9:
        r101.append(r100.getName());
        goto L11
    L5:
        return toString(r100.getComponentType()) + "[]";
    }

    private static int[] findRecursiveTypes(ParameterizedType r100) {
        Type[] r101 = (Type[]) Arrays.copyOf(r100.getActualTypeArguments(), r100.getActualTypeArguments().length);
        int r102 = 0;
        int[] r103 = new int[0];
    L4:
        if (r102 >= r101.length) goto L11;
        Type r104 = r101[r102];
        if ((r104 instanceof TypeVariable) == false) goto L10;
        if (containsVariableTypeSameParametrizedTypeBound((TypeVariable) r104, r100) == false) goto L10;
        r103 = ArrayUtils.add(r103, r102);
    L10:
        r102 = r102 + 1;
        goto L4
    L11:
        return r103;
    }

    private static String genericArrayTypeToString(GenericArrayType r100) {
        return String.format("%s[]", new Object[]{toString(r100.getGenericComponentType())});
    }

    public static Type[] getImplicitBounds(TypeVariable<?> r100) {
        Validate.notNull(r100, "typeVariable is null", new Object[0]);
        Type[] r101 = r100.getBounds();
        if (r101.length != 0) goto L6;
        return new Type[]{Object.class};
    L6:
        return normalizeUpperBounds(r101);
    }

    public static Type[] getImplicitLowerBounds(WildcardType r100) {
        Validate.notNull(r100, "wildcardType is null", new Object[0]);
        Type[] r101 = r100.getLowerBounds();
        if (r101.length == 0) goto L5;
        return r101;
    L5:
        return new Type[]{null};
    }

    public static Type[] getImplicitUpperBounds(WildcardType r100) {
        Validate.notNull(r100, "wildcardType is null", new Object[0]);
        Type[] r101 = r100.getUpperBounds();
        if (r101.length != 0) goto L6;
        return new Type[]{Object.class};
    L6:
        return normalizeUpperBounds(r101);
    }

    private static Class<?> getRawType(ParameterizedType r100) {
        Type r101 = r100.getRawType();
        if ((r101 instanceof Class) == false) goto L7;
        return (Class) r101;
    L7:
        throw new IllegalStateException("Wait... What!? Type of rawType: " + r101);
    }

    public static Type[] normalizeUpperBounds(Type[] r100) {
        Validate.notNull(r100, "null value specified for bounds array", new Object[0]);
        if (r100.length >= 2) goto L5;
        return r100;
    L5:
        HashSet r101 = new HashSet(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L20;
        Type r104 = r100[r103];
        int r105 = r100.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L15;
        Type r107 = r100[r106];
        if (r104 == r107) goto L14;
        if (isAssignable(r107, r104, null) == false) goto L14;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L18;
        r101.add(r104);
    L18:
        r103 = r103 + 1;
    L14:
        r106 = r106 + 1;
        goto L8
    L15:
        r108 = false;
        goto L16
    L20:
        return (Type[]) r101.toArray(new Type[r101.size()]);
    }

    private static String parameterizedTypeToString(ParameterizedType r100) {
        StringBuilder r101 = new StringBuilder();
        Type r102 = r100.getOwnerType();
        Class r103 = (Class) r100.getRawType();
        if (r102 != null) goto L6;
        r101.append(r103.getName());
    L10:
        int[] r104 = findRecursiveTypes(r100);
        if (r104.length <= 0) goto L13;
        appendRecursiveTypes(r101, r104, r100.getActualTypeArguments());
    L15:
        return r101.toString();
    L13:
        r101.append(Typography.less);
        appendAllTo(r101, ", ", r100.getActualTypeArguments()).append(Typography.greater);
        goto L15
    L6:
        if ((r102 instanceof Class) == false) goto L8;
        r101.append(((Class) r102).getName());
    L9:
        r101.append('.');
        r101.append(r103.getSimpleName());
        goto L10
    L8:
        r101.append(r102.toString());
        goto L9
    }

    public static String toString(Type r100) {
        Validate.notNull(r100);
        if ((r100 instanceof Class) == false) goto L7;
        return classToString((Class) r100);
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        return parameterizedTypeToString((ParameterizedType) r100);
    L11:
        if ((r100 instanceof WildcardType) == false) goto L15;
        return wildcardTypeToString((WildcardType) r100);
    L15:
        if ((r100 instanceof TypeVariable) == false) goto L19;
        return typeVariableToString((TypeVariable) r100);
    L19:
        if ((r100 instanceof GenericArrayType) == false) goto L23;
        return genericArrayTypeToString((GenericArrayType) r100);
    L23:
        throw new IllegalArgumentException(ObjectUtils.identityToString(r100));
    }

    private static String typeVariableToString(TypeVariable<?> r100) {
        StringBuilder r101 = new StringBuilder(r100.getName());
        Type[] r102 = r100.getBounds();
        if (r102.length <= 0) goto L10;
        if (r102.length == 1) goto L7;
    L8:
        r101.append(" extends ");
        appendAllTo(r101, " & ", r100.getBounds());
        goto L10
    L7:
        if (Object.class.equals(r102[0]) == false) goto L8;
    L10:
        return r101.toString();
    }

    private static String wildcardTypeToString(WildcardType r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append('?');
        Type[] r102 = r100.getLowerBounds();
        Type[] r103 = r100.getUpperBounds();
        if (r102.length <= 1) goto L5;
    L16:
        r101.append(" super ");
        appendAllTo(r101, " & ", r102);
    L18:
        return r101.toString();
    L5:
        if (r102.length != 1) goto L10;
        if (r102[0] != null) goto L16;
    L10:
        if (r103.length <= 1) goto L12;
    L15:
        r101.append(" extends ");
        appendAllTo(r101, " & ", r103);
        goto L18
    L12:
        if (r103.length != 1) goto L18;
        if (Object.class.equals(r103[0]) == true) goto L18;
        goto L15
    }

    private static <T> String toString(T r100) {
        if ((r100 instanceof Type) == false) goto L6;
        return toString((Type) r100);
    L6:
        return r100.toString();
    }

    public static /* synthetic */ boolean access$300(WildcardType r100, Type r101) {
        return equals(r100, r101);
    }

    private static boolean containsVariableTypeSameParametrizedTypeBound(TypeVariable<?> r100, ParameterizedType r101) {
        return ArrayUtils.contains(r100.getBounds(), r101);
    }

    private static boolean equals(ParameterizedType r100, Type r101) {
        if ((r101 instanceof ParameterizedType) == false) goto L10;
        ParameterizedType r102 = (ParameterizedType) r101;
        if (equals(r100.getRawType(), r102.getRawType()) == true) goto L7;
        return false;
    L7:
        if (equals(r100.getOwnerType(), r102.getOwnerType()) == true) goto L9;
        return false;
    L9:
        return equals(r100.getActualTypeArguments(), r102.getActualTypeArguments());
    L10:
        return false;
    }

    private static Type getClosestParentType(Class<?> r100, Class<?> r101) {
        if (r101.isInterface() == false) goto L23;
        Type[] r102 = r100.getGenericInterfaces();
        int r103 = r102.length;
        Type r104 = null;
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L20;
        Type r106 = r102[r105];
        if ((r106 instanceof ParameterizedType) == false) goto L10;
        Class<?> r107 = getRawType((ParameterizedType) r106);
    L13:
        if (isAssignable(r107, r101) == false) goto L17;
        if (isAssignable(r104, r107) == false) goto L17;
        r104 = r106;
    L17:
        r105 = r105 + 1;
        goto L5
    L10:
        if ((r106 instanceof Class) == false) goto L19;
        r107 = (Class) r106;
        goto L13
    L19:
        throw new IllegalStateException("Unexpected generic interface type found: " + r106);
    L20:
        if (r104 == null) goto L23;
        return r104;
    L23:
        return r100.getGenericSuperclass();
    }

    public static Map<TypeVariable<?>, Type> getTypeArguments(Type r100, Class<?> r101) {
        return getTypeArguments(r100, r101, null);
    }

    private static boolean isAssignable(Type r100, Class<?> r101) {
        if (r100 != null) goto L10;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r101.isPrimitive() == false) goto L51;
        return false;
    L51:
        return true;
    L10:
        if (r101 != null) goto L13;
        return false;
    L13:
        if (r101.equals(r100) == false) goto L16;
        return true;
    L16:
        if ((r100 instanceof Class) == false) goto L20;
        return ClassUtils.isAssignable((Class) r100, r101);
    L20:
        if ((r100 instanceof ParameterizedType) == false) goto L24;
        return isAssignable(getRawType((ParameterizedType) r100), r101);
    L24:
        if ((r100 instanceof TypeVariable) == false) goto L33;
        Type[] r102 = ((TypeVariable) r100).getBounds();
        int r103 = r102.length;
        int r104 = 0;
    L26:
        if (r104 >= r103) goto L31;
        if (isAssignable(r102[r104], r101) == true) goto L29;
        r104 = r104 + 1;
        goto L26
    L29:
        return true;
    L31:
        return false;
    L33:
        if ((r100 instanceof GenericArrayType) == false) goto L44;
        if (r101.equals(Object.class) == false) goto L37;
        return true;
    L37:
        if (r101.isArray() == true) goto L39;
    L41:
        return false;
    L39:
        if (isAssignable(((GenericArrayType) r100).getGenericComponentType(), r101.getComponentType()) == false) goto L41;
        return true;
    L44:
        if ((r100 instanceof WildcardType) == false) goto L47;
        return false;
    L47:
        throw new IllegalStateException("found an unhandled type: " + r100);
    }

    private static Type substituteTypeVariables(Type r100, Map<TypeVariable<?>, Type> r101) {
        if ((r100 instanceof TypeVariable) == false) goto L10;
        if (r101 == null) goto L10;
        Type r102 = r101.get(r100);
        if (r102 == null) goto L9;
        return r102;
    L9:
        throw new IllegalArgumentException("missing assignment type for type variable " + r100);
    L10:
        return r100;
    }

    private static Type unrollVariableAssignments(TypeVariable<?> r100, Map<TypeVariable<?>, Type> r101) {
    L2:
        Type r102 = r101.get(r100);
        if ((r102 instanceof TypeVariable) == false) goto L7;
        if (r102.equals(r100) == true) goto L7;
        r100 = (TypeVariable) r102;
    L7:
        return r102;
    }

    public static boolean equals(Type r100, Type r101) {
        if (Objects.equals(r100, r101) == false) goto L7;
        return true;
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        return equals((ParameterizedType) r100, r101);
    L11:
        if ((r100 instanceof GenericArrayType) == false) goto L15;
        return equals((GenericArrayType) r100, r101);
    L15:
        if ((r100 instanceof WildcardType) == true) goto L17;
        return false;
    L17:
        return equals((WildcardType) r100, r101);
    }

    public static boolean isAssignable(Type r100, Type r101) {
        return isAssignable(r100, r101, null);
    }

    private static boolean equals(WildcardType r100, Type r101) {
        if ((r101 instanceof WildcardType) == false) goto L10;
        WildcardType r102 = (WildcardType) r101;
        if (equals(getImplicitLowerBounds(r100), getImplicitLowerBounds(r102)) == true) goto L7;
        return false;
    L7:
        if (equals(getImplicitUpperBounds(r100), getImplicitUpperBounds(r102)) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private static boolean equals(Type[] r100, Type[] r101) {
        if (r100.length != r101.length) goto L13;
        int r102 = 0;
    L6:
        if (r102 >= r100.length) goto L11;
        if (equals(r100[r102], r101[r102]) == false) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }

    private static boolean equals(GenericArrayType r100, Type r101) {
        if ((r101 instanceof GenericArrayType) == true) goto L5;
    L7:
        return false;
    L5:
        if (equals(r100.getGenericComponentType(), ((GenericArrayType) r101).getGenericComponentType()) == false) goto L7;
        return true;
    }

    private static <T> StringBuilder appendAllTo(StringBuilder r100, String r101, T... r102) {
        Validate.notEmpty(Validate.noNullElements(r102));
        if (r102.length <= 0) goto L8;
        r100.append(toString(r102[0]));
        int r103 = 1;
    L6:
        if (r103 >= r102.length) goto L8;
        r100.append(r101);
        r100.append(toString(r102[r103]));
        r103 = r103 + 1;
    L8:
        return r100;
    }

    private static void appendRecursiveTypes(StringBuilder r100, int[] r101, Type[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L6;
        r100.append(Typography.less);
        appendAllTo(r100, ", ", new String[]{r102[r103].toString()}).append(Typography.greater);
        r103 = r103 + 1;
        goto L4
    L6:
        Type[] r104 = (Type[]) ArrayUtils.removeAll(r102, r101);
        if (r104.length <= 0) goto L11;
        r100.append(Typography.less);
        appendAllTo(r100, ", ", r104).append(Typography.greater);
        return;
    }

    private static Map<TypeVariable<?>, Type> getTypeArguments(Type r100, Class<?> r101, Map<TypeVariable<?>, Type> r102) {
        if ((r100 instanceof Class) == false) goto L7;
        return getTypeArguments((Class) r100, r101, r102);
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        return getTypeArguments((ParameterizedType) r100, r101, r102);
    L11:
        if ((r100 instanceof GenericArrayType) == false) goto L17;
        Type r103 = ((GenericArrayType) r100).getGenericComponentType();
        if (r101.isArray() == false) goto L16;
        r101 = r101.getComponentType();
    L16:
        return getTypeArguments(r103, r101, r102);
    L17:
        int r104 = 0;
        if ((r100 instanceof WildcardType) == false) goto L28;
        Type[] r105 = getImplicitUpperBounds((WildcardType) r100);
        int r106 = r105.length;
    L20:
        if (r104 >= r106) goto L26;
        Type r107 = r105[r104];
        if (isAssignable(r107, r101) == true) goto L24;
        r104 = r104 + 1;
        goto L20
    L24:
        return getTypeArguments(r107, r101, r102);
    L26:
        return null;
    L28:
        if ((r100 instanceof TypeVariable) == false) goto L38;
        Type[] r108 = getImplicitBounds((TypeVariable) r100);
        int r109 = r108.length;
    L30:
        if (r104 >= r109) goto L36;
        Type r110 = r108[r104];
        if (isAssignable(r110, r101) == true) goto L34;
        r104 = r104 + 1;
        goto L30
    L34:
        return getTypeArguments(r110, r101, r102);
    L36:
        return null;
    L38:
        throw new IllegalStateException("found an unhandled type: " + r100);
    }

    private static boolean isAssignable(Type r100, GenericArrayType r101, Map<TypeVariable<?>, Type> r102) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.equals(r100) == false) goto L11;
        return true;
    L11:
        Type r103 = r101.getGenericComponentType();
        if ((r100 instanceof Class) == false) goto L21;
        Class r104 = (Class) r100;
        if (r104.isArray() == true) goto L16;
    L18:
        return false;
    L16:
        if (isAssignable(r104.getComponentType(), r103, r102) == false) goto L18;
        return true;
    L21:
        if ((r100 instanceof GenericArrayType) == false) goto L25;
        return isAssignable(((GenericArrayType) r100).getGenericComponentType(), r103, r102);
    L25:
        if ((r100 instanceof WildcardType) == false) goto L34;
        Type[] r105 = getImplicitUpperBounds((WildcardType) r100);
        int r106 = r105.length;
        int r107 = 0;
    L27:
        if (r107 >= r106) goto L32;
        if (isAssignable(r105[r107], r101) == true) goto L30;
        r107 = r107 + 1;
        goto L27
    L30:
        return true;
    L32:
        return false;
    L34:
        if ((r100 instanceof TypeVariable) == false) goto L43;
        Type[] r108 = getImplicitBounds((TypeVariable) r100);
        int r109 = r108.length;
        int r110 = 0;
    L36:
        if (r110 >= r109) goto L41;
        if (isAssignable(r108[r110], r101) == true) goto L39;
        r110 = r110 + 1;
        goto L36
    L39:
        return true;
    L41:
        return false;
    L43:
        if ((r100 instanceof ParameterizedType) == false) goto L46;
        return false;
    L46:
        throw new IllegalStateException("found an unhandled type: " + r100);
    }

    private static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType r100, Class<?> r101, Map<TypeVariable<?>, Type> r102) {
        Class<?> r103 = getRawType(r100);
        if (isAssignable(r103, r101) == true) goto L6;
        return null;
    L6:
        Type r104 = r100.getOwnerType();
        if ((r104 instanceof ParameterizedType) == false) goto L9;
        ParameterizedType r105 = (ParameterizedType) r104;
        Map<TypeVariable<?>, Type> r106 = getTypeArguments(r105, getRawType(r105), r102);
    L12:
        Type[] r107 = r100.getActualTypeArguments();
        TypeVariable<Class<?>>[] r108 = r103.getTypeParameters();
        int r109 = 0;
    L14:
        if (r109 >= r108.length) goto L20;
        Type r110 = r107[r109];
        TypeVariable<Class<?>> r111 = r108[r109];
        if (r106.containsKey(r110) == false) goto L18;
        r110 = r106.get(r110);
    L18:
        r106.put(r111, r110);
        r109 = r109 + 1;
        goto L14
    L20:
        if (r101.equals(r103) == false) goto L23;
        return r106;
    L23:
        return getTypeArguments(getClosestParentType(r103, r101), r101, r106);
    L9:
        if (r102 != null) goto L11;
        r106 = new HashMap();
        goto L12
    L11:
        r106 = new HashMap(r102);
        goto L12
    }

    private static boolean isAssignable(Type r110, WildcardType r111, Map<TypeVariable<?>, Type> r112) {
        if (r110 != null) goto L6;
        return true;
    L6:
        if (r111 != null) goto L9;
        return false;
    L9:
        if (r111.equals(r110) == false) goto L11;
        return true;
    L11:
        Type[] r100 = getImplicitUpperBounds(r111);
        Type[] r113 = getImplicitLowerBounds(r111);
        if ((r110 instanceof WildcardType) == false) goto L32;
        WildcardType r114 = (WildcardType) r110;
        Type[] r101 = getImplicitUpperBounds(r114);
        Type[] r115 = getImplicitLowerBounds(r114);
        int r102 = r100.length;
        int r103 = 0;
    L14:
        if (r103 >= r102) goto L22;
        Type r104 = substituteTypeVariables(r100[r103], r112);
        int r105 = r101.length;
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L21;
        if (isAssignable(r101[r106], r104, r112) == false) goto L19;
        r106 = r106 + 1;
        goto L16
    L19:
        return false;
    L21:
        r103 = r103 + 1;
        goto L14
    L22:
        int r107 = r113.length;
        int r108 = 0;
    L23:
        if (r108 >= r107) goto L31;
        Type r109 = substituteTypeVariables(r113[r108], r112);
        int r116 = r115.length;
        int r117 = 0;
    L25:
        if (r117 >= r116) goto L30;
        if (isAssignable(r109, r115[r117], r112) == false) goto L28;
        r117 = r117 + 1;
        goto L25
    L28:
        return false;
    L30:
        r108 = r108 + 1;
        goto L23
    L31:
        return true;
    L32:
        int r118 = r100.length;
        int r119 = 0;
    L33:
        if (r119 >= r118) goto L38;
        if (isAssignable(r110, substituteTypeVariables(r100[r119], r112), r112) == false) goto L36;
        r119 = r119 + 1;
        goto L33
    L36:
        return false;
    L38:
        int r120 = r113.length;
        int r121 = 0;
    L39:
        if (r121 >= r120) goto L44;
        if (isAssignable(substituteTypeVariables(r113[r121], r112), r110, r112) == false) goto L42;
        r121 = r121 + 1;
        goto L39
    L42:
        return false;
    L44:
        return true;
    }

    private static Map<TypeVariable<?>, Type> getTypeArguments(Class<?> r100, Class<?> r101, Map<TypeVariable<?>, Type> r102) {
        if (isAssignable(r100, r101) == true) goto L7;
        return null;
    L7:
        if (r100.isPrimitive() == true) goto L9;
    L13:
        if (r102 != null) goto L15;
        HashMap r103 = new HashMap();
    L17:
        if (r101.equals(r100) == false) goto L20;
        return r103;
    L20:
        return getTypeArguments(getClosestParentType(r100, r101), r101, r103);
    L15:
        r103 = new HashMap(r102);
        goto L17
    L9:
        if (r101.isPrimitive() == true) goto L11;
        r100 = ClassUtils.primitiveToWrapper(r100);
        goto L13
    L11:
        return new HashMap();
    }

    private static boolean isAssignable(Type r100, ParameterizedType r101, Map<TypeVariable<?>, Type> r102) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.equals(r100) == false) goto L11;
        return true;
    L11:
        Class<?> r103 = getRawType(r101);
        Map<TypeVariable<?>, Type> r104 = getTypeArguments(r100, r103, null);
        if (r104 != null) goto L15;
        return false;
    L15:
        if (r104.isEmpty() == false) goto L17;
        return true;
    L17:
        Map<TypeVariable<?>, Type> r105 = getTypeArguments(r101, r103, r102);
        Iterator<TypeVariable<?>> r106 = r105.keySet().iterator();
    L19:
        if (r106.hasNext() == false) goto L33;
        TypeVariable<?> r107 = r106.next();
        Type r108 = unrollVariableAssignments(r107, r105);
        Type r109 = unrollVariableAssignments(r107, r104);
        if (r108 != null) goto L25;
        if ((r109 instanceof Class) == true) goto L19;
    L25:
        if (r109 == null) goto L19;
        if (r108.equals(r109) == true) goto L19;
        if ((r108 instanceof WildcardType) == false) goto L32;
        if (isAssignable(r109, r108, r102) == true) goto L19;
    L32:
        return false;
    L33:
        return true;
    }

    private static boolean isAssignable(Type r100, TypeVariable<?> r101, Map<TypeVariable<?>, Type> r102) {
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.equals(r100) == false) goto L12;
        return true;
    L12:
        if ((r100 instanceof TypeVariable) == false) goto L20;
        Type[] r103 = getImplicitBounds((TypeVariable) r100);
        int r104 = r103.length;
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L20;
        if (isAssignable(r103[r105], r101, r102) == true) goto L17;
        r105 = r105 + 1;
        goto L14
    L17:
        return true;
    L20:
        if ((r100 instanceof Class) == false) goto L22;
    L30:
        return false;
    L22:
        if ((r100 instanceof ParameterizedType) == true) goto L30;
        if ((r100 instanceof GenericArrayType) == true) goto L30;
        if ((r100 instanceof WildcardType) == true) goto L30;
        throw new IllegalStateException("found an unhandled type: " + r100);
    }

    private static boolean isAssignable(Type r100, Type r101, Map<TypeVariable<?>, Type> r102) {
        if (r101 == null) goto L25;
        if ((r101 instanceof Class) == true) goto L25;
        if ((r101 instanceof ParameterizedType) == false) goto L11;
        return isAssignable(r100, (ParameterizedType) r101, r102);
    L11:
        if ((r101 instanceof GenericArrayType) == false) goto L15;
        return isAssignable(r100, (GenericArrayType) r101, r102);
    L15:
        if ((r101 instanceof WildcardType) == false) goto L19;
        return isAssignable(r100, (WildcardType) r101, r102);
    L19:
        if ((r101 instanceof TypeVariable) == false) goto L23;
        return isAssignable(r100, (TypeVariable) r101, r102);
    L23:
        throw new IllegalStateException("found an unhandled type: " + r101);
    L25:
        return isAssignable(r100, (Class) r101);
    }
}

package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final enum FieldType extends Enum<FieldType> {
    public static final FieldType BOOL = null;
    public static final FieldType BOOL_LIST = null;
    public static final FieldType BOOL_LIST_PACKED = null;
    public static final FieldType BYTES = null;
    public static final FieldType BYTES_LIST = null;
    public static final FieldType DOUBLE = null;
    public static final FieldType DOUBLE_LIST = null;
    public static final FieldType DOUBLE_LIST_PACKED = null;
    public static final FieldType ENUM = null;
    public static final FieldType ENUM_LIST = null;
    public static final FieldType ENUM_LIST_PACKED = null;
    public static final FieldType FIXED32 = null;
    public static final FieldType FIXED32_LIST = null;
    public static final FieldType FIXED32_LIST_PACKED = null;
    public static final FieldType FIXED64 = null;
    public static final FieldType FIXED64_LIST = null;
    public static final FieldType FIXED64_LIST_PACKED = null;
    public static final FieldType FLOAT = null;
    public static final FieldType FLOAT_LIST = null;
    public static final FieldType FLOAT_LIST_PACKED = null;
    public static final FieldType GROUP = null;
    public static final FieldType GROUP_LIST = null;
    public static final FieldType INT32 = null;
    public static final FieldType INT32_LIST = null;
    public static final FieldType INT32_LIST_PACKED = null;
    public static final FieldType INT64 = null;
    public static final FieldType INT64_LIST = null;
    public static final FieldType INT64_LIST_PACKED = null;
    public static final FieldType MAP = null;
    public static final FieldType MESSAGE = null;
    public static final FieldType MESSAGE_LIST = null;
    public static final FieldType SFIXED32 = null;
    public static final FieldType SFIXED32_LIST = null;
    public static final FieldType SFIXED32_LIST_PACKED = null;
    public static final FieldType SFIXED64 = null;
    public static final FieldType SFIXED64_LIST = null;
    public static final FieldType SFIXED64_LIST_PACKED = null;
    public static final FieldType SINT32 = null;
    public static final FieldType SINT32_LIST = null;
    public static final FieldType SINT32_LIST_PACKED = null;
    public static final FieldType SINT64 = null;
    public static final FieldType SINT64_LIST = null;
    public static final FieldType SINT64_LIST_PACKED = null;
    public static final FieldType STRING = null;
    public static final FieldType STRING_LIST = null;
    public static final FieldType UINT32 = null;
    public static final FieldType UINT32_LIST = null;
    public static final FieldType UINT32_LIST_PACKED = null;
    public static final FieldType UINT64 = null;
    public static final FieldType UINT64_LIST = null;
    public static final FieldType UINT64_LIST_PACKED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FieldType[] f275819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Type[] f275820b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ FieldType[] f275821c = null;
    private final Collection collection;
    private final Class<?> elementType;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f275822id;
    private final JavaType javaType;
    private final boolean primitiveScalar;

    public static final enum Collection extends Enum<Collection> {
        public static final Collection MAP = null;
        public static final Collection PACKED_VECTOR = null;
        public static final Collection SCALAR = null;
        public static final Collection VECTOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Collection[] f275823a = null;
        private final boolean isList;

        static {
            Collection r100 = new Collection("SCALAR", 0, false);
            SCALAR = r100;
            Collection r101 = new Collection("VECTOR", 1, true);
            VECTOR = r101;
            Collection r102 = new Collection("PACKED_VECTOR", 2, true);
            PACKED_VECTOR = r102;
            Collection r103 = new Collection("MAP", 3, false);
            MAP = r103;
            f275823a = new Collection[]{r100, r101, r102, r103};
        }

        public static Collection[] values() {
            return (Collection[]) f275823a.clone();
        }

        public boolean isList() {
            return this.isList;
        }

        public static Collection valueOf(String r100) {
            return (Collection) r27.a.a(Collection.class, r100);
        }

        public Collection(String r100, int r101, boolean r102) {
            super(r100, r101);
            this.isList = r102;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275824a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f275825b = null;

        static {
            int[] r100 = new int[JavaType.values().length];
            f275825b = r100;
            r100[JavaType.BYTE_STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            f275825b[JavaType.MESSAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            f275825b[JavaType.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r101 = new int[Collection.values().length];
            f275824a = r101;
            r101[Collection.MAP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            f275824a[Collection.VECTOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            f275824a[Collection.SCALAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    static {
        Collection r110 = Collection.SCALAR;
        JavaType r111 = JavaType.DOUBLE;
        FieldType r100 = new FieldType("DOUBLE", 0, 0, r110, r111);
        DOUBLE = r100;
        JavaType r101 = JavaType.FLOAT;
        FieldType r102 = new FieldType("FLOAT", 1, 1, r110, r101);
        FLOAT = r102;
        JavaType r103 = JavaType.LONG;
        FieldType r104 = new FieldType("INT64", 2, 2, r110, r103);
        INT64 = r104;
        FieldType r105 = new FieldType("UINT64", 3, 3, r110, r103);
        UINT64 = r105;
        JavaType r210 = JavaType.INT;
        FieldType r106 = new FieldType("INT32", 4, 4, r110, r210);
        INT32 = r106;
        FieldType r211 = new FieldType("FIXED64", 5, 5, r110, r103);
        FIXED64 = r211;
        FieldType r212 = new FieldType("FIXED32", 6, 6, r110, r210);
        FIXED32 = r212;
        JavaType r213 = JavaType.BOOLEAN;
        FieldType r214 = new FieldType("BOOL", 7, 7, r110, r213);
        BOOL = r214;
        JavaType r215 = JavaType.STRING;
        FieldType r216 = new FieldType("STRING", 8, 8, r110, r215);
        STRING = r216;
        JavaType r217 = JavaType.MESSAGE;
        FieldType r218 = new FieldType("MESSAGE", 9, 9, r110, r217);
        MESSAGE = r218;
        JavaType r310 = JavaType.BYTE_STRING;
        FieldType r311 = new FieldType("BYTES", 10, 10, r110, r310);
        BYTES = r311;
        FieldType r312 = new FieldType("UINT32", 11, 11, r110, r210);
        UINT32 = r312;
        JavaType r313 = JavaType.ENUM;
        FieldType r314 = new FieldType("ENUM", 12, 12, r110, r313);
        ENUM = r314;
        FieldType r315 = new FieldType("SFIXED32", 13, 13, r110, r210);
        SFIXED32 = r315;
        FieldType r316 = new FieldType("SFIXED64", 14, 14, r110, r103);
        SFIXED64 = r316;
        FieldType r317 = new FieldType("SINT32", 15, 15, r110, r210);
        SINT32 = r317;
        FieldType r318 = new FieldType("SINT64", 16, 16, r110, r103);
        SINT64 = r318;
        FieldType r319 = new FieldType("GROUP", 17, 17, r110, r217);
        GROUP = r319;
        Collection r410 = Collection.VECTOR;
        FieldType r112 = new FieldType("DOUBLE_LIST", 18, 18, r410, r111);
        DOUBLE_LIST = r112;
        FieldType r411 = new FieldType("FLOAT_LIST", 19, 19, r410, r101);
        FLOAT_LIST = r411;
        FieldType r412 = new FieldType("INT64_LIST", 20, 20, r410, r103);
        INT64_LIST = r412;
        FieldType r413 = new FieldType("UINT64_LIST", 21, 21, r410, r103);
        UINT64_LIST = r413;
        FieldType r414 = new FieldType("INT32_LIST", 22, 22, r410, r210);
        INT32_LIST = r414;
        FieldType r415 = new FieldType("FIXED64_LIST", 23, 23, r410, r103);
        FIXED64_LIST = r415;
        FieldType r416 = new FieldType("FIXED32_LIST", 24, 24, r410, r210);
        FIXED32_LIST = r416;
        FieldType r417 = new FieldType("BOOL_LIST", 25, 25, r410, r213);
        BOOL_LIST = r417;
        FieldType r418 = new FieldType("STRING_LIST", 26, 26, r410, r215);
        STRING_LIST = r418;
        FieldType r219 = new FieldType("MESSAGE_LIST", 27, 27, r410, r217);
        MESSAGE_LIST = r219;
        FieldType r419 = new FieldType("BYTES_LIST", 28, 28, r410, r310);
        BYTES_LIST = r419;
        FieldType r320 = new FieldType("UINT32_LIST", 29, 29, r410, r210);
        UINT32_LIST = r320;
        FieldType r510 = new FieldType("ENUM_LIST", 30, 30, r410, r313);
        ENUM_LIST = r510;
        FieldType r511 = new FieldType("SFIXED32_LIST", 31, 31, r410, r210);
        SFIXED32_LIST = r511;
        FieldType r512 = new FieldType("SFIXED64_LIST", 32, 32, r410, r103);
        SFIXED64_LIST = r512;
        FieldType r513 = new FieldType("SINT32_LIST", 33, 33, r410, r210);
        SINT32_LIST = r513;
        FieldType r514 = new FieldType("SINT64_LIST", 34, 34, r410, r103);
        SINT64_LIST = r514;
        Collection r515 = Collection.PACKED_VECTOR;
        FieldType r516 = new FieldType("DOUBLE_LIST_PACKED", 35, 35, r515, r111);
        DOUBLE_LIST_PACKED = r516;
        FieldType r107 = new FieldType("FLOAT_LIST_PACKED", 36, 36, r515, r101);
        FLOAT_LIST_PACKED = r107;
        FieldType r108 = new FieldType("INT64_LIST_PACKED", 37, 37, r515, r103);
        INT64_LIST_PACKED = r108;
        FieldType r109 = new FieldType("UINT64_LIST_PACKED", 38, 38, r515, r103);
        UINT64_LIST_PACKED = r109;
        FieldType r113 = new FieldType("INT32_LIST_PACKED", 39, 39, r515, r210);
        INT32_LIST_PACKED = r113;
        FieldType r114 = new FieldType("FIXED64_LIST_PACKED", 40, 40, r515, r103);
        FIXED64_LIST_PACKED = r114;
        FieldType r115 = new FieldType("FIXED32_LIST_PACKED", 41, 41, r515, r210);
        FIXED32_LIST_PACKED = r115;
        FieldType r116 = new FieldType("BOOL_LIST_PACKED", 42, 42, r515, r213);
        BOOL_LIST_PACKED = r116;
        FieldType r117 = new FieldType("UINT32_LIST_PACKED", 43, 43, r515, r210);
        UINT32_LIST_PACKED = r117;
        FieldType r220 = new FieldType("ENUM_LIST_PACKED", 44, 44, r515, r313);
        ENUM_LIST_PACKED = r220;
        FieldType r321 = new FieldType("SFIXED32_LIST_PACKED", 45, 45, r515, r210);
        SFIXED32_LIST_PACKED = r321;
        FieldType r517 = new FieldType("SFIXED64_LIST_PACKED", 46, 46, r515, r103);
        SFIXED64_LIST_PACKED = r517;
        FieldType r518 = new FieldType("SINT32_LIST_PACKED", 47, 47, r515, r210);
        SINT32_LIST_PACKED = r518;
        FieldType r221 = new FieldType("SINT64_LIST_PACKED", 48, 48, r515, r103);
        SINT64_LIST_PACKED = r221;
        FieldType r118 = new FieldType("GROUP_LIST", 49, 49, r410, r217);
        GROUP_LIST = r118;
        FieldType r119 = new FieldType("MAP", 50, 50, Collection.MAP, JavaType.VOID);
        MAP = r119;
        int r120 = 0;
        f275821c = new FieldType[]{r100, r102, r104, r105, r106, r211, r212, r214, r216, r218, r311, r312, r314, r315, r316, r317, r318, r319, r112, r411, r412, r413, r414, r415, r416, r417, r418, r219, r419, r320, r510, r511, r512, r513, r514, r516, r107, r108, r109, r113, r114, r115, r116, r117, r220, r321, r517, r518, r221, r118, r119};
        f275820b = new Type[0];
        FieldType[] r121 = values();
        f275819a = new FieldType[r121.length];
        int r122 = r121.length;
    L3:
        if (r120 >= r122) goto L5;
        FieldType r123 = r121[r120];
        f275819a[r123.f275822id] = r123;
        r120 = r120 + 1;
        goto L3
    }

    public static FieldType[] values() {
        return (FieldType[]) f275821c.clone();
    }

    public boolean isList() {
        return this.collection.isList();
    }

    public boolean isMap() {
        if (this.collection != Collection.MAP) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPacked() {
        return Collection.PACKED_VECTOR.equals(this.collection);
    }

    public boolean isScalar() {
        if (this.collection != Collection.SCALAR) goto L5;
        return true;
    L5:
        return false;
    }

    public JavaType getJavaType() {
        return this.javaType;
    }

    public int id() {
        return this.f275822id;
    }

    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public static FieldType forId(int r100) {
        if (r100 < 0) goto L8;
        FieldType[] r101 = f275819a;
        if (r100 < r101.length) goto L7;
        return null;
    L7:
        return r101[r100];
    L8:
        return null;
    }

    public static FieldType valueOf(String r100) {
        return (FieldType) r27.a.a(FieldType.class, r100);
    }

    public boolean isValidForField(Field r110) {
        if (Collection.VECTOR.equals(this.collection) == false) goto L68;
        Class<?> r100 = r110.getType();
        if (this.javaType.getType().isAssignableFrom(r100) == false) goto L91;
        Type[] r101 = f275820b;
        if ((r110.getGenericType() instanceof ParameterizedType) == false) goto L11;
        r101 = ((ParameterizedType) r110.getGenericType()).getActualTypeArguments();
    L11:
        if (r100 == List.class) goto L59;
        Type[] r111 = r100.getGenericInterfaces();
        int r102 = r111.length;
        int r103 = 0;
    L13:
        if (r103 >= r102) goto L20;
        Type r104 = r111[r103];
        if ((r104 instanceof ParameterizedType) == false) goto L19;
        if (List.class.isAssignableFrom((Class) ((ParameterizedType) r104).getRawType()) == false) goto L19;
    L27:
        if ((r104 instanceof ParameterizedType) == true) goto L28;
        r101 = f275820b;
        Class<?>[] r112 = r100.getInterfaces();
        int r105 = r112.length;
        int r106 = 0;
    L52:
        if (r106 >= r105) goto L57;
        Class<?> r107 = r112[r106];
        if (List.class.isAssignableFrom(r107) == true) goto L55;
        r106 = r106 + 1;
        goto L52
    L55:
        r100 = r107;
        goto L11
    L57:
        r100 = r100.getSuperclass();
        goto L11
    L28:
        ParameterizedType r108 = (ParameterizedType) r104;
        Type[] r113 = r108.getActualTypeArguments();
        int r109 = 0;
    L30:
        if (r109 >= r113.length) goto L50;
        Type r114 = r113[r109];
        if ((r114 instanceof TypeVariable) == false) goto L49;
        TypeVariable<Class<?>>[] r115 = r100.getTypeParameters();
        if (r101.length != r115.length) goto L48;
        int r116 = 0;
    L37:
        if (r116 >= r115.length) goto L42;
        if (r114 == r115[r116]) goto L40;
        r116 = r116 + 1;
        goto L37
    L40:
        r113[r109] = r101[r116];
        boolean r117 = true;
    L43:
        if (r117 == true) goto L49;
        throw new RuntimeException("Unable to find replacement for " + r114);
    L42:
        r117 = false;
        goto L43
    L48:
        throw new RuntimeException("Type array mismatch");
    L49:
        r109 = r109 + 1;
        goto L30
    L50:
        r100 = (Class) r108.getRawType();
        r101 = r113;
    L19:
        r103 = r103 + 1;
        goto L13
    L20:
        r104 = r100.getGenericSuperclass();
        if ((r104 instanceof ParameterizedType) == true) goto L23;
    L25:
        r104 = null;
        goto L27
    L23:
        if (List.class.isAssignableFrom((Class) ((ParameterizedType) r104).getRawType()) == false) goto L25;
    L59:
        if (r101.length != 1) goto L66;
        Type r118 = r101[0];
        if ((r118 instanceof Class) == true) goto L64;
        return true;
    L64:
        return this.elementType.isAssignableFrom((Class) r118);
    L66:
        throw new RuntimeException("Unable to identify parameter type for List<T>");
    L91:
        return false;
    L68:
        return this.javaType.getType().isAssignableFrom(r110.getType());
    }

    public FieldType(String r100, int r101, int r102, Collection r103, JavaType r104) {
        super(r100, r101);
        this.f275822id = r102;
        this.collection = r103;
        this.javaType = r104;
        int r105 = a.f275824a[r103.ordinal()];
        boolean r106 = true;
        if (r105 == 1) goto L7;
        if (r105 == 2) goto L6;
        this.elementType = null;
    L9:
        if (r103 != Collection.SCALAR) goto L16;
        int r107 = a.f275825b[r104.ordinal()];
        if (r107 == 1) goto L16;
        if (r107 == 2) goto L16;
        if (r107 == 3) goto L16;
    L17:
        this.primitiveScalar = r106;
        return;
    L16:
        r106 = false;
        goto L17
    L6:
        this.elementType = r104.getBoxedType();
        goto L9
    L7:
        this.elementType = r104.getBoxedType();
        goto L9
    }
}

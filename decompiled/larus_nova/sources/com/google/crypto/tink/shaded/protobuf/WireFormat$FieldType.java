package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: loaded from: classes23.dex */
public enum WireFormat$FieldType extends Enum<WireFormat$FieldType> {
    public static final WireFormat$FieldType BOOL = null;
    public static final WireFormat$FieldType BYTES = null;
    public static final WireFormat$FieldType DOUBLE = null;
    public static final WireFormat$FieldType ENUM = null;
    public static final WireFormat$FieldType FIXED32 = null;
    public static final WireFormat$FieldType FIXED64 = null;
    public static final WireFormat$FieldType FLOAT = null;
    public static final WireFormat$FieldType GROUP = null;
    public static final WireFormat$FieldType INT32 = null;
    public static final WireFormat$FieldType INT64 = null;
    public static final WireFormat$FieldType MESSAGE = null;
    public static final WireFormat$FieldType SFIXED32 = null;
    public static final WireFormat$FieldType SFIXED64 = null;
    public static final WireFormat$FieldType SINT32 = null;
    public static final WireFormat$FieldType SINT64 = null;
    public static final WireFormat$FieldType STRING = null;
    public static final WireFormat$FieldType UINT32 = null;
    public static final WireFormat$FieldType UINT64 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WireFormat$FieldType[] f275851a = null;
    private final WireFormat$JavaType javaType;
    private final int wireType;

    public boolean isPackable() {
        return true;
    }

    static {
        WireFormat$FieldType r100 = new WireFormat$FieldType("DOUBLE", 0, WireFormat$JavaType.DOUBLE, 1);
        DOUBLE = r100;
        WireFormat$FieldType r101 = new WireFormat$FieldType("FLOAT", 1, WireFormat$JavaType.FLOAT, 5);
        FLOAT = r101;
        WireFormat$JavaType r102 = WireFormat$JavaType.LONG;
        final int r103 = 2;
        WireFormat$FieldType r104 = new WireFormat$FieldType("INT64", 2, r102, 0);
        INT64 = r104;
        final int r110 = 3;
        WireFormat$FieldType r105 = new WireFormat$FieldType("UINT64", 3, r102, 0);
        UINT64 = r105;
        WireFormat$JavaType r111 = WireFormat$JavaType.INT;
        WireFormat$FieldType r106 = new WireFormat$FieldType("INT32", 4, r111, 0);
        INT32 = r106;
        WireFormat$FieldType r112 = new WireFormat$FieldType("FIXED64", 5, r102, 1);
        FIXED64 = r112;
        WireFormat$FieldType r113 = new WireFormat$FieldType("FIXED32", 6, r111, 5);
        FIXED32 = r113;
        WireFormat$FieldType r114 = new WireFormat$FieldType("BOOL", 7, WireFormat$JavaType.BOOLEAN, 0);
        BOOL = r114;
        final WireFormat$JavaType r115 = WireFormat$JavaType.STRING;
        final String r107 = "STRING";
        final int r108 = 8;
        WireFormat$FieldType r109 = new AnonymousClass1(r107, r108, r115, r103);
        STRING = r109;
        final WireFormat$JavaType r116 = WireFormat$JavaType.MESSAGE;
        final String r117 = "GROUP";
        final int r118 = 9;
        WireFormat$FieldType r119 = new AnonymousClass2(r117, r118, r116, r110);
        GROUP = r119;
        final String r120 = "MESSAGE";
        final int r121 = 10;
        final int r122 = 2;
        WireFormat$FieldType r123 = new AnonymousClass3(r120, r121, r116, r122);
        MESSAGE = r123;
        final WireFormat$JavaType r124 = WireFormat$JavaType.BYTE_STRING;
        final String r125 = "BYTES";
        final int r126 = 11;
        WireFormat$FieldType r127 = new AnonymousClass4(r125, r126, r124, r122);
        BYTES = r127;
        WireFormat$FieldType r128 = new WireFormat$FieldType("UINT32", 12, r111, 0);
        UINT32 = r128;
        WireFormat$FieldType r129 = new WireFormat$FieldType("ENUM", 13, WireFormat$JavaType.ENUM, 0);
        ENUM = r129;
        WireFormat$FieldType r130 = new WireFormat$FieldType("SFIXED32", 14, r111, 5);
        SFIXED32 = r130;
        WireFormat$FieldType r131 = new WireFormat$FieldType("SFIXED64", 15, r102, 1);
        SFIXED64 = r131;
        WireFormat$FieldType r132 = new WireFormat$FieldType("SINT32", 16, r111, 0);
        SINT32 = r132;
        WireFormat$FieldType r133 = new WireFormat$FieldType("SINT64", 17, r102, 0);
        SINT64 = r133;
        f275851a = new WireFormat$FieldType[]{r100, r101, r104, r105, r106, r112, r113, r114, r109, r119, r123, r127, r128, r129, r130, r131, r132, r133};
    }

    public static WireFormat$FieldType[] values() {
        return (WireFormat$FieldType[]) f275851a.clone();
    }

    public WireFormat$JavaType getJavaType() {
        return this.javaType;
    }

    public int getWireType() {
        return this.wireType;
    }

    public static WireFormat$FieldType valueOf(String r100) {
        return (WireFormat$FieldType) r27.a.a(WireFormat$FieldType.class, r100);
    }

    public WireFormat$FieldType(String r100, int r101, WireFormat$JavaType r102, int r103) {
        super(r100, r101);
        this.javaType = r102;
        this.wireType = r103;
    }

    public /* synthetic */ WireFormat$FieldType(String r100, int r101, WireFormat$JavaType r102, int r103, j r104) {
        this(r100, r101, r102, r103);
    }
}

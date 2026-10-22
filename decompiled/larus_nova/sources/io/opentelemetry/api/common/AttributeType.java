package io.opentelemetry.api.common;

import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum AttributeType extends Enum<AttributeType> {
    public static final AttributeType BOOLEAN = null;
    public static final AttributeType BOOLEAN_ARRAY = null;
    public static final AttributeType DOUBLE = null;
    public static final AttributeType DOUBLE_ARRAY = null;
    public static final AttributeType LONG = null;
    public static final AttributeType LONG_ARRAY = null;
    public static final AttributeType STRING = null;
    public static final AttributeType STRING_ARRAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttributeType[] f492662a = null;

    static {
        AttributeType r100 = new AttributeType("STRING", 0);
        STRING = r100;
        AttributeType r101 = new AttributeType("BOOLEAN", 1);
        BOOLEAN = r101;
        AttributeType r102 = new AttributeType("LONG", 2);
        LONG = r102;
        AttributeType r103 = new AttributeType("DOUBLE", 3);
        DOUBLE = r103;
        AttributeType r104 = new AttributeType("STRING_ARRAY", 4);
        STRING_ARRAY = r104;
        AttributeType r105 = new AttributeType("BOOLEAN_ARRAY", 5);
        BOOLEAN_ARRAY = r105;
        AttributeType r110 = new AttributeType("LONG_ARRAY", 6);
        LONG_ARRAY = r110;
        AttributeType r111 = new AttributeType("DOUBLE_ARRAY", 7);
        DOUBLE_ARRAY = r111;
        f492662a = new AttributeType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static AttributeType[] values() {
        return (AttributeType[]) f492662a.clone();
    }

    public static AttributeType valueOf(String r100) {
        return (AttributeType) a.a(AttributeType.class, r100);
    }

    public AttributeType(String r100, int r101) {
        super(r100, r101);
    }
}

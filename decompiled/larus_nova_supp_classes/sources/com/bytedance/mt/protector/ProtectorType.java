package com.bytedance.mt.protector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final enum ProtectorType extends Enum<ProtectorType> {
    public static final ProtectorType CAST_COLOR = null;
    public static final ProtectorType CAST_NUMBER = null;
    public static final ProtectorType COLLECTIONS = null;
    public static final ProtectorType ENUM = null;
    public static final ProtectorType EQUALS = null;
    public static final ProtectorType JSON = null;
    public static final ProtectorType PATTERN = null;
    public static final ProtectorType URI = null;
    public static final /* synthetic */ ProtectorType[] a = null;
    private String name;

    static {
        ProtectorType r0 = new ProtectorType("PATTERN", 0, "PATTERN_PROTECT_THROWABLE");
        PATTERN = r0;
        ProtectorType r1 = new ProtectorType("JSON", 1, "JSON_PROTECT_THROWABLE");
        JSON = r1;
        ProtectorType r2 = new ProtectorType("CAST_NUMBER", 2, "CAST_NUMBER_PROTECT_THROWABLE");
        CAST_NUMBER = r2;
        ProtectorType r4 = new ProtectorType("CAST_COLOR", 3, "CAST_COLOR_PROTECT_THROWABLE");
        CAST_COLOR = r4;
        ProtectorType r6 = new ProtectorType("EQUALS", 4, "EQUALS_PROTECT_THROWABLE");
        EQUALS = r6;
        ProtectorType r8 = new ProtectorType("ENUM", 5, "ENUM_PROTECT_THROWABLE");
        ENUM = r8;
        ProtectorType r10 = new ProtectorType("URI", 6, "URI_PROTECT_THROWABLE");
        URI = r10;
        ProtectorType r12 = new ProtectorType("COLLECTIONS", 7, "COLLECTION_PROTECT_THROWABLE");
        COLLECTIONS = r12;
        a = new ProtectorType[]{r0, r1, r2, r4, r6, r8, r10, r12};
    }

    public static ProtectorType[] values() {
        return (ProtectorType[]) a.clone();
    }

    public String getName() {
        return this.name;
    }

    public static ProtectorType valueOf(String r1) {
        return (ProtectorType) r27.a.a(ProtectorType.class, r1);
    }

    public ProtectorType(String r1, int r2, String r3) {
        super(r1, r2);
        this.name = r3;
    }
}

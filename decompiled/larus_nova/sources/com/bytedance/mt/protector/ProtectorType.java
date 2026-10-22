package com.bytedance.mt.protector;

/* JADX INFO: loaded from: classes.dex */
public final enum ProtectorType extends Enum<ProtectorType> {
    public static final ProtectorType CAST_COLOR = null;
    public static final ProtectorType CAST_NUMBER = null;
    public static final ProtectorType COLLECTIONS = null;
    public static final ProtectorType ENUM = null;
    public static final ProtectorType EQUALS = null;
    public static final ProtectorType JSON = null;
    public static final ProtectorType PATTERN = null;
    public static final ProtectorType URI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProtectorType[] f265656a = null;
    private String name;

    static {
        ProtectorType r100 = new ProtectorType("PATTERN", 0, "PATTERN_PROTECT_THROWABLE");
        PATTERN = r100;
        ProtectorType r101 = new ProtectorType("JSON", 1, "JSON_PROTECT_THROWABLE");
        JSON = r101;
        ProtectorType r102 = new ProtectorType("CAST_NUMBER", 2, "CAST_NUMBER_PROTECT_THROWABLE");
        CAST_NUMBER = r102;
        ProtectorType r103 = new ProtectorType("CAST_COLOR", 3, "CAST_COLOR_PROTECT_THROWABLE");
        CAST_COLOR = r103;
        ProtectorType r104 = new ProtectorType("EQUALS", 4, "EQUALS_PROTECT_THROWABLE");
        EQUALS = r104;
        ProtectorType r105 = new ProtectorType("ENUM", 5, "ENUM_PROTECT_THROWABLE");
        ENUM = r105;
        ProtectorType r110 = new ProtectorType("URI", 6, "URI_PROTECT_THROWABLE");
        URI = r110;
        ProtectorType r111 = new ProtectorType("COLLECTIONS", 7, "COLLECTION_PROTECT_THROWABLE");
        COLLECTIONS = r111;
        f265656a = new ProtectorType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static ProtectorType[] values() {
        return (ProtectorType[]) f265656a.clone();
    }

    public String getName() {
        return this.name;
    }

    public static ProtectorType valueOf(String r100) {
        return (ProtectorType) r27.a.a(ProtectorType.class, r100);
    }

    public ProtectorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.name = r102;
    }
}

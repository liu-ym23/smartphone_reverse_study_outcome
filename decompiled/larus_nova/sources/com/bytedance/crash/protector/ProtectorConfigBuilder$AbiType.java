package com.bytedance.crash.protector;

/* JADX INFO: loaded from: classes6.dex */
public final enum ProtectorConfigBuilder$AbiType extends Enum<ProtectorConfigBuilder$AbiType> {
    public static final ProtectorConfigBuilder$AbiType ARM64_V8A = null;
    public static final ProtectorConfigBuilder$AbiType ARMEABI_V7A = null;
    public static final ProtectorConfigBuilder$AbiType BOTH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProtectorConfigBuilder$AbiType[] f203345a = null;
    private final int value;

    static {
        ProtectorConfigBuilder$AbiType r100 = new ProtectorConfigBuilder$AbiType("BOTH", 0, 0);
        BOTH = r100;
        ProtectorConfigBuilder$AbiType r101 = new ProtectorConfigBuilder$AbiType("ARM64_V8A", 1, 1);
        ARM64_V8A = r101;
        ProtectorConfigBuilder$AbiType r102 = new ProtectorConfigBuilder$AbiType("ARMEABI_V7A", 2, 2);
        ARMEABI_V7A = r102;
        f203345a = new ProtectorConfigBuilder$AbiType[]{r100, r101, r102};
    }

    public static ProtectorConfigBuilder$AbiType[] values() {
        return (ProtectorConfigBuilder$AbiType[]) f203345a.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static /* synthetic */ int access$000(ProtectorConfigBuilder$AbiType r100) {
        return r100.value;
    }

    public static ProtectorConfigBuilder$AbiType valueOf(String r100) {
        return (ProtectorConfigBuilder$AbiType) r27.a.a(ProtectorConfigBuilder$AbiType.class, r100);
    }

    public ProtectorConfigBuilder$AbiType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

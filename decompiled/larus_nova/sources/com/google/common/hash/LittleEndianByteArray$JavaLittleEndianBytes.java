package com.google.common.hash;

/* JADX INFO: loaded from: classes23.dex */
abstract enum LittleEndianByteArray$JavaLittleEndianBytes extends Enum<LittleEndianByteArray$JavaLittleEndianBytes> {
    public static final LittleEndianByteArray$JavaLittleEndianBytes INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LittleEndianByteArray$JavaLittleEndianBytes[] f275568a = null;

    public LittleEndianByteArray$JavaLittleEndianBytes() {
        throw null;
    }

    public abstract /* synthetic */ long getLongLittleEndian(byte[] r100, int r101);

    public abstract /* synthetic */ void putLongLittleEndian(byte[] r100, int r101, long r102);

    static {
        final String r100 = "INSTANCE";
        final int r101 = 0;
        LittleEndianByteArray$JavaLittleEndianBytes r102 = new AnonymousClass1(r100, r101);
        INSTANCE = r102;
        f275568a = new LittleEndianByteArray$JavaLittleEndianBytes[]{r102};
    }

    public static LittleEndianByteArray$JavaLittleEndianBytes[] values() {
        return (LittleEndianByteArray$JavaLittleEndianBytes[]) f275568a.clone();
    }

    public static LittleEndianByteArray$JavaLittleEndianBytes valueOf(String r100) {
        return (LittleEndianByteArray$JavaLittleEndianBytes) r27.a.a(LittleEndianByteArray$JavaLittleEndianBytes.class, r100);
    }

    public LittleEndianByteArray$JavaLittleEndianBytes(String r100, int r101, h r102) {
        super(r100, r101);
    }
}

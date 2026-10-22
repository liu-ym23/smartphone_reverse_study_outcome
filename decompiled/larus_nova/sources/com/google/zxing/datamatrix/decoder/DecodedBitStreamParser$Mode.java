package com.google.zxing.datamatrix.decoder;

/* JADX INFO: loaded from: classes23.dex */
final enum DecodedBitStreamParser$Mode extends Enum<DecodedBitStreamParser$Mode> {
    public static final DecodedBitStreamParser$Mode ANSIX12_ENCODE = null;
    public static final DecodedBitStreamParser$Mode ASCII_ENCODE = null;
    public static final DecodedBitStreamParser$Mode BASE256_ENCODE = null;
    public static final DecodedBitStreamParser$Mode C40_ENCODE = null;
    public static final DecodedBitStreamParser$Mode ECI_ENCODE = null;
    public static final DecodedBitStreamParser$Mode EDIFACT_ENCODE = null;
    public static final DecodedBitStreamParser$Mode PAD_ENCODE = null;
    public static final DecodedBitStreamParser$Mode TEXT_ENCODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodedBitStreamParser$Mode[] f275945a = null;

    static {
        DecodedBitStreamParser$Mode r100 = new DecodedBitStreamParser$Mode("PAD_ENCODE", 0);
        PAD_ENCODE = r100;
        DecodedBitStreamParser$Mode r101 = new DecodedBitStreamParser$Mode("ASCII_ENCODE", 1);
        ASCII_ENCODE = r101;
        DecodedBitStreamParser$Mode r102 = new DecodedBitStreamParser$Mode("C40_ENCODE", 2);
        C40_ENCODE = r102;
        DecodedBitStreamParser$Mode r103 = new DecodedBitStreamParser$Mode("TEXT_ENCODE", 3);
        TEXT_ENCODE = r103;
        DecodedBitStreamParser$Mode r104 = new DecodedBitStreamParser$Mode("ANSIX12_ENCODE", 4);
        ANSIX12_ENCODE = r104;
        DecodedBitStreamParser$Mode r105 = new DecodedBitStreamParser$Mode("EDIFACT_ENCODE", 5);
        EDIFACT_ENCODE = r105;
        DecodedBitStreamParser$Mode r110 = new DecodedBitStreamParser$Mode("BASE256_ENCODE", 6);
        BASE256_ENCODE = r110;
        DecodedBitStreamParser$Mode r111 = new DecodedBitStreamParser$Mode("ECI_ENCODE", 7);
        ECI_ENCODE = r111;
        f275945a = new DecodedBitStreamParser$Mode[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static DecodedBitStreamParser$Mode[] values() {
        return (DecodedBitStreamParser$Mode[]) f275945a.clone();
    }

    public static DecodedBitStreamParser$Mode valueOf(String r100) {
        return (DecodedBitStreamParser$Mode) r27.a.a(DecodedBitStreamParser$Mode.class, r100);
    }

    public DecodedBitStreamParser$Mode(String r100, int r101) {
        super(r100, r101);
    }
}

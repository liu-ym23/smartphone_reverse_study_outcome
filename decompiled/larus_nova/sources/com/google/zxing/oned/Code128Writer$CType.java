package com.google.zxing.oned;

/* JADX INFO: loaded from: classes23.dex */
final enum Code128Writer$CType extends Enum<Code128Writer$CType> {
    public static final Code128Writer$CType FNC_1 = null;
    public static final Code128Writer$CType ONE_DIGIT = null;
    public static final Code128Writer$CType TWO_DIGITS = null;
    public static final Code128Writer$CType UNCODABLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Code128Writer$CType[] f275948a = null;

    static {
        Code128Writer$CType r100 = new Code128Writer$CType("UNCODABLE", 0);
        UNCODABLE = r100;
        Code128Writer$CType r101 = new Code128Writer$CType("ONE_DIGIT", 1);
        ONE_DIGIT = r101;
        Code128Writer$CType r102 = new Code128Writer$CType("TWO_DIGITS", 2);
        TWO_DIGITS = r102;
        Code128Writer$CType r103 = new Code128Writer$CType("FNC_1", 3);
        FNC_1 = r103;
        f275948a = new Code128Writer$CType[]{r100, r101, r102, r103};
    }

    public static Code128Writer$CType[] values() {
        return (Code128Writer$CType[]) f275948a.clone();
    }

    public static Code128Writer$CType valueOf(String r100) {
        return (Code128Writer$CType) r27.a.a(Code128Writer$CType.class, r100);
    }

    public Code128Writer$CType(String r100, int r101) {
        super(r100, r101);
    }
}

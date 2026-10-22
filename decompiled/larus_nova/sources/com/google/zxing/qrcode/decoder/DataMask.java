package com.google.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes23.dex */
abstract enum DataMask extends Enum<DataMask> {
    public static final DataMask DATA_MASK_000 = null;
    public static final DataMask DATA_MASK_001 = null;
    public static final DataMask DATA_MASK_010 = null;
    public static final DataMask DATA_MASK_011 = null;
    public static final DataMask DATA_MASK_100 = null;
    public static final DataMask DATA_MASK_101 = null;
    public static final DataMask DATA_MASK_110 = null;
    public static final DataMask DATA_MASK_111 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataMask[] f275960a = null;

    public DataMask() {
        throw null;
    }

    public abstract boolean isMasked(int r100, int r101);

    static {
        final String r100 = "DATA_MASK_000";
        final int r101 = 0;
        DataMask r102 = new AnonymousClass1(r100, r101);
        DATA_MASK_000 = r102;
        final String r103 = "DATA_MASK_001";
        final int r104 = 1;
        DataMask r105 = new AnonymousClass2(r103, r104);
        DATA_MASK_001 = r105;
        final String r106 = "DATA_MASK_010";
        final int r107 = 2;
        DataMask r108 = new AnonymousClass3(r106, r107);
        DATA_MASK_010 = r108;
        final String r109 = "DATA_MASK_011";
        final int r110 = 3;
        DataMask r111 = new AnonymousClass4(r109, r110);
        DATA_MASK_011 = r111;
        final String r112 = "DATA_MASK_100";
        final int r113 = 4;
        DataMask r114 = new AnonymousClass5(r112, r113);
        DATA_MASK_100 = r114;
        final String r115 = "DATA_MASK_101";
        final int r116 = 5;
        DataMask r117 = new AnonymousClass6(r115, r116);
        DATA_MASK_101 = r117;
        final String r118 = "DATA_MASK_110";
        final int r119 = 6;
        DataMask r120 = new AnonymousClass7(r118, r119);
        DATA_MASK_110 = r120;
        final String r121 = "DATA_MASK_111";
        final int r122 = 7;
        DataMask r123 = new AnonymousClass8(r121, r122);
        DATA_MASK_111 = r123;
        f275960a = new DataMask[]{r102, r105, r108, r111, r114, r117, r120, r123};
    }

    public static DataMask[] values() {
        return (DataMask[]) f275960a.clone();
    }

    public static DataMask valueOf(String r100) {
        return (DataMask) r27.a.a(DataMask.class, r100);
    }

    public final void unmaskBitMatrix(nv7.b r100, int r101) {
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L10;
        if (isMasked(r102, r103) == false) goto L9;
        r100.a(r103, r102);
    L9:
        r103 = r103 + 1;
        goto L5
    L10:
        r102 = r102 + 1;
        goto L3
    }

    public DataMask(String r100, int r101, AnonymousClass1 r102) {
        super(r100, r101);
    }
}

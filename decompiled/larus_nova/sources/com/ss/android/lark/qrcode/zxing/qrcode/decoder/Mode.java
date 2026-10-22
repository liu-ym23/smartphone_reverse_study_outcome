package com.ss.android.lark.qrcode.zxing.qrcode.decoder;

/* JADX INFO: loaded from: classes37.dex */
public final enum Mode extends Enum<Mode> {
    public static final Mode ALPHANUMERIC = null;
    public static final Mode BYTE = null;
    public static final Mode ECI = null;
    public static final Mode FNC1_FIRST_POSITION = null;
    public static final Mode FNC1_SECOND_POSITION = null;
    public static final Mode HANZI = null;
    public static final Mode KANJI = null;
    public static final Mode NUMERIC = null;
    public static final Mode STRUCTURED_APPEND = null;
    public static final Mode TERMINATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Mode[] f439118a = null;
    private final int bits;
    private final int[] characterCountBitsForVersions;

    static {
        Mode r100 = new Mode("TERMINATOR", 0, new int[]{0, 0, 0}, 0);
        TERMINATOR = r100;
        Mode r101 = new Mode("NUMERIC", 1, new int[]{10, 12, 14}, 1);
        NUMERIC = r101;
        Mode r102 = new Mode("ALPHANUMERIC", 2, new int[]{9, 11, 13}, 2);
        ALPHANUMERIC = r102;
        Mode r103 = new Mode("STRUCTURED_APPEND", 3, new int[]{0, 0, 0}, 3);
        STRUCTURED_APPEND = r103;
        Mode r104 = new Mode("BYTE", 4, new int[]{8, 16, 16}, 4);
        BYTE = r104;
        Mode r105 = new Mode("ECI", 5, new int[]{0, 0, 0}, 7);
        ECI = r105;
        Mode r110 = new Mode("KANJI", 6, new int[]{8, 10, 12}, 8);
        KANJI = r110;
        Mode r111 = new Mode("FNC1_FIRST_POSITION", 7, new int[]{0, 0, 0}, 5);
        FNC1_FIRST_POSITION = r111;
        Mode r112 = new Mode("FNC1_SECOND_POSITION", 8, new int[]{0, 0, 0}, 9);
        FNC1_SECOND_POSITION = r112;
        Mode r113 = new Mode("HANZI", 9, new int[]{8, 10, 12}, 13);
        HANZI = r113;
        f439118a = new Mode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static Mode[] values() {
        return (Mode[]) f439118a.clone();
    }

    public int getBits() {
        return this.bits;
    }

    public static Mode forBits(int r100) {
        if (r100 == 0) goto L42;
        if (r100 == 1) goto L40;
        if (r100 == 2) goto L38;
        if (r100 == 3) goto L36;
        if (r100 == 4) goto L34;
        if (r100 == 5) goto L32;
        if (r100 == 7) goto L30;
        if (r100 == 8) goto L28;
        if (r100 == 9) goto L26;
        if (r100 != 13) goto L24;
        return HANZI;
    L24:
        throw new IllegalArgumentException();
    L26:
        return FNC1_SECOND_POSITION;
    L28:
        return KANJI;
    L30:
        return ECI;
    L32:
        return FNC1_FIRST_POSITION;
    L34:
        return BYTE;
    L36:
        return STRUCTURED_APPEND;
    L38:
        return ALPHANUMERIC;
    L40:
        return NUMERIC;
    L42:
        return TERMINATOR;
    }

    public static Mode valueOf(String r100) {
        return (Mode) r27.a.a(Mode.class, r100);
    }

    public int getCharacterCountBits(a r100) {
        int r101 = r100.f439120a;
        if (r101 > 9) goto L6;
        char r102 = 0;
    L10:
        return this.characterCountBitsForVersions[r102];
    L6:
        if (r101 > 26) goto L8;
        r102 = 1;
        goto L10
    L8:
        r102 = 2;
        goto L10
    }

    public Mode(String r100, int r101, int[] r102, int r103) {
        super(r100, r101);
        this.characterCountBitsForVersions = r102;
        this.bits = r103;
    }
}

package com.ss.android.lark.image.entity;

/* JADX INFO: loaded from: classes36.dex */
public final enum CutType extends Enum<CutType> {
    public static final CutType BOTTOM = null;
    public static final CutType CENTER = null;
    public static final CutType FACE = null;
    public static final CutType LEFT = null;
    public static final CutType RIGHT = null;
    public static final CutType TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CutType[] f426281a = null;
    private int value;

    static {
        CutType r100 = new CutType("TOP", 0, 1);
        TOP = r100;
        CutType r101 = new CutType("BOTTOM", 1, 2);
        BOTTOM = r101;
        CutType r102 = new CutType("LEFT", 2, 3);
        LEFT = r102;
        CutType r103 = new CutType("RIGHT", 3, 4);
        RIGHT = r103;
        CutType r104 = new CutType("CENTER", 4, 5);
        CENTER = r104;
        CutType r110 = new CutType("FACE", 5, 6);
        FACE = r110;
        f426281a = new CutType[]{r100, r101, r102, r103, r104, r110};
    }

    public static CutType[] values() {
        return (CutType[]) f426281a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static CutType forNumber(int r100) {
        switch(r100) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return CENTER;
    L6:
        return FACE;
    L8:
        return CENTER;
    L10:
        return RIGHT;
    L12:
        return LEFT;
    L14:
        return BOTTOM;
    L16:
        return TOP;
    }

    public static CutType valueOf(String r100) {
        return (CutType) r27.a.a(CutType.class, r100);
    }

    public static CutType valueOf(int r100) {
        return forNumber(r100);
    }

    public CutType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

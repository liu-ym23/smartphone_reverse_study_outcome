package com.ss.android.lark.message.card.entity;

import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum CardImageShowMode extends Enum<CardImageShowMode> {
    public static final CardImageShowMode CROP_CENTER = null;
    public static final CardImageShowMode FIT_HORIZONTAL = null;
    public static final CardImageShowMode LARGE = null;
    public static final CardImageShowMode MEDIUM = null;
    public static final CardImageShowMode SMALL = null;
    public static final CardImageShowMode STRETCH = null;
    public static final CardImageShowMode TINY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardImageShowMode[] f431905a = null;
    private int showModeValue;

    static {
        CardImageShowMode r100 = new CardImageShowMode("CROP_CENTER", 0, 0);
        CROP_CENTER = r100;
        CardImageShowMode r101 = new CardImageShowMode("STRETCH", 1, 1);
        STRETCH = r101;
        CardImageShowMode r102 = new CardImageShowMode("FIT_HORIZONTAL", 2, 2);
        FIT_HORIZONTAL = r102;
        CardImageShowMode r103 = new CardImageShowMode("LARGE", 3, 3);
        LARGE = r103;
        CardImageShowMode r104 = new CardImageShowMode("MEDIUM", 4, 4);
        MEDIUM = r104;
        CardImageShowMode r105 = new CardImageShowMode("SMALL", 5, 5);
        SMALL = r105;
        CardImageShowMode r110 = new CardImageShowMode("TINY", 6, 6);
        TINY = r110;
        f431905a = new CardImageShowMode[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static CardImageShowMode[] values() {
        return (CardImageShowMode[]) f431905a.clone();
    }

    public int getShowModeValue() {
        return this.showModeValue;
    }

    public static CardImageShowMode forNumber(int r100) {
        switch(r100) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return TINY;
    L8:
        return SMALL;
    L10:
        return MEDIUM;
    L12:
        return LARGE;
    L14:
        return FIT_HORIZONTAL;
    L16:
        return STRETCH;
    L18:
        return CROP_CENTER;
    }

    public static CardImageShowMode valueOf(String r100) {
        return (CardImageShowMode) a.a(CardImageShowMode.class, r100);
    }

    public static CardImageShowMode valueOf(int r100) {
        return forNumber(r100);
    }

    public CardImageShowMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.showModeValue = r102;
    }
}

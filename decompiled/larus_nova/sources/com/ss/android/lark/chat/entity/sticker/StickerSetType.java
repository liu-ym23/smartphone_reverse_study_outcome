package com.ss.android.lark.chat.entity.sticker;

import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum StickerSetType extends Enum<StickerSetType> {
    public static final StickerSetType FREE = null;
    public static final StickerSetType UNKNOWN_STICKER_SET_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StickerSetType[] f415361a = null;
    private int mValue;

    static {
        StickerSetType r100 = new StickerSetType("UNKNOWN_STICKER_SET_TYPE", 0, 0);
        UNKNOWN_STICKER_SET_TYPE = r100;
        StickerSetType r101 = new StickerSetType("FREE", 1, 1);
        FREE = r101;
        f415361a = new StickerSetType[]{r100, r101};
    }

    public static StickerSetType[] values() {
        return (StickerSetType[]) f415361a.clone();
    }

    public int getNumber() {
        return this.mValue;
    }

    public static StickerSetType forNumber(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return FREE;
    L10:
        return UNKNOWN_STICKER_SET_TYPE;
    }

    public static StickerSetType valueOf(String r100) {
        return (StickerSetType) a.a(StickerSetType.class, r100);
    }

    public static StickerSetType valueOf(int r100) {
        return forNumber(r100);
    }

    public StickerSetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}

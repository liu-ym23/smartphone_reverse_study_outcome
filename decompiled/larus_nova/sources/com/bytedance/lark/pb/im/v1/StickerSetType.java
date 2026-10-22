package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum StickerSetType extends Enum<StickerSetType> implements WireEnum {
    private static final /* synthetic */ StickerSetType[] $VALUES = null;
    public static final ProtoAdapter<StickerSetType> ADAPTER = null;
    public static final StickerSetType FREE = null;
    public static final StickerSetType UNKNOWN_STICKER_SET_TYPE = null;
    private final int value;

    static {
        StickerSetType r100 = new StickerSetType("UNKNOWN_STICKER_SET_TYPE", 0, 0);
        UNKNOWN_STICKER_SET_TYPE = r100;
        StickerSetType r101 = new StickerSetType("FREE", 1, 1);
        FREE = r101;
        $VALUES = new StickerSetType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(StickerSetType.class);
    }

    public static StickerSetType[] values() {
        return (StickerSetType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static StickerSetType fromValue(int r100) {
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

    private StickerSetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

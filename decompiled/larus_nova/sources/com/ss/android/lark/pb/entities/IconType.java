package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum IconType extends Enum<IconType> implements WireEnum {
    private static final /* synthetic */ IconType[] $VALUES = null;
    public static final ProtoAdapter<IconType> ADAPTER = null;
    public static final IconType EMOJI = null;
    public static final IconType IMAGE = null;
    public static final IconType UNKNOWN_ICON_TYPE = null;
    private final int value;

    static {
        IconType r100 = new IconType("UNKNOWN_ICON_TYPE", 0, 0);
        UNKNOWN_ICON_TYPE = r100;
        IconType r101 = new IconType("EMOJI", 1, 1);
        EMOJI = r101;
        IconType r102 = new IconType("IMAGE", 2, 2);
        IMAGE = r102;
        $VALUES = new IconType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(IconType.class);
    }

    public static IconType[] values() {
        return (IconType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static IconType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return IMAGE;
    L12:
        return EMOJI;
    L14:
        return UNKNOWN_ICON_TYPE;
    }

    public static IconType valueOf(String r100) {
        return (IconType) a.a(IconType.class, r100);
    }

    private IconType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

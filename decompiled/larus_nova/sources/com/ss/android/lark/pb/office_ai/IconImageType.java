package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum IconImageType extends Enum<IconImageType> implements WireEnum {
    private static final /* synthetic */ IconImageType[] $VALUES = null;
    public static final ProtoAdapter<IconImageType> ADAPTER = null;
    public static final IconImageType IconImageType_IMAGE = null;
    public static final IconImageType IconImageType_UD = null;
    private final int value;

    static {
        IconImageType r100 = new IconImageType("IconImageType_UD", 0, 1);
        IconImageType_UD = r100;
        IconImageType r101 = new IconImageType("IconImageType_IMAGE", 1, 2);
        IconImageType_IMAGE = r101;
        $VALUES = new IconImageType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(IconImageType.class);
    }

    public static IconImageType[] values() {
        return (IconImageType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static IconImageType fromValue(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return IconImageType_IMAGE;
    L11:
        return IconImageType_UD;
    }

    public static IconImageType valueOf(String r100) {
        return (IconImageType) a.a(IconImageType.class, r100);
    }

    private IconImageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

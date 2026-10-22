package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum CrossBrandActionUiStyleType extends Enum<CrossBrandActionUiStyleType> implements WireEnum {
    private static final /* synthetic */ CrossBrandActionUiStyleType[] $VALUES = null;
    public static final ProtoAdapter<CrossBrandActionUiStyleType> ADAPTER = null;
    public static final CrossBrandActionUiStyleType STYLE_TYPE_ALERT = null;
    public static final CrossBrandActionUiStyleType STYLE_TYPE_ALERT_NO_CONFIRM = null;
    public static final CrossBrandActionUiStyleType STYLE_TYPE_TIP = null;
    public static final CrossBrandActionUiStyleType STYLE_TYPE_TOAST = null;
    public static final CrossBrandActionUiStyleType STYLE_TYPE_UNKNOWN = null;
    private final int value;

    static {
        CrossBrandActionUiStyleType r100 = new CrossBrandActionUiStyleType("STYLE_TYPE_UNKNOWN", 0, 0);
        STYLE_TYPE_UNKNOWN = r100;
        CrossBrandActionUiStyleType r101 = new CrossBrandActionUiStyleType("STYLE_TYPE_ALERT", 1, 1);
        STYLE_TYPE_ALERT = r101;
        CrossBrandActionUiStyleType r102 = new CrossBrandActionUiStyleType("STYLE_TYPE_TOAST", 2, 2);
        STYLE_TYPE_TOAST = r102;
        CrossBrandActionUiStyleType r103 = new CrossBrandActionUiStyleType("STYLE_TYPE_TIP", 3, 3);
        STYLE_TYPE_TIP = r103;
        CrossBrandActionUiStyleType r104 = new CrossBrandActionUiStyleType("STYLE_TYPE_ALERT_NO_CONFIRM", 4, 4);
        STYLE_TYPE_ALERT_NO_CONFIRM = r104;
        $VALUES = new CrossBrandActionUiStyleType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(CrossBrandActionUiStyleType.class);
    }

    public static CrossBrandActionUiStyleType[] values() {
        return (CrossBrandActionUiStyleType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CrossBrandActionUiStyleType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return STYLE_TYPE_ALERT_NO_CONFIRM;
    L16:
        return STYLE_TYPE_TIP;
    L18:
        return STYLE_TYPE_TOAST;
    L20:
        return STYLE_TYPE_ALERT;
    L22:
        return STYLE_TYPE_UNKNOWN;
    }

    public static CrossBrandActionUiStyleType valueOf(String r100) {
        return (CrossBrandActionUiStyleType) a.a(CrossBrandActionUiStyleType.class, r100);
    }

    private CrossBrandActionUiStyleType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

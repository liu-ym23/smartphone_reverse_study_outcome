package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ExternalDisplayTimezoneSettingType extends Enum<ExternalDisplayTimezoneSettingType> implements WireEnum {
    private static final /* synthetic */ ExternalDisplayTimezoneSettingType[] $VALUES = null;
    public static final ProtoAdapter<ExternalDisplayTimezoneSettingType> ADAPTER = null;
    public static final ExternalDisplayTimezoneSettingType CUSTOM = null;
    public static final ExternalDisplayTimezoneSettingType FOLLOW_SYSTEM = null;
    public static final ExternalDisplayTimezoneSettingType HIDDEN = null;
    public static final ExternalDisplayTimezoneSettingType UNKNOWN = null;
    private final int value;

    static {
        ExternalDisplayTimezoneSettingType r100 = new ExternalDisplayTimezoneSettingType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ExternalDisplayTimezoneSettingType r101 = new ExternalDisplayTimezoneSettingType("FOLLOW_SYSTEM", 1, 1);
        FOLLOW_SYSTEM = r101;
        ExternalDisplayTimezoneSettingType r102 = new ExternalDisplayTimezoneSettingType("CUSTOM", 2, 2);
        CUSTOM = r102;
        ExternalDisplayTimezoneSettingType r103 = new ExternalDisplayTimezoneSettingType("HIDDEN", 3, 3);
        HIDDEN = r103;
        $VALUES = new ExternalDisplayTimezoneSettingType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ExternalDisplayTimezoneSettingType.class);
    }

    public static ExternalDisplayTimezoneSettingType[] values() {
        return (ExternalDisplayTimezoneSettingType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ExternalDisplayTimezoneSettingType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return HIDDEN;
    L14:
        return CUSTOM;
    L16:
        return FOLLOW_SYSTEM;
    L18:
        return UNKNOWN;
    }

    public static ExternalDisplayTimezoneSettingType valueOf(String r100) {
        return (ExternalDisplayTimezoneSettingType) a.a(ExternalDisplayTimezoneSettingType.class, r100);
    }

    private ExternalDisplayTimezoneSettingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

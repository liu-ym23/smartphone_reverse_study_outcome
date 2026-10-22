package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum DefDisplaySetting extends Enum<DefDisplaySetting> implements WireEnum {
    private static final /* synthetic */ DefDisplaySetting[] $VALUES = null;
    public static final ProtoAdapter<DefDisplaySetting> ADAPTER = null;
    public static final DefDisplaySetting CHAT_MENU = null;
    public static final DefDisplaySetting INPUT_BOX = null;
    public static final DefDisplaySetting UNKNOWN_DEF_DISPLAY_SETTING = null;
    private final int value;

    static {
        DefDisplaySetting r100 = new DefDisplaySetting("UNKNOWN_DEF_DISPLAY_SETTING", 0, 0);
        UNKNOWN_DEF_DISPLAY_SETTING = r100;
        DefDisplaySetting r101 = new DefDisplaySetting("INPUT_BOX", 1, 1);
        INPUT_BOX = r101;
        DefDisplaySetting r102 = new DefDisplaySetting("CHAT_MENU", 2, 2);
        CHAT_MENU = r102;
        $VALUES = new DefDisplaySetting[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(DefDisplaySetting.class);
    }

    public static DefDisplaySetting[] values() {
        return (DefDisplaySetting[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DefDisplaySetting fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return CHAT_MENU;
    L12:
        return INPUT_BOX;
    L14:
        return UNKNOWN_DEF_DISPLAY_SETTING;
    }

    public static DefDisplaySetting valueOf(String r100) {
        return (DefDisplaySetting) a.a(DefDisplaySetting.class, r100);
    }

    private DefDisplaySetting(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

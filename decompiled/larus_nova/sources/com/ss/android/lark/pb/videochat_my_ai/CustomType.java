package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum CustomType extends Enum<CustomType> implements WireEnum {
    private static final /* synthetic */ CustomType[] $VALUES = null;
    public static final ProtoAdapter<CustomType> ADAPTER = null;
    public static final CustomType CUSTOM_PULL_SUMMARY = null;
    public static final CustomType CUSTOM_PULL_TABS = null;
    public static final CustomType CUSTOM_PULL_TITLE = null;
    public static final CustomType CUSTOM_UNKNOWN = null;
    private final int value;

    static {
        CustomType r100 = new CustomType("CUSTOM_UNKNOWN", 0, 0);
        CUSTOM_UNKNOWN = r100;
        CustomType r101 = new CustomType("CUSTOM_PULL_SUMMARY", 1, 1);
        CUSTOM_PULL_SUMMARY = r101;
        CustomType r102 = new CustomType("CUSTOM_PULL_TABS", 2, 2);
        CUSTOM_PULL_TABS = r102;
        CustomType r103 = new CustomType("CUSTOM_PULL_TITLE", 3, 3);
        CUSTOM_PULL_TITLE = r103;
        $VALUES = new CustomType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(CustomType.class);
    }

    public static CustomType[] values() {
        return (CustomType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CustomType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return CUSTOM_PULL_TITLE;
    L14:
        return CUSTOM_PULL_TABS;
    L16:
        return CUSTOM_PULL_SUMMARY;
    L18:
        return CUSTOM_UNKNOWN;
    }

    public static CustomType valueOf(String r100) {
        return (CustomType) a.a(CustomType.class, r100);
    }

    private CustomType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

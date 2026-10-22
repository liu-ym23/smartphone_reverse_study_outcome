package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum CustomSubType extends Enum<CustomSubType> implements WireEnum {
    private static final /* synthetic */ CustomSubType[] $VALUES = null;
    public static final ProtoAdapter<CustomSubType> ADAPTER = null;
    public static final CustomSubType CUSTOM_GOLDEN_SENTENCES = null;
    public static final CustomSubType CUSTOM_KEY_POINT = null;
    public static final CustomSubType CUSTOM_MY_TODO = null;
    public static final CustomSubType CUSTOM_SELF_PERFORMANCE = null;
    public static final CustomSubType CUSTOM_SPEAKER_SUMMARY = null;
    public static final CustomSubType CUSTOM_SUB_UNKNOWN = null;
    private final int value;

    static {
        CustomSubType r100 = new CustomSubType("CUSTOM_SUB_UNKNOWN", 0, 0);
        CUSTOM_SUB_UNKNOWN = r100;
        CustomSubType r101 = new CustomSubType("CUSTOM_MY_TODO", 1, 1);
        CUSTOM_MY_TODO = r101;
        CustomSubType r102 = new CustomSubType("CUSTOM_KEY_POINT", 2, 2);
        CUSTOM_KEY_POINT = r102;
        CustomSubType r103 = new CustomSubType("CUSTOM_SPEAKER_SUMMARY", 3, 3);
        CUSTOM_SPEAKER_SUMMARY = r103;
        CustomSubType r104 = new CustomSubType("CUSTOM_GOLDEN_SENTENCES", 4, 4);
        CUSTOM_GOLDEN_SENTENCES = r104;
        CustomSubType r105 = new CustomSubType("CUSTOM_SELF_PERFORMANCE", 5, 5);
        CUSTOM_SELF_PERFORMANCE = r105;
        $VALUES = new CustomSubType[]{r100, r101, r102, r103, r104, r105};
        ADAPTER = ProtoAdapter.newEnumAdapter(CustomSubType.class);
    }

    public static CustomSubType[] values() {
        return (CustomSubType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CustomSubType fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return CUSTOM_SELF_PERFORMANCE;
    L18:
        return CUSTOM_GOLDEN_SENTENCES;
    L20:
        return CUSTOM_SPEAKER_SUMMARY;
    L22:
        return CUSTOM_KEY_POINT;
    L24:
        return CUSTOM_MY_TODO;
    L26:
        return CUSTOM_SUB_UNKNOWN;
    }

    public static CustomSubType valueOf(String r100) {
        return (CustomSubType) a.a(CustomSubType.class, r100);
    }

    private CustomSubType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

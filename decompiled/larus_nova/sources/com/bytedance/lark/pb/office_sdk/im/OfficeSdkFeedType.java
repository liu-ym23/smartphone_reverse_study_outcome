package com.bytedance.lark.pb.office_sdk.im;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum OfficeSdkFeedType extends Enum<OfficeSdkFeedType> implements WireEnum {
    private static final /* synthetic */ OfficeSdkFeedType[] $VALUES = null;
    public static final ProtoAdapter<OfficeSdkFeedType> ADAPTER = null;
    public static final OfficeSdkFeedType DOUBAO_CUSTOM = null;
    private final int value;

    static {
        OfficeSdkFeedType r100 = new OfficeSdkFeedType("DOUBAO_CUSTOM", 0, 15);
        DOUBAO_CUSTOM = r100;
        $VALUES = new OfficeSdkFeedType[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(OfficeSdkFeedType.class);
    }

    public static OfficeSdkFeedType[] values() {
        return (OfficeSdkFeedType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static OfficeSdkFeedType fromValue(int r100) {
        if (r100 == 15) goto L7;
        return null;
    L7:
        return DOUBAO_CUSTOM;
    }

    public static OfficeSdkFeedType valueOf(String r100) {
        return (OfficeSdkFeedType) a.a(OfficeSdkFeedType.class, r100);
    }

    private OfficeSdkFeedType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

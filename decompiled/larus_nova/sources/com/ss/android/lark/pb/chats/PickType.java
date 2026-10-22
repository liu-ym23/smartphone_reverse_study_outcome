package com.ss.android.lark.pb.chats;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum PickType extends Enum<PickType> implements WireEnum {
    private static final /* synthetic */ PickType[] $VALUES = null;
    public static final ProtoAdapter<PickType> ADAPTER = null;
    public static final PickType CHAT = null;
    public static final PickType DEPT = null;
    public static final PickType UNKNOWN = null;
    public static final PickType USER = null;
    private final int value;

    static {
        PickType r100 = new PickType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        PickType r101 = new PickType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
        USER = r101;
        PickType r102 = new PickType("CHAT", 2, 2);
        CHAT = r102;
        PickType r103 = new PickType("DEPT", 3, 3);
        DEPT = r103;
        $VALUES = new PickType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(PickType.class);
    }

    public static PickType[] values() {
        return (PickType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PickType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return DEPT;
    L14:
        return CHAT;
    L16:
        return USER;
    L18:
        return UNKNOWN;
    }

    public static PickType valueOf(String r100) {
        return (PickType) a.a(PickType.class, r100);
    }

    private PickType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

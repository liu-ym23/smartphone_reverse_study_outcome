package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ChatterType extends Enum<ChatterType> implements WireEnum {
    private static final /* synthetic */ ChatterType[] $VALUES = null;
    public static final ProtoAdapter<ChatterType> ADAPTER = null;
    public static final ChatterType AI = null;
    public static final ChatterType BOT = null;
    public static final ChatterType DOUBAO = null;
    public static final ChatterType UNKNOWN_CHATTER = null;
    public static final ChatterType USER = null;
    private final int value;

    static {
        ChatterType r100 = new ChatterType("UNKNOWN_CHATTER", 0, 0);
        UNKNOWN_CHATTER = r100;
        ChatterType r101 = new ChatterType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 1, 1);
        USER = r101;
        ChatterType r102 = new ChatterType("BOT", 2, 2);
        BOT = r102;
        ChatterType r103 = new ChatterType("AI", 3, 3);
        AI = r103;
        ChatterType r104 = new ChatterType("DOUBAO", 4, 4);
        DOUBAO = r104;
        $VALUES = new ChatterType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatterType.class);
    }

    public static ChatterType[] values() {
        return (ChatterType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChatterType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return DOUBAO;
    L16:
        return AI;
    L18:
        return BOT;
    L20:
        return USER;
    L22:
        return UNKNOWN_CHATTER;
    }

    public static ChatterType valueOf(String r100) {
        return (ChatterType) a.a(ChatterType.class, r100);
    }

    private ChatterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

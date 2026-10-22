package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum MuteWay extends Enum<MuteWay> implements WireEnum {
    private static final /* synthetic */ MuteWay[] $VALUES = null;
    public static final ProtoAdapter<MuteWay> ADAPTER = null;
    public static final MuteWay AUTO_MUTE_WAY = null;
    public static final MuteWay MANUAL_MUTE_WAY = null;
    public static final MuteWay UNKNOWN_MUTE_WAY = null;
    private final int value;

    static {
        MuteWay r100 = new MuteWay("UNKNOWN_MUTE_WAY", 0, 0);
        UNKNOWN_MUTE_WAY = r100;
        MuteWay r101 = new MuteWay("AUTO_MUTE_WAY", 1, 1);
        AUTO_MUTE_WAY = r101;
        MuteWay r102 = new MuteWay("MANUAL_MUTE_WAY", 2, 2);
        MANUAL_MUTE_WAY = r102;
        $VALUES = new MuteWay[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(MuteWay.class);
    }

    public static MuteWay[] values() {
        return (MuteWay[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static MuteWay fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return MANUAL_MUTE_WAY;
    L12:
        return AUTO_MUTE_WAY;
    L14:
        return UNKNOWN_MUTE_WAY;
    }

    public static MuteWay valueOf(String r100) {
        return (MuteWay) a.a(MuteWay.class, r100);
    }

    private MuteWay(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.ss.ugc.live.sdk.msg.unify.data.idl;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final enum UMGWEventType extends Enum<UMGWEventType> implements WireEnum {
    private static final /* synthetic */ UMGWEventType[] $VALUES = null;
    public static final ProtoAdapter<UMGWEventType> ADAPTER = null;
    public static final UMGWEventType DOWNLINK_ACK = null;
    public static final UMGWEventType DOWNLINK_MSG = null;
    public static final UMGWEventType FETCH = null;
    public static final UMGWEventType UPLINK_ACK = null;
    public static final UMGWEventType UPLINK_HB = null;
    public static final UMGWEventType UPLINK_REGISTER = null;
    public static final UMGWEventType UPLINK_UNREGISTER = null;
    private final int value;

    static {
        UMGWEventType r100 = new UMGWEventType("FETCH", 0, 0);
        FETCH = r100;
        UMGWEventType r101 = new UMGWEventType("UPLINK_REGISTER", 1, 1);
        UPLINK_REGISTER = r101;
        UMGWEventType r102 = new UMGWEventType("UPLINK_UNREGISTER", 2, 2);
        UPLINK_UNREGISTER = r102;
        UMGWEventType r103 = new UMGWEventType("UPLINK_HB", 3, 3);
        UPLINK_HB = r103;
        UMGWEventType r104 = new UMGWEventType("UPLINK_ACK", 4, 4);
        UPLINK_ACK = r104;
        UMGWEventType r105 = new UMGWEventType("DOWNLINK_ACK", 5, 5);
        DOWNLINK_ACK = r105;
        UMGWEventType r110 = new UMGWEventType("DOWNLINK_MSG", 6, 6);
        DOWNLINK_MSG = r110;
        $VALUES = new UMGWEventType[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = new ProtoAdapter_UMGWEventType();
    }

    public static UMGWEventType[] values() {
        return (UMGWEventType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static UMGWEventType fromValue(int r100) {
        switch(r100) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return DOWNLINK_MSG;
    L8:
        return DOWNLINK_ACK;
    L10:
        return UPLINK_ACK;
    L12:
        return UPLINK_HB;
    L14:
        return UPLINK_UNREGISTER;
    L16:
        return UPLINK_REGISTER;
    L18:
        return FETCH;
    }

    public static UMGWEventType valueOf(String r100) {
        return (UMGWEventType) a.a(UMGWEventType.class, r100);
    }

    private UMGWEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.bytedance.sync.v2.protocal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum PacketStatus extends Enum<PacketStatus> implements WireEnum {
    private static final /* synthetic */ PacketStatus[] $VALUES = null;
    public static final ProtoAdapter<PacketStatus> ADAPTER = null;
    public static final PacketStatus Full = null;
    public static final PacketStatus OnlySave = null;
    private final int value;

    static {
        PacketStatus r100 = new PacketStatus("Full", 0, 0);
        Full = r100;
        PacketStatus r101 = new PacketStatus("OnlySave", 1, 1);
        OnlySave = r101;
        $VALUES = new PacketStatus[]{r100, r101};
        ADAPTER = new ProtoAdapter_PacketStatus();
    }

    public static PacketStatus[] values() {
        return (PacketStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static PacketStatus fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return OnlySave;
    L10:
        return Full;
    }

    public static PacketStatus valueOf(String r100) {
        return (PacketStatus) r27.a.a(PacketStatus.class, r100);
    }

    private PacketStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

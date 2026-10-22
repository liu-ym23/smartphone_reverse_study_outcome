package com.bytedance.sync.v2.protocal;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes3.dex */
public final enum Flag extends Enum<Flag> implements WireEnum {
    private static final /* synthetic */ Flag[] $VALUES = null;
    public static final Flag ACK = null;
    public static final ProtoAdapter<Flag> ADAPTER = null;
    public static final Flag Data = null;
    public static final Flag FIN = null;
    public static final Flag None = null;
    public static final Flag Poll = null;
    public static final Flag Sync = null;
    private final int value;

    static {
        Flag r100 = new Flag("None", 0, 0);
        None = r100;
        Flag r101 = new Flag("ACK", 1, 1);
        ACK = r101;
        Flag r102 = new Flag("Data", 2, 2);
        Data = r102;
        Flag r103 = new Flag("Sync", 3, 3);
        Sync = r103;
        Flag r104 = new Flag("Poll", 4, 4);
        Poll = r104;
        Flag r105 = new Flag("FIN", 5, 5);
        FIN = r105;
        $VALUES = new Flag[]{r100, r101, r102, r103, r104, r105};
        ADAPTER = new ProtoAdapter_Flag();
    }

    public static Flag[] values() {
        return (Flag[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public int getValue() {
        return this.value;
    }

    public static Flag fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return FIN;
    L18:
        return Poll;
    L20:
        return Sync;
    L22:
        return Data;
    L24:
        return ACK;
    L26:
        return None;
    }

    public static Flag valueOf(String r100) {
        return (Flag) r27.a.a(Flag.class, r100);
    }

    private Flag(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

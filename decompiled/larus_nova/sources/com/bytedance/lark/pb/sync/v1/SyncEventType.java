package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SyncEventType extends Enum<SyncEventType> implements WireEnum {
    private static final /* synthetic */ SyncEventType[] $VALUES = null;
    public static final ProtoAdapter<SyncEventType> ADAPTER = null;
    public static final SyncEventType BIZ_RESET = null;
    public static final SyncEventType UNKNOWN = null;
    private final int value;

    static {
        SyncEventType r100 = new SyncEventType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        SyncEventType r101 = new SyncEventType("BIZ_RESET", 1, 1);
        BIZ_RESET = r101;
        $VALUES = new SyncEventType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(SyncEventType.class);
    }

    public static SyncEventType[] values() {
        return (SyncEventType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SyncEventType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return BIZ_RESET;
    L10:
        return UNKNOWN;
    }

    public static SyncEventType valueOf(String r100) {
        return (SyncEventType) a.a(SyncEventType.class, r100);
    }

    private SyncEventType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

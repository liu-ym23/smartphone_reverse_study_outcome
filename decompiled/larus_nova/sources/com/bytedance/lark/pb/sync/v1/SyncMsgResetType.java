package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SyncMsgResetType extends Enum<SyncMsgResetType> implements WireEnum {
    private static final /* synthetic */ SyncMsgResetType[] $VALUES = null;
    public static final ProtoAdapter<SyncMsgResetType> ADAPTER = null;
    public static final SyncMsgResetType FROM_BIZ_KEY = null;
    public static final SyncMsgResetType FROM_LAST_MSG = null;
    private final int value;

    static {
        SyncMsgResetType r100 = new SyncMsgResetType("FROM_LAST_MSG", 0, 0);
        FROM_LAST_MSG = r100;
        SyncMsgResetType r101 = new SyncMsgResetType("FROM_BIZ_KEY", 1, 1);
        FROM_BIZ_KEY = r101;
        $VALUES = new SyncMsgResetType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(SyncMsgResetType.class);
    }

    public static SyncMsgResetType[] values() {
        return (SyncMsgResetType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SyncMsgResetType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return FROM_BIZ_KEY;
    L10:
        return FROM_LAST_MSG;
    }

    public static SyncMsgResetType valueOf(String r100) {
        return (SyncMsgResetType) a.a(SyncMsgResetType.class, r100);
    }

    private SyncMsgResetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

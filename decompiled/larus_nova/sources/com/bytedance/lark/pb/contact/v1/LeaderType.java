package com.bytedance.lark.pb.contact.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum LeaderType extends Enum<LeaderType> implements WireEnum {
    private static final /* synthetic */ LeaderType[] $VALUES = null;
    public static final ProtoAdapter<LeaderType> ADAPTER = null;
    public static final LeaderType EnterpriseLeader = null;
    public static final LeaderType MainLeader = null;
    public static final LeaderType SubLeader = null;
    private final int value;

    static {
        LeaderType r100 = new LeaderType("MainLeader", 0, 1);
        MainLeader = r100;
        LeaderType r101 = new LeaderType("SubLeader", 1, 2);
        SubLeader = r101;
        LeaderType r102 = new LeaderType("EnterpriseLeader", 2, 3);
        EnterpriseLeader = r102;
        $VALUES = new LeaderType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(LeaderType.class);
    }

    public static LeaderType[] values() {
        return (LeaderType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static LeaderType fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return EnterpriseLeader;
    L13:
        return SubLeader;
    L15:
        return MainLeader;
    }

    public static LeaderType valueOf(String r100) {
        return (LeaderType) a.a(LeaderType.class, r100);
    }

    private LeaderType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

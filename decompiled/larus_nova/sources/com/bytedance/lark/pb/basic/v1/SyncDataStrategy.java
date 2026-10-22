package com.bytedance.lark.pb.basic.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SyncDataStrategy extends Enum<SyncDataStrategy> implements WireEnum {
    private static final /* synthetic */ SyncDataStrategy[] $VALUES = null;
    public static final ProtoAdapter<SyncDataStrategy> ADAPTER = null;
    public static final SyncDataStrategy FORCE_SERVER = null;
    public static final SyncDataStrategy LOCAL = null;
    public static final SyncDataStrategy TRY_LOCAL = null;
    private final int value;

    static {
        SyncDataStrategy r100 = new SyncDataStrategy(AccountType.LOCAL, 0, 1);
        LOCAL = r100;
        SyncDataStrategy r101 = new SyncDataStrategy("TRY_LOCAL", 1, 2);
        TRY_LOCAL = r101;
        SyncDataStrategy r102 = new SyncDataStrategy("FORCE_SERVER", 2, 3);
        FORCE_SERVER = r102;
        $VALUES = new SyncDataStrategy[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(SyncDataStrategy.class);
    }

    public static SyncDataStrategy[] values() {
        return (SyncDataStrategy[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SyncDataStrategy fromValue(int r100) {
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L11;
        return null;
    L11:
        return FORCE_SERVER;
    L13:
        return TRY_LOCAL;
    L15:
        return LOCAL;
    }

    public static SyncDataStrategy valueOf(String r100) {
        return (SyncDataStrategy) a.a(SyncDataStrategy.class, r100);
    }

    private SyncDataStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

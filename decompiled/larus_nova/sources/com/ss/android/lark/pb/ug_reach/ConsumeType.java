package com.ss.android.lark.pb.ug_reach;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ConsumeType extends Enum<ConsumeType> implements WireEnum {
    private static final /* synthetic */ ConsumeType[] $VALUES = null;
    public static final ProtoAdapter<ConsumeType> ADAPTER = null;
    public static final ConsumeType ALL = null;
    public static final ConsumeType UNKNOWN = null;
    private final int value;

    static {
        ConsumeType r100 = new ConsumeType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        ConsumeType r101 = new ConsumeType(AccountType.ALL, 1, 1);
        ALL = r101;
        $VALUES = new ConsumeType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(ConsumeType.class);
    }

    public static ConsumeType[] values() {
        return (ConsumeType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ConsumeType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return ALL;
    L10:
        return UNKNOWN;
    }

    public static ConsumeType valueOf(String r100) {
        return (ConsumeType) a.a(ConsumeType.class, r100);
    }

    private ConsumeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

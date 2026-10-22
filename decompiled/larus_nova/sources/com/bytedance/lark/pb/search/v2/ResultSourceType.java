package com.bytedance.lark.pb.search.v2;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ResultSourceType extends Enum<ResultSourceType> implements WireEnum {
    private static final /* synthetic */ ResultSourceType[] $VALUES = null;
    public static final ProtoAdapter<ResultSourceType> ADAPTER = null;
    public static final ResultSourceType DEFAULT = null;
    public static final ResultSourceType LOCAL = null;
    public static final ResultSourceType NET = null;
    private final int value;

    static {
        ResultSourceType r100 = new ResultSourceType("DEFAULT", 0, 0);
        DEFAULT = r100;
        ResultSourceType r101 = new ResultSourceType(AccountType.LOCAL, 1, 1);
        LOCAL = r101;
        ResultSourceType r102 = new ResultSourceType("NET", 2, 2);
        NET = r102;
        $VALUES = new ResultSourceType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ResultSourceType.class);
    }

    public static ResultSourceType[] values() {
        return (ResultSourceType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ResultSourceType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return NET;
    L12:
        return LOCAL;
    L14:
        return DEFAULT;
    }

    public static ResultSourceType valueOf(String r100) {
        return (ResultSourceType) a.a(ResultSourceType.class, r100);
    }

    private ResultSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

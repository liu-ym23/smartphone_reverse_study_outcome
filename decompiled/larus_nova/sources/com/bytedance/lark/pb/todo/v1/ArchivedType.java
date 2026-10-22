package com.bytedance.lark.pb.todo.v1;

import com.obric.miniapp.alarm.AccountType;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ArchivedType extends Enum<ArchivedType> implements WireEnum {
    private static final /* synthetic */ ArchivedType[] $VALUES = null;
    public static final ProtoAdapter<ArchivedType> ADAPTER = null;
    public static final ArchivedType ALL = null;
    public static final ArchivedType ARCHIVED = null;
    public static final ArchivedType NOT_ARCHIVED = null;
    private final int value;

    static {
        ArchivedType r100 = new ArchivedType(AccountType.ALL, 0, 0);
        ALL = r100;
        ArchivedType r101 = new ArchivedType("NOT_ARCHIVED", 1, 1);
        NOT_ARCHIVED = r101;
        ArchivedType r102 = new ArchivedType("ARCHIVED", 2, 2);
        ARCHIVED = r102;
        $VALUES = new ArchivedType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ArchivedType.class);
    }

    public static ArchivedType[] values() {
        return (ArchivedType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ArchivedType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return ARCHIVED;
    L12:
        return NOT_ARCHIVED;
    L14:
        return ALL;
    }

    public static ArchivedType valueOf(String r100) {
        return (ArchivedType) a.a(ArchivedType.class, r100);
    }

    private ArchivedType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

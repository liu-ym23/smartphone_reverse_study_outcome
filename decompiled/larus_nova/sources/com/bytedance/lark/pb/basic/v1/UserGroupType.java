package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum UserGroupType extends Enum<UserGroupType> implements WireEnum {
    private static final /* synthetic */ UserGroupType[] $VALUES = null;
    public static final ProtoAdapter<UserGroupType> ADAPTER = null;
    public static final UserGroupType UserGroupType_ASSIGN = null;
    public static final UserGroupType UserGroupType_DYNAMIC = null;
    public static final UserGroupType UserGroupType_UNKNOWN = null;
    private final int value;

    static {
        UserGroupType r100 = new UserGroupType("UserGroupType_UNKNOWN", 0, 0);
        UserGroupType_UNKNOWN = r100;
        UserGroupType r101 = new UserGroupType("UserGroupType_ASSIGN", 1, 1);
        UserGroupType_ASSIGN = r101;
        UserGroupType r102 = new UserGroupType("UserGroupType_DYNAMIC", 2, 2);
        UserGroupType_DYNAMIC = r102;
        $VALUES = new UserGroupType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserGroupType.class);
    }

    public static UserGroupType[] values() {
        return (UserGroupType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UserGroupType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return UserGroupType_DYNAMIC;
    L12:
        return UserGroupType_ASSIGN;
    L14:
        return UserGroupType_UNKNOWN;
    }

    public static UserGroupType valueOf(String r100) {
        return (UserGroupType) a.a(UserGroupType.class, r100);
    }

    private UserGroupType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

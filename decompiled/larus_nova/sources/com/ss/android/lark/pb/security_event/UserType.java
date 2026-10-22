package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum UserType extends Enum<UserType> implements WireEnum {
    private static final /* synthetic */ UserType[] $VALUES = null;
    public static final ProtoAdapter<UserType> ADAPTER = null;
    public static final UserType UserTypeAnonymity = null;
    public static final UserType UserTypeApp = null;
    public static final UserType UserTypePeople = null;
    public static final UserType UserTypeTemp = null;
    public static final UserType UserTypeUnknown = null;
    private final int value;

    static {
        UserType r100 = new UserType("UserTypeUnknown", 0, 0);
        UserTypeUnknown = r100;
        UserType r101 = new UserType("UserTypeAnonymity", 1, 1);
        UserTypeAnonymity = r101;
        UserType r102 = new UserType("UserTypeTemp", 2, 2);
        UserTypeTemp = r102;
        UserType r103 = new UserType("UserTypeApp", 3, 3);
        UserTypeApp = r103;
        UserType r104 = new UserType("UserTypePeople", 4, 42);
        UserTypePeople = r104;
        $VALUES = new UserType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserType.class);
    }

    public static UserType[] values() {
        return (UserType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UserType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 42) goto L14;
        return null;
    L14:
        return UserTypePeople;
    L16:
        return UserTypeApp;
    L18:
        return UserTypeTemp;
    L20:
        return UserTypeAnonymity;
    L22:
        return UserTypeUnknown;
    }

    public static UserType valueOf(String r100) {
        return (UserType) a.a(UserType.class, r100);
    }

    private UserType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

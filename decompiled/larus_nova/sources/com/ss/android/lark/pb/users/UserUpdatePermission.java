package com.ss.android.lark.pb.users;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum UserUpdatePermission extends Enum<UserUpdatePermission> implements WireEnum {
    private static final /* synthetic */ UserUpdatePermission[] $VALUES = null;
    public static final ProtoAdapter<UserUpdatePermission> ADAPTER = null;
    public static final UserUpdatePermission Avatar = null;
    private final int value;

    static {
        UserUpdatePermission r100 = new UserUpdatePermission("Avatar", 0, 1);
        Avatar = r100;
        $VALUES = new UserUpdatePermission[]{r100};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserUpdatePermission.class);
    }

    public static UserUpdatePermission[] values() {
        return (UserUpdatePermission[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UserUpdatePermission fromValue(int r100) {
        if (r100 == 1) goto L7;
        return null;
    L7:
        return Avatar;
    }

    public static UserUpdatePermission valueOf(String r100) {
        return (UserUpdatePermission) a.a(UserUpdatePermission.class, r100);
    }

    private UserUpdatePermission(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

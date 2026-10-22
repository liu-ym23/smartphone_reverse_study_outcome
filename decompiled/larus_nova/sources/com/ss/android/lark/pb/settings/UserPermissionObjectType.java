package com.ss.android.lark.pb.settings;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum UserPermissionObjectType extends Enum<UserPermissionObjectType> implements WireEnum {
    private static final /* synthetic */ UserPermissionObjectType[] $VALUES = null;
    public static final ProtoAdapter<UserPermissionObjectType> ADAPTER = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_CHAT = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_CUSTOM_GROUP = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_TEAM = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_USER = null;
    public static final UserPermissionObjectType USER_PERMISSION_OBJECT_TYPE_USER_TYPE = null;
    private final int value;

    static {
        UserPermissionObjectType r100 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_USER", 0, 1);
        USER_PERMISSION_OBJECT_TYPE_USER = r100;
        UserPermissionObjectType r101 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_CHAT", 1, 2);
        USER_PERMISSION_OBJECT_TYPE_CHAT = r101;
        UserPermissionObjectType r102 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_USER_TYPE", 2, 3);
        USER_PERMISSION_OBJECT_TYPE_USER_TYPE = r102;
        UserPermissionObjectType r103 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_TEAM", 3, 4);
        USER_PERMISSION_OBJECT_TYPE_TEAM = r103;
        UserPermissionObjectType r104 = new UserPermissionObjectType("USER_PERMISSION_OBJECT_TYPE_CUSTOM_GROUP", 4, 5);
        USER_PERMISSION_OBJECT_TYPE_CUSTOM_GROUP = r104;
        $VALUES = new UserPermissionObjectType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserPermissionObjectType.class);
    }

    public static UserPermissionObjectType[] values() {
        return (UserPermissionObjectType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UserPermissionObjectType fromValue(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return null;
    L15:
        return USER_PERMISSION_OBJECT_TYPE_CUSTOM_GROUP;
    L17:
        return USER_PERMISSION_OBJECT_TYPE_TEAM;
    L19:
        return USER_PERMISSION_OBJECT_TYPE_USER_TYPE;
    L21:
        return USER_PERMISSION_OBJECT_TYPE_CHAT;
    L23:
        return USER_PERMISSION_OBJECT_TYPE_USER;
    }

    public static UserPermissionObjectType valueOf(String r100) {
        return (UserPermissionObjectType) a.a(UserPermissionObjectType.class, r100);
    }

    private UserPermissionObjectType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

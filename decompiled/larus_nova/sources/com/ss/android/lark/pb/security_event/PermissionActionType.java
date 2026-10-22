package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum PermissionActionType extends Enum<PermissionActionType> implements WireEnum {
    private static final /* synthetic */ PermissionActionType[] $VALUES = null;
    public static final ProtoAdapter<PermissionActionType> ADAPTER = null;
    public static final PermissionActionType AddChat = null;
    public static final PermissionActionType AddDepartment = null;
    public static final PermissionActionType AddUser = null;
    public static final PermissionActionType PermissionActionTypeUnknown = null;
    public static final PermissionActionType RemoveChat = null;
    public static final PermissionActionType RemoveDepartment = null;
    public static final PermissionActionType RemoveUser = null;
    private final int value;

    static {
        PermissionActionType r100 = new PermissionActionType("PermissionActionTypeUnknown", 0, 0);
        PermissionActionTypeUnknown = r100;
        PermissionActionType r101 = new PermissionActionType("AddUser", 1, 1);
        AddUser = r101;
        PermissionActionType r102 = new PermissionActionType("RemoveUser", 2, 2);
        RemoveUser = r102;
        PermissionActionType r103 = new PermissionActionType("AddChat", 3, 3);
        AddChat = r103;
        PermissionActionType r104 = new PermissionActionType("RemoveChat", 4, 4);
        RemoveChat = r104;
        PermissionActionType r105 = new PermissionActionType("AddDepartment", 5, 5);
        AddDepartment = r105;
        PermissionActionType r110 = new PermissionActionType("RemoveDepartment", 6, 6);
        RemoveDepartment = r110;
        $VALUES = new PermissionActionType[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(PermissionActionType.class);
    }

    public static PermissionActionType[] values() {
        return (PermissionActionType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PermissionActionType fromValue(int r100) {
        switch(r100) {
            case 0: goto L18;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return RemoveDepartment;
    L8:
        return AddDepartment;
    L10:
        return RemoveChat;
    L12:
        return AddChat;
    L14:
        return RemoveUser;
    L16:
        return AddUser;
    L18:
        return PermissionActionTypeUnknown;
    }

    public static PermissionActionType valueOf(String r100) {
        return (PermissionActionType) a.a(PermissionActionType.class, r100);
    }

    private PermissionActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum PermissionSettingType extends Enum<PermissionSettingType> implements WireEnum {
    private static final /* synthetic */ PermissionSettingType[] $VALUES = null;
    public static final ProtoAdapter<PermissionSettingType> ADAPTER = null;
    public static final PermissionSettingType CanEditByLinkInInternet = null;
    public static final PermissionSettingType CanEditByLinkInTenant = null;
    public static final PermissionSettingType CanReadByLinkInInternet = null;
    public static final PermissionSettingType CanReadByLinkInTenant = null;
    public static final PermissionSettingType DisableLinkShare = null;
    public static final PermissionSettingType PermissionSettingTypeUnknown = null;
    private final int value;

    static {
        PermissionSettingType r100 = new PermissionSettingType("PermissionSettingTypeUnknown", 0, 0);
        PermissionSettingTypeUnknown = r100;
        PermissionSettingType r101 = new PermissionSettingType("DisableLinkShare", 1, 1);
        DisableLinkShare = r101;
        PermissionSettingType r102 = new PermissionSettingType("CanReadByLinkInTenant", 2, 2);
        CanReadByLinkInTenant = r102;
        PermissionSettingType r103 = new PermissionSettingType("CanEditByLinkInTenant", 3, 3);
        CanEditByLinkInTenant = r103;
        PermissionSettingType r104 = new PermissionSettingType("CanReadByLinkInInternet", 4, 4);
        CanReadByLinkInInternet = r104;
        PermissionSettingType r105 = new PermissionSettingType("CanEditByLinkInInternet", 5, 5);
        CanEditByLinkInInternet = r105;
        $VALUES = new PermissionSettingType[]{r100, r101, r102, r103, r104, r105};
        ADAPTER = ProtoAdapter.newEnumAdapter(PermissionSettingType.class);
    }

    public static PermissionSettingType[] values() {
        return (PermissionSettingType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PermissionSettingType fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return CanEditByLinkInInternet;
    L18:
        return CanReadByLinkInInternet;
    L20:
        return CanEditByLinkInTenant;
    L22:
        return CanReadByLinkInTenant;
    L24:
        return DisableLinkShare;
    L26:
        return PermissionSettingTypeUnknown;
    }

    public static PermissionSettingType valueOf(String r100) {
        return (PermissionSettingType) a.a(PermissionSettingType.class, r100);
    }

    private PermissionSettingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

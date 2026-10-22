package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum TenantNameStatus extends Enum<TenantNameStatus> implements WireEnum {
    private static final /* synthetic */ TenantNameStatus[] $VALUES = null;
    public static final ProtoAdapter<TenantNameStatus> ADAPTER = null;
    public static final TenantNameStatus TENANT_NAME_STATUS_HIDE = null;
    public static final TenantNameStatus TENANT_NAME_STATUS_NOT_FRIEND = null;
    public static final TenantNameStatus TENANT_NAME_STATUS_UNKNOWN = null;
    public static final TenantNameStatus TENANT_NAME_STATUS_VISIBLE = null;
    private final int value;

    static {
        TenantNameStatus r100 = new TenantNameStatus("TENANT_NAME_STATUS_UNKNOWN", 0, 0);
        TENANT_NAME_STATUS_UNKNOWN = r100;
        TenantNameStatus r101 = new TenantNameStatus("TENANT_NAME_STATUS_NOT_FRIEND", 1, 1);
        TENANT_NAME_STATUS_NOT_FRIEND = r101;
        TenantNameStatus r102 = new TenantNameStatus("TENANT_NAME_STATUS_VISIBLE", 2, 2);
        TENANT_NAME_STATUS_VISIBLE = r102;
        TenantNameStatus r103 = new TenantNameStatus("TENANT_NAME_STATUS_HIDE", 3, 3);
        TENANT_NAME_STATUS_HIDE = r103;
        $VALUES = new TenantNameStatus[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(TenantNameStatus.class);
    }

    public static TenantNameStatus[] values() {
        return (TenantNameStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TenantNameStatus fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return TENANT_NAME_STATUS_HIDE;
    L14:
        return TENANT_NAME_STATUS_VISIBLE;
    L16:
        return TENANT_NAME_STATUS_NOT_FRIEND;
    L18:
        return TENANT_NAME_STATUS_UNKNOWN;
    }

    public static TenantNameStatus valueOf(String r100) {
        return (TenantNameStatus) a.a(TenantNameStatus.class, r100);
    }

    private TenantNameStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}

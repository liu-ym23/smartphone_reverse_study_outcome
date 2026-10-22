package com.bytedance.ug.sdk.share.api.entity;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum PermissionType extends Enum<PermissionType> {
    public static final PermissionType DENIED = null;
    public static final PermissionType GRANTED = null;
    public static final PermissionType SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionType[] f272306a = null;

    static {
        PermissionType r100 = new PermissionType("SHOW", 0);
        SHOW = r100;
        PermissionType r101 = new PermissionType("DENIED", 1);
        DENIED = r101;
        PermissionType r102 = new PermissionType("GRANTED", 2);
        GRANTED = r102;
        f272306a = new PermissionType[]{r100, r101, r102};
    }

    public static PermissionType[] values() {
        return (PermissionType[]) f272306a.clone();
    }

    public static PermissionType valueOf(String r100) {
        return (PermissionType) a.a(PermissionType.class, r100);
    }

    public PermissionType(String r100, int r101) {
        super(r100, r101);
    }
}

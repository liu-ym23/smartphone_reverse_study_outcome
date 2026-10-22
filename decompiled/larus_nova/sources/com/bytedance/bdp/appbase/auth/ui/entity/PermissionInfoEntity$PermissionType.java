package com.bytedance.bdp.appbase.auth.ui.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/bdp/appbase/auth/ui/entity/PermissionInfoEntity$PermissionType", "", "Lcom/bytedance/bdp/appbase/auth/ui/entity/PermissionInfoEntity$PermissionType;", "REQUIRED", "DEFAULT_CHOSEN", "DEFAULT_NOT_CHOSEN", "bdp-eco-core_release"}, k = 1, mv = {1, 4, 0})
public final enum PermissionInfoEntity$PermissionType extends Enum<PermissionInfoEntity$PermissionType> {
    public static final PermissionInfoEntity$PermissionType DEFAULT_CHOSEN = null;
    public static final PermissionInfoEntity$PermissionType DEFAULT_NOT_CHOSEN = null;
    public static final PermissionInfoEntity$PermissionType REQUIRED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionInfoEntity$PermissionType[] f200405a = null;

    static {
        PermissionInfoEntity$PermissionType r100 = new PermissionInfoEntity$PermissionType("REQUIRED", 0);
        REQUIRED = r100;
        PermissionInfoEntity$PermissionType r101 = new PermissionInfoEntity$PermissionType("DEFAULT_CHOSEN", 1);
        DEFAULT_CHOSEN = r101;
        PermissionInfoEntity$PermissionType r102 = new PermissionInfoEntity$PermissionType("DEFAULT_NOT_CHOSEN", 2);
        DEFAULT_NOT_CHOSEN = r102;
        f200405a = new PermissionInfoEntity$PermissionType[]{r100, r101, r102};
    }

    public static PermissionInfoEntity$PermissionType valueOf(String r100) {
        return (PermissionInfoEntity$PermissionType) a.a(PermissionInfoEntity$PermissionType.class, r100);
    }

    public static PermissionInfoEntity$PermissionType[] values() {
        return (PermissionInfoEntity$PermissionType[]) f200405a.clone();
    }

    public PermissionInfoEntity$PermissionType(String r100, int r101) {
        super(r100, r101);
    }
}

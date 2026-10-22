package com.bytedance.ies.xbridge.base.bridge;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/ies/xbridge/base/bridge/XCheckPermissionMethod$PermissionStatus", "", "Lcom/bytedance/ies/xbridge/base/bridge/XCheckPermissionMethod$PermissionStatus;", "PERMITTED", "DENIED", "UNDETERMINED", "RESTRICTED", "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final enum XCheckPermissionMethod$PermissionStatus extends Enum<XCheckPermissionMethod$PermissionStatus> {
    public static final XCheckPermissionMethod$PermissionStatus DENIED = null;
    public static final XCheckPermissionMethod$PermissionStatus PERMITTED = null;
    public static final XCheckPermissionMethod$PermissionStatus RESTRICTED = null;
    public static final XCheckPermissionMethod$PermissionStatus UNDETERMINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XCheckPermissionMethod$PermissionStatus[] f249443a = null;

    public static XCheckPermissionMethod$PermissionStatus valueOf(String r100) {
        return (XCheckPermissionMethod$PermissionStatus) a.a(XCheckPermissionMethod$PermissionStatus.class, r100);
    }

    public static XCheckPermissionMethod$PermissionStatus[] values() {
        return (XCheckPermissionMethod$PermissionStatus[]) f249443a.clone();
    }

    static {
        XCheckPermissionMethod$PermissionStatus r100 = new XCheckPermissionMethod$PermissionStatus("PERMITTED", 0);
        PERMITTED = r100;
        XCheckPermissionMethod$PermissionStatus r101 = new XCheckPermissionMethod$PermissionStatus("DENIED", 1);
        DENIED = r101;
        XCheckPermissionMethod$PermissionStatus r102 = new XCheckPermissionMethod$PermissionStatus("UNDETERMINED", 2);
        UNDETERMINED = r102;
        XCheckPermissionMethod$PermissionStatus r103 = new XCheckPermissionMethod$PermissionStatus("RESTRICTED", 3);
        RESTRICTED = r103;
        f249443a = new XCheckPermissionMethod$PermissionStatus[]{r100, r101, r102, r103};
    }

    public XCheckPermissionMethod$PermissionStatus(String r100, int r101) {
        super(r100, r101);
    }
}

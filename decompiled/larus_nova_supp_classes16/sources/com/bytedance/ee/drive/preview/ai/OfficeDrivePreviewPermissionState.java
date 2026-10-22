package com.bytedance.ee.drive.preview.ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewPermissionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CHECKING", "CAN_READ", "NO_READ_PERMISSION", "SECURITY_BLOCKED", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeDrivePreviewPermissionState extends Enum<OfficeDrivePreviewPermissionState> {
    public static final OfficeDrivePreviewPermissionState CAN_READ = null;
    public static final OfficeDrivePreviewPermissionState CHECKING = null;
    public static final OfficeDrivePreviewPermissionState NO_READ_PERMISSION = null;
    public static final OfficeDrivePreviewPermissionState SECURITY_BLOCKED = null;
    public static final OfficeDrivePreviewPermissionState UNKNOWN = null;
    public static final /* synthetic */ OfficeDrivePreviewPermissionState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeDrivePreviewPermissionState> getEntries() {
        return b;
    }

    static {
        OfficeDrivePreviewPermissionState r0 = new OfficeDrivePreviewPermissionState("UNKNOWN", 0);
        UNKNOWN = r0;
        OfficeDrivePreviewPermissionState r1 = new OfficeDrivePreviewPermissionState("CHECKING", 1);
        CHECKING = r1;
        OfficeDrivePreviewPermissionState r3 = new OfficeDrivePreviewPermissionState("CAN_READ", 2);
        CAN_READ = r3;
        OfficeDrivePreviewPermissionState r5 = new OfficeDrivePreviewPermissionState("NO_READ_PERMISSION", 3);
        NO_READ_PERMISSION = r5;
        OfficeDrivePreviewPermissionState r7 = new OfficeDrivePreviewPermissionState("SECURITY_BLOCKED", 4);
        SECURITY_BLOCKED = r7;
        OfficeDrivePreviewPermissionState[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static OfficeDrivePreviewPermissionState[] values() {
        return (OfficeDrivePreviewPermissionState[]) a.clone();
    }

    public static OfficeDrivePreviewPermissionState valueOf(String r1) {
        return (OfficeDrivePreviewPermissionState) a.a(OfficeDrivePreviewPermissionState.class, r1);
    }

    public OfficeDrivePreviewPermissionState(String r1, int r2) {
        super(r1, r2);
    }
}

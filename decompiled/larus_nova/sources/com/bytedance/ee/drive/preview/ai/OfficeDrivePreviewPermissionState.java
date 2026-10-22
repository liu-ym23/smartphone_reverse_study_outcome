package com.bytedance.ee.drive.preview.ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewPermissionState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "CHECKING", "CAN_READ", "NO_READ_PERMISSION", "SECURITY_BLOCKED", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeDrivePreviewPermissionState extends Enum<OfficeDrivePreviewPermissionState> {
    public static final OfficeDrivePreviewPermissionState CAN_READ = null;
    public static final OfficeDrivePreviewPermissionState CHECKING = null;
    public static final OfficeDrivePreviewPermissionState NO_READ_PERMISSION = null;
    public static final OfficeDrivePreviewPermissionState SECURITY_BLOCKED = null;
    public static final OfficeDrivePreviewPermissionState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeDrivePreviewPermissionState[] f242688a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242689b = null;

    public static EnumEntries<OfficeDrivePreviewPermissionState> getEntries() {
        return f242689b;
    }

    static {
        OfficeDrivePreviewPermissionState r100 = new OfficeDrivePreviewPermissionState("UNKNOWN", 0);
        UNKNOWN = r100;
        OfficeDrivePreviewPermissionState r101 = new OfficeDrivePreviewPermissionState("CHECKING", 1);
        CHECKING = r101;
        OfficeDrivePreviewPermissionState r102 = new OfficeDrivePreviewPermissionState("CAN_READ", 2);
        CAN_READ = r102;
        OfficeDrivePreviewPermissionState r103 = new OfficeDrivePreviewPermissionState("NO_READ_PERMISSION", 3);
        NO_READ_PERMISSION = r103;
        OfficeDrivePreviewPermissionState r104 = new OfficeDrivePreviewPermissionState("SECURITY_BLOCKED", 4);
        SECURITY_BLOCKED = r104;
        OfficeDrivePreviewPermissionState[] r105 = {r100, r101, r102, r103, r104};
        f242688a = r105;
        f242689b = EnumEntriesKt.enumEntries(r105);
    }

    public static OfficeDrivePreviewPermissionState[] values() {
        return (OfficeDrivePreviewPermissionState[]) f242688a.clone();
    }

    public static OfficeDrivePreviewPermissionState valueOf(String r100) {
        return (OfficeDrivePreviewPermissionState) a.a(OfficeDrivePreviewPermissionState.class, r100);
    }

    public OfficeDrivePreviewPermissionState(String r100, int r101) {
        super(r100, r101);
    }
}

package com.bytedance.ee.drive.preview.ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/drive/preview/ai/OfficeDrivePreviewAiChangeReason;", "", "<init>", "(Ljava/lang/String;I)V", "CONTAINER_ATTACHED", "CURRENT_FILE_CHANGED", "PERMISSION_CHANGED", "PREVIEW_STATE_CHANGED", "IMAGE_INFO_CHANGED", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeDrivePreviewAiChangeReason extends Enum<OfficeDrivePreviewAiChangeReason> {
    public static final OfficeDrivePreviewAiChangeReason CONTAINER_ATTACHED = null;
    public static final OfficeDrivePreviewAiChangeReason CURRENT_FILE_CHANGED = null;
    public static final OfficeDrivePreviewAiChangeReason IMAGE_INFO_CHANGED = null;
    public static final OfficeDrivePreviewAiChangeReason PERMISSION_CHANGED = null;
    public static final OfficeDrivePreviewAiChangeReason PREVIEW_STATE_CHANGED = null;
    public static final /* synthetic */ OfficeDrivePreviewAiChangeReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeDrivePreviewAiChangeReason> getEntries() {
        return b;
    }

    static {
        OfficeDrivePreviewAiChangeReason r0 = new OfficeDrivePreviewAiChangeReason("CONTAINER_ATTACHED", 0);
        CONTAINER_ATTACHED = r0;
        OfficeDrivePreviewAiChangeReason r1 = new OfficeDrivePreviewAiChangeReason("CURRENT_FILE_CHANGED", 1);
        CURRENT_FILE_CHANGED = r1;
        OfficeDrivePreviewAiChangeReason r3 = new OfficeDrivePreviewAiChangeReason("PERMISSION_CHANGED", 2);
        PERMISSION_CHANGED = r3;
        OfficeDrivePreviewAiChangeReason r5 = new OfficeDrivePreviewAiChangeReason("PREVIEW_STATE_CHANGED", 3);
        PREVIEW_STATE_CHANGED = r5;
        OfficeDrivePreviewAiChangeReason r7 = new OfficeDrivePreviewAiChangeReason("IMAGE_INFO_CHANGED", 4);
        IMAGE_INFO_CHANGED = r7;
        OfficeDrivePreviewAiChangeReason[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static OfficeDrivePreviewAiChangeReason[] values() {
        return (OfficeDrivePreviewAiChangeReason[]) a.clone();
    }

    public static OfficeDrivePreviewAiChangeReason valueOf(String r1) {
        return (OfficeDrivePreviewAiChangeReason) a.a(OfficeDrivePreviewAiChangeReason.class, r1);
    }

    public OfficeDrivePreviewAiChangeReason(String r1, int r2) {
        super(r1, r2);
    }
}

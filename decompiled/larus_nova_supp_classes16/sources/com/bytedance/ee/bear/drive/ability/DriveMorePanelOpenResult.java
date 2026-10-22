package com.bytedance.ee.bear.drive.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/ability/DriveMorePanelOpenResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "UI_NOT_ATTACHED", "ACTIVITY_NOT_READY", "FILE_NOT_READY", "INTERNAL_ERROR", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveMorePanelOpenResult extends Enum<DriveMorePanelOpenResult> {
    public static final DriveMorePanelOpenResult ACTIVITY_NOT_READY = null;
    public static final DriveMorePanelOpenResult FILE_NOT_READY = null;
    public static final DriveMorePanelOpenResult INTERNAL_ERROR = null;
    public static final DriveMorePanelOpenResult SUCCESS = null;
    public static final DriveMorePanelOpenResult UI_NOT_ATTACHED = null;
    public static final /* synthetic */ DriveMorePanelOpenResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DriveMorePanelOpenResult> getEntries() {
        return b;
    }

    static {
        DriveMorePanelOpenResult r0 = new DriveMorePanelOpenResult("SUCCESS", 0);
        SUCCESS = r0;
        DriveMorePanelOpenResult r1 = new DriveMorePanelOpenResult("UI_NOT_ATTACHED", 1);
        UI_NOT_ATTACHED = r1;
        DriveMorePanelOpenResult r3 = new DriveMorePanelOpenResult("ACTIVITY_NOT_READY", 2);
        ACTIVITY_NOT_READY = r3;
        DriveMorePanelOpenResult r5 = new DriveMorePanelOpenResult("FILE_NOT_READY", 3);
        FILE_NOT_READY = r5;
        DriveMorePanelOpenResult r7 = new DriveMorePanelOpenResult("INTERNAL_ERROR", 4);
        INTERNAL_ERROR = r7;
        DriveMorePanelOpenResult[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static DriveMorePanelOpenResult[] values() {
        return (DriveMorePanelOpenResult[]) a.clone();
    }

    public static DriveMorePanelOpenResult valueOf(String r1) {
        return (DriveMorePanelOpenResult) a.a(DriveMorePanelOpenResult.class, r1);
    }

    public DriveMorePanelOpenResult(String r1, int r2) {
        super(r1, r2);
    }
}

package com.bytedance.ee.bear.drive.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/ability/DriveMorePanelOpenResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "UI_NOT_ATTACHED", "ACTIVITY_NOT_READY", "FILE_NOT_READY", "INTERNAL_ERROR", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveMorePanelOpenResult extends Enum<DriveMorePanelOpenResult> {
    public static final DriveMorePanelOpenResult ACTIVITY_NOT_READY = null;
    public static final DriveMorePanelOpenResult FILE_NOT_READY = null;
    public static final DriveMorePanelOpenResult INTERNAL_ERROR = null;
    public static final DriveMorePanelOpenResult SUCCESS = null;
    public static final DriveMorePanelOpenResult UI_NOT_ATTACHED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveMorePanelOpenResult[] f222579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f222580b = null;

    public static EnumEntries<DriveMorePanelOpenResult> getEntries() {
        return f222580b;
    }

    static {
        DriveMorePanelOpenResult r100 = new DriveMorePanelOpenResult("SUCCESS", 0);
        SUCCESS = r100;
        DriveMorePanelOpenResult r101 = new DriveMorePanelOpenResult("UI_NOT_ATTACHED", 1);
        UI_NOT_ATTACHED = r101;
        DriveMorePanelOpenResult r102 = new DriveMorePanelOpenResult("ACTIVITY_NOT_READY", 2);
        ACTIVITY_NOT_READY = r102;
        DriveMorePanelOpenResult r103 = new DriveMorePanelOpenResult("FILE_NOT_READY", 3);
        FILE_NOT_READY = r103;
        DriveMorePanelOpenResult r104 = new DriveMorePanelOpenResult("INTERNAL_ERROR", 4);
        INTERNAL_ERROR = r104;
        DriveMorePanelOpenResult[] r105 = {r100, r101, r102, r103, r104};
        f222579a = r105;
        f222580b = EnumEntriesKt.enumEntries(r105);
    }

    public static DriveMorePanelOpenResult[] values() {
        return (DriveMorePanelOpenResult[]) f222579a.clone();
    }

    public static DriveMorePanelOpenResult valueOf(String r100) {
        return (DriveMorePanelOpenResult) a.a(DriveMorePanelOpenResult.class, r100);
    }

    public DriveMorePanelOpenResult(String r100, int r101) {
        super(r100, r101);
    }
}

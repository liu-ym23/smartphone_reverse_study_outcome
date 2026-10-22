package com.bytedance.ee.drive.preview.errorpage;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/drive/preview/errorpage/DriveErrorPageActionType;", "", "<init>", "(Ljava/lang/String;I)V", "RETRY", "OPEN_EXTERNAL", "contentmanager-drive-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveErrorPageActionType extends Enum<DriveErrorPageActionType> {
    public static final DriveErrorPageActionType OPEN_EXTERNAL = null;
    public static final DriveErrorPageActionType RETRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveErrorPageActionType[] f242695a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f242696b = null;

    public static EnumEntries<DriveErrorPageActionType> getEntries() {
        return f242696b;
    }

    static {
        DriveErrorPageActionType r100 = new DriveErrorPageActionType("RETRY", 0);
        RETRY = r100;
        DriveErrorPageActionType r101 = new DriveErrorPageActionType("OPEN_EXTERNAL", 1);
        OPEN_EXTERNAL = r101;
        DriveErrorPageActionType[] r102 = {r100, r101};
        f242695a = r102;
        f242696b = EnumEntriesKt.enumEntries(r102);
    }

    public static DriveErrorPageActionType[] values() {
        return (DriveErrorPageActionType[]) f242695a.clone();
    }

    public static DriveErrorPageActionType valueOf(String r100) {
        return (DriveErrorPageActionType) a.a(DriveErrorPageActionType.class, r100);
    }

    public DriveErrorPageActionType(String r100, int r101) {
        super(r100, r101);
    }
}

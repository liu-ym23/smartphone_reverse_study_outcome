package com.bytedance.ee.bear.office.common.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadBannerState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "UPLOADING", "WARNING", "SUCCESS", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadBannerState extends Enum<OfficeUploadBannerState> {
    public static final OfficeUploadBannerState IDLE = null;
    public static final OfficeUploadBannerState SUCCESS = null;
    public static final OfficeUploadBannerState UPLOADING = null;
    public static final OfficeUploadBannerState WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUploadBannerState[] f235264a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235265b = null;

    public static EnumEntries<OfficeUploadBannerState> getEntries() {
        return f235265b;
    }

    static {
        OfficeUploadBannerState r100 = new OfficeUploadBannerState("IDLE", 0);
        IDLE = r100;
        OfficeUploadBannerState r101 = new OfficeUploadBannerState("UPLOADING", 1);
        UPLOADING = r101;
        OfficeUploadBannerState r102 = new OfficeUploadBannerState("WARNING", 2);
        WARNING = r102;
        OfficeUploadBannerState r103 = new OfficeUploadBannerState("SUCCESS", 3);
        SUCCESS = r103;
        OfficeUploadBannerState[] r104 = {r100, r101, r102, r103};
        f235264a = r104;
        f235265b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeUploadBannerState[] values() {
        return (OfficeUploadBannerState[]) f235264a.clone();
    }

    public static OfficeUploadBannerState valueOf(String r100) {
        return (OfficeUploadBannerState) r27.a.a(OfficeUploadBannerState.class, r100);
    }

    public OfficeUploadBannerState(String r100, int r101) {
        super(r100, r101);
    }
}

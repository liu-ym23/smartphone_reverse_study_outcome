package com.bytedance.ee.bear.office.common.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadBannerState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "UPLOADING", "WARNING", "SUCCESS", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadBannerState extends Enum<OfficeUploadBannerState> {
    public static final OfficeUploadBannerState IDLE = null;
    public static final OfficeUploadBannerState SUCCESS = null;
    public static final OfficeUploadBannerState UPLOADING = null;
    public static final OfficeUploadBannerState WARNING = null;
    public static final /* synthetic */ OfficeUploadBannerState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeUploadBannerState> getEntries() {
        return b;
    }

    static {
        OfficeUploadBannerState r0 = new OfficeUploadBannerState("IDLE", 0);
        IDLE = r0;
        OfficeUploadBannerState r1 = new OfficeUploadBannerState("UPLOADING", 1);
        UPLOADING = r1;
        OfficeUploadBannerState r3 = new OfficeUploadBannerState("WARNING", 2);
        WARNING = r3;
        OfficeUploadBannerState r5 = new OfficeUploadBannerState("SUCCESS", 3);
        SUCCESS = r5;
        OfficeUploadBannerState[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static OfficeUploadBannerState[] values() {
        return (OfficeUploadBannerState[]) a.clone();
    }

    public static OfficeUploadBannerState valueOf(String r1) {
        return (OfficeUploadBannerState) r27.a.a(OfficeUploadBannerState.class, r1);
    }

    public OfficeUploadBannerState(String r1, int r2) {
        super(r1, r2);
    }
}

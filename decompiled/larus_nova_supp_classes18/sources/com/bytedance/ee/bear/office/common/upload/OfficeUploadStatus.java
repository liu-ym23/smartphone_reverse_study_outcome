package com.bytedance.ee.bear.office.common.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNSTARTED", "UPLOADING", "FINISH", "FAILED", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadStatus extends Enum<OfficeUploadStatus> {
    public static final OfficeUploadStatus FAILED = null;
    public static final OfficeUploadStatus FINISH = null;
    public static final OfficeUploadStatus UNSTARTED = null;
    public static final OfficeUploadStatus UPLOADING = null;
    public static final /* synthetic */ OfficeUploadStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeUploadStatus> getEntries() {
        return b;
    }

    static {
        OfficeUploadStatus r0 = new OfficeUploadStatus("UNSTARTED", 0);
        UNSTARTED = r0;
        OfficeUploadStatus r1 = new OfficeUploadStatus("UPLOADING", 1);
        UPLOADING = r1;
        OfficeUploadStatus r3 = new OfficeUploadStatus("FINISH", 2);
        FINISH = r3;
        OfficeUploadStatus r5 = new OfficeUploadStatus("FAILED", 3);
        FAILED = r5;
        OfficeUploadStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static OfficeUploadStatus[] values() {
        return (OfficeUploadStatus[]) a.clone();
    }

    public static OfficeUploadStatus valueOf(String r1) {
        return (OfficeUploadStatus) r27.a.a(OfficeUploadStatus.class, r1);
    }

    public OfficeUploadStatus(String r1, int r2) {
        super(r1, r2);
    }
}

package com.bytedance.ee.bear.office.common.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNSTARTED", "UPLOADING", "FINISH", "FAILED", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeUploadStatus extends Enum<OfficeUploadStatus> {
    public static final OfficeUploadStatus FAILED = null;
    public static final OfficeUploadStatus FINISH = null;
    public static final OfficeUploadStatus UNSTARTED = null;
    public static final OfficeUploadStatus UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeUploadStatus[] f235308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235309b = null;

    public static EnumEntries<OfficeUploadStatus> getEntries() {
        return f235309b;
    }

    static {
        OfficeUploadStatus r100 = new OfficeUploadStatus("UNSTARTED", 0);
        UNSTARTED = r100;
        OfficeUploadStatus r101 = new OfficeUploadStatus("UPLOADING", 1);
        UPLOADING = r101;
        OfficeUploadStatus r102 = new OfficeUploadStatus("FINISH", 2);
        FINISH = r102;
        OfficeUploadStatus r103 = new OfficeUploadStatus("FAILED", 3);
        FAILED = r103;
        OfficeUploadStatus[] r104 = {r100, r101, r102, r103};
        f235308a = r104;
        f235309b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeUploadStatus[] values() {
        return (OfficeUploadStatus[]) f235308a.clone();
    }

    public static OfficeUploadStatus valueOf(String r100) {
        return (OfficeUploadStatus) r27.a.a(OfficeUploadStatus.class, r100);
    }

    public OfficeUploadStatus(String r100, int r101) {
        super(r100, r101);
    }
}

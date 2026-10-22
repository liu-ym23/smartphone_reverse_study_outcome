package com.larus.drive.sdk.api.file.download;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/drive/sdk/api/file/download/DriveDownloadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNSTARTED", "DOWNLOADING", "FINISH", "CANCELED", "FAILED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveDownloadStatus extends Enum<DriveDownloadStatus> {
    public static final DriveDownloadStatus CANCELED = null;
    public static final DriveDownloadStatus DOWNLOADING = null;
    public static final DriveDownloadStatus FAILED = null;
    public static final DriveDownloadStatus FINISH = null;
    public static final DriveDownloadStatus UNSTARTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveDownloadStatus[] f341579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341580b = null;

    public static EnumEntries<DriveDownloadStatus> getEntries() {
        return f341580b;
    }

    static {
        DriveDownloadStatus r100 = new DriveDownloadStatus("UNSTARTED", 0);
        UNSTARTED = r100;
        DriveDownloadStatus r101 = new DriveDownloadStatus("DOWNLOADING", 1);
        DOWNLOADING = r101;
        DriveDownloadStatus r102 = new DriveDownloadStatus("FINISH", 2);
        FINISH = r102;
        DriveDownloadStatus r103 = new DriveDownloadStatus("CANCELED", 3);
        CANCELED = r103;
        DriveDownloadStatus r104 = new DriveDownloadStatus("FAILED", 4);
        FAILED = r104;
        DriveDownloadStatus[] r105 = {r100, r101, r102, r103, r104};
        f341579a = r105;
        f341580b = EnumEntriesKt.enumEntries(r105);
    }

    public static DriveDownloadStatus[] values() {
        return (DriveDownloadStatus[]) f341579a.clone();
    }

    public static DriveDownloadStatus valueOf(String r100) {
        return (DriveDownloadStatus) a.a(DriveDownloadStatus.class, r100);
    }

    public DriveDownloadStatus(String r100, int r101) {
        super(r100, r101);
    }
}

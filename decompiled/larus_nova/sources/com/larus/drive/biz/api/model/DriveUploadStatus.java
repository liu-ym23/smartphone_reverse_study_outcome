package com.larus.drive.biz.api.model;

import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/drive/biz/api/model/DriveUploadStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "UNSTARTED", "UPLOADING", "FINISH", "FAILED", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveUploadStatus extends Enum<DriveUploadStatus> {
    public static final a Companion = null;
    public static final DriveUploadStatus FAILED = null;
    public static final DriveUploadStatus FINISH = null;
    public static final DriveUploadStatus UNSTARTED = null;
    public static final DriveUploadStatus UPLOADING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveUploadStatus[] f341025a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f341026b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DriveUploadStatus> getEntries() {
        return f341026b;
    }

    static {
        DriveUploadStatus r100 = new DriveUploadStatus("UNSTARTED", 0, "unstarted");
        UNSTARTED = r100;
        DriveUploadStatus r101 = new DriveUploadStatus("UPLOADING", 1, "uploading");
        UPLOADING = r101;
        DriveUploadStatus r102 = new DriveUploadStatus("FINISH", 2, VideoEventOneOutSync.END_TYPE_FINISH);
        FINISH = r102;
        DriveUploadStatus r103 = new DriveUploadStatus("FAILED", 3, "failed");
        FAILED = r103;
        DriveUploadStatus[] r104 = {r100, r101, r102, r103};
        f341025a = r104;
        f341026b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static DriveUploadStatus[] values() {
        return (DriveUploadStatus[]) f341025a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DriveUploadStatus valueOf(String r100) {
        return (DriveUploadStatus) r27.a.a(DriveUploadStatus.class, r100);
    }

    public DriveUploadStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}

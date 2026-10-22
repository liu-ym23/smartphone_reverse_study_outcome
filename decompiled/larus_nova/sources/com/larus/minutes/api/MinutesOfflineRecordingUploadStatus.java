package com.larus.minutes.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/minutes/api/MinutesOfflineRecordingUploadStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PROGRESS", "SUCCESS", "FAILED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MinutesOfflineRecordingUploadStatus extends Enum<MinutesOfflineRecordingUploadStatus> {
    public static final MinutesOfflineRecordingUploadStatus FAILED = null;
    public static final MinutesOfflineRecordingUploadStatus PROGRESS = null;
    public static final MinutesOfflineRecordingUploadStatus SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MinutesOfflineRecordingUploadStatus[] f359290a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359291b = null;

    public static EnumEntries<MinutesOfflineRecordingUploadStatus> getEntries() {
        return f359291b;
    }

    static {
        MinutesOfflineRecordingUploadStatus r100 = new MinutesOfflineRecordingUploadStatus("PROGRESS", 0);
        PROGRESS = r100;
        MinutesOfflineRecordingUploadStatus r101 = new MinutesOfflineRecordingUploadStatus("SUCCESS", 1);
        SUCCESS = r101;
        MinutesOfflineRecordingUploadStatus r102 = new MinutesOfflineRecordingUploadStatus("FAILED", 2);
        FAILED = r102;
        MinutesOfflineRecordingUploadStatus[] r103 = {r100, r101, r102};
        f359290a = r103;
        f359291b = EnumEntriesKt.enumEntries(r103);
    }

    public static MinutesOfflineRecordingUploadStatus[] values() {
        return (MinutesOfflineRecordingUploadStatus[]) f359290a.clone();
    }

    public static MinutesOfflineRecordingUploadStatus valueOf(String r100) {
        return (MinutesOfflineRecordingUploadStatus) a.a(MinutesOfflineRecordingUploadStatus.class, r100);
    }

    public MinutesOfflineRecordingUploadStatus(String r100, int r101) {
        super(r100, r101);
    }
}

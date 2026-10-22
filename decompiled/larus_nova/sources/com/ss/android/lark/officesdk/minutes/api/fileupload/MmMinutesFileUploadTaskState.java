package com.ss.android.lark.officesdk.minutes.api.fileupload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/fileupload/MmMinutesFileUploadTaskState;", "", "<init>", "(Ljava/lang/String;I)V", "Init", "PreCheckSuccess", "QuotaReady", "Uploading", "DriveAllUploaded", "UploadCompleted", "Interrupted", "Idle", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmMinutesFileUploadTaskState extends Enum<MmMinutesFileUploadTaskState> {
    public static final MmMinutesFileUploadTaskState DriveAllUploaded = null;
    public static final MmMinutesFileUploadTaskState Idle = null;
    public static final MmMinutesFileUploadTaskState Init = null;
    public static final MmMinutesFileUploadTaskState Interrupted = null;
    public static final MmMinutesFileUploadTaskState PreCheckSuccess = null;
    public static final MmMinutesFileUploadTaskState QuotaReady = null;
    public static final MmMinutesFileUploadTaskState UploadCompleted = null;
    public static final MmMinutesFileUploadTaskState Uploading = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmMinutesFileUploadTaskState[] f433482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433483b = null;

    public static EnumEntries<MmMinutesFileUploadTaskState> getEntries() {
        return f433483b;
    }

    static {
        MmMinutesFileUploadTaskState r100 = new MmMinutesFileUploadTaskState("Init", 0);
        Init = r100;
        MmMinutesFileUploadTaskState r101 = new MmMinutesFileUploadTaskState("PreCheckSuccess", 1);
        PreCheckSuccess = r101;
        MmMinutesFileUploadTaskState r102 = new MmMinutesFileUploadTaskState("QuotaReady", 2);
        QuotaReady = r102;
        MmMinutesFileUploadTaskState r103 = new MmMinutesFileUploadTaskState("Uploading", 3);
        Uploading = r103;
        MmMinutesFileUploadTaskState r104 = new MmMinutesFileUploadTaskState("DriveAllUploaded", 4);
        DriveAllUploaded = r104;
        MmMinutesFileUploadTaskState r105 = new MmMinutesFileUploadTaskState("UploadCompleted", 5);
        UploadCompleted = r105;
        MmMinutesFileUploadTaskState r110 = new MmMinutesFileUploadTaskState("Interrupted", 6);
        Interrupted = r110;
        MmMinutesFileUploadTaskState r111 = new MmMinutesFileUploadTaskState("Idle", 7);
        Idle = r111;
        MmMinutesFileUploadTaskState[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f433482a = r112;
        f433483b = EnumEntriesKt.enumEntries(r112);
    }

    public static MmMinutesFileUploadTaskState[] values() {
        return (MmMinutesFileUploadTaskState[]) f433482a.clone();
    }

    public static MmMinutesFileUploadTaskState valueOf(String r100) {
        return (MmMinutesFileUploadTaskState) a.a(MmMinutesFileUploadTaskState.class, r100);
    }

    public MmMinutesFileUploadTaskState(String r100, int r101) {
        super(r100, r101);
    }
}

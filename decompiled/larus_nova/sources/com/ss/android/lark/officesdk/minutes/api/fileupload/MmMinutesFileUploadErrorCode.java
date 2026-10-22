package com.ss.android.lark.officesdk.minutes.api.fileupload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/fileupload/MmMinutesFileUploadErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "NETWORK_ERROR", "NO_QUOTA", "PRE_FILE_COUNT_EMPTY", "PRE_FILE_COUNT_EXCEEDED", "FILE_TYPE_ERROR", "MEDIA_DURATION_ERROR", "FILE_SIZE_ERROR", "FILE_READ_FAIL", "PRE_FILE_NOT_EXIST", "QUOTA_REQUEST_ERROR", "PREPARE_REQUEST_ERROR", "DRIVE_UPLOAD_REQUEST_ERROR", "DRIVE_PUSH_CALLBACK_ERROR", "FINISH_REQUEST_ERROR", "DUPLICATE_IN_SERVER", "ALREADY_UPLOAD", "RETRY_TOO_MANY_TIMES", "CANCEL_BY_USER", "SOMETHING_WRONG", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmMinutesFileUploadErrorCode extends Enum<MmMinutesFileUploadErrorCode> {
    public static final MmMinutesFileUploadErrorCode ALREADY_UPLOAD = null;
    public static final MmMinutesFileUploadErrorCode CANCEL_BY_USER = null;
    public static final MmMinutesFileUploadErrorCode DRIVE_PUSH_CALLBACK_ERROR = null;
    public static final MmMinutesFileUploadErrorCode DRIVE_UPLOAD_REQUEST_ERROR = null;
    public static final MmMinutesFileUploadErrorCode DUPLICATE_IN_SERVER = null;
    public static final MmMinutesFileUploadErrorCode FILE_READ_FAIL = null;
    public static final MmMinutesFileUploadErrorCode FILE_SIZE_ERROR = null;
    public static final MmMinutesFileUploadErrorCode FILE_TYPE_ERROR = null;
    public static final MmMinutesFileUploadErrorCode FINISH_REQUEST_ERROR = null;
    public static final MmMinutesFileUploadErrorCode MEDIA_DURATION_ERROR = null;
    public static final MmMinutesFileUploadErrorCode NETWORK_ERROR = null;
    public static final MmMinutesFileUploadErrorCode NO_QUOTA = null;
    public static final MmMinutesFileUploadErrorCode PREPARE_REQUEST_ERROR = null;
    public static final MmMinutesFileUploadErrorCode PRE_FILE_COUNT_EMPTY = null;
    public static final MmMinutesFileUploadErrorCode PRE_FILE_COUNT_EXCEEDED = null;
    public static final MmMinutesFileUploadErrorCode PRE_FILE_NOT_EXIST = null;
    public static final MmMinutesFileUploadErrorCode QUOTA_REQUEST_ERROR = null;
    public static final MmMinutesFileUploadErrorCode RETRY_TOO_MANY_TIMES = null;
    public static final MmMinutesFileUploadErrorCode SOMETHING_WRONG = null;
    public static final MmMinutesFileUploadErrorCode SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmMinutesFileUploadErrorCode[] f433478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433479b = null;

    public static EnumEntries<MmMinutesFileUploadErrorCode> getEntries() {
        return f433479b;
    }

    static {
        MmMinutesFileUploadErrorCode r100 = new MmMinutesFileUploadErrorCode("SUCCESS", 0);
        SUCCESS = r100;
        MmMinutesFileUploadErrorCode r101 = new MmMinutesFileUploadErrorCode("NETWORK_ERROR", 1);
        NETWORK_ERROR = r101;
        MmMinutesFileUploadErrorCode r102 = new MmMinutesFileUploadErrorCode("NO_QUOTA", 2);
        NO_QUOTA = r102;
        MmMinutesFileUploadErrorCode r103 = new MmMinutesFileUploadErrorCode("PRE_FILE_COUNT_EMPTY", 3);
        PRE_FILE_COUNT_EMPTY = r103;
        MmMinutesFileUploadErrorCode r104 = new MmMinutesFileUploadErrorCode("PRE_FILE_COUNT_EXCEEDED", 4);
        PRE_FILE_COUNT_EXCEEDED = r104;
        MmMinutesFileUploadErrorCode r105 = new MmMinutesFileUploadErrorCode("FILE_TYPE_ERROR", 5);
        FILE_TYPE_ERROR = r105;
        MmMinutesFileUploadErrorCode r110 = new MmMinutesFileUploadErrorCode("MEDIA_DURATION_ERROR", 6);
        MEDIA_DURATION_ERROR = r110;
        MmMinutesFileUploadErrorCode r111 = new MmMinutesFileUploadErrorCode("FILE_SIZE_ERROR", 7);
        FILE_SIZE_ERROR = r111;
        MmMinutesFileUploadErrorCode r112 = new MmMinutesFileUploadErrorCode("FILE_READ_FAIL", 8);
        FILE_READ_FAIL = r112;
        MmMinutesFileUploadErrorCode r113 = new MmMinutesFileUploadErrorCode("PRE_FILE_NOT_EXIST", 9);
        PRE_FILE_NOT_EXIST = r113;
        MmMinutesFileUploadErrorCode r114 = new MmMinutesFileUploadErrorCode("QUOTA_REQUEST_ERROR", 10);
        QUOTA_REQUEST_ERROR = r114;
        MmMinutesFileUploadErrorCode r115 = new MmMinutesFileUploadErrorCode("PREPARE_REQUEST_ERROR", 11);
        PREPARE_REQUEST_ERROR = r115;
        MmMinutesFileUploadErrorCode r106 = new MmMinutesFileUploadErrorCode("DRIVE_UPLOAD_REQUEST_ERROR", 12);
        DRIVE_UPLOAD_REQUEST_ERROR = r106;
        MmMinutesFileUploadErrorCode r107 = new MmMinutesFileUploadErrorCode("DRIVE_PUSH_CALLBACK_ERROR", 13);
        DRIVE_PUSH_CALLBACK_ERROR = r107;
        MmMinutesFileUploadErrorCode r108 = new MmMinutesFileUploadErrorCode("FINISH_REQUEST_ERROR", 14);
        FINISH_REQUEST_ERROR = r108;
        MmMinutesFileUploadErrorCode r109 = new MmMinutesFileUploadErrorCode("DUPLICATE_IN_SERVER", 15);
        DUPLICATE_IN_SERVER = r109;
        MmMinutesFileUploadErrorCode r116 = new MmMinutesFileUploadErrorCode("ALREADY_UPLOAD", 16);
        ALREADY_UPLOAD = r116;
        MmMinutesFileUploadErrorCode r117 = new MmMinutesFileUploadErrorCode("RETRY_TOO_MANY_TIMES", 17);
        RETRY_TOO_MANY_TIMES = r117;
        MmMinutesFileUploadErrorCode r118 = new MmMinutesFileUploadErrorCode("CANCEL_BY_USER", 18);
        CANCEL_BY_USER = r118;
        MmMinutesFileUploadErrorCode r119 = new MmMinutesFileUploadErrorCode("SOMETHING_WRONG", 19);
        SOMETHING_WRONG = r119;
        MmMinutesFileUploadErrorCode[] r120 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
        f433478a = r120;
        f433479b = EnumEntriesKt.enumEntries(r120);
    }

    public static MmMinutesFileUploadErrorCode[] values() {
        return (MmMinutesFileUploadErrorCode[]) f433478a.clone();
    }

    public static MmMinutesFileUploadErrorCode valueOf(String r100) {
        return (MmMinutesFileUploadErrorCode) a.a(MmMinutesFileUploadErrorCode.class, r100);
    }

    public MmMinutesFileUploadErrorCode(String r100, int r101) {
        super(r100, r101);
    }
}

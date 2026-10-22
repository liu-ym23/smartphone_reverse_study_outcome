package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusUploadFileVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/o;", "", "code", "I", "getCode", "()I", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "SESSION_ID_FOUND_MODE_BLOCK", "SESSION_ID_FOUND_MODE_REPORT", "REGEX_HIT_MODE_BLOCK", "REGEX_HIT_MODE_REPORT", "FILE_PATH_IN_SKIP_LIST", "APPLICATION_IS_NULL", "FILE_CAN_NOT_READ", "FILE_SIZE_EXCEED_LIMIT", "CAN_NOT_GET_FILE_SIZE", "CAN_NOT_GET_SESSION_ID", "FILE_MATCH_NOTHING", "FILE_DETECT_TIMEOUT", "UNEXPECTED_DETECT_RESULT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum ArgusUploadFileVerifyReason extends Enum<ArgusUploadFileVerifyReason> implements o {
    public static final ArgusUploadFileVerifyReason APPLICATION_IS_NULL = null;
    public static final ArgusUploadFileVerifyReason CAN_NOT_GET_FILE_SIZE = null;
    public static final ArgusUploadFileVerifyReason CAN_NOT_GET_SESSION_ID = null;
    public static final ArgusUploadFileVerifyReason FILE_CAN_NOT_READ = null;
    public static final ArgusUploadFileVerifyReason FILE_DETECT_TIMEOUT = null;
    public static final ArgusUploadFileVerifyReason FILE_MATCH_NOTHING = null;
    public static final ArgusUploadFileVerifyReason FILE_PATH_IN_SKIP_LIST = null;
    public static final ArgusUploadFileVerifyReason FILE_SIZE_EXCEED_LIMIT = null;
    public static final ArgusUploadFileVerifyReason REGEX_HIT_MODE_BLOCK = null;
    public static final ArgusUploadFileVerifyReason REGEX_HIT_MODE_REPORT = null;
    public static final ArgusUploadFileVerifyReason SESSION_ID_FOUND_MODE_BLOCK = null;
    public static final ArgusUploadFileVerifyReason SESSION_ID_FOUND_MODE_REPORT = null;
    public static final ArgusUploadFileVerifyReason UNEXPECTED_DETECT_RESULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArgusUploadFileVerifyReason[] f245974a = null;
    private final int code;
    private final String strValue;

    public static ArgusUploadFileVerifyReason valueOf(String r100) {
        return (ArgusUploadFileVerifyReason) r27.a.a(ArgusUploadFileVerifyReason.class, r100);
    }

    public static ArgusUploadFileVerifyReason[] values() {
        return (ArgusUploadFileVerifyReason[]) f245974a.clone();
    }

    static {
        ArgusUploadFileVerifyReason r100 = new ArgusUploadFileVerifyReason("SESSION_ID_FOUND_MODE_BLOCK", 0, -1, "session id found, mode block");
        SESSION_ID_FOUND_MODE_BLOCK = r100;
        ArgusUploadFileVerifyReason r101 = new ArgusUploadFileVerifyReason("SESSION_ID_FOUND_MODE_REPORT", 1, -2, "session id found, mode report");
        SESSION_ID_FOUND_MODE_REPORT = r101;
        ArgusUploadFileVerifyReason r102 = new ArgusUploadFileVerifyReason("REGEX_HIT_MODE_BLOCK", 2, -3, "regex hit, mode block");
        REGEX_HIT_MODE_BLOCK = r102;
        ArgusUploadFileVerifyReason r103 = new ArgusUploadFileVerifyReason("REGEX_HIT_MODE_REPORT", 3, -4, "regex hit, mode report");
        REGEX_HIT_MODE_REPORT = r103;
        ArgusUploadFileVerifyReason r104 = new ArgusUploadFileVerifyReason("FILE_PATH_IN_SKIP_LIST", 4, 2, "file path in skip list");
        FILE_PATH_IN_SKIP_LIST = r104;
        ArgusUploadFileVerifyReason r105 = new ArgusUploadFileVerifyReason("APPLICATION_IS_NULL", 5, 3, "application is null");
        APPLICATION_IS_NULL = r105;
        ArgusUploadFileVerifyReason r106 = new ArgusUploadFileVerifyReason("FILE_CAN_NOT_READ", 6, 4, "file can not read");
        FILE_CAN_NOT_READ = r106;
        ArgusUploadFileVerifyReason r110 = new ArgusUploadFileVerifyReason("FILE_SIZE_EXCEED_LIMIT", 7, 5, "file size exceed limit");
        FILE_SIZE_EXCEED_LIMIT = r110;
        ArgusUploadFileVerifyReason r111 = new ArgusUploadFileVerifyReason("CAN_NOT_GET_FILE_SIZE", 8, 6, "can not get file size");
        CAN_NOT_GET_FILE_SIZE = r111;
        ArgusUploadFileVerifyReason r112 = new ArgusUploadFileVerifyReason("CAN_NOT_GET_SESSION_ID", 9, 7, "can not get session id");
        CAN_NOT_GET_SESSION_ID = r112;
        ArgusUploadFileVerifyReason r113 = new ArgusUploadFileVerifyReason("FILE_MATCH_NOTHING", 10, 8, "file match nothing");
        FILE_MATCH_NOTHING = r113;
        ArgusUploadFileVerifyReason r114 = new ArgusUploadFileVerifyReason("FILE_DETECT_TIMEOUT", 11, 9, "file detect timeout");
        FILE_DETECT_TIMEOUT = r114;
        ArgusUploadFileVerifyReason r107 = new ArgusUploadFileVerifyReason("UNEXPECTED_DETECT_RESULT", 12, 1000, "unexpected detect result");
        UNEXPECTED_DETECT_RESULT = r107;
        f245974a = new ArgusUploadFileVerifyReason[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107};
    }

    @Override // com.bytedance.ies.argus.bean.o
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.o
    public String getStrValue() {
        return this.strValue;
    }

    public ArgusUploadFileVerifyReason(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.strValue = r103;
    }
}

package okhttp3.internal.http2;

import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum ErrorCode extends Enum<ErrorCode> {
    public static final ErrorCode CANCEL = null;
    public static final ErrorCode COMPRESSION_ERROR = null;
    public static final ErrorCode CONNECT_ERROR = null;
    public static final ErrorCode ENHANCE_YOUR_CALM = null;
    public static final ErrorCode FLOW_CONTROL_ERROR = null;
    public static final ErrorCode HTTP_1_1_REQUIRED = null;
    public static final ErrorCode INADEQUATE_SECURITY = null;
    public static final ErrorCode INTERNAL_ERROR = null;
    public static final ErrorCode NO_ERROR = null;
    public static final ErrorCode PROTOCOL_ERROR = null;
    public static final ErrorCode REFUSED_STREAM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorCode[] f523910a = null;
    public final int httpCode;

    static {
        ErrorCode r100 = new ErrorCode("NO_ERROR", 0, 0);
        NO_ERROR = r100;
        ErrorCode r101 = new ErrorCode("PROTOCOL_ERROR", 1, 1);
        PROTOCOL_ERROR = r101;
        ErrorCode r102 = new ErrorCode("INTERNAL_ERROR", 2, 2);
        INTERNAL_ERROR = r102;
        ErrorCode r103 = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
        FLOW_CONTROL_ERROR = r103;
        ErrorCode r104 = new ErrorCode("REFUSED_STREAM", 4, 7);
        REFUSED_STREAM = r104;
        ErrorCode r105 = new ErrorCode("CANCEL", 5, 8);
        CANCEL = r105;
        ErrorCode r110 = new ErrorCode("COMPRESSION_ERROR", 6, 9);
        COMPRESSION_ERROR = r110;
        ErrorCode r111 = new ErrorCode("CONNECT_ERROR", 7, 10);
        CONNECT_ERROR = r111;
        ErrorCode r112 = new ErrorCode("ENHANCE_YOUR_CALM", 8, 11);
        ENHANCE_YOUR_CALM = r112;
        ErrorCode r113 = new ErrorCode("INADEQUATE_SECURITY", 9, 12);
        INADEQUATE_SECURITY = r113;
        ErrorCode r106 = new ErrorCode("HTTP_1_1_REQUIRED", 10, 13);
        HTTP_1_1_REQUIRED = r106;
        f523910a = new ErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106};
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) f523910a.clone();
    }

    public static ErrorCode fromHttp2(int r100) {
        ErrorCode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ErrorCode r104 = r101[r103];
        if (r104.httpCode == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ErrorCode valueOf(String r100) {
        return (ErrorCode) a.a(ErrorCode.class, r100);
    }

    public ErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.httpCode = r102;
    }
}

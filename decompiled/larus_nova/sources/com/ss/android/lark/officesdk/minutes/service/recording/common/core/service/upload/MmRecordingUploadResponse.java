package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b#\b\u0086\u0081\u0002\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001*B9\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)¨\u0006+"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/MmRecordingUploadResponse;", "", "httpCode", "", "statusCode", "errorType", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/ErrorType;", "rtt", "", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/ErrorType;Ljava/lang/Long;)V", "getHttpCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatusCode", "getErrorType", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/upload/ErrorType;", "getRtt", "()Ljava/lang/Long;", "setRtt", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "SUCCESS", "INTERRUPTED", "NON_RECORDING_TYPE", "INVALID_PARAMETER", "UPLOAD_COMPLETED", "REACH_MAX_DURATION", "TENANT_KEY_DELETED", "GET_TENANT_KEY_FAILED", "ENCRYPTION_FAILED", "TOS_UPLOAD_FAILED", "ABASE_FAILED", "TRANSCODING_FAILED", "SERVER_DOWN", "NOT_LOGGED_IN", "UNAUTHORIZED", "INCORRECT_PATH", "OBJECT_DELETED", "NETWORK", "DISKCACHE_INSUFFICIENT", "UNKNOWN", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingUploadResponse extends Enum<MmRecordingUploadResponse> {
    public static final MmRecordingUploadResponse ABASE_FAILED = null;
    public static final a Companion = null;
    public static final MmRecordingUploadResponse DISKCACHE_INSUFFICIENT = null;
    public static final MmRecordingUploadResponse ENCRYPTION_FAILED = null;
    public static final MmRecordingUploadResponse GET_TENANT_KEY_FAILED = null;
    public static final MmRecordingUploadResponse INCORRECT_PATH = null;
    public static final MmRecordingUploadResponse INTERRUPTED = null;
    public static final MmRecordingUploadResponse INVALID_PARAMETER = null;
    public static final MmRecordingUploadResponse NETWORK = null;
    public static final MmRecordingUploadResponse NON_RECORDING_TYPE = null;
    public static final MmRecordingUploadResponse NOT_LOGGED_IN = null;
    public static final MmRecordingUploadResponse OBJECT_DELETED = null;
    public static final MmRecordingUploadResponse REACH_MAX_DURATION = null;
    public static final MmRecordingUploadResponse SERVER_DOWN = null;
    public static final MmRecordingUploadResponse SUCCESS = null;
    public static final MmRecordingUploadResponse TENANT_KEY_DELETED = null;
    public static final MmRecordingUploadResponse TOS_UPLOAD_FAILED = null;
    public static final MmRecordingUploadResponse TRANSCODING_FAILED = null;
    public static final MmRecordingUploadResponse UNAUTHORIZED = null;
    public static final MmRecordingUploadResponse UNKNOWN = null;
    public static final MmRecordingUploadResponse UPLOAD_COMPLETED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingUploadResponse[] f434473a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434474b = null;
    private final ErrorType errorType;
    private final Integer httpCode;
    private Long rtt;
    private final Integer statusCode;

    public static final class a {
        public a() {
        }

        public static MmRecordingUploadResponse a(Integer r100, Integer r101) {
            if (r100 != null) goto L5;
        L10:
            if (r100 != null) goto L13;
        L21:
            if (r100 != null) goto L24;
        L26:
            if (r100 != null) goto L29;
        L31:
            if (r100 != null) goto L34;
        L36:
            if (r100 != null) goto L39;
        L47:
            if (r100 != null) goto L50;
        L52:
            if (r100 != null) goto L55;
        L75:
            MmRecordingUploadResponse r102 = MmRecordingUploadResponse.NETWORK;
            if (Intrinsics.areEqual(r101, r102.getStatusCode()) == true) goto L106;
            MmRecordingUploadResponse r103 = MmRecordingUploadResponse.DISKCACHE_INSUFFICIENT;
            if (Intrinsics.areEqual(r101, r103.getStatusCode()) == false) goto L82;
            return r103;
        L82:
            if (NetworkUtils.d(LarkContext.getApplication()) == true) goto L85;
            return r102;
        L85:
            return MmRecordingUploadResponse.UNKNOWN;
        L106:
            return r102;
        L55:
            if (r100.intValue() != 500) goto L75;
            MmRecordingUploadResponse r104 = MmRecordingUploadResponse.TENANT_KEY_DELETED;
            if (Intrinsics.areEqual(r101, r104.getStatusCode()) == true) goto L100;
            MmRecordingUploadResponse r105 = MmRecordingUploadResponse.GET_TENANT_KEY_FAILED;
            if (Intrinsics.areEqual(r101, r105.getStatusCode()) == true) goto L101;
            MmRecordingUploadResponse r106 = MmRecordingUploadResponse.ENCRYPTION_FAILED;
            if (Intrinsics.areEqual(r101, r106.getStatusCode()) == true) goto L102;
            MmRecordingUploadResponse r107 = MmRecordingUploadResponse.TOS_UPLOAD_FAILED;
            if (Intrinsics.areEqual(r101, r107.getStatusCode()) == true) goto L103;
            MmRecordingUploadResponse r108 = MmRecordingUploadResponse.ABASE_FAILED;
            if (Intrinsics.areEqual(r101, r108.getStatusCode()) == true) goto L104;
            MmRecordingUploadResponse r109 = MmRecordingUploadResponse.TRANSCODING_FAILED;
            if (Intrinsics.areEqual(r101, r109.getStatusCode()) == false) goto L93;
            return r109;
        L93:
            return MmRecordingUploadResponse.SERVER_DOWN;
        L104:
            return r108;
        L103:
            return r107;
        L102:
            return r106;
        L101:
            return r105;
        L100:
            return r104;
        L50:
            if (r100.intValue() != 410) goto L52;
            return MmRecordingUploadResponse.OBJECT_DELETED;
        L39:
            if (r100.intValue() != 406) goto L47;
            MmRecordingUploadResponse r110 = MmRecordingUploadResponse.UPLOAD_COMPLETED;
            if (Intrinsics.areEqual(r101, r110.getStatusCode()) == true) goto L98;
            MmRecordingUploadResponse r111 = MmRecordingUploadResponse.REACH_MAX_DURATION;
            if (Intrinsics.areEqual(r101, r111.getStatusCode()) == false) goto L91;
            return r111;
        L91:
            return MmRecordingUploadResponse.UNKNOWN;
        L98:
            return r110;
        L34:
            if (r100.intValue() != 404) goto L36;
            return MmRecordingUploadResponse.INCORRECT_PATH;
        L29:
            if (r100.intValue() != 403) goto L31;
            return MmRecordingUploadResponse.UNAUTHORIZED;
        L24:
            if (r100.intValue() != 401) goto L26;
            return MmRecordingUploadResponse.NOT_LOGGED_IN;
        L13:
            if (r100.intValue() != 400) goto L21;
            MmRecordingUploadResponse r112 = MmRecordingUploadResponse.NON_RECORDING_TYPE;
            if (Intrinsics.areEqual(r101, r112.getStatusCode()) == true) goto L96;
            MmRecordingUploadResponse r113 = MmRecordingUploadResponse.INVALID_PARAMETER;
            if (Intrinsics.areEqual(r101, r113.getStatusCode()) == false) goto L87;
            return r113;
        L87:
            return MmRecordingUploadResponse.UNKNOWN;
        L96:
            return r112;
        L5:
            if (r100.intValue() != 200) goto L10;
            MmRecordingUploadResponse r114 = MmRecordingUploadResponse.INTERRUPTED;
            if (Intrinsics.areEqual(r101, r114.getStatusCode()) == false) goto L86;
            return r114;
        L86:
            return MmRecordingUploadResponse.SUCCESS;
        }
    }

    public MmRecordingUploadResponse() {
        throw null;
    }

    public static EnumEntries<MmRecordingUploadResponse> getEntries() {
        return f434474b;
    }

    static {
        MmRecordingUploadResponse r100 = new MmRecordingUploadResponse("SUCCESS", 0, 200, 0, null, null, 12, null);
        SUCCESS = r100;
        MmRecordingUploadResponse r101 = new MmRecordingUploadResponse("INTERRUPTED", 1, 200, 1000130048, null, null, 12, null);
        INTERRUPTED = r101;
        ErrorType r102 = ErrorType.CLIENT_ERROR;
        MmRecordingUploadResponse r103 = new MmRecordingUploadResponse("NON_RECORDING_TYPE", 2, 400, 1000130040, r102, null, 8, null);
        NON_RECORDING_TYPE = r103;
        MmRecordingUploadResponse r104 = new MmRecordingUploadResponse("INVALID_PARAMETER", 3, 400, -1, r102, null, 8, null);
        INVALID_PARAMETER = r104;
        MmRecordingUploadResponse r105 = new MmRecordingUploadResponse("UPLOAD_COMPLETED", 4, 406, 1000130041, r102, null, 8, null);
        UPLOAD_COMPLETED = r105;
        MmRecordingUploadResponse r410 = new MmRecordingUploadResponse("REACH_MAX_DURATION", 5, 406, 1000130043, r102, null, 8, null);
        REACH_MAX_DURATION = r410;
        ErrorType r106 = ErrorType.BIZ_SERVER_ERROR;
        MmRecordingUploadResponse r107 = new MmRecordingUploadResponse("TENANT_KEY_DELETED", 6, 500, 11010, r106, null, 8, null);
        TENANT_KEY_DELETED = r107;
        MmRecordingUploadResponse r108 = new MmRecordingUploadResponse("GET_TENANT_KEY_FAILED", 7, 500, 1000130044, r106, null, 8, null);
        GET_TENANT_KEY_FAILED = r108;
        MmRecordingUploadResponse r210 = new MmRecordingUploadResponse("ENCRYPTION_FAILED", 8, 500, 1000130045, r106, null, 8, null);
        ENCRYPTION_FAILED = r210;
        MmRecordingUploadResponse r211 = new MmRecordingUploadResponse("TOS_UPLOAD_FAILED", 9, 500, 1000130046, r106, null, 8, null);
        TOS_UPLOAD_FAILED = r211;
        MmRecordingUploadResponse r212 = new MmRecordingUploadResponse("ABASE_FAILED", 10, 500, 1000130047, r106, null, 8, null);
        ABASE_FAILED = r212;
        MmRecordingUploadResponse r213 = new MmRecordingUploadResponse("TRANSCODING_FAILED", 11, 500, 1000130049, r106, null, 8, null);
        TRANSCODING_FAILED = r213;
        MmRecordingUploadResponse r214 = new MmRecordingUploadResponse("SERVER_DOWN", 12, 500, -1, r106, null, 8, null);
        SERVER_DOWN = r214;
        ErrorType r109 = ErrorType.GATEWAY_ERROR;
        MmRecordingUploadResponse r110 = new MmRecordingUploadResponse("NOT_LOGGED_IN", 13, 401, null, r109, null, 10, null);
        NOT_LOGGED_IN = r110;
        MmRecordingUploadResponse r310 = new MmRecordingUploadResponse("UNAUTHORIZED", 14, 403, null, r109, null, 10, null);
        UNAUTHORIZED = r310;
        MmRecordingUploadResponse r411 = new MmRecordingUploadResponse("INCORRECT_PATH", 15, 404, null, r109, null, 10, null);
        INCORRECT_PATH = r411;
        MmRecordingUploadResponse r412 = new MmRecordingUploadResponse("OBJECT_DELETED", 16, 410, null, r109, null, 10, null);
        OBJECT_DELETED = r412;
        ErrorType r111 = ErrorType.OTHER;
        MmRecordingUploadResponse r112 = new MmRecordingUploadResponse("NETWORK", 17, -1, -10001, r111, null, 8, null);
        NETWORK = r112;
        MmRecordingUploadResponse r113 = new MmRecordingUploadResponse("DISKCACHE_INSUFFICIENT", 18, null, -10002, r111, null, 9, null);
        DISKCACHE_INSUFFICIENT = r113;
        MmRecordingUploadResponse r114 = new MmRecordingUploadResponse("UNKNOWN", 19, null, null, null, null, 15, null);
        UNKNOWN = r114;
        MmRecordingUploadResponse[] r115 = {r100, r101, r103, r104, r105, r410, r107, r108, r210, r211, r212, r213, r214, r110, r310, r411, r412, r112, r113, r114};
        f434473a = r115;
        f434474b = EnumEntriesKt.enumEntries(r115);
        Companion = new a();
    }

    public static MmRecordingUploadResponse[] values() {
        return (MmRecordingUploadResponse[]) f434473a.clone();
    }

    public final ErrorType getErrorType() {
        return this.errorType;
    }

    public final Integer getHttpCode() {
        return this.httpCode;
    }

    public final Long getRtt() {
        return this.rtt;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public static MmRecordingUploadResponse valueOf(String r100) {
        return (MmRecordingUploadResponse) r27.a.a(MmRecordingUploadResponse.class, r100);
    }

    public final void setRtt(Long r100) {
        this.rtt = r100;
    }

    public MmRecordingUploadResponse(String r100, int r101, Integer r102, Integer r103, ErrorType r104, Long r105, int r106, DefaultConstructorMarker r107) {
        if ((r106 & 1) == 0) goto L6;
        r102 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 8) == 0) goto L14;
        r105 = null;
    L14:
        super(r100, r101);
        this.httpCode = r102;
        this.statusCode = r103;
        this.errorType = r104;
        this.rtt = r105;
    }
}

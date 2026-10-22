package com.hihonor.push.sdk.internal;

import android.util.SparseArray;
import com.hihonor.push.sdk.common.data.ApiException;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum HonorPushErrorEnum extends Enum<HonorPushErrorEnum> {
    public static final SparseArray<HonorPushErrorEnum> ENUM_MAPPER = null;
    public static final HonorPushErrorEnum ERROR_ARGUMENTS_INVALID = null;
    public static final HonorPushErrorEnum ERROR_BIND_SERVICE = null;
    public static final HonorPushErrorEnum ERROR_CERT_FINGERPRINT_EMPTY = null;
    public static final HonorPushErrorEnum ERROR_HTTP_OPERATION_FREQUENTLY = null;
    public static final HonorPushErrorEnum ERROR_INTERNAL_ERROR = null;
    public static final HonorPushErrorEnum ERROR_MAIN_THREAD = null;
    public static final HonorPushErrorEnum ERROR_NETWORK_NONE = null;
    public static final HonorPushErrorEnum ERROR_NOT_INITIALIZED = null;
    public static final HonorPushErrorEnum ERROR_NOT_SUPPORT_PUSH = null;
    public static final HonorPushErrorEnum ERROR_NO_APPID = null;
    public static final HonorPushErrorEnum ERROR_NO_TOKEN = null;
    public static final HonorPushErrorEnum ERROR_OPERATION_FREQUENTLY = null;
    public static final HonorPushErrorEnum ERROR_PUSH_SERVER = null;
    public static final HonorPushErrorEnum ERROR_SERVICE_ARGUMENTS_INVALID = null;
    public static final HonorPushErrorEnum ERROR_SERVICE_DISABLED = null;
    public static final HonorPushErrorEnum ERROR_SERVICE_DISCONNECTED = null;
    public static final HonorPushErrorEnum ERROR_SERVICE_INVALID = null;
    public static final HonorPushErrorEnum ERROR_SERVICE_MISSING = null;
    public static final HonorPushErrorEnum ERROR_SERVICE_NULL_BINDING = null;
    public static final HonorPushErrorEnum ERROR_SERVICE_REQUEST_TIME_OUT = null;
    public static final HonorPushErrorEnum ERROR_SERVICE_TIME_OUT = null;
    public static final HonorPushErrorEnum ERROR_STATEMENT_AGREEMENT = null;
    public static final HonorPushErrorEnum ERROR_UNKNOWN = null;
    public static final HonorPushErrorEnum SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HonorPushErrorEnum[] f276684a = null;
    public String message;
    public int statusCode;

    static {
        HonorPushErrorEnum r100 = new HonorPushErrorEnum("SUCCESS", 0, 0, "success");
        SUCCESS = r100;
        HonorPushErrorEnum r101 = new HonorPushErrorEnum("ERROR_NOT_SUPPORT_PUSH", 1, 8001000, "device is not support push.");
        ERROR_NOT_SUPPORT_PUSH = r101;
        HonorPushErrorEnum r102 = new HonorPushErrorEnum("ERROR_MAIN_THREAD", 2, 8001001, "operation in MAIN thread prohibited.");
        ERROR_MAIN_THREAD = r102;
        HonorPushErrorEnum r103 = new HonorPushErrorEnum("ERROR_NO_TOKEN", 3, 8001004, "token missing.");
        ERROR_NO_TOKEN = r103;
        HonorPushErrorEnum r104 = new HonorPushErrorEnum("ERROR_NO_APPID", 4, 8001002, "app id missing.");
        ERROR_NO_APPID = r104;
        HonorPushErrorEnum r105 = new HonorPushErrorEnum("ERROR_NOT_INITIALIZED", 5, 8001005, "SDK not initialized");
        ERROR_NOT_INITIALIZED = r105;
        HonorPushErrorEnum r106 = new HonorPushErrorEnum("ERROR_CERT_FINGERPRINT_EMPTY", 6, 8001003, "certificate fingerprint empty.");
        ERROR_CERT_FINGERPRINT_EMPTY = r106;
        HonorPushErrorEnum r110 = new HonorPushErrorEnum("ERROR_BIND_SERVICE", 7, 8002001, "bind service failed.");
        ERROR_BIND_SERVICE = r110;
        HonorPushErrorEnum r111 = new HonorPushErrorEnum("ERROR_SERVICE_DISCONNECTED", 8, 8002002, "service disconnected.");
        ERROR_SERVICE_DISCONNECTED = r111;
        HonorPushErrorEnum r112 = new HonorPushErrorEnum("ERROR_SERVICE_TIME_OUT", 9, 8002003, "service connect time out.");
        ERROR_SERVICE_TIME_OUT = r112;
        HonorPushErrorEnum r113 = new HonorPushErrorEnum("ERROR_SERVICE_ARGUMENTS_INVALID", 10, 8002004, "service arguments invalid.");
        ERROR_SERVICE_ARGUMENTS_INVALID = r113;
        HonorPushErrorEnum r107 = new HonorPushErrorEnum("ERROR_SERVICE_NULL_BINDING", 11, 8002005, "service being bound has return null.");
        ERROR_SERVICE_NULL_BINDING = r107;
        HonorPushErrorEnum r108 = new HonorPushErrorEnum("ERROR_SERVICE_INVALID", 12, 8002006, "service invalid.");
        ERROR_SERVICE_INVALID = r108;
        HonorPushErrorEnum r109 = new HonorPushErrorEnum("ERROR_SERVICE_DISABLED", 13, 8002007, "service disabled.");
        ERROR_SERVICE_DISABLED = r109;
        HonorPushErrorEnum r114 = new HonorPushErrorEnum("ERROR_SERVICE_MISSING", 14, 8002008, "service missing.");
        ERROR_SERVICE_MISSING = r114;
        HonorPushErrorEnum r115 = new HonorPushErrorEnum("ERROR_PUSH_SERVER", 15, 8003001, "push server error.");
        ERROR_PUSH_SERVER = r115;
        HonorPushErrorEnum r116 = new HonorPushErrorEnum("ERROR_UNKNOWN", 16, 8003002, "unknown error.");
        ERROR_UNKNOWN = r116;
        HonorPushErrorEnum r117 = new HonorPushErrorEnum("ERROR_INTERNAL_ERROR", 17, 8003003, "internal error.");
        ERROR_INTERNAL_ERROR = r117;
        HonorPushErrorEnum r118 = new HonorPushErrorEnum("ERROR_ARGUMENTS_INVALID", 18, 8003004, "arguments invalid.");
        ERROR_ARGUMENTS_INVALID = r118;
        HonorPushErrorEnum r119 = new HonorPushErrorEnum("ERROR_OPERATION_FREQUENTLY", 19, 8003005, "operation too frequently.");
        ERROR_OPERATION_FREQUENTLY = r119;
        HonorPushErrorEnum r120 = new HonorPushErrorEnum("ERROR_NETWORK_NONE", 20, 8003006, "no network.");
        ERROR_NETWORK_NONE = r120;
        HonorPushErrorEnum r121 = new HonorPushErrorEnum("ERROR_STATEMENT_AGREEMENT", 21, 8003007, "not statement agreement.");
        ERROR_STATEMENT_AGREEMENT = r121;
        HonorPushErrorEnum r122 = new HonorPushErrorEnum("ERROR_SERVICE_REQUEST_TIME_OUT", 22, 8003008, "service request time out.");
        ERROR_SERVICE_REQUEST_TIME_OUT = r122;
        HonorPushErrorEnum r123 = new HonorPushErrorEnum("ERROR_HTTP_OPERATION_FREQUENTLY", 23, 10214, "http operation too frequently.");
        ERROR_HTTP_OPERATION_FREQUENTLY = r123;
        f276684a = new HonorPushErrorEnum[]{r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123};
        ENUM_MAPPER = new SparseArray();
        HonorPushErrorEnum[] r124 = values();
        int r125 = 0;
    L4:
        if (r125 >= 24) goto L6;
        HonorPushErrorEnum r126 = r124[r125];
        ENUM_MAPPER.put(r126.statusCode, r126);
        r125 = r125 + 1;
        goto L4
    }

    public static HonorPushErrorEnum[] values() {
        return (HonorPushErrorEnum[]) f276684a.clone();
    }

    public ApiException toApiException() {
        return new ApiException(getErrorCode(), getMessage());
    }

    public int getErrorCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public static HonorPushErrorEnum fromCode(int r100) {
        return ENUM_MAPPER.get(r100, ERROR_UNKNOWN);
    }

    public static HonorPushErrorEnum valueOf(String r100) {
        return (HonorPushErrorEnum) a.a(HonorPushErrorEnum.class, r100);
    }

    public HonorPushErrorEnum(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.statusCode = r102;
        this.message = r103;
    }
}

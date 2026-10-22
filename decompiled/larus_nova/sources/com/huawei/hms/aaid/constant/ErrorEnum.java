package com.huawei.hms.aaid.constant;

import android.util.SparseArray;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.SendException;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.huawei.hms.support.api.entity.core.CommonCode;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final enum ErrorEnum extends Enum<ErrorEnum> {
    private static final /* synthetic */ ErrorEnum[] $VALUES = null;
    private static final SparseArray<ErrorEnum> ENUM_MAPPER = null;
    public static final ErrorEnum ERROR_3RD_PARTY_INTERNAL_ERROR = null;
    public static final ErrorEnum ERROR_API_NOT_SPECIFIED = null;
    public static final ErrorEnum ERROR_APP_SERVER_NOT_ONLINE = null;
    public static final ErrorEnum ERROR_ARGUMENTS_INVALID = null;
    public static final ErrorEnum ERROR_AUTH_INFO_NOT_EXIST = null;
    public static final ErrorEnum ERROR_AUTO_INITIALIZING = null;
    public static final ErrorEnum ERROR_BIND_SERVICE_SELF_MAPPING = null;
    public static final ErrorEnum ERROR_BUILD_CONTENT_ERROR = null;
    public static final ErrorEnum ERROR_CACHE_SIZE_EXCEED = null;
    public static final ErrorEnum ERROR_CERT_FINGERPRINT_EMPTY = null;
    public static final ErrorEnum ERROR_CERT_FINGERPRINT_ERROR = null;
    public static final ErrorEnum ERROR_CLIENT_API_INVALID = null;
    public static final ErrorEnum ERROR_DELETE_3RD_PARTY_TOKEN_FAILED = null;
    public static final ErrorEnum ERROR_DENY_SUBSCRIPTION = null;
    public static final ErrorEnum ERROR_EVENT_INVALID = null;
    public static final ErrorEnum ERROR_EXECUTE_TIMEOUT = null;
    public static final ErrorEnum ERROR_FETCH_DOMAIN_FAILED = null;
    public static final ErrorEnum ERROR_GET_3RD_PARTY_TOKEN_FAILED = null;
    public static final ErrorEnum ERROR_GET_SCOPE_ERROR = null;
    public static final ErrorEnum ERROR_HMS_CLIENT_API = null;
    public static final ErrorEnum ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING = null;
    public static final ErrorEnum ERROR_HMS_OUTDATED_VERSION = null;
    public static final ErrorEnum ERROR_HWID_NOT_LOGIN = null;
    public static final ErrorEnum ERROR_INTERNAL_ERROR = null;
    public static final ErrorEnum ERROR_INVALID_PARAMETERS = null;
    public static final ErrorEnum ERROR_LENGTH = null;
    public static final ErrorEnum ERROR_LENGTH_OLD = null;
    public static final ErrorEnum ERROR_MAIN_THREAD = null;
    public static final ErrorEnum ERROR_MISSING_PROJECT_ID = null;
    public static final ErrorEnum ERROR_MSG_CACHE = null;
    public static final ErrorEnum ERROR_MULTISENDER_NO_RIGHT = null;
    public static final ErrorEnum ERROR_NAMING_INVALID = null;
    public static final ErrorEnum ERROR_NOTIFICATION_DISABLED = null;
    public static final ErrorEnum ERROR_NOTIFICATION_ENABLED = null;
    public static final ErrorEnum ERROR_NOT_ALLOW_CROSS_APPLY = null;
    public static final ErrorEnum ERROR_NOT_IN_SERVICE = null;
    public static final ErrorEnum ERROR_NOT_SUPPORT_SUB_USER = null;
    public static final ErrorEnum ERROR_NO_CONNECTION_ID = null;
    public static final ErrorEnum ERROR_NO_CONNECTION_ID_OLD = null;
    public static final ErrorEnum ERROR_NO_DEVICE_ID_TYPE = null;
    public static final ErrorEnum ERROR_NO_DEVICE_ID_TYPE_OLD = null;
    public static final ErrorEnum ERROR_NO_NETWORK = null;
    public static final ErrorEnum ERROR_NO_NETWORK_OLD = null;
    public static final ErrorEnum ERROR_NO_RIGHT = null;
    public static final ErrorEnum ERROR_NO_RIGHT_SELF_MAPPING = null;
    public static final ErrorEnum ERROR_NO_RIGHT_TO_ACCESS_ENTITY = null;
    public static final ErrorEnum ERROR_NO_TOKEN = null;
    public static final ErrorEnum ERROR_NO_TOKENSIGN = null;
    public static final ErrorEnum ERROR_NO_TOKEN_OLD = null;
    public static final ErrorEnum ERROR_OPERATION_NOT_SUPPORTED = null;
    public static final ErrorEnum ERROR_OPER_IN_CHILD_PROCESS = null;
    public static final ErrorEnum ERROR_OVER_FLOW_CONTROL_SIZE = null;
    public static final ErrorEnum ERROR_PARAM_INVALID = null;
    public static final ErrorEnum ERROR_PERMISSION_EXPIRED = null;
    public static final ErrorEnum ERROR_PERMISSION_LIST_EMPTY = null;
    public static final ErrorEnum ERROR_PERMISSION_NOT_AUTHORIZED = null;
    public static final ErrorEnum ERROR_PERMISSION_NOT_EXIST = null;
    public static final ErrorEnum ERROR_PROFILE_EXCEED = null;
    public static final ErrorEnum ERROR_PUSHAGENT_OUTDATED_VERSION = null;
    public static final ErrorEnum ERROR_PUSH_ARGUMENTS_INVALID = null;
    public static final ErrorEnum ERROR_PUSH_CLIENT_API_INVALID = null;
    public static final ErrorEnum ERROR_PUSH_EXECUTE_TIMEOUT = null;
    public static final ErrorEnum ERROR_PUSH_INTERNAL_ERROR = null;
    public static final ErrorEnum ERROR_PUSH_NAMING_INVALID = null;
    public static final ErrorEnum ERROR_PUSH_NOT_IN_SERVICE = null;
    public static final ErrorEnum ERROR_PUSH_SERVER = null;
    public static final ErrorEnum ERROR_PUSH_SERVER_OLD = null;
    public static final ErrorEnum ERROR_REQUEST_TOO_FREQUENT = null;
    public static final ErrorEnum ERROR_RESTRICT_GET_TOKEN = null;
    public static final ErrorEnum ERROR_RETRY_LATER_SELF_MAPPING = null;
    public static final ErrorEnum ERROR_SCOPE_LIST_EMPTY = null;
    public static final ErrorEnum ERROR_SEND_SELF_MAPPING = null;
    public static final ErrorEnum ERROR_SERVICE_NOT_AVAILABLE = null;
    public static final ErrorEnum ERROR_SESSION_INVALID = null;
    public static final ErrorEnum ERROR_SIZE = null;
    public static final ErrorEnum ERROR_SPUSH_ESSION_INVALID = null;
    public static final ErrorEnum ERROR_STORAGE_LOCATION_EMPTY = null;
    public static final ErrorEnum ERROR_TOKENSIGN_VALID = null;
    public static final ErrorEnum ERROR_TOKEN_DECRYPT = null;
    public static final ErrorEnum ERROR_TOKEN_URL_EMPTY = null;
    public static final ErrorEnum ERROR_TOO_MANY_MESSAGES = null;
    public static final ErrorEnum ERROR_TOPIC_EXCEED = null;
    public static final ErrorEnum ERROR_TOPIC_SEND = null;
    public static final ErrorEnum ERROR_TTL_EXCEEDED = null;
    public static final ErrorEnum ERROR_UNKNOWN = null;
    public static final ErrorEnum ERROR_UPSTREAM_DEVICE_NOT_IN_GROUP = null;
    public static final ErrorEnum ERROR_UPSTREAM_STORAGE_LOCATION_EMPTY = null;
    public static final ErrorEnum ERROR_UPSTREAM_TOKENSIGN_VALID = null;
    public static final ErrorEnum ERROR_UPSTREAM_TOKEN_DECRYPT = null;
    public static final ErrorEnum SUCCESS = null;
    private int externalCode;
    private int internalCode;
    private String message;

    static {
        ErrorEnum r100 = new ErrorEnum("SUCCESS", 0, 0, 0, "success");
        SUCCESS = r100;
        ErrorEnum r101 = new ErrorEnum("ERROR_NO_TOKEN", 1, 800000000, SendException.ERROR_NO_TOKEN, "token missing");
        ERROR_NO_TOKEN = r101;
        ErrorEnum r102 = new ErrorEnum("ERROR_NO_TOKENSIGN", 2, 800000001, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_NO_TOKENSIGN = r102;
        ErrorEnum r103 = new ErrorEnum("ERROR_NO_NETWORK", 3, 800000002, SendException.ERROR_NO_NETWORK, "no network");
        ERROR_NO_NETWORK = r103;
        ErrorEnum r104 = new ErrorEnum("ERROR_SERVICE_NOT_AVAILABLE", 4, 800000003, SendException.ERROR_SERVICE_NOT_AVAILABLE, "service not available");
        ERROR_SERVICE_NOT_AVAILABLE = r104;
        ErrorEnum r105 = new ErrorEnum("ERROR_PUSH_SERVER", 5, 800000004, SendException.ERROR_PUSH_SERVER, "push server error");
        ERROR_PUSH_SERVER = r105;
        ErrorEnum r106 = new ErrorEnum("ERROR_UNKNOWN", 6, 800000005, SendException.ERROR_UNKNOWN, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ERROR_UNKNOWN = r106;
        ErrorEnum r110 = new ErrorEnum("ERROR_NO_RIGHT", 7, 800100000, 907122036, "no right");
        ERROR_NO_RIGHT = r110;
        ErrorEnum r107 = new ErrorEnum("ERROR_NO_CONNECTION_ID", 8, 800100001, 907122037, "get token error");
        ERROR_NO_CONNECTION_ID = r107;
        ErrorEnum r108 = new ErrorEnum("ERROR_LENGTH", 9, 800100002, 907122037, "get token error");
        ERROR_LENGTH = r108;
        ErrorEnum r109 = new ErrorEnum("ERROR_NO_DEVICE_ID_TYPE", 10, 800100003, 907122037, "get token error");
        ERROR_NO_DEVICE_ID_TYPE = r109;
        ErrorEnum r111 = new ErrorEnum("ERROR_PARAM_INVALID", 11, 800100004, 907122037, "get token error");
        ERROR_PARAM_INVALID = r111;
        ErrorEnum r112 = new ErrorEnum("ERROR_TOKEN_URL_EMPTY", 12, 800100005, 907122037, "get token error");
        ERROR_TOKEN_URL_EMPTY = r112;
        ErrorEnum r113 = new ErrorEnum("ERROR_NOT_ALLOW_CROSS_APPLY", 13, 800100006, 907122053, "Failed to apply for the token. Cross-region application is not allowed.");
        ERROR_NOT_ALLOW_CROSS_APPLY = r113;
        ErrorEnum r210 = new ErrorEnum("ERROR_MULTISENDER_NO_RIGHT", 14, 800100007, 907122039, "Failed to apply for the token. No multisender right.");
        ERROR_MULTISENDER_NO_RIGHT = r210;
        ErrorEnum r114 = new ErrorEnum("ERROR_TOKEN_DECRYPT", 15, 800200001, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_TOKEN_DECRYPT = r114;
        ErrorEnum r115 = new ErrorEnum("ERROR_TOKENSIGN_VALID", 16, 800200002, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_TOKENSIGN_VALID = r115;
        ErrorEnum r116 = new ErrorEnum("ERROR_TOPIC_EXCEED", 17, 800200003, 907122034, "topic exceed");
        ERROR_TOPIC_EXCEED = r116;
        ErrorEnum r117 = new ErrorEnum("ERROR_TOPIC_SEND", 18, 800200004, 907122035, "topic send error");
        ERROR_TOPIC_SEND = r117;
        ErrorEnum r118 = new ErrorEnum("ERROR_STORAGE_LOCATION_EMPTY", 19, 800200005, 907122038, "storage location is empty or invalid");
        ERROR_STORAGE_LOCATION_EMPTY = r118;
        ErrorEnum r119 = new ErrorEnum("ERROR_SIZE", 20, 800300000, SendException.ERROR_SIZE, "message size error");
        ERROR_SIZE = r119;
        ErrorEnum r211 = new ErrorEnum("ERROR_INVALID_PARAMETERS", 21, 800300001, SendException.ERROR_INVALID_PARAMETERS, "parameter invalid");
        ERROR_INVALID_PARAMETERS = r211;
        ErrorEnum r212 = new ErrorEnum("ERROR_TOO_MANY_MESSAGES", 22, 800300002, SendException.ERROR_TOO_MANY_MESSAGES, "too many messages");
        ERROR_TOO_MANY_MESSAGES = r212;
        ErrorEnum r213 = new ErrorEnum("ERROR_TTL_EXCEEDED", 23, 800300003, SendException.ERROR_TTL_EXCEEDED, "ttl exceed");
        ERROR_TTL_EXCEEDED = r213;
        ErrorEnum r214 = new ErrorEnum("ERROR_UPSTREAM_TOKEN_DECRYPT", 24, 800300004, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_UPSTREAM_TOKEN_DECRYPT = r214;
        ErrorEnum r215 = new ErrorEnum("ERROR_UPSTREAM_TOKENSIGN_VALID", 25, 800300005, SendException.ERROR_TOKEN_INVALID, "token invalid");
        ERROR_UPSTREAM_TOKENSIGN_VALID = r215;
        ErrorEnum r216 = new ErrorEnum("ERROR_UPSTREAM_DEVICE_NOT_IN_GROUP", 26, 800300006, 907122057, "device not in device group");
        ERROR_UPSTREAM_DEVICE_NOT_IN_GROUP = r216;
        ErrorEnum r217 = new ErrorEnum("ERROR_UPSTREAM_STORAGE_LOCATION_EMPTY", 27, 800300007, 907122038, "storage location is empty or invalid");
        ERROR_UPSTREAM_STORAGE_LOCATION_EMPTY = r217;
        ErrorEnum r310 = new ErrorEnum("ERROR_CACHE_SIZE_EXCEED", 28, 800300008, 907122058, "cache size exceeds threshold");
        ERROR_CACHE_SIZE_EXCEED = r310;
        ErrorEnum r218 = new ErrorEnum("ERROR_MSG_CACHE", 29, 800300009, 907122059, "message is cached");
        ERROR_MSG_CACHE = r218;
        ErrorEnum r219 = new ErrorEnum("ERROR_APP_SERVER_NOT_ONLINE", 30, 800300010, 907122060, "app server is not online.");
        ERROR_APP_SERVER_NOT_ONLINE = r219;
        ErrorEnum r311 = new ErrorEnum("ERROR_OVER_FLOW_CONTROL_SIZE", 31, 800300011, 907122061, "The frequency of invoking APIs is too high.");
        ERROR_OVER_FLOW_CONTROL_SIZE = r311;
        ErrorEnum r312 = new ErrorEnum("ERROR_PUSH_ARGUMENTS_INVALID", 32, 807135000, 907135000, "arguments invalid");
        ERROR_PUSH_ARGUMENTS_INVALID = r312;
        ErrorEnum r313 = new ErrorEnum("ERROR_PUSH_INTERNAL_ERROR", 33, 807135001, CommonCode.ErrorCode.INTERNAL_ERROR, "internal error");
        ERROR_PUSH_INTERNAL_ERROR = r313;
        ErrorEnum r314 = new ErrorEnum("ERROR_PUSH_NAMING_INVALID", 34, 807135002, CommonCode.ErrorCode.NAMING_INVALID, "naming invalid");
        ERROR_PUSH_NAMING_INVALID = r314;
        ErrorEnum r410 = new ErrorEnum("ERROR_PUSH_CLIENT_API_INVALID", 35, 807135003, CommonCode.ErrorCode.CLIENT_API_INVALID, "client api invalid");
        ERROR_PUSH_CLIENT_API_INVALID = r410;
        ErrorEnum r315 = new ErrorEnum("ERROR_PUSH_EXECUTE_TIMEOUT", 36, 807135004, CommonCode.ErrorCode.EXECUTE_TIMEOUT, "execute timeout");
        ERROR_PUSH_EXECUTE_TIMEOUT = r315;
        ErrorEnum r316 = new ErrorEnum("ERROR_PUSH_NOT_IN_SERVICE", 37, 807135005, CommonCode.ErrorCode.NOT_IN_SERVICE, "not in service");
        ERROR_PUSH_NOT_IN_SERVICE = r316;
        ErrorEnum r317 = new ErrorEnum("ERROR_SPUSH_ESSION_INVALID", 38, 807135006, CommonCode.ErrorCode.SESSION_INVALID, "session invalid");
        ERROR_SPUSH_ESSION_INVALID = r317;
        ErrorEnum r318 = new ErrorEnum("ERROR_ARGUMENTS_INVALID", 39, 907135000, 907135000, "arguments invalid");
        ERROR_ARGUMENTS_INVALID = r318;
        ErrorEnum r319 = new ErrorEnum("ERROR_INTERNAL_ERROR", 40, CommonCode.ErrorCode.INTERNAL_ERROR, CommonCode.ErrorCode.INTERNAL_ERROR, "internal error");
        ERROR_INTERNAL_ERROR = r319;
        ErrorEnum r411 = new ErrorEnum("ERROR_NAMING_INVALID", 41, CommonCode.ErrorCode.NAMING_INVALID, CommonCode.ErrorCode.NAMING_INVALID, "naming invalid");
        ERROR_NAMING_INVALID = r411;
        ErrorEnum r412 = new ErrorEnum("ERROR_CLIENT_API_INVALID", 42, CommonCode.ErrorCode.CLIENT_API_INVALID, CommonCode.ErrorCode.CLIENT_API_INVALID, "client api invalid");
        ERROR_CLIENT_API_INVALID = r412;
        ErrorEnum r413 = new ErrorEnum("ERROR_EXECUTE_TIMEOUT", 43, CommonCode.ErrorCode.EXECUTE_TIMEOUT, CommonCode.ErrorCode.EXECUTE_TIMEOUT, "execute timeout");
        ERROR_EXECUTE_TIMEOUT = r413;
        ErrorEnum r414 = new ErrorEnum("ERROR_NOT_IN_SERVICE", 44, CommonCode.ErrorCode.NOT_IN_SERVICE, CommonCode.ErrorCode.NOT_IN_SERVICE, "not in service");
        ERROR_NOT_IN_SERVICE = r414;
        ErrorEnum r415 = new ErrorEnum("ERROR_SESSION_INVALID", 45, CommonCode.ErrorCode.SESSION_INVALID, CommonCode.ErrorCode.SESSION_INVALID, "session invalid");
        ERROR_SESSION_INVALID = r415;
        ErrorEnum r416 = new ErrorEnum("ERROR_API_NOT_SPECIFIED", 46, 1002, 1002, "API not specified");
        ERROR_API_NOT_SPECIFIED = r416;
        ErrorEnum r417 = new ErrorEnum("ERROR_GET_SCOPE_ERROR", 47, AuthCode.ErrorCode.GET_SCOPE_ERROR, AuthCode.ErrorCode.GET_SCOPE_ERROR, "get scope error");
        ERROR_GET_SCOPE_ERROR = r417;
        ErrorEnum r418 = new ErrorEnum("ERROR_SCOPE_LIST_EMPTY", 48, 907135701, 907135701, "scope list empty");
        ERROR_SCOPE_LIST_EMPTY = r418;
        ErrorEnum r510 = new ErrorEnum("ERROR_CERT_FINGERPRINT_EMPTY", 49, AuthCode.ErrorCode.CERT_FINGERPRINT_EMPTY, AuthCode.ErrorCode.CERT_FINGERPRINT_EMPTY, "certificate fingerprint empty");
        ERROR_CERT_FINGERPRINT_EMPTY = r510;
        ErrorEnum r419 = new ErrorEnum("ERROR_PERMISSION_LIST_EMPTY", 50, AuthCode.ErrorCode.PERMISSION_LIST_EMPTY, AuthCode.ErrorCode.PERMISSION_LIST_EMPTY, "permission list empty");
        ERROR_PERMISSION_LIST_EMPTY = r419;
        ErrorEnum r511 = new ErrorEnum("ERROR_AUTH_INFO_NOT_EXIST", 51, 6002, 6002, "auth info not exist");
        ERROR_AUTH_INFO_NOT_EXIST = r511;
        ErrorEnum r512 = new ErrorEnum("ERROR_CERT_FINGERPRINT_ERROR", 52, 6003, 6003, "certificate fingerprint error");
        ERROR_CERT_FINGERPRINT_ERROR = r512;
        ErrorEnum r513 = new ErrorEnum("ERROR_PERMISSION_NOT_EXIST", 53, AuthCode.StatusCode.PERMISSION_NOT_EXIST, AuthCode.StatusCode.PERMISSION_NOT_EXIST, "permission not exist");
        ERROR_PERMISSION_NOT_EXIST = r513;
        ErrorEnum r514 = new ErrorEnum("ERROR_PERMISSION_NOT_AUTHORIZED", 54, AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, "permission not authorized");
        ERROR_PERMISSION_NOT_AUTHORIZED = r514;
        ErrorEnum r515 = new ErrorEnum("ERROR_PERMISSION_EXPIRED", 55, AuthCode.StatusCode.PERMISSION_EXPIRED, AuthCode.StatusCode.PERMISSION_EXPIRED, "permission expired");
        ERROR_PERMISSION_EXPIRED = r515;
        ErrorEnum r610 = new ErrorEnum("ERROR_NO_NETWORK_OLD", 56, 907122005, SendException.ERROR_NO_NETWORK, "no network");
        ERROR_NO_NETWORK_OLD = r610;
        ErrorEnum r516 = new ErrorEnum("ERROR_NO_RIGHT_SELF_MAPPING", 57, 907122011, 907122036, "no right");
        ERROR_NO_RIGHT_SELF_MAPPING = r516;
        ErrorEnum r517 = new ErrorEnum("ERROR_NO_CONNECTION_ID_OLD", 58, 907122012, 907122037, "get token error");
        ERROR_NO_CONNECTION_ID_OLD = r517;
        ErrorEnum r518 = new ErrorEnum("ERROR_LENGTH_OLD", 59, 907122013, 907122037, "get token error");
        ERROR_LENGTH_OLD = r518;
        ErrorEnum r519 = new ErrorEnum("ERROR_NO_DEVICE_ID_TYPE_OLD", 60, 907122014, 907122037, "get token error");
        ERROR_NO_DEVICE_ID_TYPE_OLD = r519;
        ErrorEnum r611 = new ErrorEnum("ERROR_PUSH_SERVER_OLD", 61, 907122017, SendException.ERROR_PUSH_SERVER, "push server error");
        ERROR_PUSH_SERVER_OLD = r611;
        ErrorEnum r612 = new ErrorEnum("ERROR_NO_TOKEN_OLD", 62, 907122019, SendException.ERROR_NO_TOKEN, "token missing");
        ERROR_NO_TOKEN_OLD = r612;
        ErrorEnum r613 = new ErrorEnum("ERROR_HMS_CLIENT_API", 63, 907122048, 907122048, "HMS client api invalid");
        ERROR_HMS_CLIENT_API = r613;
        ErrorEnum r614 = new ErrorEnum("ERROR_OPERATION_NOT_SUPPORTED", 64, 907122049, 907122049, "operation not supported");
        ERROR_OPERATION_NOT_SUPPORTED = r614;
        ErrorEnum r615 = new ErrorEnum("ERROR_MAIN_THREAD", 65, 907122050, 907122050, "operation in MAIN thread prohibited");
        ERROR_MAIN_THREAD = r615;
        ErrorEnum r616 = new ErrorEnum("ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING", 66, 907122051, 907122051, "device certificate auth fail");
        ERROR_HMS_DEVICE_AUTH_FAILED_SELF_MAPPING = r616;
        ErrorEnum r617 = new ErrorEnum("ERROR_BIND_SERVICE_SELF_MAPPING", 67, 907122052, 907122052, "bind service failed.");
        ERROR_BIND_SERVICE_SELF_MAPPING = r617;
        ErrorEnum r618 = new ErrorEnum("ERROR_AUTO_INITIALIZING", 68, 907122054, 907122054, "push kit initializing, try again later");
        ERROR_AUTO_INITIALIZING = r618;
        ErrorEnum r619 = new ErrorEnum("ERROR_RETRY_LATER_SELF_MAPPING", 69, 907122055, 907122055, "System busy, please retry later.");
        ERROR_RETRY_LATER_SELF_MAPPING = r619;
        ErrorEnum r710 = new ErrorEnum("ERROR_SEND_SELF_MAPPING", 70, 907122056, 907122056, "send error.");
        ERROR_SEND_SELF_MAPPING = r710;
        ErrorEnum r711 = new ErrorEnum("ERROR_MISSING_PROJECT_ID", 71, 907122064, 907122064, "agc connect services config missing project id");
        ERROR_MISSING_PROJECT_ID = r711;
        ErrorEnum r712 = new ErrorEnum("ERROR_RESTRICT_GET_TOKEN", 72, 800100014, 907122065, "restrict get token");
        ERROR_RESTRICT_GET_TOKEN = r712;
        ErrorEnum r713 = new ErrorEnum("ERROR_GET_3RD_PARTY_TOKEN_FAILED", 73, 907122101, 907122101, "get 3rd-party token failed.");
        ERROR_GET_3RD_PARTY_TOKEN_FAILED = r713;
        ErrorEnum r714 = new ErrorEnum("ERROR_DELETE_3RD_PARTY_TOKEN_FAILED", 74, 907122102, 907122102, "delete 3rd-party token failed.");
        ERROR_DELETE_3RD_PARTY_TOKEN_FAILED = r714;
        ErrorEnum r715 = new ErrorEnum("ERROR_3RD_PARTY_INTERNAL_ERROR", 75, 907122103, 907122103, "3rd-party internal error.");
        ERROR_3RD_PARTY_INTERNAL_ERROR = r715;
        ErrorEnum r716 = new ErrorEnum("ERROR_FETCH_DOMAIN_FAILED", 76, 907135104, 907135104, "fetch domain failed.");
        ERROR_FETCH_DOMAIN_FAILED = r716;
        ErrorEnum r810 = new ErrorEnum("ERROR_BUILD_CONTENT_ERROR", 77, 907122105, 907122105, "build content error.");
        ERROR_BUILD_CONTENT_ERROR = r810;
        ErrorEnum r717 = new ErrorEnum("ERROR_HWID_NOT_LOGIN", 78, 907122066, 907122066, "account logout");
        ERROR_HWID_NOT_LOGIN = r717;
        ErrorEnum r718 = new ErrorEnum("ERROR_PROFILE_EXCEED", 79, 800400000, 907122067, "profile num over limit");
        ERROR_PROFILE_EXCEED = r718;
        ErrorEnum r719 = new ErrorEnum("ERROR_OPER_IN_CHILD_PROCESS", 80, 907122068, 907122068, "Operations in child processes are not supported.");
        ERROR_OPER_IN_CHILD_PROCESS = r719;
        ErrorEnum r811 = new ErrorEnum("ERROR_NOT_SUPPORT_SUB_USER", 81, 907122069, 907122069, "Operations on sub-users are not supported.");
        ERROR_NOT_SUPPORT_SUB_USER = r811;
        ErrorEnum r812 = new ErrorEnum("ERROR_PUSHAGENT_OUTDATED_VERSION", 82, 907122070, 907122070, "Push Service version out-of-date.");
        ERROR_PUSHAGENT_OUTDATED_VERSION = r812;
        ErrorEnum r813 = new ErrorEnum("ERROR_NOTIFICATION_ENABLED", 83, 907122071, 907122071, "Notification Enabled.");
        ERROR_NOTIFICATION_ENABLED = r813;
        ErrorEnum r910 = new ErrorEnum("ERROR_HMS_OUTDATED_VERSION", 84, 907122072, 907122072, "HMS Core version out-of-date.");
        ERROR_HMS_OUTDATED_VERSION = r910;
        ErrorEnum r814 = new ErrorEnum("ERROR_REQUEST_TOO_FREQUENT", 85, 907122073, 907122073, "Requests are too frequent.");
        ERROR_REQUEST_TOO_FREQUENT = r814;
        ErrorEnum r815 = new ErrorEnum("ERROR_NOTIFICATION_DISABLED", 86, 907122074, 907122074, "The notification is disabled.");
        ERROR_NOTIFICATION_DISABLED = r815;
        ErrorEnum r816 = new ErrorEnum("ERROR_DENY_SUBSCRIPTION", 87, 907122075, 907122075, "Deny subscription.");
        ERROR_DENY_SUBSCRIPTION = r816;
        ErrorEnum r817 = new ErrorEnum("ERROR_EVENT_INVALID", 88, 907122076, 907122076, "Event invalid.");
        ERROR_EVENT_INVALID = r817;
        ErrorEnum r818 = new ErrorEnum("ERROR_NO_RIGHT_TO_ACCESS_ENTITY", 89, 907122077, 907122077, "No rights to access entity id.");
        ERROR_NO_RIGHT_TO_ACCESS_ENTITY = r818;
        $VALUES = new ErrorEnum[]{r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112, r113, r210, r114, r115, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217, r310, r218, r219, r311, r312, r313, r314, r410, r315, r316, r317, r318, r319, r411, r412, r413, r414, r415, r416, r417, r418, r510, r419, r511, r512, r513, r514, r515, r610, r516, r517, r518, r519, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r810, r717, r718, r719, r811, r812, r813, r910, r814, r815, r816, r817, r818};
        ENUM_MAPPER = new SparseArray();
        ErrorEnum[] r120 = values();
        int r121 = r120.length;
        int r122 = 0;
    L3:
        if (r122 >= r121) goto L5;
        ErrorEnum r123 = r120[r122];
        SparseArray<ErrorEnum> r124 = ENUM_MAPPER;
        r124.put(r123.internalCode, r123);
        r124.put(r123.externalCode, r123);
        r122 = r122 + 1;
        goto L3
    }

    public static ErrorEnum[] values() {
        return (ErrorEnum[]) $VALUES.clone();
    }

    public ApiException toApiException() {
        return new ApiException(new Status(getExternalCode(), getMessage()));
    }

    public int getExternalCode() {
        return this.externalCode;
    }

    public int getInternalCode() {
        return this.internalCode;
    }

    public String getMessage() {
        return this.message;
    }

    public static ErrorEnum fromCode(int r100) {
        return ENUM_MAPPER.get(r100, ERROR_UNKNOWN);
    }

    public static ErrorEnum valueOf(String r100) {
        return (ErrorEnum) a.a(ErrorEnum.class, r100);
    }

    private ErrorEnum(String r100, int r101, int r102, int r103, String r104) {
        super(r100, r101);
        this.internalCode = r102;
        this.externalCode = r103;
        this.message = r104;
    }
}

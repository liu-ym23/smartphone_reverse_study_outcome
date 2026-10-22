package com.bytedance.bdp.appbase.context.service.operate.sync;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/bdp/appbase/context/service/operate/sync/ResultType;", "", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "OK", "ERROR_NATIVE_EXCEPTION", "ERROR_INTERNAL_ERROR", "ERROR_APP_BACKGROUND", "ERROR_FEATURE_NOT_SUPPORTED", "ERROR_USER_AUTH_DENY", "ERROR_SYSTEM_AUTH_DENY", "ERROR_USER_CANCEL", "ERROR_CUSTOM", "ERROR_NETWORK_DISABLED", "ERROR_REQUEST_FAIL", "ERROR_PLATFORM_SERVER", "ERROR_HOST_NOT_LOGIN", "ERROR_PLATFORM_NOT_LOGIN", "ERROR_LOGIN_CANCEL", "INVOKE_TOO_FREQUENTLY", "ERROR_UNKNOWN", "ERROR_METHOD_DEPRECATED", "ERROR_PRIVACY_SCOPE_BEYOND", "ERROR_PRIVACY_AUTH_DENY", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final enum ResultType extends Enum<ResultType> {
    public static final ResultType ERROR_APP_BACKGROUND = null;
    public static final ResultType ERROR_CUSTOM = null;
    public static final ResultType ERROR_FEATURE_NOT_SUPPORTED = null;
    public static final ResultType ERROR_HOST_NOT_LOGIN = null;
    public static final ResultType ERROR_INTERNAL_ERROR = null;
    public static final ResultType ERROR_LOGIN_CANCEL = null;
    public static final ResultType ERROR_METHOD_DEPRECATED = null;
    public static final ResultType ERROR_NATIVE_EXCEPTION = null;
    public static final ResultType ERROR_NETWORK_DISABLED = null;
    public static final ResultType ERROR_PLATFORM_NOT_LOGIN = null;
    public static final ResultType ERROR_PLATFORM_SERVER = null;
    public static final ResultType ERROR_PRIVACY_AUTH_DENY = null;
    public static final ResultType ERROR_PRIVACY_SCOPE_BEYOND = null;
    public static final ResultType ERROR_REQUEST_FAIL = null;
    public static final ResultType ERROR_SYSTEM_AUTH_DENY = null;
    public static final ResultType ERROR_UNKNOWN = null;
    public static final ResultType ERROR_USER_AUTH_DENY = null;
    public static final ResultType ERROR_USER_CANCEL = null;
    public static final ResultType INVOKE_TOO_FREQUENTLY = null;
    public static final ResultType OK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultType[] f200773a = null;
    private final String desc;

    public static ResultType valueOf(String r100) {
        return (ResultType) a.a(ResultType.class, r100);
    }

    public static ResultType[] values() {
        return (ResultType[]) f200773a.clone();
    }

    static {
        ResultType r100 = new ResultType("OK", 0, "operate success");
        OK = r100;
        ResultType r101 = new ResultType("ERROR_NATIVE_EXCEPTION", 1, "occur native exception");
        ERROR_NATIVE_EXCEPTION = r101;
        ResultType r102 = new ResultType("ERROR_INTERNAL_ERROR", 2, "occur internal error");
        ERROR_INTERNAL_ERROR = r102;
        ResultType r103 = new ResultType("ERROR_APP_BACKGROUND", 3, "app in background");
        ERROR_APP_BACKGROUND = r103;
        ResultType r104 = new ResultType("ERROR_FEATURE_NOT_SUPPORTED", 4, "feature not supported");
        ERROR_FEATURE_NOT_SUPPORTED = r104;
        ResultType r105 = new ResultType("ERROR_USER_AUTH_DENY", 5, "auth deny");
        ERROR_USER_AUTH_DENY = r105;
        ResultType r106 = new ResultType("ERROR_SYSTEM_AUTH_DENY", 6, "system auth deny");
        ERROR_SYSTEM_AUTH_DENY = r106;
        ResultType r107 = new ResultType("ERROR_USER_CANCEL", 7, "cancel");
        ERROR_USER_CANCEL = r107;
        ResultType r108 = new ResultType("ERROR_CUSTOM", 8, "customer error");
        ERROR_CUSTOM = r108;
        ResultType r109 = new ResultType("ERROR_NETWORK_DISABLED", 9, "network disabled");
        ERROR_NETWORK_DISABLED = r109;
        ResultType r110 = new ResultType("ERROR_REQUEST_FAIL", 10, "request fail");
        ERROR_REQUEST_FAIL = r110;
        ResultType r111 = new ResultType("ERROR_PLATFORM_SERVER", 11, "platform server");
        ERROR_PLATFORM_SERVER = r111;
        ResultType r112 = new ResultType("ERROR_HOST_NOT_LOGIN", 12, "not login");
        ERROR_HOST_NOT_LOGIN = r112;
        ResultType r113 = new ResultType("ERROR_PLATFORM_NOT_LOGIN", 13, "platform not login");
        ERROR_PLATFORM_NOT_LOGIN = r113;
        ResultType r114 = new ResultType("ERROR_LOGIN_CANCEL", 14, "login canceled by user");
        ERROR_LOGIN_CANCEL = r114;
        ResultType r115 = new ResultType("INVOKE_TOO_FREQUENTLY", 15, "invoke too frequently");
        INVOKE_TOO_FREQUENTLY = r115;
        ResultType r116 = new ResultType("ERROR_UNKNOWN", 16, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        ERROR_UNKNOWN = r116;
        ResultType r117 = new ResultType("ERROR_METHOD_DEPRECATED", 17, "method is deprecated");
        ERROR_METHOD_DEPRECATED = r117;
        ResultType r118 = new ResultType("ERROR_PRIVACY_SCOPE_BEYOND", 18, "api scope is not declared in the privacy agreement");
        ERROR_PRIVACY_SCOPE_BEYOND = r118;
        ResultType r119 = new ResultType("ERROR_PRIVACY_AUTH_DENY", 19, "privacy permission is not authorized");
        ERROR_PRIVACY_AUTH_DENY = r119;
        f200773a = new ResultType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119};
    }

    public final String getDesc() {
        return this.desc;
    }

    public ResultType(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}

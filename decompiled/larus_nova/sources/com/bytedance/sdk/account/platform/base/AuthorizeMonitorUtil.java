package com.bytedance.sdk.account.platform.base;

import com.bytedance.sdk.account.platform.BuildConfig;
import com.bytedance.sdk.account.platform.api.IAuthorizeMonitorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AuthorizeMonitorUtil {
    public static final String EVENT = "passport_third_party_oauth_result";
    public static final String SCENE_AUTH = "auth";
    public static final String SPECIAL = "uc_login";

    /* JADX INFO: loaded from: classes22.dex */
    public interface Param {
        public static final String AUTH_ERROR_CANCEL = "errorCancel";
        public static final String ERROR_CODE = "errCode";
        public static final String ERROR_DESC = "errDesc";
        public static final String PARAMS_FOR_SPECIAL = "params_for_special";
        public static final String PASSPORT_SDK_VERSION = "passport-sdk-version";
        public static final String PLATFORM = "platform";
        public static final String RESULT = "result";
        public static final String SCENE = "scene";
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface Result {
        public static final int FAILURE = 0;
        public static final int SUCCESS = 1;
    }

    public AuthorizeMonitorUtil() {
    }

    public static void checkMonitorService() {
        if (((IAuthorizeMonitorService) AuthorizeFramework.getService(IAuthorizeMonitorService.class)) == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("need IAuthorizeMonitorService to upload SDK events, please call AuthorizeFramework.registerService(IAuthorizeMonitorService instacne) first");
    }

    private static void innerOnEvent(String r100, JSONObject r101) {
        IAuthorizeMonitorService r102 = (IAuthorizeMonitorService) AuthorizeFramework.getService(IAuthorizeMonitorService.class);
        if (r102 == null) goto L6;
        r102.onEvent(r100, r101);
        return;
    }

    public static void onPlatformAuthEvent(String r100, int r101, String r102, String r103, boolean r104, JSONObject r105) {
        if (r105 == null) goto L17;
    L4:
        r105.put("platform", r100);     // Catch: Exception -> L14
        r105.put("scene", "auth");     // Catch: Exception -> L14
        r105.put("result", r101);     // Catch: Exception -> L14
        if (r102 == null) goto L7;
        r105.put("errCode", r102);     // Catch: Exception -> L14
    L7:
        if (r103 == null) goto L9;
        r105.put(Param.ERROR_DESC, r103);     // Catch: Exception -> L14
    L9:
        if (r101 != 0) goto L12;
        if (r104 == false) goto L12;
        r105.put(Param.AUTH_ERROR_CANCEL, r104);     // Catch: Exception -> L14
    L12:
        r105.put(Param.PASSPORT_SDK_VERSION, BuildConfig.VERSION_CODE);     // Catch: Exception -> L14
        r105.put("params_for_special", "uc_login");     // Catch: Exception -> L14
        innerOnEvent(EVENT, r105);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        r105 = new JSONObject();     // Catch: Exception -> L14
        goto L4
    }
}

package com.bytedance.sdk.account.platform.douyin;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.authorize.model.VerifyObject;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class Douyin {
    public static final String ERROR_INVALID_RESPONSE = "invalid_response";
    public static final String ERROR_RESPONSE_NULL = "response null";
    static final String PLATFORM = "aweme";
    private static SoftReference<Request> currentRequest = null;
    public static boolean didCallback = true;
    private static SoftReference<AuthorizeCallback> sAuthorizeCallBack;

    public Douyin() {
    }

    public static void reset() {
        sAuthorizeCallBack = null;
        currentRequest = null;
    }

    private static JSONObject getMonitorExtra() {
        JSONObject r100 = new JSONObject();
        SoftReference<Request> r101 = currentRequest;     // Catch: Exception -> L9
        if (r101 == null) goto L8;
        Request r102 = r101.get();     // Catch: Exception -> L9
        if (r102 == null) goto L8;
        r100.put(BdpAppEventConstant.PARAMS_AUTH_TYPE, r102.authType);     // Catch: Exception -> L9
    L8:
        return r100;
    }

    public static void authorizeCallback(Authorization.Response r110) {
        didCallback = true;
        if (r110 != null) goto L6;
        onAuthorizeFailed(Integer.MAX_VALUE, "response null", null);
        return;
    L6:
        int r100 = r110.errorCode;
        if (r100 != 0) goto L22;
        String r101 = r110.authCode;
        String r102 = r110.state;
        String r103 = r110.grantedPermissions;
        if (r101 != null) goto L24;
    L21:
        onAuthorizeFailed(Integer.MAX_VALUE, "invalid_response", r110.extras);
        return;
    L24:
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L11:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        Bundle r104 = new Bundle();     // Catch: Exception -> L19
        r104.putString("auth_code", r101);     // Catch: Exception -> L19
        r104.putString("state", r102);     // Catch: Exception -> L19
        r104.putString("granted_permission", r103);     // Catch: Exception -> L19
        r104.putBundle("extras", r110.extras);     // Catch: Exception -> L19
        AuthorizeMonitorUtil.onPlatformAuthEvent("aweme", 1, null, null, false, getMonitorExtra());     // Catch: Exception -> L19
        SoftReference<AuthorizeCallback> r105 = sAuthorizeCallBack;     // Catch: Exception -> L19
        if (r105 == null) goto L17;
        AuthorizeCallback r106 = r105.get();     // Catch: Exception -> L19
        if (r106 == null) goto L17;
        r106.onSuccess(r104);     // Catch: Exception -> L19
    L17:
        reset();     // Catch: Exception -> L19
        return;
    L22:
        onAuthorizeFailed(r100, r110.errorMsg, r110.extras);
    }

    private static Authorization.Request buildRequest(Request r100) {
        Authorization.Request r101 = new Authorization.Request();
        String r102 = getScopes(r100.scopes);
        String r103 = getScopes(r100.optionalScopes0);
        String r104 = getScopes(r100.optionalScopes1);
        String r105 = r100.callerLocalEntry;
        String r106 = r100.state;
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r101.scope = r102;
    L6:
        if (TextUtils.isEmpty(r103) == true) goto L9;
        r101.optionalScope0 = r103;
    L9:
        if (TextUtils.isEmpty(r104) == true) goto L12;
        r101.optionalScope1 = r104;
    L12:
        if (TextUtils.isEmpty(r106) == true) goto L15;
        r101.state = r106;
    L15:
        if (TextUtils.isEmpty(r105) == true) goto L17;
        r101.callerLocalEntry = r105;
    L17:
        Bundle r107 = r100.extra;
        r101.extras = r107;
        r101.verifyObject = new VerifyObject(r107.getString(IDouYin2Service.Extra.VERIFY_SCOPE), r100.extra.getString(IDouYin2Service.Extra.VERIFY_TIC), r100.extra.getString(IDouYin2Service.Extra.VERIFY_OPENID));
        r101.isThridAuthDialog = r100.extra.getBoolean(IDouYin2Service.Extra.IS_THIRD_AUTH_DIALOG);
        r101.authTicket = r100.authTicket;
        r101.maskPhoneNumber = r100.maskPhoneNumber;
        r101.isSkipUIInThirdAuth = r100.extra.getBoolean(IDouYin2Service.Extra.IS_SKIP_UI_IN_THIRD_AUTH);
        r101.thirdAuthScene = r100.extra.getString(IDouYin2Service.Extra.THIRD_AUTH_SCENE);
        r101.commentId = r100.extra.getString("comment_id");
        return r101;
    }

    private static String getScopes(Set<String> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L26;
        StringBuilder r101 = new StringBuilder();
        Iterator<String> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L8;
        r101.append(r103);
        r101.append(",");
        goto L8
    L14:
        if (r101.length() > 0) goto L25;
        return "";
    L25:
        return r101.substring(0, r101.length() - 1);
    L26:
        return null;
    }

    public static boolean authorize(DouYinOpenApi r100, Request r101, AuthorizeCallback r102) {
        didCallback = false;
        if (r100 != null) goto L6;
        reset();     // Catch: Exception -> L12
        return false;
    L6:
        sAuthorizeCallBack = new SoftReference(r102);     // Catch: Exception -> L12
        currentRequest = new SoftReference(r101);     // Catch: Exception -> L12
        Authorization.Request r103 = buildRequest(r101);     // Catch: Exception -> L12
        if (r100.isAppSupportAuthorization() == false) goto L11;
        return r100.authorize(r103);
    L11:
        return r100.authorizeWeb(r103);
    L12:
        e = move-exception;
        reset();
        e.printStackTrace();
        return false;
    }

    public static boolean authorizeInThirdApp(DouYinOpenApi r100, Request r101, AuthorizeCallback r102) {
        didCallback = false;
        if (r100 != null) goto L6;
        reset();     // Catch: Exception -> L8
        return false;
    L6:
        sAuthorizeCallBack = new SoftReference(r102);     // Catch: Exception -> L8
        currentRequest = new SoftReference(r101);     // Catch: Exception -> L8
        return r100.authorizeInThirdApp(buildRequest(r101));
    L8:
        e = move-exception;
        reset();
        e.printStackTrace();
        return false;
    }

    public static boolean authorizeWeb(DouYinOpenApi r100, Request r101, AuthorizeCallback r102) {
        didCallback = false;
        if (r100 != null) goto L6;
        reset();     // Catch: Exception -> L8
        return false;
    L6:
        sAuthorizeCallBack = new SoftReference(r102);     // Catch: Exception -> L8
        currentRequest = new SoftReference(r101);     // Catch: Exception -> L8
        return r100.authorizeWeb(buildRequest(r101));
    L8:
        e = move-exception;
        reset();
        e.printStackTrace();
        return false;
    }

    private static void onAuthorizeFailed(int r100, String r101, Bundle r102) {
        AuthorizeErrorResponse r103 = new AuthorizeErrorResponse(r100, r101);
        if (r100 != (-2)) goto L5;
        r103.isCancel = true;
    L5:
        JSONObject r104 = getMonitorExtra();
        if (r102 == null) goto L15;
        r103.extras = r102;
        Iterator<String> r105 = r102.keySet().iterator();     // Catch: Exception -> L13
    L10:
        if (r105.hasNext() == false) goto L15;
        String r106 = r105.next();     // Catch: Exception -> L13
        r104.put(r106, r102.get(r106));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L15:
        AuthorizeMonitorUtil.onPlatformAuthEvent("aweme", 0, r103.platformErrorCode, r103.platformErrorMsg, r103.isCancel, r104);
        SoftReference<AuthorizeCallback> r107 = sAuthorizeCallBack;
        if (r107 == null) goto L20;
        AuthorizeCallback r108 = r107.get();
        if (r108 == null) goto L20;
        r108.onError(r103);
    L20:
        reset();
    }
}

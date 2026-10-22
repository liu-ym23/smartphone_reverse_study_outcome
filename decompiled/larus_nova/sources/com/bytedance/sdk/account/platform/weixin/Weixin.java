package com.bytedance.sdk.account.platform.weixin;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes22.dex */
public class Weixin {
    public static final String ERROR_INVALID_RESPONSE = "invalid_response";
    public static final String ERROR_RESPONSE_NULL = "response null";
    private static final String PLATFORM = "weixin";
    public static boolean didCallback = true;
    private static SoftReference<AuthorizeCallback> sAuthorizeCallBack;

    public Weixin() {
    }

    public static void resetCallBack() {
        sAuthorizeCallBack = null;
    }

    public static void authorizeCallback(SendAuth.Resp r110) {
        didCallback = true;
        if (r110 != null) goto L6;
        onAuthorizeFailed(Integer.MAX_VALUE, "response null");
        return;
    L6:
        int r100 = r110.errCode;
        if (r100 == 0) goto L22;
        onAuthorizeFailed(r100, r110.errStr);
        return;
    L22:
        if (TextUtils.isEmpty(r110.code) == true) goto L18;
        String r101 = r110.code;     // Catch: Exception -> L21
        String r102 = r110.state;     // Catch: Exception -> L21
        String r103 = r110.url;     // Catch: Exception -> L21
        String r111 = r110.openId;     // Catch: Exception -> L21
        Bundle r104 = new Bundle();     // Catch: Exception -> L21
        r104.putString("auth_code", r101);     // Catch: Exception -> L21
        r104.putString("state", r102);     // Catch: Exception -> L21
        r104.putString("url", r103);     // Catch: Exception -> L21
        r104.putString("openId", r111);     // Catch: Exception -> L21
        SoftReference<AuthorizeCallback> r112 = sAuthorizeCallBack;     // Catch: Exception -> L21
        if (r112 != null) goto L14;
    L16:
        sAuthorizeCallBack = null;     // Catch: Exception -> L21
        return;
    L14:
        if (r112.get() == null) goto L16;
        AuthorizeMonitorUtil.onPlatformAuthEvent("weixin", 1, null, null, false, null);     // Catch: Exception -> L21
        sAuthorizeCallBack.get().onSuccess(r104);     // Catch: Exception -> L21
    L18:
        onAuthorizeFailed(Integer.MAX_VALUE, "invalid_response");
    }

    public static void setsAuthorizeCallBack(AuthorizeCallback r100) {
        sAuthorizeCallBack = new SoftReference(r100);
    }

    private static void onAuthorizeFailed(int r100, String r101) {
        SoftReference<AuthorizeCallback> r102 = sAuthorizeCallBack;
        if (r102 != null) goto L5;
    L10:
        sAuthorizeCallBack = null;
        return;
    L5:
        if (r102.get() == null) goto L10;
        AuthorizeErrorResponse r103 = new AuthorizeErrorResponse(r100, r101);
        if (r100 != (-2)) goto L9;
        r103.isCancel = true;
    L9:
        AuthorizeMonitorUtil.onPlatformAuthEvent("weixin", 0, r103.platformErrorCode, r103.platformErrorMsg, r103.isCancel, null);
        sAuthorizeCallBack.get().onError(r103);
        goto L10
    }

    public static boolean authorize(IWXAPI r100, String r101, String r102) {
        didCallback = false;
        if (r100 != null) goto L6;
        sAuthorizeCallBack = null;     // Catch: Exception -> L8
        return false;
    L6:
        SendAuth.Req r103 = new SendAuth.Req();     // Catch: Exception -> L8
        r103.scope = r101;     // Catch: Exception -> L8
        r103.state = r102;     // Catch: Exception -> L8
        return r100.sendReq(r103);
    L8:
        e = move-exception;
        sAuthorizeCallBack = null;
        e.printStackTrace();
        return false;
    }
}

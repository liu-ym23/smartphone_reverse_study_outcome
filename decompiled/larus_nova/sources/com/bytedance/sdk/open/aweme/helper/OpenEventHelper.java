package com.bytedance.sdk.open.aweme.helper;

import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.authorize.model.VerifyObject;
import com.bytedance.sdk.open.aweme.commonbase.OpenEvent;

/* JADX INFO: loaded from: classes22.dex */
public class OpenEventHelper {
    public OpenEventHelper() {
    }

    public static void mobApiAuth(Authorization.Request r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        OpenEvent.Builder r102 = new OpenEvent.Builder("dysdk_api_auth").kv("auth_host_type", r101).kv("scope", r100.scope).kv("scope_option", r100.optionalScope0).kv("scope_option_checked", r100.optionalScope1);
        VerifyObject r103 = r100.verifyObject;
        if (r103 == null) goto L7;
        r102.kv(IDouYin2Service.Extra.VERIFY_SCOPE, r103.verifyScope);
        r102.kv(IDouYin2Service.Extra.VERIFY_OPENID, r100.verifyObject.verifyOpenId);
        r102.kv(IDouYin2Service.Extra.VERIFY_TIC, r100.verifyObject.verifyTic);
    L7:
        r102.build().flush();
    }

    public static void mobApiInvoke(String r100) {
        new OpenEvent.Builder("dysdk_api_invoke").kv("api_name", r100).build().flush();
    }

    public static void mobApiInvoke(String r100, boolean r101) {
        OpenEvent.Builder r102 = new OpenEvent.Builder("dysdk_api_invoke").kv("api_name", r100);
        if (r101 == false) goto L5;
        String r103 = "1";
    L6:
        r102.kv("is_support", r103).build().flush();
        return;
    L5:
        r103 = "0";
        goto L6
    }

    public static void mobApiInvoke(String r100, boolean r101, int r102) {
        OpenEvent.Builder r103 = new OpenEvent.Builder("dysdk_api_invoke").kv("api_name", r100);
        if (r101 == false) goto L5;
        String r104 = "1";
    L6:
        r103.kv("is_support", r104).kv("common_type", Integer.valueOf(r102)).build().flush();
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public static void mobApiInvoke(String r100, boolean r101, int r102, int r103) {
        OpenEvent.Builder r104 = new OpenEvent.Builder("dysdk_api_invoke").kv("api_name", r100);
        if (r101 == false) goto L5;
        String r105 = "1";
    L6:
        r104.kv("is_support", r105).kv("ability", Integer.valueOf(r102)).kv("api", Integer.valueOf(r103)).build().flush();
        return;
    L5:
        r105 = "0";
        goto L6
    }

    public static void mobSdkCallHost(String r100, String r101) {
        new OpenEvent.Builder("dysdk_call_host").kv("host", r100).kv("api_type", r101).build().flush();
    }
}

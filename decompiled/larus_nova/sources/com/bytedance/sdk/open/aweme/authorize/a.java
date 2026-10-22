package com.bytedance.sdk.open.aweme.authorize;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.authorize.model.VerifyObject;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.core.OpenOptionService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.aweme.utils.Md5Utils;
import com.bytedance.sdk.open.aweme.utils.NetUtils;
import com.bytedance.sdk.open.aweme.utils.OpenUtils;
import com.bytedance.sdk.open.aweme.utils.SignatureUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class a {
    public a() {
    }

    private static String a() {
        if (OpenUtils.isExternal() == false) goto L5;
        return null;
    L5:
        OpenOptionService r100 = (OpenOptionService) OpenServiceManager.getInst().getService(OpenOptionService.class);
        if (r100 != null) goto L8;
        return null;
    L8:
        HashMap<String, String> r101 = r100.getCommonParams();
        if (r101 != null) goto L11;
    L20:
        return null;
    L11:
        if (r101.isEmpty() == true) goto L20;
        JSONObject r102 = new JSONObject();
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();     // Catch: Exception -> L21
    L16:
        if (r103.hasNext() == false) goto L18;
        Map.Entry<String, String> r104 = r103.next();     // Catch: Exception -> L21
        r102.putOpt(r104.getKey(), r104.getValue());     // Catch: Exception -> L21
        goto L16
    L18:
        return r102.toString();
    }

    public static String a(Context r110, Authorization.Request r111, String r112, String r113, String r114) {
        StringBuilder r100 = new StringBuilder();
        if (TextUtils.isEmpty(r111.optionalScope1) == true) goto L12;
        String[] r101 = r111.optionalScope1.split(",");
        int r102 = 0;
    L6:
        if (r102 >= r101.length) goto L12;
        if (r100.length() <= 0) goto L10;
        r100.append(",");
    L10:
        r100.append(r101[r102] + ",1");
        r102 = r102 + 1;
    L12:
        if (TextUtils.isEmpty(r111.optionalScope0) == true) goto L20;
        String[] r103 = r111.optionalScope0.split(",");
        int r104 = 0;
    L15:
        if (r104 >= r103.length) goto L20;
        if (r100.length() <= 0) goto L19;
        r100.append(",");
    L19:
        r100.append(r103[r104] + ",0");
        r104 = r104 + 1;
    L20:
        StringBuilder r105 = new StringBuilder();
        String r106 = r111.scope;
        if (r106 == null) goto L23;
        r105.append(r106);
    L23:
        VerifyObject r107 = r111.verifyObject;
        if (r107 != null) goto L26;
    L31:
        List<String> r108 = SignatureUtils.getMd5Signs(r110, r111.getCallerPackage());
        Bundle r109 = r111.extras;
        String r115 = "auth_login";
        String r116 = "";
        if (r109 == null) goto L34;
        String r117 = r109.getString(ParamKeyConstants.WebViewConstants.LIVE_ENTER_FROM_KEY, "");
        String r118 = r109.getString("enter_from", "auth_login");
    L36:
        if (TextUtils.isEmpty(r118) == true) goto L39;
        r115 = r118;
    L39:
        Uri.Builder r119 = new Uri.Builder().scheme(r112).authority(r113).path(r114).appendQueryParameter("response_type", "code").appendQueryParameter("redirect_uri", r111.redirectUri).appendQueryParameter("client_key", r111.getClientKey()).appendQueryParameter("state", r111.state).appendQueryParameter("from", ParamKeyConstants.WebViewConstants.VALUE_FROM_OPENSDK).appendQueryParameter("scope", r105.toString()).appendQueryParameter(ParamKeyConstants.WebViewConstants.QUERY_OPTIONAL_SCOPE, r100.toString()).appendQueryParameter("signature", SignatureUtils.packageSignature(r108)).appendQueryParameter(ParamKeyConstants.WebViewConstants.QUERY_ENCRIPTION_PACKAGE, Md5Utils.hexDigest(r111.getCallerPackage())).appendQueryParameter("device_platform", "android").appendQueryParameter(ParamKeyConstants.WebViewConstants.LIVE_ENTER_FROM_KEY, r117).appendQueryParameter("enter_from", r115).appendQueryParameter(ParamKeyConstants.WebViewConstants.IS_WIFI, String.valueOf(NetUtils.getNetWorkType(r110).getValue()));
        if (TextUtils.isEmpty(r111.commentId) == true) goto L43;
        r116 = r111.commentId;
    L43:
        Uri.Builder r120 = r119.appendQueryParameter("comment_id", r116);
        if (r111.isOtherAccountAuth == false) goto L46;
        String r121 = "1";
    L47:
        Uri.Builder r122 = r120.appendQueryParameter("is_other_account_auth", r121);
        String r123 = a();
        if (TextUtils.isEmpty(r123) == true) goto L50;
        r122.appendQueryParameter("common_params", r123);
    L50:
        LogUtils.i("WebViewHelper", new Object[]{r122.build().toString()});
        return r122.build().toString();
    L46:
        r121 = "2";
        goto L47
    L34:
        r118 = "auth_login";
        r117 = "";
        goto L36
    L26:
        if (r107.verifyScope == null) goto L31;
        if (r105.length() <= 0) goto L30;
        r105.append(',');
    L30:
        r105.append(r111.verifyObject.verifyScope);
        goto L31
    }
}

package com.huawei.hms.hwid;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.hwid.internal.ui.activity.HwIdSignInHubActivity;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.api.entity.hwid.HuaweiIdSignInRequest;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthAPIService;
import com.huawei.hms.utils.Util;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public final class x {
    public static void a() {
        y.a().c();
    }

    public static AuthHuaweiId b() {
        return y.a().b();
    }

    public static HuaweiIdAuthParams a(List<Scope> r100) {
        HuaweiIdAuthParamsHelper r101 = new HuaweiIdAuthParamsHelper();
        if (ap.b(r100).booleanValue() == false) goto L5;
        r101.setScopeList(r100);
    L5:
        Iterator<Scope> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        if (a(r102.next(), CommonConstant.SCOPE.SCOPE_ACCOUNT_SHIPPING_ADDRESS) == false) goto L7;
        r101.setShippingAddress();
        goto L7
    L12:
        return r101.createParams();
    }

    public static HuaweiIdAuthResult a(Intent r100) {
        as.b("[HUAWEIIDSDK]HuaweiIdAuthTool", "getSignInResultFromIntent", true);
        if (r100 != null) goto L5;
    L12:
        as.d("[HUAWEIIDSDK]HuaweiIdAuthTool", "data or signInResult is null", true);
        return null;
    L5:
        if (r100.hasExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID) == false) goto L12;
        String r101 = r100.getStringExtra(HuaweiIdAuthAPIService.EXTRA_AUTH_HUAWEI_ID);
        return new HuaweiIdAuthResult().fromJson(r101);
    L10:
        as.d("[HUAWEIIDSDK]HuaweiIdAuthTool", "JSONException", true);
        return null;
    }

    private static boolean a(Scope r100, String r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        return TextUtils.equals(r100.getScopeUri(), r101);
    }

    public static Intent a(Context r100, HuaweiIdAuthParams r101, String r110) {
        as.b("[HUAWEIIDSDK]HuaweiIdAuthTool", "getSignInIntent enter", true);
        Intent r102 = new Intent("com.huawei.hms.jos.signIn");
        r102.setPackage(r100.getPackageName());     // Catch: Exception -> L9
        r102.setClass(r100, HwIdSignInHubActivity.class);     // Catch: Exception -> L9
        String r103 = Util.getAppId(r100);     // Catch: Exception -> L9
        String r104 = r100.getPackageName();     // Catch: Exception -> L9
        s r105 = new s();     // Catch: Exception -> L9
        r105.b(r103);     // Catch: Exception -> L9
        r105.c(r104);     // Catch: Exception -> L9
        r105.a(61100301);     // Catch: Exception -> L9
        r105.d(r110);     // Catch: Exception -> L9
        HuaweiIdSignInRequest r106 = new HuaweiIdSignInRequest();     // Catch: Exception -> L9
        r106.setHuaweiIdAuthParams(r101);     // Catch: Exception -> L9
        r102.putExtra("HUAWEIID_CP_CLIENTINFO", r105.d());     // Catch: JSONException -> L6 Exception -> L9
        r102.putExtra("HUAWEIID_SIGNIN_REQUEST", r106.toJson());     // Catch: JSONException -> L6 Exception -> L9
    L11:
        return r102;
    L6:
        e = move-exception;
        as.d("[HUAWEIIDSDK]HuaweiIdAuthTool", "JSONException:".concat(e.getClass().getSimpleName()), true);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        as.d("[HUAWEIIDSDK]HuaweiIdAuthTool", "Exception:".concat(e.getClass().getSimpleName()), true);
        goto L11
    }
}

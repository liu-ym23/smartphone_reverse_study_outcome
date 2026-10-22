package com.bytedance.sdk.open.aweme.authorize;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.LogUtils;

/* JADX INFO: loaded from: classes22.dex */
public class AuthImpl {
    private static final String TAG = "AuthImpl";
    private final String mClientKey;

    public AuthImpl(String r100) {
        this.mClientKey = r100;
    }

    private String buildComponentClassName(String r100) {
        return "com.ss.android.ugc.aweme." + r100;
    }

    public boolean authorizeNative(Activity r100, Authorization.Request r101, String r102, String r110, String r111, String r112, String r113) {
        if (r100 != null) goto L7;
        LogUtils.w(TAG, new Object[]{"authorizeNative: activity is null"});
        return false;
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        LogUtils.w(TAG, new Object[]{"authorizeNative: packageName is " + r102});
        return false;
    L10:
        if (r101 != null) goto L14;
        LogUtils.w(TAG, new Object[]{"authorizeNative: req is null"});
        return false;
    L14:
        if (r101.checkArgs() == true) goto L17;
        LogUtils.w(TAG, new Object[]{"authorizeNative: checkArgs fail"});
        return false;
    L17:
        Bundle r103 = new Bundle();
        r101.toBundle(r103);
        r103.putString(ParamKeyConstants.AuthParams.CLIENT_KEY, this.mClientKey);
        r103.putString(ParamKeyConstants.BaseParams.CALLER_PKG, r100.getPackageName());
        if (TextUtils.isEmpty(r101.callerLocalEntry) == false) goto L20;
        r103.putString(ParamKeyConstants.BaseParams.FROM_ENTRY, AppUtil.buildComponentClassName(r100.getPackageName(), r111));
    L20:
        r103.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, r112);
        r103.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, r113);
        Intent r114 = new Intent();
        r114.setComponent(new ComponentName(r102, buildComponentClassName(r110)));
        r114.putExtras(r103);
        r100.startActivityForResult(r114, 100);     // Catch: Exception -> L33
        if (TextUtils.equals("com.ss.android.ugc.aweme", r102) == false) goto L25;
        String r104 = "douyin";
    L31:
        OpenEventHelper.mobApiAuth(r101, r104);     // Catch: Exception -> L33
        OpenEventHelper.mobSdkCallHost(r104, "auth");     // Catch: Exception -> L33
        return true;
    L25:
        if (TextUtils.equals("com.ss.android.ugc.aweme.lite", r102) == false) goto L28;
        r104 = "douyinLite";
        goto L31
    L28:
        if (TextUtils.equals("com.ss.android.ugc.live", r102) == false) goto L30;
        r104 = "dyhts";
        goto L31
    L30:
        r104 = "";
    L33:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{"authorizeNative: fail to startActivityForResult", e});
        return false;
    }

    public boolean authorizeWeb(Activity r100, Class<?> r101, Authorization.Request r102) {
        if (r100 != null) goto L6;
        LogUtils.w(TAG, new Object[]{"authorizeWeb: activity is null"});
        return false;
    L6:
        if (r102 != null) goto L10;
        LogUtils.w(TAG, new Object[]{"authorizeWeb: req is null"});
        return false;
    L10:
        if (r102.checkArgs() == true) goto L13;
        LogUtils.w(TAG, new Object[]{"authorizeWeb: checkArgs fail"});
        return false;
    L13:
        Bundle r103 = new Bundle();
        r102.toBundle(r103);
        r103.putString(ParamKeyConstants.AuthParams.CLIENT_KEY, this.mClientKey);
        r103.putString(ParamKeyConstants.BaseParams.CALLER_PKG, r100.getPackageName());
        Intent r104 = new Intent(r100, r101);
        r104.putExtras(r103);
        r104.addFlags(67108864);
        r100.startActivity(r104);     // Catch: Exception -> L16
        OpenEventHelper.mobApiAuth(r102, "H5");     // Catch: Exception -> L16
        return true;
    L16:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{"authorizeWeb: fail to startActivity", e});
        return false;
    }
}

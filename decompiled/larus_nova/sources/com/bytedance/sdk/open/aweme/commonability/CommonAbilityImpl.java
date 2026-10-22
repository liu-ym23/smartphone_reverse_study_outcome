package com.bytedance.sdk.open.aweme.commonability;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.utils.LogUtils;

/* JADX INFO: loaded from: classes22.dex */
public class CommonAbilityImpl {
    private static final String TAG = "CommonAbilityImpl";
    private final String mClientKey;
    private final Context mContext;

    public CommonAbilityImpl(Context r100, String r101) {
        this.mContext = r100;
        this.mClientKey = r101;
    }

    private String buildComponentClassName(String r100) {
        return "com.ss.android.ugc.aweme." + r100;
    }

    public boolean open(Activity r100, String r101, String r102, String r110, CommonAbility.Request r111, String r112, String r113) {
        if (r100 != null) goto L7;
        LogUtils.w(TAG, new Object[]{"share: activity is null"});
        return false;
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        LogUtils.w(TAG, new Object[]{"share: remotePackageName is " + r102});
        return false;
    L10:
        if (r111 != null) goto L14;
        LogUtils.w(TAG, new Object[]{"share: request is null"});
        return false;
    L14:
        if (r111.checkArgs() == true) goto L17;
        LogUtils.w(TAG, new Object[]{"share: checkArgs fail"});
        return false;
    L17:
        Bundle r103 = new Bundle();
        r111.toBundle(r103);
        r103.putString(ParamKeyConstants.CommonAbilityParam.CLIENT_KEY, this.mClientKey);
        r103.putString(ParamKeyConstants.CommonAbilityParam.CALLER_PKG, this.mContext.getPackageName());
        r103.putString(ParamKeyConstants.CommonAbilityParam.CALLER_SDK_VERSION, "1");
        r103.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, r112);
        r103.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, r113);
        if (TextUtils.isEmpty(r111.callerLocalEntry) == false) goto L20;
        r103.putString(ParamKeyConstants.BaseParams.FROM_ENTRY, this.mContext.getPackageName() + "." + r101);
    L20:
        Intent r104 = new Intent();
        r104.setComponent(new ComponentName(r102, buildComponentClassName(r110)));
        r104.putExtras(r103);
        r100.startActivityForResult(r104, 104);     // Catch: Exception -> L33
        if (TextUtils.equals("com.ss.android.ugc.aweme", r102) == false) goto L25;
        String r105 = "douyin";
    L31:
        OpenEventHelper.mobSdkCallHost(r105, "common");     // Catch: Exception -> L33
        return true;
    L25:
        if (TextUtils.equals("com.ss.android.ugc.aweme.lite", r102) == false) goto L28;
        r105 = "douyinLite";
        goto L31
    L28:
        if (TextUtils.equals("com.ss.android.ugc.live", r102) == false) goto L30;
        r105 = "dyhts";
        goto L31
    L30:
        r105 = "";
    L33:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{"fail to startActivity", e});
        return false;
    }
}

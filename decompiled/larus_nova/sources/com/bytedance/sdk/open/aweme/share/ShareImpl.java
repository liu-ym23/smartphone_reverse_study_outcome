package com.bytedance.sdk.open.aweme.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.LogUtils;

/* JADX INFO: loaded from: classes22.dex */
public class ShareImpl {
    private static final String TAG = "ShareImpl";
    private final String mClientKey;
    private final Context mContext;
    private IShareApplier shareApplier;

    public ShareImpl(Context r100, IShareApplier r101) {
        this(r100, r101.getClientKey());
        this.shareApplier = r101;
    }

    public ShareImpl(Context r100, String r101) {
        this.mContext = r100.getApplicationContext();
        this.mClientKey = r101;
    }

    private String buildComponentClassName(String r100, String r101) {
        IShareApplier r102 = this.shareApplier;
        if (r102 == null) goto L7;
        return r102.getComponentClassName();
    L7:
        return "com.ss.android.ugc.aweme." + r101;
    }

    public void requestToBundle(String r100, String r101, Share.Request r102, Bundle r103) {
        IShareApplier r104 = this.shareApplier;
        if (r104 == null) goto L7;
        r104.fillBundle(this.mContext, r102, r103);
        return;
    L7:
        if (AppUtil.getPlatformSDKVersion(this.mContext, r100, buildComponentClassName(r100, r101)) < 3) goto L10;
        r102.toBundle(r103);
        return;
    }

    public boolean share(Activity r100, String r101, String r102, String r103, Share.Request r110, String r111, String r112, String r113) {
        if (r100 != null) goto L7;
        LogUtils.w(TAG, new Object[]{"share: activity is null"});
        return false;
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        LogUtils.w(TAG, new Object[]{"share: remotePackageName is " + r102});
        return false;
    L10:
        if (r110 != null) goto L14;
        LogUtils.w(TAG, new Object[]{"share: request is null"});
        return false;
    L14:
        if (r110.checkArgs() == true) goto L17;
        LogUtils.w(TAG, new Object[]{"share: checkArgs fail"});
        return false;
    L17:
        Bundle r104 = new Bundle();
        requestToBundle(r102, r111, r110, r104);
        r104.putString(ParamKeyConstants.ShareParams.CLIENT_KEY, this.mClientKey);
        r104.putString(ParamKeyConstants.ShareParams.CALLER_PKG, this.mContext.getPackageName());
        r104.putString(ParamKeyConstants.ShareParams.CALLER_SDK_VERSION, "1");
        if (TextUtils.isEmpty(r110.callerLocalEntry) == false) goto L20;
        r104.putString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY, this.mContext.getPackageName() + "." + r101);
    L20:
        Bundle r105 = r110.extras;
        if (r105 == null) goto L23;
        r104.putBundle(ParamKeyConstants.BaseParams.EXTRA, r105);
    L23:
        r104.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, r112);
        r104.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, r113);
        Intent r106 = new Intent();
        r106.setComponent(new ComponentName(r102, buildComponentClassName(r102, r103)));
        r106.putExtras(r104);
        IShareApplier r107 = this.shareApplier;
        if (r107 == null) goto L26;
        r107.addIntentFlags(this.mContext, r106);
    L43:
        r100.startActivityForResult(r106, 103);     // Catch: Exception -> L40
        if (TextUtils.equals("com.ss.android.ugc.aweme", r102) == false) goto L32;
        String r108 = "douyin";
    L38:
        OpenEventHelper.mobSdkCallHost(r108, "share");     // Catch: Exception -> L40
        return true;
    L32:
        if (TextUtils.equals("com.ss.android.ugc.aweme.lite", r102) == false) goto L35;
        r108 = "douyinLite";
        goto L38
    L35:
        if (TextUtils.equals("com.ss.android.ugc.live", r102) == false) goto L37;
        r108 = "dyhts";
        goto L38
    L37:
        r108 = "";
    L40:
        e = move-exception;
        LogUtils.w(TAG, new Object[]{"fail to startActivity", e});
        return false;
    L26:
        r106.addFlags(67108864);
        goto L43
    }
}

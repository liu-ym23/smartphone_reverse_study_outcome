package com.bytedance.sdk.open.aweme.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.commonability.CommonAbility;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.SignatureUtils;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseCheckHelperImpl implements IAPPCheckHelper {
    public static String REMOTE_AUTH_ACTIVITY = "openauthorize.AwemeAuthorizedActivity";
    public static String REMOTE_COMMON_ABILITY_ACTIVITY = "openability.CommonAbilityActivity";
    public static String REMOTE_SHARE_ACTIVITY = "share.SystemShareActivity";
    public static String REMOTE_SHARE_CONTACTS_ACTIVITY = "openshare.ShareToContactsActivity";
    public static String REMOTE_SHARE_RECORD_ACTIVITY = "opensdk.OpenCameraActivity";
    protected Context mContext;

    public BaseCheckHelperImpl(Context r100) {
        this.mContext = r100.getApplicationContext();
    }

    private int getPlatformSDKVersion(String r100, String r101) {
        if (this.mContext != null) goto L5;
    L18:
        return -1;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L18;
        if (AppUtil.isAppInstalled(this.mContext, getPackageName()) == true) goto L19;
        return -1;
    L19:
        ComponentName r102 = new ComponentName(r100, buildComponentClassName(r100, r101));     // Catch: PackageManager.NameNotFoundException -> L16
        ActivityInfo r103 = this.mContext.getPackageManager().getActivityInfo(r102, 128);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r103 == null) goto L18;
        Bundle r104 = r103.metaData;     // Catch: PackageManager.NameNotFoundException -> L16
        if (r104 == null) goto L18;
        return r104.getInt(ParamKeyConstants.META_PLATFORM_SDK_VERSION, -1);
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    private boolean isAppSupportAuthApi() {
        return isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), getAuthRequestApi());
    }

    private boolean isAppSupportShareApi(String r100, String r101, int r102) {
        return isAppSupportAPI(r100, r101, r102);
    }

    public abstract boolean allowAuth();

    public abstract boolean allowShare();

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String buildComponentClassName(String r100, String r101) {
        return AppUtil.buildComponentClassName("com.ss.android.ugc.aweme", r101);
    }

    public abstract int getAuthRequestApi();

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getRemoteAuthEntryActivity() {
        return "openauthorize.AwemeAuthorizedActivity";
    }

    public String getSignature() {
        return "aea615ab910015038f73c47e45d21466";
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppInstalled() {
        return AppUtil.isAppInstalled(this.mContext, getPackageName());
    }

    public boolean isAppSupportAPI(String r100, String r101, int r102) {
        if (this.mContext != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        if (isAppInstalled() == true) goto L10;
        return false;
    L10:
        Intent r103 = new Intent();
        r103.setComponent(new ComponentName(r100, buildComponentClassName(r100, r101)));
        ActivityInfo r104 = r103.resolveActivityInfo(this.mContext.getPackageManager(), 65536);
        int r105 = getPlatformSDKVersion(r100, r101);
        if (r104 != null) goto L13;
        return false;
    L13:
        if (r104.exported == false) goto L19;
        if (r105 < r102) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppSupportAuthorization() {
        if (allowAuth() == true) goto L5;
    L11:
        return false;
    L5:
        if (isAppInstalled() == false) goto L11;
        if (isAppSupportAuthApi() == false) goto L11;
        if (SignatureUtils.validateSign(this.mContext, getPackageName(), getSignature()) == false) goto L11;
        return true;
    }

    public boolean isAppSupportMixShare() {
        if (allowShare() == true) goto L5;
    L9:
        return false;
    L5:
        if (isAppInstalled() == false) goto L9;
        if (isAppSupportAPI(getPackageName(), REMOTE_SHARE_ACTIVITY, 2) == false) goto L9;
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppSupportShare() {
        if (allowShare() == true) goto L5;
    L9:
        return false;
    L5:
        if (isAppInstalled() == false) goto L9;
        if (isAppSupportShareApi(getPackageName(), getRemoteAuthEntryActivity(), 3) == false) goto L9;
        return true;
    }

    public boolean isAppSupportShareToImageAlbum() {
        if (allowShare() == true) goto L5;
    L9:
        return false;
    L5:
        if (isAppInstalled() == false) goto L9;
        if (isAppSupportAPI(getPackageName(), REMOTE_SHARE_ACTIVITY, 2) == false) goto L9;
        return true;
    }

    public boolean isShareSupportFileProvider() {
        return isSupportApi(2, 10007);
    }

    public boolean isSupportApi(int r100, int r101) {
        if (r100 == 1) goto L55;
        if (r100 == 2) goto L32;
        if (r100 == 3) goto L26;
        if (r100 == 4) goto L20;
        if (r100 == 5) goto L14;
        return false;
    L14:
        if (isAppInstalled() == true) goto L16;
        return false;
    L16:
        if (isAppSupportAPI(getPackageName(), REMOTE_COMMON_ABILITY_ACTIVITY, r101) == false) goto L65;
        return true;
    L65:
        return false;
    L20:
        if (isAppInstalled() == true) goto L22;
        return false;
    L22:
        if (isAppSupportAPI(getPackageName(), REMOTE_SHARE_RECORD_ACTIVITY, r101) == false) goto L67;
        return true;
    L67:
        return false;
    L26:
        if (isAppInstalled() == true) goto L28;
        return false;
    L28:
        if (isAppSupportAPI(getPackageName(), REMOTE_SHARE_CONTACTS_ACTIVITY, r101) == false) goto L69;
        return true;
    L69:
        return false;
    L32:
        if (r101 == 10003) goto L47;
        if (r101 == 10007) goto L47;
        if (r101 == 10008) goto L47;
        if (allowShare() == true) goto L41;
        return false;
    L41:
        if (isAppInstalled() == true) goto L43;
        return false;
    L43:
        if (isAppSupportAPI(getPackageName(), REMOTE_SHARE_ACTIVITY, r101) == false) goto L72;
        return true;
    L72:
        return false;
    L47:
        if (allowShare() == true) goto L49;
        return false;
    L49:
        if (isAppInstalled() == true) goto L51;
        return false;
    L51:
        if (isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), r101 - 10000) == false) goto L75;
        return true;
    L75:
        return false;
    L55:
        if (allowAuth() == true) goto L57;
        return false;
    L57:
        if (isAppInstalled() == true) goto L59;
        return false;
    L59:
        if (isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), r101) == true) goto L61;
        return false;
    L61:
        if (validateSign() == false) goto L79;
        return true;
    L79:
        return false;
    }

    public boolean isSupportAuthSwitchAccount() {
        if (isAppInstalled() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), 9) == false) goto L7;
        return true;
    }

    public boolean isSupportCommonAbility(int r100) {
        int r101 = CommonAbility.supportApi(r100);
        if (isAppInstalled() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAppSupportAPI(getPackageName(), REMOTE_COMMON_ABILITY_ACTIVITY, r101) == false) goto L7;
        return true;
    }

    public boolean isSupportOpenRecordPage() {
        if (isAppInstalled() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAppSupportAPI(getPackageName(), REMOTE_SHARE_RECORD_ACTIVITY, 1) == false) goto L7;
        return true;
    }

    public boolean isSupportShareCardToContact() {
        if (isAppInstalled() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAppSupportAPI(getPackageName(), REMOTE_SHARE_CONTACTS_ACTIVITY, 2) == false) goto L7;
        return true;
    }

    public boolean isSupportShareLunaMusic() {
        return isSupportApi(2, 3);
    }

    public boolean isSupportShareToContact() {
        if (isAppInstalled() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAppSupportAPI(getPackageName(), REMOTE_SHARE_CONTACTS_ACTIVITY, 1) == false) goto L7;
        return true;
    }

    public boolean isSupportShareToPublish() {
        if (allowShare() == true) goto L5;
    L9:
        return false;
    L5:
        if (isAppInstalled() == false) goto L9;
        if (isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), 8) == false) goto L9;
        return true;
    }

    public boolean isSupportUnifiedJoinGroup() {
        if (isAppInstalled() == true) goto L5;
    L7:
        return false;
    L5:
        if (isAppSupportAPI(getPackageName(), REMOTE_SHARE_CONTACTS_ACTIVITY, 3) == false) goto L7;
        return true;
    }

    public boolean isSupportVerify() {
        return isSupportApi(1, 6);
    }

    public boolean validateSign() {
        return SignatureUtils.validateSign(this.mContext, getPackageName(), getSignature());
    }
}

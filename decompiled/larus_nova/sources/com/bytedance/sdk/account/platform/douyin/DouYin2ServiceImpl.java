package com.bytedance.sdk.account.platform.douyin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.a;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;

/* JADX INFO: loaded from: classes3.dex */
public class DouYin2ServiceImpl implements IDouYin2Service {
    private static final int AUTH_BIND_MOBILE_API_VERSION = 4;
    private static final String ENTRY_ACTIVITY = "com.ss.android.ugc.aweme.openauthorize.AwemeAuthorizedActivity";
    private static final String META_PLATFORM_SDK_VERSION = "BD_PLATFORM_SDK_VERSION";
    private static final String PACKAGE_NAME_DOUYIN = "com.ss.android.ugc.aweme";
    private static final String PACKAGE_NAME_DOUYIN_LITE = "com.ss.android.ugc.aweme.lite";
    private String mClientKey;

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public void onDestroy() {
        Douyin.reset();
    }

    public DouYin2ServiceImpl(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.mClientKey = r100;
        a.init(new DouYinOpenConfig(r100));
        return;
    }

    private DouYinOpenApi getDouYinLiteOpenApi(Activity r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return DouYinOpenApiFactory.createDouYinLite(r100, new DouYinOpenConfig(this.mClientKey));
    }

    private DouYinOpenApi getDouYinOpenApi(Activity r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return a.create(r100);
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public String getSdkVersion(Activity r100) {
        DouYinOpenApi r101 = getDouYinOpenApi(r100);
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getSdkVersion();
    }

    private int getPlatformSDKVersion(Activity r100, ComponentName r101) {
        ActivityInfo r102 = r100.getPackageManager().getActivityInfo(r101, 128);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r102 == null) goto L11;
        Bundle r103 = r102.metaData;     // Catch: PackageManager.NameNotFoundException -> L9
        if (r103 == null) goto L11;
        return r103.getInt("BD_PLATFORM_SDK_VERSION", -1);
    L11:
        return -1;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean isAppInstalled(Activity r100, boolean r101) {
        if (r101 == false) goto L4;
        DouYinOpenApi r102 = getDouYinLiteOpenApi(r100);
    L5:
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.isAppInstalled();
    L4:
        r102 = getDouYinOpenApi(r100);
        goto L5
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean isAppSupportAuthBindMobile(Activity r100, boolean r101) {
        if (r101 == true) goto L5;
        boolean r102 = isSupportAuthBindMobile(r100, "com.ss.android.ugc.aweme", ENTRY_ACTIVITY, 4);
    L6:
        if (r102 == false) goto L8;
        return r102;
    L8:
        return isSupportAuthBindMobile(r100, "com.ss.android.ugc.aweme.lite", ENTRY_ACTIVITY, 4);
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean isAppSupportAuthorization(Activity r100, boolean r101) {
        if (r101 == false) goto L4;
        DouYinOpenApi r102 = getDouYinLiteOpenApi(r100);
    L5:
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.isAppSupportAuthorization();
    L4:
        r102 = getDouYinOpenApi(r100);
        goto L5
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean isAppSupportSwitchAccount(Activity r100, boolean r101) {
        if (r101 == false) goto L4;
        DouYinOpenApi r102 = getDouYinLiteOpenApi(r100);
    L5:
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.isSupportSwitchAccount();
    L4:
        r102 = getDouYinOpenApi(r100);
        goto L5
    }

    private boolean authorizeInThirdApp(Activity r100, Request r101, AuthorizeCallback r102) {
        DouYinOpenApi r103 = getDouYinOpenApi(r100);
        if (r103 != null) goto L5;
        return false;
    L5:
        return Douyin.authorizeInThirdApp(r103, r101, r102);
    }

    private boolean authorizeWeb(Activity r100, Request r101, AuthorizeCallback r102) {
        DouYinOpenApi r103 = getDouYinOpenApi(r100);     // Catch: Exception -> L6
        if (r103 == null) goto L12;
        return Douyin.authorizeWeb(r103, r101, r102);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private boolean authorizeWithSwitchAccount(DouYinOpenApi r100, Request r101, AuthorizeCallback r102) {
        if (r100 == null) goto L14;
    L9:
        e = move-exception;
        e.printStackTrace();
        return false;
    L4:
        if (r100.isSupportSwitchAccount() == false) goto L8;
        r101.extra.putBoolean(ParamKeyConstants.AuthParams.EXTRA_AUTH_NOT_SKIP_CONFIRM, true);     // Catch: Exception -> L9
        return Douyin.authorize(r100, r101, r102);
    L8:
        return Douyin.authorizeWeb(r100, r101, r102);
    L14:
        return false;
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public boolean authorize(Activity r100, Request r101, AuthorizeCallback r102) {
        int r103 = r101.authType;
        if (r103 == 1) goto L18;
        if (r103 == 2) goto L23;
        if (r103 == 3) goto L22;
        if (r103 == 4) goto L21;
        if (r103 == 5) goto L20;
        return authorize(getDouYinOpenApi(r100), r101, r102);
    L20:
        return authorizeInThirdApp(r100, r101, r102);
    L21:
        return authorizeWeb(r100, r101, r102);
    L22:
        return authorizeWithSwitchAccount(getDouYinLiteOpenApi(r100), r101, r102);
    L23:
        return authorize(getDouYinLiteOpenApi(r100), r101, r102);
    L18:
        return authorizeWithSwitchAccount(getDouYinOpenApi(r100), r101, r102);
    }

    @Override // com.bytedance.sdk.account.platform.api.IDouYin2Service
    public void onActivityResult(int r100, int r101, Intent r102) {
        if (Douyin.didCallback == true) goto L6;
        Authorization.Response r103 = new Authorization.Response();
        r103.errorCode = -2;
        Douyin.authorizeCallback(r103);
        return;
    }

    private boolean authorize(DouYinOpenApi r100, Request r101, AuthorizeCallback r102) {
        if (r100 != null) goto L4;
        return false;
    L4:
        return Douyin.authorize(r100, r101, r102);
    }

    private boolean isSupportAuthBindMobile(Activity r100, String r101, String r102, int r103) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L17;
        Intent r104 = new Intent();     // Catch: Exception -> L13
        ComponentName r105 = new ComponentName(r101, r102);     // Catch: Exception -> L13
        r104.setComponent(r105);     // Catch: Exception -> L13
        ActivityInfo r106 = r104.resolveActivityInfo(r100.getPackageManager(), 65536);     // Catch: Exception -> L13
        int r107 = getPlatformSDKVersion(r100, r105);     // Catch: Exception -> L13
        if (r106 == null) goto L18;
        if (r106.exported == false) goto L19;
        if (r107 < r103) goto L20;
        return true;
    L20:
        return false;
    L19:
        return false;
    L18:
        return false;
    L21:
        return false;
    L17:
        return false;
    }
}

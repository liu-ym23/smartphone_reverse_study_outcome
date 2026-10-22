package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;

/* JADX INFO: loaded from: classes22.dex */
public class DouYinCheckHelperImpl extends BaseCheckHelperImpl {
    public DouYinCheckHelperImpl(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowAuth() {
        return com.bytedance.sdk.open.douyin.settings.a.a(com.bytedance.sdk.open.douyin.settings.a.c.f269680a, com.bytedance.sdk.open.douyin.settings.a.b.f269676a);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowShare() {
        return com.bytedance.sdk.open.douyin.settings.a.a(com.bytedance.sdk.open.douyin.settings.a.c.f269681b, com.bytedance.sdk.open.douyin.settings.a.b.f269676a);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public int getAuthRequestApi() {
        return 1;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getPackageName() {
        return "com.ss.android.ugc.aweme";
    }

    public int getVerifyRequestApi() {
        return 6;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isShareSupportFileProvider() {
        if (allowShare() == true) goto L5;
    L9:
        return false;
    L5:
        if (isAppInstalled() == false) goto L9;
        if (isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), 7) == false) goto L9;
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isSupportShareLunaMusic() {
        if (allowShare() == true) goto L5;
    L9:
        return false;
    L5:
        if (isAppInstalled() == false) goto L9;
        if (isAppSupportAPI(getPackageName(), BaseCheckHelperImpl.REMOTE_SHARE_ACTIVITY, 3) == false) goto L9;
        return true;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isSupportVerify() {
        if (allowAuth() == true) goto L5;
    L11:
        return false;
    L5:
        if (isAppInstalled() == false) goto L11;
        if (isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), getVerifyRequestApi()) == false) goto L11;
        if (validateSign() == false) goto L11;
        return true;
    }
}

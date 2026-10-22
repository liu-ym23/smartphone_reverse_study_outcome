package com.bytedance.sdk.open.douyin.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;

/* JADX INFO: loaded from: classes22.dex */
public class e extends BaseCheckHelperImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f269656b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f269657a;

    static {
        f269656b = new String[]{"com.ss.android.ugc.aweme.share.SystemShareActivity", "com.ss.android.ugc.aweme.opensdk.share.SystemShareActivity"};
    }

    public e(Context r100, g r101) {
        super(r100);
        this.f269657a = r101;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowAuth() {
        return com.bytedance.sdk.open.douyin.settings.a.a(com.bytedance.sdk.open.douyin.settings.a.c.f269680a, com.bytedance.sdk.open.douyin.settings.a.b.f269677b);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowShare() {
        return com.bytedance.sdk.open.douyin.settings.a.a(com.bytedance.sdk.open.douyin.settings.a.c.f269681b, com.bytedance.sdk.open.douyin.settings.a.b.f269677b);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public int getAuthRequestApi() {
        return 10;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getPackageName() {
        return "com.ss.android.ugc.aweme.lite";
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl, com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppSupportShare() {
        if (allowShare() == true) goto L6;
        return false;
    L6:
        if (isAppInstalled() == true) goto L9;
        return false;
    L9:
        if (this.mContext != null) goto L11;
        return false;
    L11:
        String[] r100 = f269656b;
        int r101 = r100.length;
        int r102 = 0;
    L12:
        if (r102 >= r101) goto L20;
        String r103 = r100[r102];
        Intent r104 = new Intent();
        r104.setComponent(new ComponentName(this.f269657a.getPackageName(), r103));
        ActivityInfo r105 = r104.resolveActivityInfo(this.mContext.getPackageManager(), 65536);
        if (r105 == null) goto L19;
        if (r105.exported == false) goto L19;
        this.f269657a.a(r103);
        return true;
    L19:
        r102 = r102 + 1;
        goto L12
    L20:
        return false;
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean isSupportAuthSwitchAccount() {
        if (isAppSupportAuthorization() == true) goto L5;
    L7:
        return false;
    L5:
        if (super.isSupportAuthSwitchAccount() == false) goto L7;
        return true;
    }
}

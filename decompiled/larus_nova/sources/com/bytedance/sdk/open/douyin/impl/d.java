package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;

/* JADX INFO: loaded from: classes22.dex */
public class d extends BaseCheckHelperImpl {
    public d(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowAuth() {
        return com.bytedance.sdk.open.douyin.settings.a.a(com.bytedance.sdk.open.douyin.settings.a.c.f269680a, com.bytedance.sdk.open.douyin.settings.a.b.f269678c);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public boolean allowShare() {
        return com.bytedance.sdk.open.douyin.settings.a.a(com.bytedance.sdk.open.douyin.settings.a.c.f269681b, com.bytedance.sdk.open.douyin.settings.a.b.f269678c);
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public int getAuthRequestApi() {
        return Integer.MAX_VALUE;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getPackageName() {
        return "com.ss.android.ugc.live";
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

package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.sdk.open.aweme.share.IShareApplier;
import com.bytedance.sdk.open.aweme.share.Share;

/* JADX INFO: loaded from: classes22.dex */
public class g implements IShareApplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f269670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f269671b;

    public g(String r100) {
        this.f269671b = null;
        this.f269670a = r100;
    }

    public void a(String r100) {
        this.f269671b = r100;
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public void addIntentFlags(Context r100, Intent r101) {
        r101.addFlags(67108864);
        r101.addFlags(268435456);
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public void fillBundle(Context r100, Share.Request r101, Bundle r102) {
        r101.toBundle(r102);
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public String getClientKey() {
        return this.f269670a;
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public String getComponentClassName() {
        String r100 = this.f269671b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return "com.ss.android.ugc.aweme.share.SystemShareActivity";
    }

    @Override // com.bytedance.sdk.open.aweme.share.IShareApplier
    public String getPackageName() {
        return "com.ss.android.ugc.aweme.lite";
    }
}

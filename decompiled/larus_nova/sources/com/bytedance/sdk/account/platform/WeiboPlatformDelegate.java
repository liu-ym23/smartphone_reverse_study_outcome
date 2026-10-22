package com.bytedance.sdk.account.platform;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public class WeiboPlatformDelegate extends f {
    private String accessToken;
    private Long expiresIn;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String refreshToken;
    private String uid;

    /* JADX INFO: loaded from: classes3.dex */
    public static class Factory implements f.a {
        public Factory() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createBind(PlatformBindAdapter r100) {
            return new WeiboPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createLogin(PlatformLoginAdapter r100) {
            return new WeiboPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createProfile(PlatformProfileAdapter r100) {
            return new WeiboPlatformDelegate(r100);
        }
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void cancelBind() {
        PlatformBindAdapter.a r100 = this.mBindCallback;
        if (r100 == null) goto L5;
        r100.cancel();
        this.mBindCallback = null;
    L5:
        this.bindDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void cancelLogin() {
        PlatformLoginAdapter.LoginCallback r100 = this.mLoginCallback;
        if (r100 == null) goto L5;
        r100.cancel();
        this.mLoginCallback = null;
    L5:
        this.loginDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void cancelProfile() {
        PlatformProfileAdapter.ProfileCallback r100 = this.mProfileCallback;
        if (r100 == null) goto L5;
        r100.cancel();
        this.mProfileCallback = null;
    L5:
        this.profileAdapter = null;
    }

    public WeiboPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
    }

    private void parseData(Bundle r100) {
        this.accessToken = r100.getString("access_token");
        this.expiresIn = Long.valueOf(r100.getLong("expires_in"));
        this.uid = r100.getString("uid");
        this.refreshToken = r100.getString("refresh_token");
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestBind(Bundle r100) {
        if (this.bindDelegate == null) goto L6;
        parseData(r100);
        PlatformBindAdapter r101 = this.bindDelegate;
        r101.getClass();
        this.mBindCallback = new PlatformBindAdapter.a(r101);
        PlatformBindAdapter r102 = this.bindDelegate;
        r102.api.f(r102.platformId, r102.platform, this.accessToken, this.expiresIn.longValue(), this.bindDelegate.mExtendParam, this.mBindCallback);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestLogin(Bundle r100) {
        if (this.loginDelegate == null) goto L6;
        parseData(r100);
        PlatformLoginAdapter r101 = this.loginDelegate;
        r101.getClass();
        this.mLoginCallback = new PlatformLoginAdapter.LoginCallback(r101);
        PlatformLoginAdapter r102 = this.loginDelegate;
        r102.api.j(r102.platformId, r102.platform, this.accessToken, this.expiresIn.longValue(), this.loginDelegate.mExtendParam, this.mLoginCallback);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestProfile(Bundle r100) {
        if (this.profileAdapter == null) goto L6;
        parseData(r100);
        PlatformProfileAdapter r101 = this.profileAdapter;
        r101.api.a(r101.platformId, r101.platform, this.accessToken, this.expiresIn.longValue(), this.profileAdapter.mExtendParam, this.mProfileCallback);
        return;
    }

    public WeiboPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
    }

    public WeiboPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
    }
}

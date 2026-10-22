package com.bytedance.sdk.account.platform;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public class TouTiaoPlatformDelegate extends f {
    private String authCode;
    private String grantedPermission;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String state;

    /* JADX INFO: loaded from: classes3.dex */
    public static class Factory implements f.a {
        public Factory() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createBind(PlatformBindAdapter r100) {
            return new TouTiaoPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createLogin(PlatformLoginAdapter r100) {
            return new TouTiaoPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createProfile(PlatformProfileAdapter r100) {
            return new TouTiaoPlatformDelegate(r100);
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

    public TouTiaoPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
    }

    private void parseData(Bundle r100) {
        this.authCode = r100.getString("auth_code");
        this.state = r100.getString("state");
        this.grantedPermission = r100.getString("grantedPermissions");
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestBind(Bundle r100) {
        if (this.bindDelegate == null) goto L6;
        parseData(r100);
        PlatformBindAdapter r101 = this.bindDelegate;
        r101.getClass();
        PlatformBindAdapter.a r102 = new PlatformBindAdapter.a(r101);
        this.mBindCallback = r102;
        PlatformBindAdapter r103 = this.bindDelegate;
        r103.api.b(r103.platformId, r103.platform, this.authCode, r103.mExtendParam, r102);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestLogin(Bundle r100) {
        if (this.loginDelegate == null) goto L9;
        parseData(r100);
        PlatformLoginAdapter r101 = this.loginDelegate;
        r101.getClass();
        PlatformLoginAdapter.LoginCallback r102 = new PlatformLoginAdapter.LoginCallback(r101);
        this.mLoginCallback = r102;
        PlatformLoginAdapter r103 = this.loginDelegate;
        if (r103.isShareLogin == false) goto L7;
        r103.api.e(this.authCode, r103.platformId, r103.platform, r103.mExtendParam, r102);
        return;
    L7:
        r103.api.c(r103.platformId, r103.platform, this.authCode, r103.mExtendParam, r102);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestProfile(Bundle r100) {
        if (this.profileAdapter == null) goto L6;
        parseData(r100);
        PlatformProfileAdapter r101 = this.profileAdapter;
        r101.api.l(r101.platformId, r101.platform, this.authCode, r101.mExtendParam, this.mProfileCallback);
        return;
    }

    public TouTiaoPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
    }

    public TouTiaoPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
    }
}

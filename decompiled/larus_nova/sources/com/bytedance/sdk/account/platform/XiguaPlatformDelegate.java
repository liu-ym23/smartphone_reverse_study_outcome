package com.bytedance.sdk.account.platform;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public class XiguaPlatformDelegate extends f {
    String authCode;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;

    /* JADX INFO: loaded from: classes3.dex */
    public static class Factory implements f.a {
        public Factory() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createBind(PlatformBindAdapter r100) {
            return new XiguaPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createLogin(PlatformLoginAdapter r100) {
            return new XiguaPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createProfile(PlatformProfileAdapter r100) {
            return new XiguaPlatformDelegate(r100);
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

    public XiguaPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
    }

    private void parseData(Bundle r100) {
        this.authCode = r100.getString("auth_code");
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
        r103.api.b(r103.platformId, null, this.authCode, r103.mExtendParam, r102);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestLogin(Bundle r100) {
        if (this.loginDelegate == null) goto L6;
        parseData(r100);
        PlatformLoginAdapter r101 = this.loginDelegate;
        r101.getClass();
        PlatformLoginAdapter.LoginCallback r102 = new PlatformLoginAdapter.LoginCallback(r101);
        this.mLoginCallback = r102;
        PlatformLoginAdapter r103 = this.loginDelegate;
        r103.api.c(r103.platformId, null, this.authCode, r103.mExtendParam, r102);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestProfile(Bundle r100) {
        if (this.profileAdapter == null) goto L6;
        parseData(r100);
        PlatformProfileAdapter r101 = this.profileAdapter;
        r101.getClass();
        PlatformProfileAdapter.ProfileCallback r102 = new PlatformProfileAdapter.ProfileCallback(r101);
        this.mProfileCallback = r102;
        PlatformProfileAdapter r103 = this.profileAdapter;
        r103.api.l(r103.platformId, null, this.authCode, r103.mExtendParam, r102);
        return;
    }

    public XiguaPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
    }

    public XiguaPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
    }
}

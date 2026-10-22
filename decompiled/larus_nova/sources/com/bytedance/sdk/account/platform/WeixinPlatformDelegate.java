package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public class WeixinPlatformDelegate extends f {
    private String authCode;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String openId;
    private String state;
    private String url;

    /* JADX INFO: loaded from: classes3.dex */
    public static class Factory implements f.a {
        public Factory() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createBind(PlatformBindAdapter r100) {
            return new WeixinPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createLogin(PlatformLoginAdapter r100) {
            return new WeixinPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createProfile(PlatformProfileAdapter r100) {
            return new WeixinPlatformDelegate(r100);
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

    public WeixinPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
    }

    private void parseData(Bundle r100) {
        this.authCode = r100.getString("auth_code");
        this.state = r100.getString("state");
        this.url = r100.getString("url");
        this.openId = r100.getString("openId");
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestBind(Bundle r100) {
        if (this.bindDelegate == null) goto L9;
        parseData(r100);
        PlatformBindAdapter r101 = this.bindDelegate;
        r101.getClass();
        PlatformBindAdapter.a r102 = new PlatformBindAdapter.a(r101);
        this.mBindCallback = r102;
        PlatformBindAdapter r103 = this.bindDelegate;
        if (r103.isBindPlatformAndThirdMobileMode == false) goto L7;
        r103.api.o(r103.platformId, "weixin", this.authCode, r103.mExtendParam, r102);
        return;
    L7:
        r103.api.b(r103.platformId, "weixin", this.authCode, r103.mExtendParam, r102);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestLogin(Bundle r100) {
        if (this.loginDelegate == null) goto L15;
        parseData(r100);
        PlatformLoginAdapter r101 = this.loginDelegate;
        r101.getClass();
        PlatformLoginAdapter.LoginCallback r102 = new PlatformLoginAdapter.LoginCallback(r101);
        this.mLoginCallback = r102;
        PlatformLoginAdapter r103 = this.loginDelegate;
        if (r103.isLoginAndBindThirdMobileMode == true) goto L7;
        r103.api.c(r103.platformId, "weixin", this.authCode, r103.mExtendParam, r102);
        return;
    L7:
        if (r103.isLoginNeedBindMobile == true) goto L9;
    L12:
        PlatformLoginAdapter r104 = this.loginDelegate;
        r104.api.h(r104.platformId, "weixin", this.authCode, r104.isRegisterNeedThirdMobile, r104.isChangeBind, r104.mExtendParam, this.mLoginCallback);
        return;
    L9:
        if (r103.mExtendParam != null) goto L11;
        r103.mExtendParam = new HashMap();
    L11:
        this.loginDelegate.mExtendParam.put("check_mobile", "1");
        goto L12
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
        r103.api.l(r103.platformId, r103.platform, this.authCode, r103.mExtendParam, r102);
        return;
    }

    public WeixinPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
    }

    public WeixinPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
    }
}

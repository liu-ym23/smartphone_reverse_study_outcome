package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public class DouyinPlatformDelegate extends f {
    private String authCode;
    private boolean isBindThirdMobile;
    private boolean isChangeBind;
    private boolean isLoginNeedBindMobile;
    private boolean isRegisterNeedThirdMobile;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;

    /* JADX INFO: loaded from: classes3.dex */
    public static class Factory implements f.a {
        public Factory() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createBind(PlatformBindAdapter r100) {
            return new DouyinPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createLogin(PlatformLoginAdapter r100) {
            return new DouyinPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createProfile(PlatformProfileAdapter r100) {
            return new DouyinPlatformDelegate(r100);
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

    public DouyinPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
        this.isBindThirdMobile = r100.isLoginAndBindThirdMobileMode;
        this.isRegisterNeedThirdMobile = r100.isRegisterNeedThirdMobile;
        this.isLoginNeedBindMobile = r100.isLoginNeedBindMobile;
        this.isChangeBind = r100.isChangeBind;
    }

    private void parseData(Bundle r100) {
        this.authCode = r100.getString("auth_code");
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestBind(Bundle r100) {
        if (this.bindDelegate == null) goto L9;
        parseData(r100);
        PlatformBindAdapter r101 = this.bindDelegate;
        r101.getClass();
        PlatformBindAdapter.a r102 = new PlatformBindAdapter.a(r101);
        this.mBindCallback = r102;
        if (this.isBindThirdMobile == false) goto L7;
        PlatformBindAdapter r103 = this.bindDelegate;
        r103.api.o(r103.platformId, r103.platform, this.authCode, r103.mExtendParam, r102);
        return;
    L7:
        PlatformBindAdapter r104 = this.bindDelegate;
        r104.api.b(r104.platformId, r104.platform, this.authCode, r104.mExtendParam, r102);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestLogin(Bundle r100) {
        if (this.loginDelegate == null) goto L18;
        parseData(r100);
        PlatformLoginAdapter r101 = this.loginDelegate;
        r101.getClass();
        PlatformLoginAdapter.LoginCallback r102 = new PlatformLoginAdapter.LoginCallback(r101);
        this.mLoginCallback = r102;
        PlatformLoginAdapter r103 = this.loginDelegate;
        if (r103.isShareLogin == false) goto L8;
        r103.api.e(this.authCode, r103.platformId, r103.platform, r103.mExtendParam, r102);
        return;
    L8:
        if (this.isBindThirdMobile == true) goto L10;
        r103.api.c(r103.platformId, r103.platform, this.authCode, r103.mExtendParam, r102);
        return;
    L10:
        if (this.isLoginNeedBindMobile == true) goto L12;
    L15:
        PlatformLoginAdapter r104 = this.loginDelegate;
        r104.api.h(r104.platformId, r104.platform, this.authCode, this.isRegisterNeedThirdMobile, this.isChangeBind, r104.mExtendParam, this.mLoginCallback);
        return;
    L12:
        if (r103.mExtendParam != null) goto L14;
        r103.mExtendParam = new HashMap();
    L14:
        this.loginDelegate.mExtendParam.put("check_mobile", "1");
        goto L15
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

    public DouyinPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
        this.isBindThirdMobile = r100.isBindPlatformAndThirdMobileMode;
    }

    public DouyinPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
    }
}

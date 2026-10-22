package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.sdk.account.platform.api.ITiktokService;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class TiktokPlatformDelegate extends f {
    private String authCode;
    private String codeVerifier;
    private Bundle extras;
    private String grantedFields;
    private String grantedPermission;
    private boolean isBindMobileApi;
    private boolean isChangeBind;
    private boolean isNeedMobile;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String redirectUrl;
    private String state;
    private String ttopVersion;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements f.a {
        public a() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createBind(PlatformBindAdapter r100) {
            return new TiktokPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createLogin(PlatformLoginAdapter r100) {
            return new TiktokPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createProfile(PlatformProfileAdapter r100) {
            return new TiktokPlatformDelegate(r100);
        }
    }

    private Map<String, String> getCommonRequestParams() {
        HashMap r100 = new HashMap();
        if (TextUtils.isEmpty(this.ttopVersion) == true) goto L6;
        r100.put("ttop_v", this.ttopVersion);
    L6:
        if (TextUtils.isEmpty(this.redirectUrl) == true) goto L9;
        r100.put("redirect_uri", this.redirectUrl);
    L9:
        if (TextUtils.isEmpty(this.codeVerifier) == true) goto L12;
        r100.put(ITiktokService.ResponseConstants.CODE_VERIFIER, this.codeVerifier);
    L12:
        if (TextUtils.isEmpty(this.grantedFields) == true) goto L14;
        r100.put(SlcCommonAction.KEY_PARAMS, this.grantedFields);
    L14:
        return r100;
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

    public TiktokPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
        this.isBindMobileApi = r100.isLoginAndBindThirdMobileMode;
        this.isNeedMobile = r100.isRegisterNeedThirdMobile;
        this.isChangeBind = r100.isChangeBind;
    }

    private void parseData(Bundle r100) {
        this.authCode = r100.getString("auth_code");
        this.state = r100.getString("state");
        this.grantedPermission = r100.getString("granted_permission");
        this.grantedFields = r100.getString(ITiktokService.ResponseConstants.GRANTED_FIELDS);
        this.extras = r100.getBundle("extras");
        this.ttopVersion = r100.getString(ITiktokService.ResponseConstants.TTOP_VERSION);
        this.codeVerifier = r100.getString(ITiktokService.ResponseConstants.CODE_VERIFIER);
        this.redirectUrl = r100.getString(ITiktokService.ResponseConstants.REDIRECT_URL);
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestBind(Bundle r100) {
        if (this.bindDelegate == null) goto L12;
        parseData(r100);
        Map<String, String> r101 = getCommonRequestParams();
        Map<String, String> r102 = this.bindDelegate.mExtendParam;
        if (r102 == null) goto L7;
        r101.putAll(r102);
    L7:
        PlatformBindAdapter r103 = this.bindDelegate;
        r103.getClass();
        PlatformBindAdapter.a r104 = new PlatformBindAdapter.a(r103);
        this.mBindCallback = r104;
        if (this.isBindMobileApi == false) goto L10;
        PlatformBindAdapter r105 = this.bindDelegate;
        r105.api.o(r105.platformId, r105.platform, this.authCode, r101, r104);
        return;
    L10:
        PlatformBindAdapter r106 = this.bindDelegate;
        r106.api.b(r106.platformId, r106.platform, this.authCode, r101, r104);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestLogin(Bundle r110) {
        if (this.loginDelegate == null) goto L12;
        parseData(r110);
        Map<String, String> r111 = getCommonRequestParams();
        Map<String, String> r100 = this.loginDelegate.mExtendParam;
        if (r100 == null) goto L7;
        r111.putAll(r100);
    L7:
        PlatformLoginAdapter r101 = this.loginDelegate;
        r101.getClass();
        PlatformLoginAdapter.LoginCallback r102 = new PlatformLoginAdapter.LoginCallback(r101);
        this.mLoginCallback = r102;
        if (this.isBindMobileApi == false) goto L10;
        PlatformLoginAdapter r103 = this.loginDelegate;
        r103.api.h(r103.platformId, r103.platform, this.authCode, this.isNeedMobile, this.isChangeBind, r111, r102);
        return;
    L10:
        PlatformLoginAdapter r104 = this.loginDelegate;
        r104.api.c(r104.platformId, r104.platform, this.authCode, r111, r102);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestProfile(Bundle r100) {
        if (this.profileAdapter == null) goto L9;
        parseData(r100);
        Map<String, String> r101 = getCommonRequestParams();
        Map<String, String> r102 = this.profileAdapter.mExtendParam;
        if (r102 == null) goto L7;
        r101.putAll(r102);
    L7:
        PlatformProfileAdapter r103 = this.profileAdapter;
        r103.getClass();
        PlatformProfileAdapter.ProfileCallback r104 = new PlatformProfileAdapter.ProfileCallback(r103);
        this.mProfileCallback = r104;
        PlatformProfileAdapter r105 = this.profileAdapter;
        r105.api.l(r105.platformId, r105.platform, this.authCode, r101, r104);
        return;
    }

    public TiktokPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
        this.isBindMobileApi = r100.isBindPlatformAndThirdMobileMode;
    }

    public TiktokPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
    }
}

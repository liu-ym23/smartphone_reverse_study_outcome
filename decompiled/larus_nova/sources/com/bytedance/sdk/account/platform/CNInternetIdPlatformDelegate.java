package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.ICNInternetIdService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class CNInternetIdPlatformDelegate extends f {
    private String bizSeq;
    private String certPwdData;
    private String idCardAuthData;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private int type;

    /* JADX INFO: loaded from: classes3.dex */
    public static class Factory implements f.a {
        public Factory() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createBind(PlatformBindAdapter r100) {
            return new CNInternetIdPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createLogin(PlatformLoginAdapter r100) {
            return new CNInternetIdPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createProfile(PlatformProfileAdapter r100) {
            return new CNInternetIdPlatformDelegate(r100);
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

    public Map<String, String> getCommonRequestParams() {
        HashMap r100 = new HashMap();
        r100.put("extra_data", new JSONObject().put(ICNInternetIdService.ResponseConstants.BIZ_SEQ, this.bizSeq).put("type", this.type).put(ICNInternetIdService.ResponseConstants.CERT_PWD_DATA, this.certPwdData).toString());     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public CNInternetIdPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
    }

    private void parseData(Bundle r100) {
        this.type = r100.getInt("type");
        this.bizSeq = r100.getString(ICNInternetIdService.ResponseConstants.BIZ_SEQ);
        this.idCardAuthData = r100.getString(ICNInternetIdService.ResponseConstants.ID_CARD_AUTH_DATA);
        this.certPwdData = r100.getString(ICNInternetIdService.ResponseConstants.CERT_PWD_DATA);
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestBind(Bundle r110) {
        if (this.bindDelegate == null) goto L9;
        parseData(r110);
        Map<String, String> r100 = getCommonRequestParams();
        Map<String, String> r111 = this.bindDelegate.mExtendParam;
        if (r111 == null) goto L7;
        r100.putAll(r111);
    L7:
        PlatformBindAdapter r112 = this.bindDelegate;
        r112.getClass();
        PlatformBindAdapter.a r101 = new PlatformBindAdapter.a(r112);
        this.mBindCallback = r101;
        PlatformBindAdapter r113 = this.bindDelegate;
        r113.api.f(r113.platformId, r113.platform, this.idCardAuthData, 0, r100, r101);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestLogin(Bundle r110) {
        if (this.loginDelegate == null) goto L9;
        parseData(r110);
        Map<String, String> r100 = getCommonRequestParams();
        Map<String, String> r111 = this.loginDelegate.mExtendParam;
        if (r111 == null) goto L7;
        r100.putAll(r111);
    L7:
        PlatformLoginAdapter r112 = this.loginDelegate;
        r112.getClass();
        PlatformLoginAdapter.LoginCallback r101 = new PlatformLoginAdapter.LoginCallback(r112);
        this.mLoginCallback = r101;
        PlatformLoginAdapter r113 = this.loginDelegate;
        r113.api.j(r113.platformId, r113.platform, this.idCardAuthData, 0, r100, r101);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestProfile(Bundle r110) {
        if (this.profileAdapter == null) goto L9;
        parseData(r110);
        Map<String, String> r100 = getCommonRequestParams();
        Map<String, String> r111 = this.profileAdapter.mExtendParam;
        if (r111 == null) goto L7;
        r100.putAll(r111);
    L7:
        PlatformProfileAdapter r112 = this.profileAdapter;
        r112.api.a(r112.platformId, r112.platform, this.idCardAuthData, 0, r100, this.mProfileCallback);
        return;
    }

    public CNInternetIdPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
    }

    public CNInternetIdPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
    }
}

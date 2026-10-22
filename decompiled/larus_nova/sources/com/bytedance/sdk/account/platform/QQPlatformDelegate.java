package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes22.dex */
public class QQPlatformDelegate extends f {
    private String accessToken;
    private long exp;
    private String expires;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String openId;

    /* JADX INFO: loaded from: classes3.dex */
    public static class QQLoginFactor implements f.a {
        public QQLoginFactor() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createBind(PlatformBindAdapter r100) {
            return new QQPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createLogin(PlatformLoginAdapter r100) {
            return new QQPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public f createProfile(PlatformProfileAdapter r100) {
            return new QQPlatformDelegate(r100);
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

    public QQPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
    }

    private void parseData(Bundle r100) {
        this.openId = r100.getString("openid");
        this.accessToken = r100.getString("access_token");
        String r101 = r100.getString("expires_in");
        this.expires = r101;
        if (r101 != null) goto L5;
    L9:
        long r102 = 0;
    L10:
        this.exp = r102;
        return;
    L5:
        if (r101.isEmpty() == true) goto L9;
        r102 = CastLongProtector.parseLong(r101);     // Catch: NumberFormatException -> L12
        goto L10
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestBind(Bundle r110) {
        if (this.bindDelegate == null) goto L6;
        parseData(r110);
        PlatformBindAdapter r111 = this.bindDelegate;
        r111.getClass();
        PlatformBindAdapter.a r100 = new PlatformBindAdapter.a(r111);
        this.mBindCallback = r100;
        PlatformBindAdapter r112 = this.bindDelegate;
        r112.api.f(r112.platformId, r112.platform, this.accessToken, this.exp, r112.mExtendParam, r100);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestLogin(Bundle r110) {
        if (this.loginDelegate == null) goto L6;
        parseData(r110);
        PlatformLoginAdapter r111 = this.loginDelegate;
        r111.getClass();
        PlatformLoginAdapter.LoginCallback r100 = new PlatformLoginAdapter.LoginCallback(r111);
        this.mLoginCallback = r100;
        PlatformLoginAdapter r112 = this.loginDelegate;
        r112.api.j(r112.platformId, "qzone_sns", this.accessToken, this.exp, r112.mExtendParam, r100);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestProfile(Bundle r100) {
        if (this.profileAdapter == null) goto L6;
        parseData(r100);
        PlatformProfileAdapter r101 = this.profileAdapter;
        r101.api.a(r101.platformId, r101.platform, this.accessToken, this.exp, r101.mExtendParam, this.mProfileCallback);
        return;
    }

    public QQPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
    }

    public QQPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
    }
}

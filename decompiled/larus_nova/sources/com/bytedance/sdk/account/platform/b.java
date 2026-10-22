package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f269251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f269252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f269253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f269254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PlatformLoginAdapter.LoginCallback f269255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PlatformBindAdapter.a f269256f;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements f.a {
        public a() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createBind(PlatformBindAdapter r100) {
            return new b(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createLogin(PlatformLoginAdapter r100) {
            return new b(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createProfile(PlatformProfileAdapter r100) {
            return new b(r100);
        }
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelProfile() {
        this.profileAdapter = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelBind() {
        PlatformBindAdapter.a r100 = this.f269256f;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269256f = null;
    L5:
        this.bindDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelLogin() {
        PlatformLoginAdapter.LoginCallback r100 = this.f269255e;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269255e = null;
    L5:
        this.loginDelegate = null;
    }

    public b(PlatformBindAdapter r100) {
        super(r100);
    }

    public final void b(Bundle r100) {
        this.f269251a = r100.getString("id_token");
        this.f269252b = r100.getLong(IAppAuthService.ResponseKey.ACCESS_TOKEN_EXPIRATION_TIME);
        this.f269254d = r100.getString("nonce");
        this.f269253c = r100.getString("auth_code");
    }

    public final void parseData(Bundle r100) {
        r100.getString("id");
        this.f269251a = r100.getString("idToken");
        this.f269252b = r100.getLong("expire_in", 0);
        r100.getString(IGoogleService.ResponseKey.DISPLAY_NAME);
        this.f269253c = r100.getString(IGoogleService.ResponseKey.SERVER_AUTH_CODE);
        this.f269254d = r100.getString("nonce");
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestBind(Bundle r110) {
        PlatformBindAdapter r100 = this.bindDelegate;
        if (r100 == null) goto L15;
        a(r110, r100.appAuth);
        PlatformBindAdapter r101 = this.bindDelegate;
        r101.getClass();
        this.f269256f = new PlatformBindAdapter.a(r101);
        PlatformBindAdapter r111 = this.bindDelegate;
        if (r111.mExtendParam != null) goto L8;
        r111.mExtendParam = new HashMap();
    L8:
        if (TextUtils.isEmpty(this.f269253c) == true) goto L11;
        this.bindDelegate.mExtendParam.put("code", this.f269253c);
    L11:
        if (TextUtils.isEmpty(this.f269254d) == true) goto L13;
        this.bindDelegate.mExtendParam.put("nonce", this.f269254d);
    L13:
        PlatformBindAdapter r112 = this.bindDelegate;
        r112.api.i(r112.platformId, r112.platform, null, this.f269251a, this.f269252b, r112.mExtendParam, this.f269256f);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestLogin(Bundle r110) {
        PlatformLoginAdapter r100 = this.loginDelegate;
        if (r100 == null) goto L15;
        a(r110, r100.appAuth);
        PlatformLoginAdapter r101 = this.loginDelegate;
        r101.getClass();
        this.f269255e = new PlatformLoginAdapter.LoginCallback(r101);
        PlatformLoginAdapter r111 = this.loginDelegate;
        if (r111.mExtendParam != null) goto L8;
        r111.mExtendParam = new HashMap();
    L8:
        if (TextUtils.isEmpty(this.f269253c) == true) goto L11;
        this.loginDelegate.mExtendParam.put("code", this.f269253c);
    L11:
        if (TextUtils.isEmpty(this.f269254d) == true) goto L13;
        this.loginDelegate.mExtendParam.put("nonce", this.f269254d);
    L13:
        PlatformLoginAdapter r112 = this.loginDelegate;
        r112.api.g(r112.platformId, r112.platform, null, this.f269251a, this.f269252b, r112.mExtendParam, this.f269255e);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestProfile(Bundle r110) {
        if (this.profileAdapter == null) goto L15;
        parseData(r110);
        PlatformProfileAdapter r111 = this.profileAdapter;
        if (r111.mExtendParam != null) goto L8;
        r111.mExtendParam = new HashMap();
    L8:
        if (TextUtils.isEmpty(this.f269253c) == true) goto L11;
        this.profileAdapter.mExtendParam.put("code", this.f269253c);
    L11:
        if (TextUtils.isEmpty(this.f269254d) == true) goto L13;
        this.profileAdapter.mExtendParam.put("nonce", this.f269254d);
    L13:
        PlatformProfileAdapter r112 = this.profileAdapter;
        r112.api.k(r112.platformId, r112.platform, null, this.f269251a, this.f269252b, r112.mExtendParam, null);
        return;
    }

    public b(PlatformLoginAdapter r100) {
        super(r100);
    }

    public b(PlatformProfileAdapter r100) {
        super(r100);
    }

    public final void a(Bundle r100, int r101) {
        if (r101 != 0) goto L5;
        parseData(r100);
        return;
    L5:
        if (r101 != 1) goto L12;
        IGoogleService r102 = (IGoogleService) AuthorizeFramework.getService(IGoogleService.class);
        if (r102 != null) goto L9;
    L11:
        b(r100);
        return;
    L9:
        if (r102.isGooglePlayServiceAvailable() == false) goto L11;
        parseData(r100);
        return;
    L12:
        b(r100);
    }
}

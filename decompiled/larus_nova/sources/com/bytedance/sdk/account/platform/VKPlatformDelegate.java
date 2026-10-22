package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.IVKService;

/* JADX INFO: loaded from: classes22.dex */
public class VKPlatformDelegate extends f {
    String ACCESS_TOKEN;
    String CREATED;
    String EMAIL;
    String PHONE;
    String PHONE_ACCESS_KEY;
    String SECRET;
    String USER_ID;
    private String accessToken;
    private long created;
    private String email;
    private PlatformBindAdapter.a mBindCallback;
    private PlatformLoginAdapter.LoginCallback mLoginCallback;
    private PlatformProfileAdapter.ProfileCallback mProfileCallback;
    private String phone;
    private String phoneAccessKey;
    private String secret;
    private int userId;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements f.a {
        public a() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createBind(PlatformBindAdapter r100) {
            return new VKPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createLogin(PlatformLoginAdapter r100) {
            return new VKPlatformDelegate(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createProfile(PlatformProfileAdapter r100) {
            return new VKPlatformDelegate(r100);
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

    public VKPlatformDelegate(PlatformBindAdapter r100) {
        super(r100);
        this.ACCESS_TOKEN = "access_token";
        this.USER_ID = "user_id";
        this.SECRET = "secret";
        this.CREATED = IVKService.ResponseConstants.CREATED;
        this.EMAIL = "email";
        this.PHONE = "phone";
        this.PHONE_ACCESS_KEY = IVKService.ResponseConstants.PHONE_ACCESS_KEY;
    }

    private void parseData(Bundle r100) {
        this.accessToken = r100.getString("access_token");
        this.userId = r100.getInt("user_id");
        this.secret = r100.getString("secret");
        this.created = r100.getLong(IVKService.ResponseConstants.CREATED);
        this.email = r100.getString("email");
        this.phone = r100.getString("phone");
        this.phoneAccessKey = r100.getString(IVKService.ResponseConstants.PHONE_ACCESS_KEY);
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
        r112.api.i(r112.platformId, r112.platform, this.accessToken, this.secret, 0, r112.mExtendParam, r100);
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
        r112.api.g(r112.platformId, r112.platform, this.accessToken, this.secret, 0, r112.mExtendParam, r100);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public void requestProfile(Bundle r110) {
        if (this.profileAdapter == null) goto L6;
        parseData(r110);
        PlatformProfileAdapter r111 = this.profileAdapter;
        r111.api.k(r111.platformId, r111.platform, this.accessToken, this.secret, 0, r111.mExtendParam, this.mProfileCallback);
        return;
    }

    public VKPlatformDelegate(PlatformLoginAdapter r100) {
        super(r100);
        this.ACCESS_TOKEN = "access_token";
        this.USER_ID = "user_id";
        this.SECRET = "secret";
        this.CREATED = IVKService.ResponseConstants.CREATED;
        this.EMAIL = "email";
        this.PHONE = "phone";
        this.PHONE_ACCESS_KEY = IVKService.ResponseConstants.PHONE_ACCESS_KEY;
    }

    public VKPlatformDelegate(PlatformProfileAdapter r100) {
        super(r100);
        this.ACCESS_TOKEN = "access_token";
        this.USER_ID = "user_id";
        this.SECRET = "secret";
        this.CREATED = IVKService.ResponseConstants.CREATED;
        this.EMAIL = "email";
        this.PHONE = "phone";
        this.PHONE_ACCESS_KEY = IVKService.ResponseConstants.PHONE_ACCESS_KEY;
    }
}

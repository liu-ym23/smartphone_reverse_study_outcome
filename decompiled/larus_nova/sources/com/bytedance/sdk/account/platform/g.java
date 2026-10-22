package com.bytedance.sdk.account.platform;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.api.ITwitterService;

/* JADX INFO: loaded from: classes22.dex */
public final class g extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f269267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f269268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlatformLoginAdapter.LoginCallback f269269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PlatformBindAdapter.a f269270d;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements f.a {
        public a() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createBind(PlatformBindAdapter r100) {
            return new g(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createLogin(PlatformLoginAdapter r100) {
            return new g(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createProfile(PlatformProfileAdapter r100) {
            return new g(r100);
        }
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelProfile() {
        this.profileAdapter = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelBind() {
        PlatformBindAdapter.a r100 = this.f269270d;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269270d = null;
    L5:
        this.bindDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelLogin() {
        PlatformLoginAdapter.LoginCallback r100 = this.f269269c;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269269c = null;
    L5:
        this.loginDelegate = null;
    }

    public g(PlatformBindAdapter r100) {
        super(r100);
    }

    public final void parseData(Bundle r100) {
        this.f269267a = r100.getString(ITwitterService.ResponseConstants.AUTH_TOKEN);
        r100.getString("id");
        r100.getString(ITwitterService.ResponseConstants.USER_NAME);
        this.f269268b = r100.getString("secret");
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestBind(Bundle r110) {
        if (this.bindDelegate == null) goto L6;
        parseData(r110);
        PlatformBindAdapter r111 = this.bindDelegate;
        r111.getClass();
        PlatformBindAdapter.a r100 = new PlatformBindAdapter.a(r111);
        this.f269270d = r100;
        PlatformBindAdapter r112 = this.bindDelegate;
        r112.api.i(r112.platformId, r112.platform, this.f269267a, this.f269268b, 0, r112.mExtendParam, r100);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestLogin(Bundle r110) {
        if (this.loginDelegate == null) goto L6;
        parseData(r110);
        PlatformLoginAdapter r111 = this.loginDelegate;
        r111.getClass();
        PlatformLoginAdapter.LoginCallback r100 = new PlatformLoginAdapter.LoginCallback(r111);
        this.f269269c = r100;
        PlatformLoginAdapter r112 = this.loginDelegate;
        r112.api.g(r112.platformId, r112.platform, this.f269267a, this.f269268b, 0, r112.mExtendParam, r100);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestProfile(Bundle r110) {
        if (this.profileAdapter == null) goto L6;
        parseData(r110);
        PlatformProfileAdapter r111 = this.profileAdapter;
        r111.api.k(r111.platformId, r111.platform, this.f269267a, this.f269268b, 0, r111.mExtendParam, null);
        return;
    }

    public g(PlatformLoginAdapter r100) {
        super(r100);
    }

    public g(PlatformProfileAdapter r100) {
        super(r100);
    }
}

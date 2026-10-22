package com.bytedance.sdk.account.platform;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f269246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f269247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlatformLoginAdapter.LoginCallback f269248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PlatformBindAdapter.a f269249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PlatformProfileAdapter.ProfileCallback f269250e;

    /* JADX INFO: renamed from: com.bytedance.sdk.account.platform.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static class C3764a implements f.a {
        public C3764a() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createBind(PlatformBindAdapter r100) {
            return new a(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createLogin(PlatformLoginAdapter r100) {
            return new a(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createProfile(PlatformProfileAdapter r100) {
            return new a(r100);
        }
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelBind() {
        PlatformBindAdapter.a r100 = this.f269249d;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269249d = null;
    L5:
        this.bindDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelLogin() {
        PlatformLoginAdapter.LoginCallback r100 = this.f269248c;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269248c = null;
    L5:
        this.loginDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelProfile() {
        PlatformProfileAdapter.ProfileCallback r100 = this.f269250e;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269250e = null;
    L5:
        this.profileAdapter = null;
    }

    public a(PlatformBindAdapter r100) {
        super(r100);
    }

    public final void parseData(Bundle r100) {
        this.f269246a = r100.getString("access_token");
        r100.getString("user_id");
        this.f269247b = r100.getLong("expires_in");
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestBind(Bundle r110) {
        if (this.bindDelegate == null) goto L6;
        parseData(r110);
        PlatformBindAdapter r111 = this.bindDelegate;
        r111.getClass();
        PlatformBindAdapter.a r100 = new PlatformBindAdapter.a(r111);
        this.f269249d = r100;
        PlatformBindAdapter r112 = this.bindDelegate;
        r112.api.f(r112.platformId, r112.platform, this.f269246a, this.f269247b, r112.mExtendParam, r100);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestLogin(Bundle r110) {
        if (this.loginDelegate == null) goto L6;
        parseData(r110);
        PlatformLoginAdapter r111 = this.loginDelegate;
        r111.getClass();
        PlatformLoginAdapter.LoginCallback r100 = new PlatformLoginAdapter.LoginCallback(r111);
        this.f269248c = r100;
        PlatformLoginAdapter r112 = this.loginDelegate;
        r112.api.j(r112.platformId, r112.platform, this.f269246a, this.f269247b, r112.mExtendParam, r100);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestProfile(Bundle r110) {
        if (this.profileAdapter == null) goto L6;
        parseData(r110);
        PlatformProfileAdapter r111 = this.profileAdapter;
        r111.getClass();
        PlatformProfileAdapter.ProfileCallback r100 = new PlatformProfileAdapter.ProfileCallback(r111);
        this.f269250e = r100;
        PlatformProfileAdapter r112 = this.profileAdapter;
        r112.api.a(r112.platformId, r112.platform, this.f269246a, this.f269247b, r112.mExtendParam, r100);
        return;
    }

    public a(PlatformLoginAdapter r100) {
        super(r100);
    }

    public a(PlatformProfileAdapter r100) {
        super(r100);
    }
}

package com.bytedance.sdk.account.platform;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f269261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PlatformLoginAdapter.LoginCallback f269262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlatformBindAdapter.a f269263c;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements f.a {
        public a() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createBind(PlatformBindAdapter r100) {
            return new d(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createLogin(PlatformLoginAdapter r100) {
            return new d(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createProfile(PlatformProfileAdapter r100) {
            return new d(r100);
        }
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelProfile() {
        this.profileAdapter = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelBind() {
        PlatformBindAdapter.a r100 = this.f269263c;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269263c = null;
    L5:
        this.bindDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelLogin() {
        PlatformLoginAdapter.LoginCallback r100 = this.f269262b;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269262b = null;
    L5:
        this.loginDelegate = null;
    }

    public d(PlatformBindAdapter r100) {
        super(r100);
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestBind(Bundle r100) {
        if (this.bindDelegate == null) goto L6;
        this.f269261a = r100.getString("access_token");
        PlatformBindAdapter r101 = this.bindDelegate;
        r101.getClass();
        PlatformBindAdapter.a r102 = new PlatformBindAdapter.a(r101);
        this.f269263c = r102;
        PlatformBindAdapter r103 = this.bindDelegate;
        r103.api.f(r103.platformId, r103.platform, this.f269261a, 0, r103.mExtendParam, r102);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestLogin(Bundle r100) {
        if (this.loginDelegate == null) goto L6;
        this.f269261a = r100.getString("access_token");
        PlatformLoginAdapter r101 = this.loginDelegate;
        r101.getClass();
        PlatformLoginAdapter.LoginCallback r102 = new PlatformLoginAdapter.LoginCallback(r101);
        this.f269262b = r102;
        PlatformLoginAdapter r103 = this.loginDelegate;
        r103.api.j(r103.platformId, r103.platform, this.f269261a, 0, r103.mExtendParam, r102);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestProfile(Bundle r110) {
        if (this.profileAdapter == null) goto L6;
        String r100 = r110.getString("access_token");
        this.f269261a = r100;
        PlatformProfileAdapter r111 = this.profileAdapter;
        r111.api.a(r111.platformId, r111.platform, r100, 0, r111.mExtendParam, null);
        return;
    }

    public d(PlatformLoginAdapter r100) {
        super(r100);
    }

    public d(PlatformProfileAdapter r100) {
        super(r100);
    }
}

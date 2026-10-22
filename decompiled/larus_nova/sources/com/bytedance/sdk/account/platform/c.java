package com.bytedance.sdk.account.platform;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f269257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f269258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlatformLoginAdapter.LoginCallback f269259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PlatformBindAdapter.a f269260d;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements f.a {
        public a() {
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createBind(PlatformBindAdapter r100) {
            return new c(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createLogin(PlatformLoginAdapter r100) {
            return new c(r100);
        }

        @Override // com.bytedance.sdk.account.platform.f.a
        public final f createProfile(PlatformProfileAdapter r100) {
            return new c(r100);
        }
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelProfile() {
        this.profileAdapter = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelBind() {
        PlatformBindAdapter.a r100 = this.f269260d;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269260d = null;
    L5:
        this.bindDelegate = null;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void cancelLogin() {
        PlatformLoginAdapter.LoginCallback r100 = this.f269259c;
        if (r100 == null) goto L5;
        r100.cancel();
        this.f269259c = null;
    L5:
        this.loginDelegate = null;
    }

    public c(PlatformBindAdapter r100) {
        super(r100);
    }

    public final void parseData(Bundle r100) {
        this.f269257a = r100.getString("access_token");
        this.f269258b = r100.getLong("expire_in", 0);
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestBind(Bundle r110) {
        if (this.bindDelegate == null) goto L6;
        parseData(r110);
        PlatformBindAdapter r111 = this.bindDelegate;
        r111.getClass();
        PlatformBindAdapter.a r100 = new PlatformBindAdapter.a(r111);
        this.f269260d = r100;
        PlatformBindAdapter r112 = this.bindDelegate;
        r112.api.f(r112.platformId, r112.platform, this.f269257a, this.f269258b, r112.mExtendParam, r100);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestLogin(Bundle r110) {
        if (this.loginDelegate == null) goto L6;
        parseData(r110);
        PlatformLoginAdapter r111 = this.loginDelegate;
        r111.getClass();
        PlatformLoginAdapter.LoginCallback r100 = new PlatformLoginAdapter.LoginCallback(r111);
        this.f269259c = r100;
        PlatformLoginAdapter r112 = this.loginDelegate;
        r112.api.j(r112.platformId, r112.platform, this.f269257a, this.f269258b, r112.mExtendParam, r100);
        return;
    }

    @Override // com.bytedance.sdk.account.platform.f
    public final void requestProfile(Bundle r100) {
        if (this.profileAdapter == null) goto L6;
        parseData(r100);
        PlatformProfileAdapter r101 = this.profileAdapter;
        r101.api.a(r101.platformId, r101.platform, this.f269257a, this.f269258b, r101.mExtendParam, null);
        return;
    }

    public c(PlatformLoginAdapter r100) {
        super(r100);
    }

    public c(PlatformProfileAdapter r100) {
        super(r100);
    }
}

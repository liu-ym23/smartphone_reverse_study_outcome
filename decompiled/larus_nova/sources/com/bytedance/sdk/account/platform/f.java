package com.bytedance.sdk.account.platform;

import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public abstract class f {
    PlatformBindAdapter bindDelegate;
    PlatformLoginAdapter loginDelegate;
    PlatformProfileAdapter profileAdapter;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        f createBind(PlatformBindAdapter r100);

        f createLogin(PlatformLoginAdapter r100);

        f createProfile(PlatformProfileAdapter r100);
    }

    public abstract void cancelBind();

    public abstract void cancelLogin();

    public abstract void cancelProfile();

    public abstract void requestBind(Bundle r100);

    public abstract void requestLogin(Bundle r100);

    public abstract void requestProfile(Bundle r100);

    public f(PlatformBindAdapter r100) {
        this.bindDelegate = r100;
        this.loginDelegate = null;
        this.profileAdapter = null;
    }

    public f(PlatformLoginAdapter r100) {
        this.loginDelegate = r100;
        this.bindDelegate = null;
        this.profileAdapter = null;
    }

    public f(PlatformProfileAdapter r100) {
        this.profileAdapter = r100;
        this.loginDelegate = null;
        this.bindDelegate = null;
    }
}

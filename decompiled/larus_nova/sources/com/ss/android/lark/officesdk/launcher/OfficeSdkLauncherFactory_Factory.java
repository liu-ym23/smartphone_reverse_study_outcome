package com.ss.android.lark.officesdk.launcher;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSdkLauncherFactory_Factory implements Factory<i> {
    private final Provider<com.ss.android.lark.app.initiator.a> appLauncherProvider;

    public static i newInstance() {
        return new i();
    }

    @Override // javax.inject.Provider
    public i get() {
        i r100 = newInstance();
        r100.f433449a = DoubleCheck.lazy(this.appLauncherProvider);
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSdkLauncherFactory_Factory(Provider<com.ss.android.lark.app.initiator.a> r100) {
        this.appLauncherProvider = r100;
    }

    public static OfficeSdkLauncherFactory_Factory create(Provider<com.ss.android.lark.app.initiator.a> r100) {
        return new OfficeSdkLauncherFactory_Factory(r100);
    }
}

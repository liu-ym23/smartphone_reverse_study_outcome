package com.ss.android.lark.app.initiator;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AppLauncher_Factory implements Factory<a> {
    private final Provider<c> initiatorFactoryProvider;
    private final Provider<AppLaunchLifecycle> lifecycleProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.initiatorFactoryProvider.get(), this.lifecycleProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AppLauncher_Factory(Provider<c> r100, Provider<AppLaunchLifecycle> r101) {
        this.initiatorFactoryProvider = r100;
        this.lifecycleProvider = r101;
    }

    public static AppLauncher_Factory create(Provider<c> r100, Provider<AppLaunchLifecycle> r101) {
        return new AppLauncher_Factory(r100, r101);
    }

    public static a newInstance(c r100, AppLaunchLifecycle r101) {
        return new a(r100, r101);
    }
}

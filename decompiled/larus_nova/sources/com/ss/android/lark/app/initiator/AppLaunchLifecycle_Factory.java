package com.ss.android.lark.app.initiator;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AppLaunchLifecycle_Factory implements Factory<AppLaunchLifecycle> {
    private final Provider<Set<AppLaunchLifecycle.b>> observersProvider;

    @Override // javax.inject.Provider
    public AppLaunchLifecycle get() {
        return newInstance(this.observersProvider);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AppLaunchLifecycle_Factory(Provider<Set<AppLaunchLifecycle.b>> r100) {
        this.observersProvider = r100;
    }

    public static AppLaunchLifecycle_Factory create(Provider<Set<AppLaunchLifecycle.b>> r100) {
        return new AppLaunchLifecycle_Factory(r100);
    }

    public static AppLaunchLifecycle newInstance(Provider<Set<AppLaunchLifecycle.b>> r100) {
        return new AppLaunchLifecycle(r100);
    }
}

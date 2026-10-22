package com.ss.android.lark.app.initiator;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes34.dex */
public final class AppLaunchLifecycle_LogLaunchLifecycleObserver_Factory implements Factory<AppLaunchLifecycle.c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AppLaunchLifecycle_LogLaunchLifecycleObserver_Factory f408743a = null;

        static {
            f408743a = new AppLaunchLifecycle_LogLaunchLifecycleObserver_Factory();
        }
    }

    public AppLaunchLifecycle_LogLaunchLifecycleObserver_Factory() {
    }

    public static AppLaunchLifecycle.c newInstance() {
        return new AppLaunchLifecycle.c();
    }

    @Override // javax.inject.Provider
    public AppLaunchLifecycle.c get() {
        return newInstance();
    }

    public static AppLaunchLifecycle_LogLaunchLifecycleObserver_Factory create() {
        return a.f408743a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

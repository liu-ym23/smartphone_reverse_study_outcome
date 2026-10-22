package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseSingletonMocksModule_ProvideINotificationControllerApiFactory implements Factory<ysb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseSingletonMocksModule_ProvideINotificationControllerApiFactory f433151a = null;

        static {
            f433151a = new BaseSingletonMocksModule_ProvideINotificationControllerApiFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideINotificationControllerApiFactory() {
    }

    public static ysb.a provideINotificationControllerApi() {
        int r100 = com.ss.android.lark.officesdk.demo.dependency.a.f433161a;
        return (ysb.a) Preconditions.checkNotNullFromProvides((ysb.a) com.ss.android.lark.officesdk.demo.dependency.a.a(ysb.a.class));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BaseSingletonMocksModule_ProvideINotificationControllerApiFactory create() {
        return a.f433151a;
    }

    @Override // javax.inject.Provider
    public ysb.a get() {
        return provideINotificationControllerApi();
    }
}

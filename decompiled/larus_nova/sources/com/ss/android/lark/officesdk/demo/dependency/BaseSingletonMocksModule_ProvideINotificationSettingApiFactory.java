package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseSingletonMocksModule_ProvideINotificationSettingApiFactory implements Factory<ysb.b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseSingletonMocksModule_ProvideINotificationSettingApiFactory f433152a = null;

        static {
            f433152a = new BaseSingletonMocksModule_ProvideINotificationSettingApiFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideINotificationSettingApiFactory() {
    }

    public static ysb.b provideINotificationSettingApi() {
        int r100 = com.ss.android.lark.officesdk.demo.dependency.a.f433161a;
        return (ysb.b) Preconditions.checkNotNullFromProvides((ysb.b) com.ss.android.lark.officesdk.demo.dependency.a.a(ysb.b.class));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BaseSingletonMocksModule_ProvideINotificationSettingApiFactory create() {
        return a.f433152a;
    }

    @Override // javax.inject.Provider
    public ysb.b get() {
        return provideINotificationSettingApi();
    }
}

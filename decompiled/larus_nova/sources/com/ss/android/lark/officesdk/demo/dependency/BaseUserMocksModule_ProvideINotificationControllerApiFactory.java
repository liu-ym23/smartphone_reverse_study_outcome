package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseUserMocksModule_ProvideINotificationControllerApiFactory implements Factory<ysb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseUserMocksModule_ProvideINotificationControllerApiFactory f433156a = null;

        static {
            f433156a = new BaseUserMocksModule_ProvideINotificationControllerApiFactory();
        }
    }

    public BaseUserMocksModule_ProvideINotificationControllerApiFactory() {
    }

    public static ysb.a provideINotificationControllerApi() {
        int r100 = b.f433163a;
        return (ysb.a) Preconditions.checkNotNullFromProvides((ysb.a) b.a(ysb.a.class));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BaseUserMocksModule_ProvideINotificationControllerApiFactory create() {
        return a.f433156a;
    }

    @Override // javax.inject.Provider
    public ysb.a get() {
        return provideINotificationControllerApi();
    }
}

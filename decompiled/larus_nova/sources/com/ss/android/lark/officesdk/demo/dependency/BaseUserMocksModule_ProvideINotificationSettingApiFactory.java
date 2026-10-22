package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseUserMocksModule_ProvideINotificationSettingApiFactory implements Factory<ysb.b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseUserMocksModule_ProvideINotificationSettingApiFactory f433157a = null;

        static {
            f433157a = new BaseUserMocksModule_ProvideINotificationSettingApiFactory();
        }
    }

    public BaseUserMocksModule_ProvideINotificationSettingApiFactory() {
    }

    public static ysb.b provideINotificationSettingApi() {
        int r100 = b.f433163a;
        return (ysb.b) Preconditions.checkNotNullFromProvides((ysb.b) b.a(ysb.b.class));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BaseUserMocksModule_ProvideINotificationSettingApiFactory create() {
        return a.f433157a;
    }

    @Override // javax.inject.Provider
    public ysb.b get() {
        return provideINotificationSettingApi();
    }
}

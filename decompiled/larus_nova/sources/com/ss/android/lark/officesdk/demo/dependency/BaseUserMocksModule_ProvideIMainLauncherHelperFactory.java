package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseUserMocksModule_ProvideIMainLauncherHelperFactory implements Factory<s9b.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseUserMocksModule_ProvideIMainLauncherHelperFactory f433155a = null;

        static {
            f433155a = new BaseUserMocksModule_ProvideIMainLauncherHelperFactory();
        }
    }

    public BaseUserMocksModule_ProvideIMainLauncherHelperFactory() {
    }

    public static s9b.a provideIMainLauncherHelper() {
        int r100 = b.f433163a;
        return (s9b.a) Preconditions.checkNotNullFromProvides((s9b.a) b.a(s9b.a.class));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BaseUserMocksModule_ProvideIMainLauncherHelperFactory create() {
        return a.f433155a;
    }

    @Override // javax.inject.Provider
    public s9b.a get() {
        return provideIMainLauncherHelper();
    }
}

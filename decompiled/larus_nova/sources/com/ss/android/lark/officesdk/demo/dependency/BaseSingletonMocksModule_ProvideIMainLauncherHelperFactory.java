package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory implements Factory<s9b.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory f433150a = null;

        static {
            f433150a = new BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory() {
    }

    public static s9b.a provideIMainLauncherHelper() {
        int r100 = com.ss.android.lark.officesdk.demo.dependency.a.f433161a;
        return (s9b.a) Preconditions.checkNotNullFromProvides((s9b.a) com.ss.android.lark.officesdk.demo.dependency.a.a(s9b.a.class));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BaseSingletonMocksModule_ProvideIMainLauncherHelperFactory create() {
        return a.f433150a;
    }

    @Override // javax.inject.Provider
    public s9b.a get() {
        return provideIMainLauncherHelper();
    }
}

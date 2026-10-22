package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory implements Factory<yqb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory f433149a = null;

        static {
            f433149a = new BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory() {
    }

    public static yqb.a provideIExportTabDataManager() {
        int r100 = com.ss.android.lark.officesdk.demo.dependency.a.f433161a;
        return (yqb.a) Preconditions.checkNotNullFromProvides((yqb.a) com.ss.android.lark.officesdk.demo.dependency.a.a(yqb.a.class));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BaseSingletonMocksModule_ProvideIExportTabDataManagerFactory create() {
        return a.f433149a;
    }

    @Override // javax.inject.Provider
    public yqb.a get() {
        return provideIExportTabDataManager();
    }
}

package com.ss.android.lark.officesdk.demo.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseUserMocksModule_ProvideIExportTabDataManagerFactory implements Factory<yqb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseUserMocksModule_ProvideIExportTabDataManagerFactory f433154a = null;

        static {
            f433154a = new BaseUserMocksModule_ProvideIExportTabDataManagerFactory();
        }
    }

    public BaseUserMocksModule_ProvideIExportTabDataManagerFactory() {
    }

    public static yqb.a provideIExportTabDataManager() {
        int r100 = b.f433163a;
        return (yqb.a) Preconditions.checkNotNullFromProvides((yqb.a) b.a(yqb.a.class));
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static BaseUserMocksModule_ProvideIExportTabDataManagerFactory create() {
        return a.f433154a;
    }

    @Override // javax.inject.Provider
    public yqb.a get() {
        return provideIExportTabDataManager();
    }
}

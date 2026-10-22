package com.ss.android.lark.officesdk.demo.dependency;

import com.ss.android.lark.myai.export.MyAIService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseSingletonMocksModule_ProvideMyAIServiceFactory implements Factory<MyAIService> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseSingletonMocksModule_ProvideMyAIServiceFactory f433153a = null;

        static {
            f433153a = new BaseSingletonMocksModule_ProvideMyAIServiceFactory();
        }
    }

    public BaseSingletonMocksModule_ProvideMyAIServiceFactory() {
    }

    public static MyAIService provideMyAIService() {
        int r100 = com.ss.android.lark.officesdk.demo.dependency.a.f433161a;
        return (MyAIService) Preconditions.checkNotNullFromProvides((MyAIService) com.ss.android.lark.officesdk.demo.dependency.a.a(MyAIService.class));
    }

    @Override // javax.inject.Provider
    public MyAIService get() {
        return provideMyAIService();
    }

    public static BaseSingletonMocksModule_ProvideMyAIServiceFactory create() {
        return a.f433153a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

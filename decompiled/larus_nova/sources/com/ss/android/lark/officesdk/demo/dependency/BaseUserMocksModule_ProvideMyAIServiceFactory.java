package com.ss.android.lark.officesdk.demo.dependency;

import com.ss.android.lark.myai.export.MyAIService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class BaseUserMocksModule_ProvideMyAIServiceFactory implements Factory<MyAIService> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BaseUserMocksModule_ProvideMyAIServiceFactory f433158a = null;

        static {
            f433158a = new BaseUserMocksModule_ProvideMyAIServiceFactory();
        }
    }

    public BaseUserMocksModule_ProvideMyAIServiceFactory() {
    }

    public static MyAIService provideMyAIService() {
        int r100 = b.f433163a;
        return (MyAIService) Preconditions.checkNotNullFromProvides((MyAIService) b.a(MyAIService.class));
    }

    @Override // javax.inject.Provider
    public MyAIService get() {
        return provideMyAIService();
    }

    public static BaseUserMocksModule_ProvideMyAIServiceFactory create() {
        return a.f433158a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

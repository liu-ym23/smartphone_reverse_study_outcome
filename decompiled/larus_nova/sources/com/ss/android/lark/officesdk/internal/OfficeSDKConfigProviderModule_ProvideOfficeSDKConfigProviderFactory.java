package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKConfigProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideOfficeSDKConfigProviderFactory implements Factory<IOfficeSDKConfigProvider> {
    private final d module;

    @Override // javax.inject.Provider
    public IOfficeSDKConfigProvider get() {
        return provideOfficeSDKConfigProvider(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKConfigProviderModule_ProvideOfficeSDKConfigProviderFactory(d r100) {
        this.module = r100;
    }

    public static OfficeSDKConfigProviderModule_ProvideOfficeSDKConfigProviderFactory create(d r100) {
        return new OfficeSDKConfigProviderModule_ProvideOfficeSDKConfigProviderFactory(r100);
    }

    public static IOfficeSDKConfigProvider provideOfficeSDKConfigProvider(d r100) {
        r100.getClass();
        return (IOfficeSDKConfigProvider) Preconditions.checkNotNullFromProvides(new c());
    }
}

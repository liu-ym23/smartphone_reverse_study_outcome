package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideTokenProviderFactory implements Factory<IOfficeSDKTokenProvider> {

    public static final class InstanceHolder {
        private static final OfficeSDKConfigProviderModule_ProvideTokenProviderFactory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new OfficeSDKConfigProviderModule_ProvideTokenProviderFactory();
        }

        public static /* synthetic */ OfficeSDKConfigProviderModule_ProvideTokenProviderFactory access$000() {
            return INSTANCE;
        }
    }

    public OfficeSDKConfigProviderModule_ProvideTokenProviderFactory() {
    }

    public static IOfficeSDKTokenProvider provideTokenProvider() {
        return (IOfficeSDKTokenProvider) Preconditions.checkNotNullFromProvides(OfficeSDKConfigProviderModule.INSTANCE.provideTokenProvider());
    }

    public static OfficeSDKConfigProviderModule_ProvideTokenProviderFactory create() {
        return InstanceHolder.access$000();
    }

    @Override // javax.inject.Provider
    public IOfficeSDKTokenProvider get() {
        return provideTokenProvider();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKHostAppHeaderProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideHostAppHeaderProviderFactory implements Factory<IOfficeSDKHostAppHeaderProvider> {

    public static final class InstanceHolder {
        private static final OfficeSDKConfigProviderModule_ProvideHostAppHeaderProviderFactory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new OfficeSDKConfigProviderModule_ProvideHostAppHeaderProviderFactory();
        }

        public static /* synthetic */ OfficeSDKConfigProviderModule_ProvideHostAppHeaderProviderFactory access$000() {
            return INSTANCE;
        }
    }

    public OfficeSDKConfigProviderModule_ProvideHostAppHeaderProviderFactory() {
    }

    public static IOfficeSDKHostAppHeaderProvider provideHostAppHeaderProvider() {
        return (IOfficeSDKHostAppHeaderProvider) Preconditions.checkNotNullFromProvides(OfficeSDKConfigProviderModule.INSTANCE.provideHostAppHeaderProvider());
    }

    public static OfficeSDKConfigProviderModule_ProvideHostAppHeaderProviderFactory create() {
        return InstanceHolder.access$000();
    }

    @Override // javax.inject.Provider
    public IOfficeSDKHostAppHeaderProvider get() {
        return provideHostAppHeaderProvider();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

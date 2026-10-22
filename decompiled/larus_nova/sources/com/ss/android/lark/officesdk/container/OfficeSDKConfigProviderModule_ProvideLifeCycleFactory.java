package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideLifeCycleFactory implements Factory<IOfficeSDKLifeCycle> {

    public static final class InstanceHolder {
        private static final OfficeSDKConfigProviderModule_ProvideLifeCycleFactory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new OfficeSDKConfigProviderModule_ProvideLifeCycleFactory();
        }

        public static /* synthetic */ OfficeSDKConfigProviderModule_ProvideLifeCycleFactory access$000() {
            return INSTANCE;
        }
    }

    public OfficeSDKConfigProviderModule_ProvideLifeCycleFactory() {
    }

    public static IOfficeSDKLifeCycle provideLifeCycle() {
        return (IOfficeSDKLifeCycle) Preconditions.checkNotNullFromProvides(OfficeSDKConfigProviderModule.INSTANCE.provideLifeCycle());
    }

    public static OfficeSDKConfigProviderModule_ProvideLifeCycleFactory create() {
        return InstanceHolder.access$000();
    }

    @Override // javax.inject.Provider
    public IOfficeSDKLifeCycle get() {
        return provideLifeCycle();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

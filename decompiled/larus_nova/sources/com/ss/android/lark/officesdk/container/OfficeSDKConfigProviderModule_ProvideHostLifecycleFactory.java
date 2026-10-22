package com.ss.android.lark.officesdk.container;

import com.ss.android.lark.officesdk.api.service.capacity.IHostLifecycle;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory implements Factory<IHostLifecycle> {

    public static final class InstanceHolder {
        private static final OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory INSTANCE = null;

        private InstanceHolder() {
        }

        static {
            INSTANCE = new OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory();
        }

        public static /* synthetic */ OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory access$000() {
            return INSTANCE;
        }
    }

    public OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory() {
    }

    public static IHostLifecycle provideHostLifecycle() {
        return (IHostLifecycle) Preconditions.checkNotNullFromProvides(OfficeSDKConfigProviderModule.INSTANCE.provideHostLifecycle());
    }

    public static OfficeSDKConfigProviderModule_ProvideHostLifecycleFactory create() {
        return InstanceHolder.access$000();
    }

    @Override // javax.inject.Provider
    public IHostLifecycle get() {
        return provideHostLifecycle();
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

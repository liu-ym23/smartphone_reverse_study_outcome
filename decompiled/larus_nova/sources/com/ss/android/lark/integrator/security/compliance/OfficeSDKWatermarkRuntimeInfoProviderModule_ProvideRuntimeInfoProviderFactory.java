package com.ss.android.lark.integrator.security.compliance;

import com.ss.android.lark.watermark.userscope.u0;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory implements Factory<u0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory f428047a = null;

        static {
            f428047a = new OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory();
        }
    }

    public OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory() {
    }

    public static u0 provideRuntimeInfoProvider() {
        int r100 = h.f428095a;
        return (u0) Preconditions.checkNotNullFromProvides(g.f428094a);
    }

    @Override // javax.inject.Provider
    public u0 get() {
        return provideRuntimeInfoProvider();
    }

    public static OfficeSDKWatermarkRuntimeInfoProviderModule_ProvideRuntimeInfoProviderFactory create() {
        return a.f428047a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

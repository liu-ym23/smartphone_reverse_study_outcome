package com.ss.android.lark.framework.assembly.rust;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class RustAssemblyModule_ProviderMakeOnlineV2RequestFactoryFactory implements Factory<p> {
    private final Provider<p> requestFactoryProvider;

    @Override // javax.inject.Provider
    public p get() {
        return providerMakeOnlineV2RequestFactory(this.requestFactoryProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustAssemblyModule_ProviderMakeOnlineV2RequestFactoryFactory(Provider<p> r100) {
        this.requestFactoryProvider = r100;
    }

    public static RustAssemblyModule_ProviderMakeOnlineV2RequestFactoryFactory create(Provider<p> r100) {
        return new RustAssemblyModule_ProviderMakeOnlineV2RequestFactoryFactory(r100);
    }

    public static p providerMakeOnlineV2RequestFactory(p r100) {
        int r101 = t.f425713a;
        Intrinsics.checkNotNullParameter(r100, "requestFactory");
        return (p) Preconditions.checkNotNullFromProvides(r100);
    }
}

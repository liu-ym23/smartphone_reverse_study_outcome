package com.bytedance.bdp.live.livecontainer.di;

import dagger.internal.Factory;
import ya4.a;

/* JADX INFO: loaded from: classes11.dex */
public final class MiniAppModuleFallback_ProvideMiniAppServiceFactory implements Factory<a> {
    private final pa4.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MiniAppModuleFallback_ProvideMiniAppServiceFactory(pa4.a r100) {
    }

    public static MiniAppModuleFallback_ProvideMiniAppServiceFactory create(pa4.a r100) {
        return new MiniAppModuleFallback_ProvideMiniAppServiceFactory(r100);
    }

    public static a provideInstance(pa4.a r100) {
        return proxyProvideMiniAppService(r100);
    }

    public static a proxyProvideMiniAppService(pa4.a r100) {
        throw null;
    }
}

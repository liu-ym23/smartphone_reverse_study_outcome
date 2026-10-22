package com.bytedance.bdp.live.livecontainer.miniapp.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ya4.a;
import ya4.d;

/* JADX INFO: loaded from: classes11.dex */
public final class MiniAppModule_ProvideMiniAppServiceFactory implements Factory<a> {
    private final za4.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MiniAppModule_ProvideMiniAppServiceFactory(za4.a r100) {
        this.module = r100;
    }

    public static MiniAppModule_ProvideMiniAppServiceFactory create(za4.a r100) {
        return new MiniAppModule_ProvideMiniAppServiceFactory(r100);
    }

    public static a provideInstance(za4.a r100) {
        return proxyProvideMiniAppService(r100);
    }

    public static a proxyProvideMiniAppService(za4.a r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNull(new d(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

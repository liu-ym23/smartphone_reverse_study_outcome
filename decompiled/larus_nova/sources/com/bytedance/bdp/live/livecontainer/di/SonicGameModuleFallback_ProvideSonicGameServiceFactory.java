package com.bytedance.bdp.live.livecontainer.di;

import com.bytedance.bdp.live.livecontainer.sonicgame.a;
import dagger.internal.Factory;
import pa4.b;

/* JADX INFO: loaded from: classes11.dex */
public final class SonicGameModuleFallback_ProvideSonicGameServiceFactory implements Factory<a> {
    private final b module;

    @Override // javax.inject.Provider
    public a get() {
        return provideInstance(null);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SonicGameModuleFallback_ProvideSonicGameServiceFactory(b r100) {
    }

    public static SonicGameModuleFallback_ProvideSonicGameServiceFactory create(b r100) {
        return new SonicGameModuleFallback_ProvideSonicGameServiceFactory(r100);
    }

    public static a provideInstance(b r100) {
        return proxyProvideSonicGameService(r100);
    }

    public static a proxyProvideSonicGameService(b r100) {
        throw null;
    }
}

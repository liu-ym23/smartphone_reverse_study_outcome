package com.bytedance.bdp.live.livecontainer.sonicgame.di;

import com.bytedance.bdp.live.livecontainer.sonicgame.a;
import com.bytedance.bdp.live.livecontainer.sonicgame.d;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class SonicGameModule_ProvideSonicGameServiceFactory implements Factory<a> {
    private final bb4.a module;

    @Override // javax.inject.Provider
    public a get() {
        return provideInstance(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SonicGameModule_ProvideSonicGameServiceFactory(bb4.a r100) {
        this.module = r100;
    }

    public static SonicGameModule_ProvideSonicGameServiceFactory create(bb4.a r100) {
        return new SonicGameModule_ProvideSonicGameServiceFactory(r100);
    }

    public static a provideInstance(bb4.a r100) {
        return proxyProvideSonicGameService(r100);
    }

    public static a proxyProvideSonicGameService(bb4.a r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNull(new d(), "Cannot return null from a non-@Nullable @Provides method");
    }
}

package com.ss.android.lark.watermark.userscope;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class WatermarkRepositoryV3_Factory implements Factory<WatermarkRepositoryV3> {
    private final Provider<Set<u0>> runtimeInfoProvidersProvider;
    private final Provider<com.ss.android.lark.storage.kv.storage.a> userKVProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userRustClientProvider;

    @Override // javax.inject.Provider
    public WatermarkRepositoryV3 get() {
        return newInstance(this.userKVProvider.get(), this.userRustClientProvider.get(), this.runtimeInfoProvidersProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public WatermarkRepositoryV3_Factory(Provider<com.ss.android.lark.storage.kv.storage.a> r100, Provider<com.bytedance.lark.rustclient.api.l> r101, Provider<Set<u0>> r102) {
        this.userKVProvider = r100;
        this.userRustClientProvider = r101;
        this.runtimeInfoProvidersProvider = r102;
    }

    public static WatermarkRepositoryV3_Factory create(Provider<com.ss.android.lark.storage.kv.storage.a> r100, Provider<com.bytedance.lark.rustclient.api.l> r101, Provider<Set<u0>> r102) {
        return new WatermarkRepositoryV3_Factory(r100, r101, r102);
    }

    public static WatermarkRepositoryV3 newInstance(com.ss.android.lark.storage.kv.storage.a r100, com.bytedance.lark.rustclient.api.l r101, Set<u0> r102) {
        return new WatermarkRepositoryV3(r100, r101, r102);
    }
}

package com.ss.android.lark.watermark.userscope;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class WatermarkModuleV3_Factory implements Factory<WatermarkModuleV3> {
    private final Provider<com.ss.android.lark.passportc.api.m> passportProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userRustClientProvider;
    private final Provider<WatermarkImplFactoryV3> watermarkImplFactoryV3Provider;

    @Override // javax.inject.Provider
    public WatermarkModuleV3 get() {
        return newInstance(this.passportProvider.get(), this.watermarkImplFactoryV3Provider.get(), this.userRustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public WatermarkModuleV3_Factory(Provider<com.ss.android.lark.passportc.api.m> r100, Provider<WatermarkImplFactoryV3> r101, Provider<com.bytedance.lark.rustclient.api.l> r102) {
        this.passportProvider = r100;
        this.watermarkImplFactoryV3Provider = r101;
        this.userRustClientProvider = r102;
    }

    public static WatermarkModuleV3_Factory create(Provider<com.ss.android.lark.passportc.api.m> r100, Provider<WatermarkImplFactoryV3> r101, Provider<com.bytedance.lark.rustclient.api.l> r102) {
        return new WatermarkModuleV3_Factory(r100, r101, r102);
    }

    public static WatermarkModuleV3 newInstance(com.ss.android.lark.passportc.api.m r100, WatermarkImplFactoryV3 r101, com.bytedance.lark.rustclient.api.l r102) {
        return new WatermarkModuleV3(r100, r101, r102);
    }
}

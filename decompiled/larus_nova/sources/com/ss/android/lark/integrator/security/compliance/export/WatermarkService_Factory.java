package com.ss.android.lark.integrator.security.compliance.export;

import com.ss.android.lark.watermark.userscope.WatermarkImplFactoryV3;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class WatermarkService_Factory implements Factory<WatermarkService> {
    private final Provider<WatermarkImplFactoryV3> watermarkImplFactoryV3Provider;
    private final Provider<com.ss.android.lark.watermark.userscope.c> watermarkModuleProvider;

    @Override // javax.inject.Provider
    public WatermarkService get() {
        return newInstance(this.watermarkImplFactoryV3Provider.get(), this.watermarkModuleProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public WatermarkService_Factory(Provider<WatermarkImplFactoryV3> r100, Provider<com.ss.android.lark.watermark.userscope.c> r101) {
        this.watermarkImplFactoryV3Provider = r100;
        this.watermarkModuleProvider = r101;
    }

    public static WatermarkService_Factory create(Provider<WatermarkImplFactoryV3> r100, Provider<com.ss.android.lark.watermark.userscope.c> r101) {
        return new WatermarkService_Factory(r100, r101);
    }

    public static WatermarkService newInstance(WatermarkImplFactoryV3 r100, com.ss.android.lark.watermark.userscope.c r101) {
        return new WatermarkService(r100, r101);
    }
}

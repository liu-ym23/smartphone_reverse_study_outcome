package com.ss.android.lark.watermark.userscope;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class WatermarkImplFactoryV3_Factory implements Factory<WatermarkImplFactoryV3> {
    private final Provider<UiThreadExecutionWatermarkImplV3> uiThreadExecutionWatermarkImplV3Provider;
    private final Provider<WatermarkAdapterV3> watermarkAdapterV3Provider;

    @Override // javax.inject.Provider
    public WatermarkImplFactoryV3 get() {
        return newInstance(this.uiThreadExecutionWatermarkImplV3Provider.get(), this.watermarkAdapterV3Provider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public WatermarkImplFactoryV3_Factory(Provider<UiThreadExecutionWatermarkImplV3> r100, Provider<WatermarkAdapterV3> r101) {
        this.uiThreadExecutionWatermarkImplV3Provider = r100;
        this.watermarkAdapterV3Provider = r101;
    }

    public static WatermarkImplFactoryV3_Factory create(Provider<UiThreadExecutionWatermarkImplV3> r100, Provider<WatermarkAdapterV3> r101) {
        return new WatermarkImplFactoryV3_Factory(r100, r101);
    }

    public static WatermarkImplFactoryV3 newInstance(UiThreadExecutionWatermarkImplV3 r100, WatermarkAdapterV3 r101) {
        return new WatermarkImplFactoryV3(r100, r101);
    }
}

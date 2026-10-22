package com.ss.android.lark.watermark.userscope;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class WatermarkAdapterV3_Factory implements Factory<WatermarkAdapterV3> {
    private final Provider<UiThreadExecutionWatermarkImplV3> watermarkInstanceProvider;

    @Override // javax.inject.Provider
    public WatermarkAdapterV3 get() {
        return newInstance(this.watermarkInstanceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public WatermarkAdapterV3_Factory(Provider<UiThreadExecutionWatermarkImplV3> r100) {
        this.watermarkInstanceProvider = r100;
    }

    public static WatermarkAdapterV3_Factory create(Provider<UiThreadExecutionWatermarkImplV3> r100) {
        return new WatermarkAdapterV3_Factory(r100);
    }

    public static WatermarkAdapterV3 newInstance(UiThreadExecutionWatermarkImplV3 r100) {
        return new WatermarkAdapterV3(r100);
    }
}

package com.ss.android.lark.watermark.userscope;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class UiThreadExecutionWatermarkImplV3_Factory implements Factory<UiThreadExecutionWatermarkImplV3> {
    private final Provider<WatermarkImplV3> delegateProvider;

    @Override // javax.inject.Provider
    public UiThreadExecutionWatermarkImplV3 get() {
        return newInstance(this.delegateProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UiThreadExecutionWatermarkImplV3_Factory(Provider<WatermarkImplV3> r100) {
        this.delegateProvider = r100;
    }

    public static UiThreadExecutionWatermarkImplV3_Factory create(Provider<WatermarkImplV3> r100) {
        return new UiThreadExecutionWatermarkImplV3_Factory(r100);
    }

    public static UiThreadExecutionWatermarkImplV3 newInstance(WatermarkImplV3 r100) {
        return new UiThreadExecutionWatermarkImplV3(r100);
    }
}

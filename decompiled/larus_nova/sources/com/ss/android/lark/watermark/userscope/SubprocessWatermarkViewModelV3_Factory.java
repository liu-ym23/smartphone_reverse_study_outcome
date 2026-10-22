package com.ss.android.lark.watermark.userscope;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class SubprocessWatermarkViewModelV3_Factory implements Factory<SubprocessWatermarkViewModelV3> {
    private final Provider<WatermarkRepositoryV3> repositoryV3Provider;
    private final Provider<ProcessSynchronizerV3> subprocessSynchronizerV3Provider;

    @Override // javax.inject.Provider
    public SubprocessWatermarkViewModelV3 get() {
        return newInstance(this.repositoryV3Provider.get(), this.subprocessSynchronizerV3Provider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SubprocessWatermarkViewModelV3_Factory(Provider<WatermarkRepositoryV3> r100, Provider<ProcessSynchronizerV3> r101) {
        this.repositoryV3Provider = r100;
        this.subprocessSynchronizerV3Provider = r101;
    }

    public static SubprocessWatermarkViewModelV3_Factory create(Provider<WatermarkRepositoryV3> r100, Provider<ProcessSynchronizerV3> r101) {
        return new SubprocessWatermarkViewModelV3_Factory(r100, r101);
    }

    public static SubprocessWatermarkViewModelV3 newInstance(WatermarkRepositoryV3 r100, ProcessSynchronizerV3 r101) {
        return new SubprocessWatermarkViewModelV3(r100, r101);
    }
}

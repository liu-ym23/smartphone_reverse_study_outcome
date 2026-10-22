package com.ss.android.lark.watermark.userscope;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class WatermarkModuleV2Module_ProvideWatermarkModuleFactory implements Factory<c> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public c get() {
        return provideWatermarkModule(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public WatermarkModuleV2Module_ProvideWatermarkModuleFactory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.internal.v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static WatermarkModuleV2Module_ProvideWatermarkModuleFactory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.internal.v> r101) {
        return new WatermarkModuleV2Module_ProvideWatermarkModuleFactory(r100, r101);
    }

    public static c provideWatermarkModule(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        int r102 = t.f445509a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        WatermarkModuleProxy r103 = new WatermarkModuleProxy(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (c) Preconditions.checkNotNullFromProvides(r103);
    }
}

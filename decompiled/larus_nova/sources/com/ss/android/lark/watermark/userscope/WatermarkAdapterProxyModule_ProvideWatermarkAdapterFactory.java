package com.ss.android.lark.watermark.userscope;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class WatermarkAdapterProxyModule_ProvideWatermarkAdapterFactory implements Factory<com.ss.android.lark.watermark.v2.p> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public com.ss.android.lark.watermark.v2.p get() {
        return provideWatermarkAdapter(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public WatermarkAdapterProxyModule_ProvideWatermarkAdapterFactory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.internal.v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static WatermarkAdapterProxyModule_ProvideWatermarkAdapterFactory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.internal.v> r101) {
        return new WatermarkAdapterProxyModule_ProvideWatermarkAdapterFactory(r100, r101);
    }

    public static com.ss.android.lark.watermark.v2.p provideWatermarkAdapter(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        int r102 = l.f445456a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        k r103 = new k(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (com.ss.android.lark.watermark.v2.p) Preconditions.checkNotNullFromProvides(r103);
    }
}

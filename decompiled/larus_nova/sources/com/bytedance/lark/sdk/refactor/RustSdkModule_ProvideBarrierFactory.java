package com.bytedance.lark.sdk.refactor;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class RustSdkModule_ProvideBarrierFactory implements Factory<e> {
    private final Provider<n> rustProvider;

    @Override // javax.inject.Provider
    public e get() {
        return provideBarrier(this.rustProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustSdkModule_ProvideBarrierFactory(Provider<n> r100) {
        this.rustProvider = r100;
    }

    public static RustSdkModule_ProvideBarrierFactory create(Provider<n> r100) {
        return new RustSdkModule_ProvideBarrierFactory(r100);
    }

    public static e provideBarrier(n r100) {
        int r101 = h0.f254272a;
        Intrinsics.checkNotNullParameter(r100, "rust");
        return (e) Preconditions.checkNotNullFromProvides(r100);
    }
}

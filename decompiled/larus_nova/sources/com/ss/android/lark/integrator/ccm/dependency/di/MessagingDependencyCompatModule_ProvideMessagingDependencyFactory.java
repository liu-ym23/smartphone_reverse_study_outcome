package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class MessagingDependencyCompatModule_ProvideMessagingDependencyFactory implements Factory<com.bytedance.ee.bear.lark.dependency.t> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final h0 module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportServiceProvider;

    @Override // javax.inject.Provider
    public com.bytedance.ee.bear.lark.dependency.t get() {
        return provideMessagingDependency(this.module, this.passportServiceProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public MessagingDependencyCompatModule_ProvideMessagingDependencyFactory(h0 r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        this.module = r100;
        this.passportServiceProvider = r101;
        this.accessorProvider = r102;
    }

    public static MessagingDependencyCompatModule_ProvideMessagingDependencyFactory create(h0 r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        return new MessagingDependencyCompatModule_ProvideMessagingDependencyFactory(r100, r101, r102);
    }

    public static com.bytedance.ee.bear.lark.dependency.t provideMessagingDependency(h0 r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.internal.v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passportService");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        j0 r103 = new j0(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (com.bytedance.ee.bear.lark.dependency.t) Preconditions.checkNotNullFromProvides(r103);
    }
}

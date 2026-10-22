package com.bytedance.ee.bear.lark.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class PassportDependencyModule_ProvidePassportDependencyFactory implements Factory<a0> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public a0 get() {
        return providePassportDependency(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PassportDependencyModule_ProvidePassportDependencyFactory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.internal.v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static PassportDependencyModule_ProvidePassportDependencyFactory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<com.ss.android.lark.passportc.internal.v> r101) {
        return new PassportDependencyModule_ProvidePassportDependencyFactory(r100, r101);
    }

    public static a0 providePassportDependency(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        int r102 = m0.f227356a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        PassportDependencyProxy r103 = new PassportDependencyProxy(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (a0) Preconditions.checkNotNullFromProvides(r103);
    }
}

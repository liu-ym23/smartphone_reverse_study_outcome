package com.bytedance.ee.bear.lark.dependency;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class PassportDependencyModule_ProvidePassportDependencyFactory implements Factory<a0> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    public a0 get() {
        return providePassportDependency((com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m426get() {
        return get();
    }

    public PassportDependencyModule_ProvidePassportDependencyFactory(Provider<com.ss.android.lark.passportc.api.j> r1, Provider<com.ss.android.lark.passportc.internal.v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static PassportDependencyModule_ProvidePassportDependencyFactory create(Provider<com.ss.android.lark.passportc.api.j> r1, Provider<com.ss.android.lark.passportc.internal.v> r2) {
        return new PassportDependencyModule_ProvidePassportDependencyFactory(r1, r2);
    }

    public static a0 providePassportDependency(com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        int r0 = m0.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        PassportDependencyProxy r3 = new PassportDependencyProxy(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (a0) Preconditions.checkNotNullFromProvides(r3);
    }
}

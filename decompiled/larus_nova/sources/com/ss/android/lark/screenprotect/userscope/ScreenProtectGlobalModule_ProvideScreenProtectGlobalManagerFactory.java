package com.ss.android.lark.screenprotect.userscope;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class ScreenProtectGlobalModule_ProvideScreenProtectGlobalManagerFactory implements Factory<a> {
    private final Provider<com.ss.android.lark.screenprotect.a> dependencyProvider;
    private final Provider<j> passportProvider;
    private final Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> requestServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideScreenProtectGlobalManager(this.passportProvider.get(), this.requestServiceProvider.get(), this.dependencyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ScreenProtectGlobalModule_ProvideScreenProtectGlobalManagerFactory(Provider<j> r100, Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> r101, Provider<com.ss.android.lark.screenprotect.a> r102) {
        this.passportProvider = r100;
        this.requestServiceProvider = r101;
        this.dependencyProvider = r102;
    }

    public static ScreenProtectGlobalModule_ProvideScreenProtectGlobalManagerFactory create(Provider<j> r100, Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> r101, Provider<com.ss.android.lark.screenprotect.a> r102) {
        return new ScreenProtectGlobalModule_ProvideScreenProtectGlobalManagerFactory(r100, r101, r102);
    }

    public static a provideScreenProtectGlobalManager(j r100, com.ss.android.lark.security.compliance.infra.network.userscpoe.a r101, com.ss.android.lark.screenprotect.a r102) {
        int r103 = f.f439848a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "requestService");
        Intrinsics.checkNotNullParameter(r102, "dependency");
        r102.a().getClass();
        ScreenProtectGlobalManager r104 = new ScreenProtectGlobalManager(r100, r101);
        r100.e(r104);
        return (a) Preconditions.checkNotNullFromProvides(r104);
    }
}

package com.bytedance.ee.bear.domain.container;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import mcb.c;
import t45.a;
import t45.b;
import t45.e;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory implements Factory<b> {
    private final Provider<m> passportProvider;
    private final Provider<c> userDomainConfigProvider;

    @Override // javax.inject.Provider
    public b get() {
        return provideDwarfDocDomainConfig(this.passportProvider.get(), this.userDomainConfigProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory(Provider<m> r100, Provider<c> r101) {
        this.passportProvider = r100;
        this.userDomainConfigProvider = r101;
    }

    public static CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory create(Provider<m> r100, Provider<c> r101) {
        return new CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory(r100, r101);
    }

    public static b provideDwarfDocDomainConfig(m r100, c r101) {
        int r102 = a.f544571a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "userDomainConfig");
        return (b) Preconditions.checkNotNullFromProvides(new e(r100, r101));
    }
}

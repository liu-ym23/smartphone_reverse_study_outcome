package com.bytedance.ee.bear.domain.container;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import s45.c;
import s45.f;
import t45.a;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory implements Factory<f> {
    private final Provider<c> domainCharacteristicServiceProvider;
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public f get() {
        return provideDwarfDomainConfigParser(this.passportProvider.get(), this.domainCharacteristicServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory(Provider<m> r100, Provider<c> r101) {
        this.passportProvider = r100;
        this.domainCharacteristicServiceProvider = r101;
    }

    public static CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory create(Provider<m> r100, Provider<c> r101) {
        return new CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory(r100, r101);
    }

    public static f provideDwarfDomainConfigParser(m r100, c r101) {
        int r102 = a.f544571a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "domainCharacteristicService");
        return (f) Preconditions.checkNotNullFromProvides(new f(r101));
    }
}

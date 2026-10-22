package com.bytedance.ee.bear.domain.container;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import s45.c;
import s45.f;
import t45.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory implements Factory<f> {
    private final Provider<c> domainCharacteristicServiceProvider;
    private final Provider<m> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public f m281get() {
        return provideDwarfDomainConfigParser((m) this.passportProvider.get(), (c) this.domainCharacteristicServiceProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m281get();
    }

    public CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory(Provider<m> r1, Provider<c> r2) {
        this.passportProvider = r1;
        this.domainCharacteristicServiceProvider = r2;
    }

    public static CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory create(Provider<m> r1, Provider<c> r2) {
        return new CCMDomainUserModule_ProvideDwarfDomainConfigParserFactory(r1, r2);
    }

    public static f provideDwarfDomainConfigParser(m r1, c r2) {
        int r0 = a.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "domainCharacteristicService");
        return (f) Preconditions.checkNotNullFromProvides(new f(r2));
    }
}

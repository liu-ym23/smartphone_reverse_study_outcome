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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory implements Factory<b> {
    private final Provider<m> passportProvider;
    private final Provider<c> userDomainConfigProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m280get() {
        return provideDwarfDocDomainConfig((m) this.passportProvider.get(), (c) this.userDomainConfigProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m280get();
    }

    public CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory(Provider<m> r1, Provider<c> r2) {
        this.passportProvider = r1;
        this.userDomainConfigProvider = r2;
    }

    public static CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory create(Provider<m> r1, Provider<c> r2) {
        return new CCMDomainUserModule_ProvideDwarfDocDomainConfigFactory(r1, r2);
    }

    public static b provideDwarfDocDomainConfig(m r1, c r2) {
        int r0 = a.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "userDomainConfig");
        return (b) Preconditions.checkNotNullFromProvides(new e(r1, r2));
    }
}

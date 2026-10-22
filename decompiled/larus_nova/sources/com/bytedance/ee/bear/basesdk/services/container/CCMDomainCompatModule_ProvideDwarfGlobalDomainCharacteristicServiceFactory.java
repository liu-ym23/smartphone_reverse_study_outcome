package com.bytedance.ee.bear.basesdk.services.container;

import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class CCMDomainCompatModule_ProvideDwarfGlobalDomainCharacteristicServiceFactory implements Factory<s45.c> {
    private final Provider<v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public s45.c get() {
        return provideDwarfGlobalDomainCharacteristicService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CCMDomainCompatModule_ProvideDwarfGlobalDomainCharacteristicServiceFactory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static CCMDomainCompatModule_ProvideDwarfGlobalDomainCharacteristicServiceFactory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101) {
        return new CCMDomainCompatModule_ProvideDwarfGlobalDomainCharacteristicServiceFactory(r100, r101);
    }

    public static s45.c provideDwarfGlobalDomainCharacteristicService(com.ss.android.lark.passportc.api.j r100, v r101) {
        int r102 = a.f206621a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        UserDomainCharacteristicServiceProxy r103 = new UserDomainCharacteristicServiceProxy(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (s45.c) Preconditions.checkNotNullFromProvides(r103);
    }
}

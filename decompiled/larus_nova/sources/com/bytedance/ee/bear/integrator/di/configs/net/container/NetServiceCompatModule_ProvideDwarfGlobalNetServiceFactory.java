package com.bytedance.ee.bear.integrator.di.configs.net.container;

import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import nb5.a;
import nb5.i;

/* JADX INFO: loaded from: classes16.dex */
public final class NetServiceCompatModule_ProvideDwarfGlobalNetServiceFactory implements Factory<NetService> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public NetService get() {
        return provideDwarfGlobalNetService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public NetServiceCompatModule_ProvideDwarfGlobalNetServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static NetServiceCompatModule_ProvideDwarfGlobalNetServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new NetServiceCompatModule_ProvideDwarfGlobalNetServiceFactory(r100, r101);
    }

    public static NetService provideDwarfGlobalNetService(j r100, v r101) {
        int r102 = a.f518500a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        i r103 = new i(r100, r101);
        h.a(r103);
        return (NetService) Preconditions.checkNotNullFromProvides(r103);
    }
}

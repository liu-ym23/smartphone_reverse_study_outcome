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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class NetServiceCompatModule_ProvideDwarfGlobalNetServiceFactory implements Factory<NetService> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public NetService get() {
        return provideDwarfGlobalNetService((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m410get() {
        return get();
    }

    public NetServiceCompatModule_ProvideDwarfGlobalNetServiceFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static NetServiceCompatModule_ProvideDwarfGlobalNetServiceFactory create(Provider<j> r1, Provider<v> r2) {
        return new NetServiceCompatModule_ProvideDwarfGlobalNetServiceFactory(r1, r2);
    }

    public static NetService provideDwarfGlobalNetService(j r1, v r2) {
        int r0 = a.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        i r3 = new i(r1, r2);
        h.a(r3);
        return (NetService) Preconditions.checkNotNullFromProvides(r3);
    }
}

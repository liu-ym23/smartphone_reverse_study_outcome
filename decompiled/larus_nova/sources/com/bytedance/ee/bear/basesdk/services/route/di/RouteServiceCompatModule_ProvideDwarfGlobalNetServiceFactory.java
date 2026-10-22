package com.bytedance.ee.bear.basesdk.services.route.di;

import com.bytedance.ee.bear.basesdk.services.route.f;
import com.bytedance.ee.bear.route.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import zn4.a;

/* JADX INFO: loaded from: classes15.dex */
public final class RouteServiceCompatModule_ProvideDwarfGlobalNetServiceFactory implements Factory<h> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public h get() {
        return provideDwarfGlobalNetService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RouteServiceCompatModule_ProvideDwarfGlobalNetServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static RouteServiceCompatModule_ProvideDwarfGlobalNetServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new RouteServiceCompatModule_ProvideDwarfGlobalNetServiceFactory(r100, r101);
    }

    public static h provideDwarfGlobalNetService(j r100, v r101) {
        int r102 = a.f572929a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        f r103 = new f(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (h) Preconditions.checkNotNullFromProvides(r103);
    }
}

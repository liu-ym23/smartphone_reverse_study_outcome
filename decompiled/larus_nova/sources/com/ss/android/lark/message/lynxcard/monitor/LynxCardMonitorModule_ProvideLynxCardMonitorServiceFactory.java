package com.ss.android.lark.message.lynxcard.monitor;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class LynxCardMonitorModule_ProvideLynxCardMonitorServiceFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideLynxCardMonitorService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LynxCardMonitorModule_ProvideLynxCardMonitorServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static LynxCardMonitorModule_ProvideLynxCardMonitorServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new LynxCardMonitorModule_ProvideLynxCardMonitorServiceFactory(r100, r101);
    }

    public static a provideLynxCardMonitorService(j r100, v r101) {
        int r102 = c.f432226a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        d r103 = new d(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}

package com.bytedance.ee.bear.drive.services;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveCoreServiceModule_ProvideDwarfGlobalDriveConfigServiceFactory implements Factory<o75.a> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final b module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public o75.a get() {
        return provideDwarfGlobalDriveConfigService(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DriveCoreServiceModule_ProvideDwarfGlobalDriveConfigServiceFactory(b r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static DriveCoreServiceModule_ProvideDwarfGlobalDriveConfigServiceFactory create(b r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        return new DriveCoreServiceModule_ProvideDwarfGlobalDriveConfigServiceFactory(r100, r101, r102);
    }

    public static o75.a provideDwarfGlobalDriveConfigService(b r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.internal.v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        o75.c r103 = new o75.c(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (o75.a) Preconditions.checkNotNullFromProvides(r103);
    }
}

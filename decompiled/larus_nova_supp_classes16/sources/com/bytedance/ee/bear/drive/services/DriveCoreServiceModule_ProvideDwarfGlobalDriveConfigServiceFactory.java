package com.bytedance.ee.bear.drive.services;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveCoreServiceModule_ProvideDwarfGlobalDriveConfigServiceFactory implements Factory<o75.a> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final b module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public o75.a m367get() {
        return provideDwarfGlobalDriveConfigService(this.module, (com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m367get();
    }

    public DriveCoreServiceModule_ProvideDwarfGlobalDriveConfigServiceFactory(b r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        this.module = r1;
        this.passportProvider = r2;
        this.accessorProvider = r3;
    }

    public static DriveCoreServiceModule_ProvideDwarfGlobalDriveConfigServiceFactory create(b r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        return new DriveCoreServiceModule_ProvideDwarfGlobalDriveConfigServiceFactory(r1, r2, r3);
    }

    public static o75.a provideDwarfGlobalDriveConfigService(b r0, com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        o75.c r3 = new o75.c(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (o75.a) Preconditions.checkNotNullFromProvides(r3);
    }
}

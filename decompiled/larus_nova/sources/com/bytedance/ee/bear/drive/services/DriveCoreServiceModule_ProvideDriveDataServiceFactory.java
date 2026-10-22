package com.bytedance.ee.bear.drive.services;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveCoreServiceModule_ProvideDriveDataServiceFactory implements Factory<c> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final b module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public c get() {
        return provideDriveDataService(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DriveCoreServiceModule_ProvideDriveDataServiceFactory(b r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static DriveCoreServiceModule_ProvideDriveDataServiceFactory create(b r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        return new DriveCoreServiceModule_ProvideDriveDataServiceFactory(r100, r101, r102);
    }

    public static c provideDriveDataService(b r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.internal.v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        o85.a r103 = new o85.a(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (c) Preconditions.checkNotNullFromProvides(r103);
    }
}

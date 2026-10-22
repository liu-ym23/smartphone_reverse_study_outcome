package com.bytedance.ee.bear.drive.services;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveCoreServiceModule_ProvideDrivePreviewServiceFactory implements Factory<com.bytedance.ee.drive.preview.f> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final b module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportServiceProvider;

    @Override // javax.inject.Provider
    public com.bytedance.ee.drive.preview.f get() {
        return provideDrivePreviewService(this.module, this.passportServiceProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DriveCoreServiceModule_ProvideDrivePreviewServiceFactory(b r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        this.module = r100;
        this.passportServiceProvider = r101;
        this.accessorProvider = r102;
    }

    public static DriveCoreServiceModule_ProvideDrivePreviewServiceFactory create(b r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<com.ss.android.lark.passportc.internal.v> r102) {
        return new DriveCoreServiceModule_ProvideDrivePreviewServiceFactory(r100, r101, r102);
    }

    public static com.bytedance.ee.drive.preview.f provideDrivePreviewService(b r100, com.ss.android.lark.passportc.api.j r101, com.ss.android.lark.passportc.internal.v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passportService");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        com.bytedance.ee.drive.preview.b r103 = new com.bytedance.ee.drive.preview.b(r101, r102);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (com.bytedance.ee.drive.preview.f) Preconditions.checkNotNullFromProvides(r103);
    }
}

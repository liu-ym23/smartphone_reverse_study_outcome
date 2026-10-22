package com.bytedance.ee.bear.drive.services;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveCoreServiceModule_ProvideDriveCacheServiceFactory implements Factory<com.bytedance.ee.bear.drive.cache.w> {
    private final Provider<com.ss.android.lark.passportc.internal.v> accessorProvider;
    private final b module;
    private final Provider<com.ss.android.lark.passportc.api.j> passportServiceProvider;

    public com.bytedance.ee.bear.drive.cache.w get() {
        return provideDriveCacheService(this.module, (com.ss.android.lark.passportc.api.j) this.passportServiceProvider.get(), (com.ss.android.lark.passportc.internal.v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m363get() {
        return get();
    }

    public DriveCoreServiceModule_ProvideDriveCacheServiceFactory(b r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        this.module = r1;
        this.passportServiceProvider = r2;
        this.accessorProvider = r3;
    }

    public static DriveCoreServiceModule_ProvideDriveCacheServiceFactory create(b r1, Provider<com.ss.android.lark.passportc.api.j> r2, Provider<com.ss.android.lark.passportc.internal.v> r3) {
        return new DriveCoreServiceModule_ProvideDriveCacheServiceFactory(r1, r2, r3);
    }

    public static com.bytedance.ee.bear.drive.cache.w provideDriveCacheService(b r0, com.ss.android.lark.passportc.api.j r1, com.ss.android.lark.passportc.internal.v r2) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "passportService");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        com.bytedance.ee.bear.drive.cache.v r3 = new com.bytedance.ee.bear.drive.cache.v(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (com.bytedance.ee.bear.drive.cache.w) Preconditions.checkNotNullFromProvides(r3);
    }
}

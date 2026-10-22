package com.bytedance.ee.bear.drive.module.user;

import com.bytedance.ee.bear.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import o85.b;
import o85.e;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveUserInterfaceServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory implements Factory<h> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public h get() {
        return provideDwarfGlobalUserInterfaceService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DriveUserInterfaceServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static DriveUserInterfaceServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new DriveUserInterfaceServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory(r100, r101);
    }

    public static h provideDwarfGlobalUserInterfaceService(j r100, v r101) {
        int r102 = e.f522383a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        b r103 = new b(r100, r101);
        com.ss.android.lark.passportc.api.h.a(r103);
        return (h) Preconditions.checkNotNullFromProvides(r103);
    }
}

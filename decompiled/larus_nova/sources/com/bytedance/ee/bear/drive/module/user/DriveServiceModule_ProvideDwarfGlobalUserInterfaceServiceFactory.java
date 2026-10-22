package com.bytedance.ee.bear.drive.module.user;

import com.bytedance.ee.bear.drive.services.w;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import o85.c;
import o85.d;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory implements Factory<w> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public w get() {
        return provideDwarfGlobalUserInterfaceService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DriveServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static DriveServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new DriveServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory(r100, r101);
    }

    public static w provideDwarfGlobalUserInterfaceService(j r100, v r101) {
        int r102 = c.f522379a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        d r103 = new d(r100, r101);
        h.a(r103);
        return (w) Preconditions.checkNotNullFromProvides(r103);
    }
}

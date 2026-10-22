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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveUserInterfaceServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory implements Factory<h> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public h get() {
        return provideDwarfGlobalUserInterfaceService((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m356get() {
        return get();
    }

    public DriveUserInterfaceServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static DriveUserInterfaceServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory create(Provider<j> r1, Provider<v> r2) {
        return new DriveUserInterfaceServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory(r1, r2);
    }

    public static h provideDwarfGlobalUserInterfaceService(j r1, v r2) {
        int r0 = e.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        b r3 = new b(r1, r2);
        com.ss.android.lark.passportc.api.h.a(r3);
        return (h) Preconditions.checkNotNullFromProvides(r3);
    }
}

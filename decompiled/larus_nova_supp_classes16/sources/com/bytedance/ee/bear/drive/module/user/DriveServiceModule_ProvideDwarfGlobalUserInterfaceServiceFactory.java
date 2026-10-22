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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory implements Factory<w> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    public w get() {
        return provideDwarfGlobalUserInterfaceService((j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m355get() {
        return get();
    }

    public DriveServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory(Provider<j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static DriveServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory create(Provider<j> r1, Provider<v> r2) {
        return new DriveServiceModule_ProvideDwarfGlobalUserInterfaceServiceFactory(r1, r2);
    }

    public static w provideDwarfGlobalUserInterfaceService(j r1, v r2) {
        int r0 = c.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        d r3 = new d(r1, r2);
        h.a(r3);
        return (w) Preconditions.checkNotNullFromProvides(r3);
    }
}

package com.ss.android.lark.conditional.access.display;

import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class DeviceManagementServiceGlobalModule_ProvideCustomDisplayModuleFactory implements Factory<g> {
    private final Provider<v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public g get() {
        return provideCustomDisplayModule(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DeviceManagementServiceGlobalModule_ProvideCustomDisplayModuleFactory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static DeviceManagementServiceGlobalModule_ProvideCustomDisplayModuleFactory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101) {
        return new DeviceManagementServiceGlobalModule_ProvideCustomDisplayModuleFactory(r100, r101);
    }

    public static g provideCustomDisplayModule(com.ss.android.lark.passportc.api.j r100, v r101) {
        int r102 = f.f418067a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        return (g) Preconditions.checkNotNullFromProvides(new c(r100, r101));
    }
}

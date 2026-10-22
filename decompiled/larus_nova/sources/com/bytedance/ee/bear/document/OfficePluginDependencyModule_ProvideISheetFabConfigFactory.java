package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficePluginDependencyModule_ProvideISheetFabConfigFactory implements Factory<ew4.e0> {
    private final r5 module;
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public ew4.e0 get() {
        return provideISheetFabConfig(this.module, this.uidProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficePluginDependencyModule_ProvideISheetFabConfigFactory(r5 r100, Provider<String> r101) {
        this.module = r100;
        this.uidProvider = r101;
    }

    public static OfficePluginDependencyModule_ProvideISheetFabConfigFactory create(r5 r100, Provider<String> r101) {
        return new OfficePluginDependencyModule_ProvideISheetFabConfigFactory(r100, r101);
    }

    public static ew4.e0 provideISheetFabConfig(r5 r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "uid");
        Object r102 = (ew4.e0) OfficeSDKManager.getHostUserService(r101, ew4.e0.class);
        if (r102 != null) goto L6;
        r102 = new o5();
    L6:
        return (ew4.e0) Preconditions.checkNotNullFromProvides(r102);
    }
}

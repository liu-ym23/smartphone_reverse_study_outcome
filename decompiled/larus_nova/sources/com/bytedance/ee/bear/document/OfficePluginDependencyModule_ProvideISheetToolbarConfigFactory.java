package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficePluginDependencyModule_ProvideISheetToolbarConfigFactory implements Factory<ew4.g0> {
    private final r5 module;
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public ew4.g0 get() {
        return provideISheetToolbarConfig(this.module, this.uidProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficePluginDependencyModule_ProvideISheetToolbarConfigFactory(r5 r100, Provider<String> r101) {
        this.module = r100;
        this.uidProvider = r101;
    }

    public static OfficePluginDependencyModule_ProvideISheetToolbarConfigFactory create(r5 r100, Provider<String> r101) {
        return new OfficePluginDependencyModule_ProvideISheetToolbarConfigFactory(r100, r101);
    }

    public static ew4.g0 provideISheetToolbarConfig(r5 r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "uid");
        Object r102 = (ew4.g0) OfficeSDKManager.getHostUserService(r101, ew4.g0.class);
        if (r102 != null) goto L6;
        r102 = new q5();
    L6:
        return (ew4.g0) Preconditions.checkNotNullFromProvides(r102);
    }
}

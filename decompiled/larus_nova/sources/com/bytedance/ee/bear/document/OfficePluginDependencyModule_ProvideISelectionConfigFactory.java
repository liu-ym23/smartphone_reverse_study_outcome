package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficePluginDependencyModule_ProvideISelectionConfigFactory implements Factory<gm5.a> {
    private final r5 module;
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public gm5.a get() {
        return provideISelectionConfig(this.module, this.uidProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficePluginDependencyModule_ProvideISelectionConfigFactory(r5 r100, Provider<String> r101) {
        this.module = r100;
        this.uidProvider = r101;
    }

    public static OfficePluginDependencyModule_ProvideISelectionConfigFactory create(r5 r100, Provider<String> r101) {
        return new OfficePluginDependencyModule_ProvideISelectionConfigFactory(r100, r101);
    }

    public static gm5.a provideISelectionConfig(r5 r100, String r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "uid");
        gm5.a r102 = (gm5.a) OfficeSDKManager.getHostUserService(r101, gm5.a.class);
        if (r102 != null) goto L6;
        r102 = new OfficePluginDependencyModule$provideISelectionConfig$1();
    L6:
        return (gm5.a) Preconditions.checkNotNullFromProvides(r102);
    }
}

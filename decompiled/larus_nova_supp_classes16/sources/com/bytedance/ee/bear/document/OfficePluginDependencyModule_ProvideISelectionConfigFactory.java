package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficePluginDependencyModule_ProvideISelectionConfigFactory implements Factory<gm5.a> {
    private final r5 module;
    private final Provider<String> uidProvider;

    public gm5.a get() {
        return provideISelectionConfig(this.module, (String) this.uidProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m175get() {
        return get();
    }

    public OfficePluginDependencyModule_ProvideISelectionConfigFactory(r5 r1, Provider<String> r2) {
        this.module = r1;
        this.uidProvider = r2;
    }

    public static OfficePluginDependencyModule_ProvideISelectionConfigFactory create(r5 r1, Provider<String> r2) {
        return new OfficePluginDependencyModule_ProvideISelectionConfigFactory(r1, r2);
    }

    public static gm5.a provideISelectionConfig(r5 r0, String r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "uid");
        gm5.a r2 = OfficeSDKManager.getHostUserService(r1, gm5.a.class);
        if (r2 != null) goto L6;
        r2 = new OfficePluginDependencyModule$provideISelectionConfig$1();
    L6:
        return (gm5.a) Preconditions.checkNotNullFromProvides(r2);
    }
}

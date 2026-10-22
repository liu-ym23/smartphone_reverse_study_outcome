package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficePluginDependencyModule_ProvideIBitableFabConfigFactory implements Factory<ew4.x> {
    private final r5 module;
    private final Provider<String> uidProvider;

    public ew4.x get() {
        return provideIBitableFabConfig(this.module, (String) this.uidProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m169get() {
        return get();
    }

    public OfficePluginDependencyModule_ProvideIBitableFabConfigFactory(r5 r1, Provider<String> r2) {
        this.module = r1;
        this.uidProvider = r2;
    }

    public static OfficePluginDependencyModule_ProvideIBitableFabConfigFactory create(r5 r1, Provider<String> r2) {
        return new OfficePluginDependencyModule_ProvideIBitableFabConfigFactory(r1, r2);
    }

    public static ew4.x provideIBitableFabConfig(r5 r0, String r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "uid");
        Object r2 = (ew4.x) OfficeSDKManager.getHostUserService(r1, ew4.x.class);
        if (r2 != null) goto L6;
        r2 = new m5();
    L6:
        return (ew4.x) Preconditions.checkNotNullFromProvides(r2);
    }
}

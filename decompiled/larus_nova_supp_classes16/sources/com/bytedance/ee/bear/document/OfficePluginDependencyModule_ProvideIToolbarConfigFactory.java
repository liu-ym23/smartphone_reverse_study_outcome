package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficePluginDependencyModule_ProvideIToolbarConfigFactory implements Factory<an4.a> {
    private final r5 module;
    private final Provider<String> uidProvider;

    public an4.a get() {
        return provideIToolbarConfig(this.module, (String) this.uidProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m179get() {
        return get();
    }

    public OfficePluginDependencyModule_ProvideIToolbarConfigFactory(r5 r1, Provider<String> r2) {
        this.module = r1;
        this.uidProvider = r2;
    }

    public static OfficePluginDependencyModule_ProvideIToolbarConfigFactory create(r5 r1, Provider<String> r2) {
        return new OfficePluginDependencyModule_ProvideIToolbarConfigFactory(r1, r2);
    }

    public static an4.a provideIToolbarConfig(r5 r0, String r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "uid");
        an4.a r2 = OfficeSDKManager.getHostUserService(r1, an4.a.class);
        if (r2 != null) goto L6;
        r2 = new OfficePluginDependencyModule$provideIToolbarConfig$1();
    L6:
        return (an4.a) Preconditions.checkNotNullFromProvides(r2);
    }
}

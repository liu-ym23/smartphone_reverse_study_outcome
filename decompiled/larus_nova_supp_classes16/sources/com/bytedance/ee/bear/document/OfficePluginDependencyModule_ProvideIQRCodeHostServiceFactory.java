package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficePluginDependencyModule_ProvideIQRCodeHostServiceFactory implements Factory<ew4.c0> {
    private final r5 module;
    private final Provider<String> uidProvider;

    public ew4.c0 get() {
        return provideIQRCodeHostService(this.module, (String) this.uidProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m174get() {
        return get();
    }

    public OfficePluginDependencyModule_ProvideIQRCodeHostServiceFactory(r5 r1, Provider<String> r2) {
        this.module = r1;
        this.uidProvider = r2;
    }

    public static OfficePluginDependencyModule_ProvideIQRCodeHostServiceFactory create(r5 r1, Provider<String> r2) {
        return new OfficePluginDependencyModule_ProvideIQRCodeHostServiceFactory(r1, r2);
    }

    public static ew4.c0 provideIQRCodeHostService(r5 r0, String r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "uid");
        Object r2 = (ew4.c0) OfficeSDKManager.getHostUserService(r1, ew4.c0.class);
        if (r2 != null) goto L6;
        r2 = ew4.v.a;
    L6:
        return (ew4.c0) Preconditions.checkNotNullFromProvides(r2);
    }
}

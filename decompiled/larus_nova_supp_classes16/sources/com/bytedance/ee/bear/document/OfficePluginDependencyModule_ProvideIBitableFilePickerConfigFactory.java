package com.bytedance.ee.bear.document;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficePluginDependencyModule_ProvideIBitableFilePickerConfigFactory implements Factory<ew4.y> {
    private final r5 module;
    private final Provider<String> uidProvider;

    public ew4.y get() {
        return provideIBitableFilePickerConfig(this.module, (String) this.uidProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m170get() {
        return get();
    }

    public OfficePluginDependencyModule_ProvideIBitableFilePickerConfigFactory(r5 r1, Provider<String> r2) {
        this.module = r1;
        this.uidProvider = r2;
    }

    public static OfficePluginDependencyModule_ProvideIBitableFilePickerConfigFactory create(r5 r1, Provider<String> r2) {
        return new OfficePluginDependencyModule_ProvideIBitableFilePickerConfigFactory(r1, r2);
    }

    public static ew4.y provideIBitableFilePickerConfig(r5 r0, String r1) {
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "uid");
        Object r2 = (ew4.y) OfficeSDKManager.getHostUserService(r1, ew4.y.class);
        if (r2 != null) goto L6;
        r2 = new ew4.s();
    L6:
        return (ew4.y) Preconditions.checkNotNullFromProvides(r2);
    }
}

package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class LarkInjectContainerDaggerModule_ProvidesCommandMoltenServiceGlobalFactory implements Factory<d> {
    private final Provider<LarkInjectContainerExportedModuleWrapper> containerProvider;
    private final e module;

    public d get() {
        return providesCommandMoltenServiceGlobal(null, (LarkInjectContainerExportedModuleWrapper) this.containerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m513get() {
        return get();
    }

    public LarkInjectContainerDaggerModule_ProvidesCommandMoltenServiceGlobalFactory(e r1, Provider<LarkInjectContainerExportedModuleWrapper> r2) {
        this.containerProvider = r2;
    }

    public static LarkInjectContainerDaggerModule_ProvidesCommandMoltenServiceGlobalFactory create(e r1, Provider<LarkInjectContainerExportedModuleWrapper> r2) {
        return new LarkInjectContainerDaggerModule_ProvidesCommandMoltenServiceGlobalFactory(r1, r2);
    }

    public static d providesCommandMoltenServiceGlobal(e r0, LarkInjectContainerExportedModuleWrapper r1) {
        throw null;
    }
}

package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class LarkInjectContainerDaggerModule_ProvidesCommandMoltenServiceGlobalFactory implements Factory<d> {
    private final Provider<LarkInjectContainerExportedModuleWrapper> containerProvider;
    private final e module;

    @Override // javax.inject.Provider
    public d get() {
        return providesCommandMoltenServiceGlobal(null, this.containerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkInjectContainerDaggerModule_ProvidesCommandMoltenServiceGlobalFactory(e r100, Provider<LarkInjectContainerExportedModuleWrapper> r101) {
        this.containerProvider = r101;
    }

    public static LarkInjectContainerDaggerModule_ProvidesCommandMoltenServiceGlobalFactory create(e r100, Provider<LarkInjectContainerExportedModuleWrapper> r101) {
        return new LarkInjectContainerDaggerModule_ProvidesCommandMoltenServiceGlobalFactory(r100, r101);
    }

    public static d providesCommandMoltenServiceGlobal(e r100, LarkInjectContainerExportedModuleWrapper r101) {
        throw null;
    }
}

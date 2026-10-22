package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.lark.view_flow_wrapper.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class LarkInjectContainerDaggerModule_ProvidesLarkInjectContainerExportedModuleFactory implements Factory<LarkInjectContainerExportedModuleWrapper> {
    private final e module;
    private final Provider<v> strategyProvider;

    @Override // javax.inject.Provider
    public LarkInjectContainerExportedModuleWrapper get() {
        return providesLarkInjectContainerExportedModule(null, this.strategyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkInjectContainerDaggerModule_ProvidesLarkInjectContainerExportedModuleFactory(e r100, Provider<v> r101) {
        this.strategyProvider = r101;
    }

    public static LarkInjectContainerDaggerModule_ProvidesLarkInjectContainerExportedModuleFactory create(e r100, Provider<v> r101) {
        return new LarkInjectContainerDaggerModule_ProvidesLarkInjectContainerExportedModuleFactory(r100, r101);
    }

    public static LarkInjectContainerExportedModuleWrapper providesLarkInjectContainerExportedModule(e r100, v r101) {
        throw null;
    }
}

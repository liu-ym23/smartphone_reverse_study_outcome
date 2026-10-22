package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.lark.view_flow_wrapper.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class LarkInjectContainerDaggerModule_ProvidesLarkInjectContainerExportedModuleFactory implements Factory<LarkInjectContainerExportedModuleWrapper> {
    private final e module;
    private final Provider<v> strategyProvider;

    public LarkInjectContainerExportedModuleWrapper get() {
        return providesLarkInjectContainerExportedModule(null, (v) this.strategyProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m514get() {
        return get();
    }

    public LarkInjectContainerDaggerModule_ProvidesLarkInjectContainerExportedModuleFactory(e r1, Provider<v> r2) {
        this.strategyProvider = r2;
    }

    public static LarkInjectContainerDaggerModule_ProvidesLarkInjectContainerExportedModuleFactory create(e r1, Provider<v> r2) {
        return new LarkInjectContainerDaggerModule_ProvidesLarkInjectContainerExportedModuleFactory(r1, r2);
    }

    public static LarkInjectContainerExportedModuleWrapper providesLarkInjectContainerExportedModule(e r0, v r1) {
        throw null;
    }
}

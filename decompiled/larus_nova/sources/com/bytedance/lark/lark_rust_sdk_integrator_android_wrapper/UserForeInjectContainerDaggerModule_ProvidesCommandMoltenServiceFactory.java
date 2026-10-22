package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class UserForeInjectContainerDaggerModule_ProvidesCommandMoltenServiceFactory implements Factory<c> {
    private final Provider<UserForeInjectContainerExportedModuleWrapper> containerProvider;
    private final f module;

    @Override // javax.inject.Provider
    public c get() {
        return providesCommandMoltenService(null, this.containerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserForeInjectContainerDaggerModule_ProvidesCommandMoltenServiceFactory(f r100, Provider<UserForeInjectContainerExportedModuleWrapper> r101) {
        this.containerProvider = r101;
    }

    public static UserForeInjectContainerDaggerModule_ProvidesCommandMoltenServiceFactory create(f r100, Provider<UserForeInjectContainerExportedModuleWrapper> r101) {
        return new UserForeInjectContainerDaggerModule_ProvidesCommandMoltenServiceFactory(r100, r101);
    }

    public static c providesCommandMoltenService(f r100, UserForeInjectContainerExportedModuleWrapper r101) {
        throw null;
    }
}

package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class UserForeInjectContainerDaggerModule_ProvidesCommandMoltenServiceFactory implements Factory<c> {
    private final Provider<UserForeInjectContainerExportedModuleWrapper> containerProvider;
    private final f module;

    public c get() {
        return providesCommandMoltenService(null, (UserForeInjectContainerExportedModuleWrapper) this.containerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m517get() {
        return get();
    }

    public UserForeInjectContainerDaggerModule_ProvidesCommandMoltenServiceFactory(f r1, Provider<UserForeInjectContainerExportedModuleWrapper> r2) {
        this.containerProvider = r2;
    }

    public static UserForeInjectContainerDaggerModule_ProvidesCommandMoltenServiceFactory create(f r1, Provider<UserForeInjectContainerExportedModuleWrapper> r2) {
        return new UserForeInjectContainerDaggerModule_ProvidesCommandMoltenServiceFactory(r1, r2);
    }

    public static c providesCommandMoltenService(f r0, UserForeInjectContainerExportedModuleWrapper r1) {
        throw null;
    }
}

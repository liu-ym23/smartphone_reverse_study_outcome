package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.lark.lark_rust_sdk_integrator_android.l;
import com.bytedance.lark.view_flow_wrapper.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class UserForeInjectContainerDaggerModule_ProvidesUserForeInjectContainerExportedModuleFactory implements Factory<UserForeInjectContainerExportedModuleWrapper> {
    private final f module;
    private final Provider<l> param0Provider;
    private final Provider<v> strategyProvider;

    @Override // javax.inject.Provider
    public UserForeInjectContainerExportedModuleWrapper get() {
        return providesUserForeInjectContainerExportedModule(null, this.param0Provider.get(), this.strategyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserForeInjectContainerDaggerModule_ProvidesUserForeInjectContainerExportedModuleFactory(f r100, Provider<l> r101, Provider<v> r102) {
        this.param0Provider = r101;
        this.strategyProvider = r102;
    }

    public static UserForeInjectContainerDaggerModule_ProvidesUserForeInjectContainerExportedModuleFactory create(f r100, Provider<l> r101, Provider<v> r102) {
        return new UserForeInjectContainerDaggerModule_ProvidesUserForeInjectContainerExportedModuleFactory(r100, r101, r102);
    }

    public static UserForeInjectContainerExportedModuleWrapper providesUserForeInjectContainerExportedModule(f r100, l r101, v r102) {
        throw null;
    }
}

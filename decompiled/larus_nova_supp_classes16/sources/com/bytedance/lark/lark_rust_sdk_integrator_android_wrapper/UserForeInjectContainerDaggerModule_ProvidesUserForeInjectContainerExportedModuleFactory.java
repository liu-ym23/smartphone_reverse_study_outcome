package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.lark.lark_rust_sdk_integrator_android.l;
import com.bytedance.lark.view_flow_wrapper.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class UserForeInjectContainerDaggerModule_ProvidesUserForeInjectContainerExportedModuleFactory implements Factory<UserForeInjectContainerExportedModuleWrapper> {
    private final f module;
    private final Provider<l> param0Provider;
    private final Provider<v> strategyProvider;

    public UserForeInjectContainerExportedModuleWrapper get() {
        return providesUserForeInjectContainerExportedModule(null, (l) this.param0Provider.get(), (v) this.strategyProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m519get() {
        return get();
    }

    public UserForeInjectContainerDaggerModule_ProvidesUserForeInjectContainerExportedModuleFactory(f r1, Provider<l> r2, Provider<v> r3) {
        this.param0Provider = r2;
        this.strategyProvider = r3;
    }

    public static UserForeInjectContainerDaggerModule_ProvidesUserForeInjectContainerExportedModuleFactory create(f r1, Provider<l> r2, Provider<v> r3) {
        return new UserForeInjectContainerDaggerModule_ProvidesUserForeInjectContainerExportedModuleFactory(r1, r2, r3);
    }

    public static UserForeInjectContainerExportedModuleWrapper providesUserForeInjectContainerExportedModule(f r0, l r1, v r2) {
        throw null;
    }
}

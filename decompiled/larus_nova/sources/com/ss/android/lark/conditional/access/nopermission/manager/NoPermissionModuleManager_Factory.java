package com.ss.android.lark.conditional.access.nopermission.manager;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class NoPermissionModuleManager_Factory implements Factory<NoPermissionModuleManager> {
    private final Provider<k8b.c> conditionalAccessDependencyProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;
    private final Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> scRequestProvider;

    @Override // javax.inject.Provider
    public NoPermissionModuleManager get() {
        return newInstance(this.scRequestProvider.get(), this.passportProvider.get(), this.conditionalAccessDependencyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public NoPermissionModuleManager_Factory(Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<k8b.c> r102) {
        this.scRequestProvider = r100;
        this.passportProvider = r101;
        this.conditionalAccessDependencyProvider = r102;
    }

    public static NoPermissionModuleManager_Factory create(Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> r100, Provider<com.ss.android.lark.passportc.api.j> r101, Provider<k8b.c> r102) {
        return new NoPermissionModuleManager_Factory(r100, r101, r102);
    }

    public static NoPermissionModuleManager newInstance(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r100, com.ss.android.lark.passportc.api.j r101, k8b.c r102) {
        return new NoPermissionModuleManager(r100, r101, r102);
    }
}

package com.ss.android.lark.audit.userscope.auth;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AuthDataServiceGlobalScope_Factory implements Factory<AuthDataServiceGlobalScope> {
    private final Provider<jdb.e> globalFGServiceProvider;
    private final Provider<com.bytedance.lark.rustclient.api.h> globalRustServiceProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;
    private final Provider<PermissionDataService> permissionDataServiceProvider;

    @Override // javax.inject.Provider
    public AuthDataServiceGlobalScope get() {
        return newInstance(this.passportProvider.get(), this.permissionDataServiceProvider.get(), this.globalRustServiceProvider.get(), this.globalFGServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuthDataServiceGlobalScope_Factory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<PermissionDataService> r101, Provider<com.bytedance.lark.rustclient.api.h> r102, Provider<jdb.e> r103) {
        this.passportProvider = r100;
        this.permissionDataServiceProvider = r101;
        this.globalRustServiceProvider = r102;
        this.globalFGServiceProvider = r103;
    }

    public static AuthDataServiceGlobalScope_Factory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<PermissionDataService> r101, Provider<com.bytedance.lark.rustclient.api.h> r102, Provider<jdb.e> r103) {
        return new AuthDataServiceGlobalScope_Factory(r100, r101, r102, r103);
    }

    public static AuthDataServiceGlobalScope newInstance(com.ss.android.lark.passportc.api.j r100, PermissionDataService r101, com.bytedance.lark.rustclient.api.h r102, jdb.e r103) {
        return new AuthDataServiceGlobalScope(r100, r101, r102, r103);
    }
}

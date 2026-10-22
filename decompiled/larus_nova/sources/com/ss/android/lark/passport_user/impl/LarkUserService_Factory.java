package com.ss.android.lark.passport_user.impl;

import a0c.b;
import dagger.internal.Factory;
import izb.a;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class LarkUserService_Factory implements Factory<b> {
    private final Provider<a> environmentDependencyProvider;
    private final Provider<kzb.b> globalEnvironmentServiceProvider;
    private final Provider<yzb.b> larkUserListServiceProvider;
    private final Provider<String> uidProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.uidProvider.get(), this.larkUserListServiceProvider.get(), this.globalEnvironmentServiceProvider.get(), this.environmentDependencyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkUserService_Factory(Provider<String> r100, Provider<yzb.b> r101, Provider<kzb.b> r102, Provider<a> r103) {
        this.uidProvider = r100;
        this.larkUserListServiceProvider = r101;
        this.globalEnvironmentServiceProvider = r102;
        this.environmentDependencyProvider = r103;
    }

    public static LarkUserService_Factory create(Provider<String> r100, Provider<yzb.b> r101, Provider<kzb.b> r102, Provider<a> r103) {
        return new LarkUserService_Factory(r100, r101, r102, r103);
    }

    public static b newInstance(String r100, yzb.b r101, kzb.b r102, a r103) {
        return new b(r100, r101, r102, r103);
    }
}

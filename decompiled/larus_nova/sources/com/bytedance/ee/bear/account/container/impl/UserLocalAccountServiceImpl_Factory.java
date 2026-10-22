package com.bytedance.ee.bear.account.container.impl;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.a0;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes15.dex */
public final class UserLocalAccountServiceImpl_Factory implements Factory<c> {
    private final Provider<com.bytedance.ee.util.db.a> dbControllerProvider;
    private final Provider<by4.d> kvStoreProvider;
    private final Provider<NetService> netServiceProvider;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<a0> userAccountInfoServiceProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.passportUserServiceProvider.get(), this.userAccountInfoServiceProvider.get(), this.netServiceProvider.get(), this.dbControllerProvider.get(), this.kvStoreProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserLocalAccountServiceImpl_Factory(Provider<m> r100, Provider<a0> r101, Provider<NetService> r102, Provider<com.bytedance.ee.util.db.a> r103, Provider<by4.d> r104) {
        this.passportUserServiceProvider = r100;
        this.userAccountInfoServiceProvider = r101;
        this.netServiceProvider = r102;
        this.dbControllerProvider = r103;
        this.kvStoreProvider = r104;
    }

    public static UserLocalAccountServiceImpl_Factory create(Provider<m> r100, Provider<a0> r101, Provider<NetService> r102, Provider<com.bytedance.ee.util.db.a> r110, Provider<by4.d> r111) {
        return new UserLocalAccountServiceImpl_Factory(r100, r101, r102, r110, r111);
    }

    public static c newInstance(m r100, a0 r101, NetService r102, com.bytedance.ee.util.db.a r110, by4.d r111) {
        return new c(r100, r101, r102, r110, r111);
    }
}

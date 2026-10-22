package com.bytedance.ee.bear.basesdk.services.container;

import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes15.dex */
public final class UserDomainCharacteristicServiceImpl_Factory implements Factory<g> {
    private final Provider<t45.b> docDomainConfigProvider;
    private final Provider<by4.d> kvStoreProvider;
    private final Provider<NetService> netServiceProvider;
    private final Provider<m> passportUserServiceProvider;

    @Override // javax.inject.Provider
    public g get() {
        return newInstance(this.kvStoreProvider.get(), this.netServiceProvider.get(), this.docDomainConfigProvider.get(), this.passportUserServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserDomainCharacteristicServiceImpl_Factory(Provider<by4.d> r100, Provider<NetService> r101, Provider<t45.b> r102, Provider<m> r103) {
        this.kvStoreProvider = r100;
        this.netServiceProvider = r101;
        this.docDomainConfigProvider = r102;
        this.passportUserServiceProvider = r103;
    }

    public static UserDomainCharacteristicServiceImpl_Factory create(Provider<by4.d> r100, Provider<NetService> r101, Provider<t45.b> r102, Provider<m> r103) {
        return new UserDomainCharacteristicServiceImpl_Factory(r100, r101, r102, r103);
    }

    public static g newInstance(by4.d r100, NetService r101, t45.b r102, m r103) {
        return new g(r100, r101, r102, r103);
    }
}

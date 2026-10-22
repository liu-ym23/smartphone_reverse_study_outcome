package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes18.dex */
public final class BenefitManagerImpl_Factory implements Factory<BenefitManagerImpl> {
    private final Provider<com.bytedance.ee.util.db.a> dbControllerProvider;
    private final Provider<by4.b> kvStorageProvider;
    private final Provider<NetService> netServiceProvider;
    private final Provider<m> passportUserServiceProvider;

    @Override // javax.inject.Provider
    public BenefitManagerImpl get() {
        return newInstance(this.netServiceProvider.get(), this.passportUserServiceProvider.get(), this.kvStorageProvider.get(), this.dbControllerProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public BenefitManagerImpl_Factory(Provider<NetService> r100, Provider<m> r101, Provider<by4.b> r102, Provider<com.bytedance.ee.util.db.a> r103) {
        this.netServiceProvider = r100;
        this.passportUserServiceProvider = r101;
        this.kvStorageProvider = r102;
        this.dbControllerProvider = r103;
    }

    public static BenefitManagerImpl_Factory create(Provider<NetService> r100, Provider<m> r101, Provider<by4.b> r102, Provider<com.bytedance.ee.util.db.a> r103) {
        return new BenefitManagerImpl_Factory(r100, r101, r102, r103);
    }

    public static BenefitManagerImpl newInstance(NetService r100, m r101, by4.b r102, com.bytedance.ee.util.db.a r103) {
        return new BenefitManagerImpl(r100, r101, r102, r103);
    }
}

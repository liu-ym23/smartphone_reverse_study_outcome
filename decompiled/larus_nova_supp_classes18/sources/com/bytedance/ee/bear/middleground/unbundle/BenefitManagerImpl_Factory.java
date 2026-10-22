package com.bytedance.ee.bear.middleground.unbundle;

import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BenefitManagerImpl_Factory implements Factory<BenefitManagerImpl> {
    private final Provider<com.bytedance.ee.util.db.a> dbControllerProvider;
    private final Provider<by4.b> kvStorageProvider;
    private final Provider<NetService> netServiceProvider;
    private final Provider<m> passportUserServiceProvider;

    public BenefitManagerImpl get() {
        return newInstance((NetService) this.netServiceProvider.get(), (m) this.passportUserServiceProvider.get(), (by4.b) this.kvStorageProvider.get(), (com.bytedance.ee.util.db.a) this.dbControllerProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m299get() {
        return get();
    }

    public BenefitManagerImpl_Factory(Provider<NetService> r1, Provider<m> r2, Provider<by4.b> r3, Provider<com.bytedance.ee.util.db.a> r4) {
        this.netServiceProvider = r1;
        this.passportUserServiceProvider = r2;
        this.kvStorageProvider = r3;
        this.dbControllerProvider = r4;
    }

    public static BenefitManagerImpl_Factory create(Provider<NetService> r1, Provider<m> r2, Provider<by4.b> r3, Provider<com.bytedance.ee.util.db.a> r4) {
        return new BenefitManagerImpl_Factory(r1, r2, r3, r4);
    }

    public static BenefitManagerImpl newInstance(NetService r1, m r2, by4.b r3, com.bytedance.ee.util.db.a r4) {
        return new BenefitManagerImpl(r1, r2, r3, r4);
    }
}

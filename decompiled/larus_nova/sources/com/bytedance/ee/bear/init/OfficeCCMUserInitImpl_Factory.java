package com.bytedance.ee.bear.init;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.a0;
import dagger.internal.Factory;
import javax.inject.Provider;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeCCMUserInitImpl_Factory implements Factory<d> {
    private final Provider<s45.c> domainCharacteristicServiceProvider;
    private final Provider<NetService> netServiceProvider;
    private final Provider<p> spaceKitUrlHelperProvider;
    private final Provider<a0> userAccountInfoServiceProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.netServiceProvider.get(), this.domainCharacteristicServiceProvider.get(), this.userAccountInfoServiceProvider.get(), this.spaceKitUrlHelperProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeCCMUserInitImpl_Factory(Provider<NetService> r100, Provider<s45.c> r101, Provider<a0> r102, Provider<p> r103) {
        this.netServiceProvider = r100;
        this.domainCharacteristicServiceProvider = r101;
        this.userAccountInfoServiceProvider = r102;
        this.spaceKitUrlHelperProvider = r103;
    }

    public static OfficeCCMUserInitImpl_Factory create(Provider<NetService> r100, Provider<s45.c> r101, Provider<a0> r102, Provider<p> r103) {
        return new OfficeCCMUserInitImpl_Factory(r100, r101, r102, r103);
    }

    public static d newInstance(NetService r100, s45.c r101, a0 r102, p r103) {
        return new d(r100, r101, r102, r103);
    }
}

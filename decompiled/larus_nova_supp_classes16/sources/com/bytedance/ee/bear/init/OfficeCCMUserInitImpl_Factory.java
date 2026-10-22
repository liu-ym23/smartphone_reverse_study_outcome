package com.bytedance.ee.bear.init;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.a0;
import dagger.internal.Factory;
import javax.inject.Provider;
import s45.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class OfficeCCMUserInitImpl_Factory implements Factory<d> {
    private final Provider<s45.c> domainCharacteristicServiceProvider;
    private final Provider<NetService> netServiceProvider;
    private final Provider<p> spaceKitUrlHelperProvider;
    private final Provider<a0> userAccountInfoServiceProvider;

    public d get() {
        return newInstance((NetService) this.netServiceProvider.get(), (s45.c) this.domainCharacteristicServiceProvider.get(), (a0) this.userAccountInfoServiceProvider.get(), (p) this.spaceKitUrlHelperProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m406get() {
        return get();
    }

    public OfficeCCMUserInitImpl_Factory(Provider<NetService> r1, Provider<s45.c> r2, Provider<a0> r3, Provider<p> r4) {
        this.netServiceProvider = r1;
        this.domainCharacteristicServiceProvider = r2;
        this.userAccountInfoServiceProvider = r3;
        this.spaceKitUrlHelperProvider = r4;
    }

    public static OfficeCCMUserInitImpl_Factory create(Provider<NetService> r1, Provider<s45.c> r2, Provider<a0> r3, Provider<p> r4) {
        return new OfficeCCMUserInitImpl_Factory(r1, r2, r3, r4);
    }

    public static d newInstance(NetService r1, s45.c r2, a0 r3, p r4) {
        return new d(r1, r2, r3, r4);
    }
}

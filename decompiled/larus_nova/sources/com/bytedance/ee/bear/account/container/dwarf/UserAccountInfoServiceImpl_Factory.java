package com.bytedance.ee.bear.account.container.dwarf;

import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import t45.b;
import t45.c;

/* JADX INFO: loaded from: classes15.dex */
public final class UserAccountInfoServiceImpl_Factory implements Factory<a> {
    private final Provider<b> docDomainConfigProvider;
    private final Provider<NetService> netServiceProvider;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<c> spacekitUrlHelperProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.passportUserServiceProvider.get(), this.spacekitUrlHelperProvider.get(), this.netServiceProvider.get(), this.docDomainConfigProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserAccountInfoServiceImpl_Factory(Provider<m> r100, Provider<c> r101, Provider<NetService> r102, Provider<b> r103) {
        this.passportUserServiceProvider = r100;
        this.spacekitUrlHelperProvider = r101;
        this.netServiceProvider = r102;
        this.docDomainConfigProvider = r103;
    }

    public static UserAccountInfoServiceImpl_Factory create(Provider<m> r100, Provider<c> r101, Provider<NetService> r102, Provider<b> r103) {
        return new UserAccountInfoServiceImpl_Factory(r100, r101, r102, r103);
    }

    public static a newInstance(m r100, c r101, NetService r102, b r103) {
        return new a(r100, r101, r102, r103);
    }
}

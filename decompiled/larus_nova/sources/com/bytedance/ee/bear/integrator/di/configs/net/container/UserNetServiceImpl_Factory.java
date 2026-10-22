package com.bytedance.ee.bear.integrator.di.configs.net.container;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;
import sa5.j;
import t45.b;

/* JADX INFO: loaded from: classes16.dex */
public final class UserNetServiceImpl_Factory implements Factory<UserNetServiceImpl> {
    private final Provider<j> cookiesAdapterV2Provider;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<b> userDocDomainConfigProvider;
    private final Provider<g> userFgServiceProvider;

    @Override // javax.inject.Provider
    public UserNetServiceImpl get() {
        return newInstance(this.userDocDomainConfigProvider.get(), this.passportUserServiceProvider.get(), this.cookiesAdapterV2Provider.get(), this.userFgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserNetServiceImpl_Factory(Provider<b> r100, Provider<m> r101, Provider<j> r102, Provider<g> r103) {
        this.userDocDomainConfigProvider = r100;
        this.passportUserServiceProvider = r101;
        this.cookiesAdapterV2Provider = r102;
        this.userFgServiceProvider = r103;
    }

    public static UserNetServiceImpl_Factory create(Provider<b> r100, Provider<m> r101, Provider<j> r102, Provider<g> r103) {
        return new UserNetServiceImpl_Factory(r100, r101, r102, r103);
    }

    public static UserNetServiceImpl newInstance(b r100, m r101, j r102, g r103) {
        return new UserNetServiceImpl(r100, r101, r102, r103);
    }
}

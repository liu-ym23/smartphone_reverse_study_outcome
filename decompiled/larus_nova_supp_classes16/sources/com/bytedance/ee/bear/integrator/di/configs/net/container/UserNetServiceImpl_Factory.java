package com.bytedance.ee.bear.integrator.di.configs.net.container;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;
import sa5.j;
import t45.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class UserNetServiceImpl_Factory implements Factory<UserNetServiceImpl> {
    private final Provider<j> cookiesAdapterV2Provider;
    private final Provider<m> passportUserServiceProvider;
    private final Provider<b> userDocDomainConfigProvider;
    private final Provider<g> userFgServiceProvider;

    public UserNetServiceImpl get() {
        return newInstance((b) this.userDocDomainConfigProvider.get(), (m) this.passportUserServiceProvider.get(), (j) this.cookiesAdapterV2Provider.get(), (g) this.userFgServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m413get() {
        return get();
    }

    public UserNetServiceImpl_Factory(Provider<b> r1, Provider<m> r2, Provider<j> r3, Provider<g> r4) {
        this.userDocDomainConfigProvider = r1;
        this.passportUserServiceProvider = r2;
        this.cookiesAdapterV2Provider = r3;
        this.userFgServiceProvider = r4;
    }

    public static UserNetServiceImpl_Factory create(Provider<b> r1, Provider<m> r2, Provider<j> r3, Provider<g> r4) {
        return new UserNetServiceImpl_Factory(r1, r2, r3, r4);
    }

    public static UserNetServiceImpl newInstance(b r1, m r2, j r3, g r4) {
        return new UserNetServiceImpl(r1, r2, r3, r4);
    }
}

package com.ss.android.lark.dynamicconfig.v2.impl.service;

import android.app.Application;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;
import lcb.d;

/* JADX INFO: loaded from: classes35.dex */
public final class GlobalDomainConfigService_Factory implements Factory<d> {
    private final Provider<Application> appProvider;
    private final Provider<j> mPassportGlobalServiceProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public d get() {
        d r100 = newInstance(this.passportProvider.get());
        r100.f508633c = this.mPassportGlobalServiceProvider.get();
        Application r101 = this.appProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static d newInstance(j r100) {
        return new d(r100);
    }

    public GlobalDomainConfigService_Factory(Provider<j> r100, Provider<j> r101, Provider<Application> r102) {
        this.passportProvider = r100;
        this.mPassportGlobalServiceProvider = r101;
        this.appProvider = r102;
    }

    public static GlobalDomainConfigService_Factory create(Provider<j> r100, Provider<j> r101, Provider<Application> r102) {
        return new GlobalDomainConfigService_Factory(r100, r101, r102);
    }
}

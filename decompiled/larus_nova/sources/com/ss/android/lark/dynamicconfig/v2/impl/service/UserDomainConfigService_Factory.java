package com.ss.android.lark.dynamicconfig.v2.impl.service;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;
import lcb.f;
import mcb.b;

/* JADX INFO: loaded from: classes35.dex */
public final class UserDomainConfigService_Factory implements Factory<f> {
    private final Provider<b> globalDomainDispatcherProvider;
    private final Provider<b> mGlobalDomainDispatcherProvider;
    private final Provider<j> mPassportGlobalServiceProvider;
    private final Provider<String> mUidProvider;
    private final Provider<j> passportGlobalServiceProvider;

    @Override // javax.inject.Provider
    public f get() {
        f r100 = newInstance(this.passportGlobalServiceProvider.get(), this.globalDomainDispatcherProvider.get());
        r100.f508638a = this.mUidProvider.get();
        r100.f508639b = this.mGlobalDomainDispatcherProvider.get();
        r100.f508640c = this.mPassportGlobalServiceProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static f newInstance(j r100, b r101) {
        return new f(r100, r101);
    }

    public UserDomainConfigService_Factory(Provider<j> r100, Provider<b> r101, Provider<String> r102, Provider<b> r103, Provider<j> r104) {
        this.passportGlobalServiceProvider = r100;
        this.globalDomainDispatcherProvider = r101;
        this.mUidProvider = r102;
        this.mGlobalDomainDispatcherProvider = r103;
        this.mPassportGlobalServiceProvider = r104;
    }

    public static UserDomainConfigService_Factory create(Provider<j> r100, Provider<b> r101, Provider<String> r102, Provider<b> r110, Provider<j> r111) {
        return new UserDomainConfigService_Factory(r100, r101, r102, r110, r111);
    }
}

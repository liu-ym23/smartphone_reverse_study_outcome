package com.ss.android.lark.appsetting.v2.impl;

import android.app.Application;
import awa.a;
import bwa.p;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class GlobalSettingManager_Factory implements Factory<p> {
    private final Provider<a> appConfigExternalSourceProvider;
    private final Provider<Application> appProvider;
    private final Provider<j> mPassportGlobalServiceProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public p get() {
        p r100 = newInstance(this.passportProvider.get(), this.appConfigExternalSourceProvider.get());
        r100.f21266b = this.mPassportGlobalServiceProvider.get();
        Application r101 = this.appProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static p newInstance(j r100, a r101) {
        return new p(r100, r101);
    }

    public GlobalSettingManager_Factory(Provider<j> r100, Provider<a> r101, Provider<j> r102, Provider<Application> r103) {
        this.passportProvider = r100;
        this.appConfigExternalSourceProvider = r101;
        this.mPassportGlobalServiceProvider = r102;
        this.appProvider = r103;
    }

    public static GlobalSettingManager_Factory create(Provider<j> r100, Provider<a> r101, Provider<j> r102, Provider<Application> r103) {
        return new GlobalSettingManager_Factory(r100, r101, r102, r103);
    }
}

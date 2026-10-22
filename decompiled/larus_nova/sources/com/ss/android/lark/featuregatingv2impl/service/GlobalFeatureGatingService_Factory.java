package com.ss.android.lark.featuregatingv2impl.service;

import android.app.Application;
import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.f;
import ldb.c;

/* JADX INFO: loaded from: classes35.dex */
public final class GlobalFeatureGatingService_Factory implements Factory<c> {
    private final Provider<Application> appProvider;
    private final Provider<j> globalServiceProvider;
    private final Provider<j> mPassportGlobalServiceProvider;
    private final Provider<f> mockFgProvider;

    @Override // javax.inject.Provider
    public c get() {
        c r100 = newInstance(this.globalServiceProvider.get(), this.mockFgProvider.get());
        r100.f508871p = this.mPassportGlobalServiceProvider.get();
        r100.f508872q = this.appProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static c newInstance(j r100, f r101) {
        return new c(r100, r101);
    }

    public GlobalFeatureGatingService_Factory(Provider<j> r100, Provider<f> r101, Provider<j> r102, Provider<Application> r103) {
        this.globalServiceProvider = r100;
        this.mockFgProvider = r101;
        this.mPassportGlobalServiceProvider = r102;
        this.appProvider = r103;
    }

    public static GlobalFeatureGatingService_Factory create(Provider<j> r100, Provider<f> r101, Provider<j> r102, Provider<Application> r103) {
        return new GlobalFeatureGatingService_Factory(r100, r101, r102, r103);
    }
}

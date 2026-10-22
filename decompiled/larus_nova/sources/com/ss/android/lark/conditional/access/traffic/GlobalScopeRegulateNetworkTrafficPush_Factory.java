package com.ss.android.lark.conditional.access.traffic;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class GlobalScopeRegulateNetworkTrafficPush_Factory implements Factory<a> {
    private final Provider<jdb.e> fgServiceProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.passportProvider.get(), this.fgServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GlobalScopeRegulateNetworkTrafficPush_Factory(Provider<j> r100, Provider<jdb.e> r101) {
        this.passportProvider = r100;
        this.fgServiceProvider = r101;
    }

    public static GlobalScopeRegulateNetworkTrafficPush_Factory create(Provider<j> r100, Provider<jdb.e> r101) {
        return new GlobalScopeRegulateNetworkTrafficPush_Factory(r100, r101);
    }

    public static a newInstance(j r100, jdb.e r101) {
        return new a(r100, r101);
    }
}

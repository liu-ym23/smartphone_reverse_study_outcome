package com.ss.android.lark.featuregatingv2impl.service;

import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.d;
import ldb.g;

/* JADX INFO: loaded from: classes35.dex */
public final class UserFeatureGatingService_Factory implements Factory<g> {
    private final Provider<d> globalFeatureGatingDispatcherProvider;
    private final Provider<String> mUidProvider;

    @Override // javax.inject.Provider
    public g get() {
        g r100 = newInstance(this.globalFeatureGatingDispatcherProvider.get());
        r100.f508883a = this.mUidProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static g newInstance(d r100) {
        return new g(r100);
    }

    public UserFeatureGatingService_Factory(Provider<d> r100, Provider<String> r101) {
        this.globalFeatureGatingDispatcherProvider = r100;
        this.mUidProvider = r101;
    }

    public static UserFeatureGatingService_Factory create(Provider<d> r100, Provider<String> r101) {
        return new UserFeatureGatingService_Factory(r100, r101);
    }
}

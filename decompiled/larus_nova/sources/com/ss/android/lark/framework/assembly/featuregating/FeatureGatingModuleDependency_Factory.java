package com.ss.android.lark.framework.assembly.featuregating;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class FeatureGatingModuleDependency_Factory implements Factory<FeatureGatingModuleDependency> {
    private final Provider<epb.a> deviceIdApiProvider;
    private final Provider<j> passportProvider;
    private final Provider<yzb.b> userListApiProvider;

    @Override // javax.inject.Provider
    public FeatureGatingModuleDependency get() {
        return newInstance(this.passportProvider.get(), this.deviceIdApiProvider.get(), this.userListApiProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeatureGatingModuleDependency_Factory(Provider<j> r100, Provider<epb.a> r101, Provider<yzb.b> r102) {
        this.passportProvider = r100;
        this.deviceIdApiProvider = r101;
        this.userListApiProvider = r102;
    }

    public static FeatureGatingModuleDependency_Factory create(Provider<j> r100, Provider<epb.a> r101, Provider<yzb.b> r102) {
        return new FeatureGatingModuleDependency_Factory(r100, r101, r102);
    }

    public static FeatureGatingModuleDependency newInstance(j r100, epb.a r101, yzb.b r102) {
        return new FeatureGatingModuleDependency(r100, r101, r102);
    }
}

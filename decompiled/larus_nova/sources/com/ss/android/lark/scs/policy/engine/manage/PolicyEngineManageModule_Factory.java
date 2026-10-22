package com.ss.android.lark.scs.policy.engine.manage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes38.dex */
public final class PolicyEngineManageModule_Factory implements Factory<d> {
    private final Provider<o3c.a> dependencyProvider;

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        d r100 = newInstance();
        r100.f439854b = this.dependencyProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PolicyEngineManageModule_Factory(Provider<o3c.a> r100) {
        this.dependencyProvider = r100;
    }

    public static PolicyEngineManageModule_Factory create(Provider<o3c.a> r100) {
        return new PolicyEngineManageModule_Factory(r100);
    }
}

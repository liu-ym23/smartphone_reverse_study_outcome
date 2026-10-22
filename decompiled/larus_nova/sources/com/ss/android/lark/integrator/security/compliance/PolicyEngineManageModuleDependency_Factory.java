package com.ss.android.lark.integrator.security.compliance;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class PolicyEngineManageModuleDependency_Factory implements Factory<k> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PolicyEngineManageModuleDependency_Factory f428048a = null;

        static {
            f428048a = new PolicyEngineManageModuleDependency_Factory();
        }
    }

    public PolicyEngineManageModuleDependency_Factory() {
    }

    public static k newInstance() {
        return new k();
    }

    @Override // javax.inject.Provider
    public k get() {
        return newInstance();
    }

    public static PolicyEngineManageModuleDependency_Factory create() {
        return a.f428048a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

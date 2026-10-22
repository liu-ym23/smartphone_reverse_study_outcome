package com.ss.android.lark.integrator.security.compliance;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class ConditionalAccessModuleDependency_Factory implements Factory<ConditionalAccessModuleDependency> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ConditionalAccessModuleDependency_Factory f428045a = null;

        static {
            f428045a = new ConditionalAccessModuleDependency_Factory();
        }
    }

    public ConditionalAccessModuleDependency_Factory() {
    }

    public static ConditionalAccessModuleDependency newInstance() {
        return new ConditionalAccessModuleDependency();
    }

    @Override // javax.inject.Provider
    public ConditionalAccessModuleDependency get() {
        return newInstance();
    }

    public static ConditionalAccessModuleDependency_Factory create() {
        return a.f428045a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

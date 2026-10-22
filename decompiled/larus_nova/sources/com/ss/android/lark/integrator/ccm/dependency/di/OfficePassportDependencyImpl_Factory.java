package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficePassportDependencyImpl_Factory implements Factory<g1> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficePassportDependencyImpl_Factory f427834a = null;

        static {
            f427834a = new OfficePassportDependencyImpl_Factory();
        }
    }

    public OfficePassportDependencyImpl_Factory() {
    }

    public static g1 newInstance() {
        return new g1();
    }

    @Override // javax.inject.Provider
    public g1 get() {
        return newInstance();
    }

    public static OfficePassportDependencyImpl_Factory create() {
        return a.f427834a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

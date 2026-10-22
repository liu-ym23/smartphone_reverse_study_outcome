package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeVcApiDependencyImpl_Factory implements Factory<j1> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeVcApiDependencyImpl_Factory f427837a = null;

        static {
            f427837a = new OfficeVcApiDependencyImpl_Factory();
        }
    }

    public OfficeVcApiDependencyImpl_Factory() {
    }

    public static j1 newInstance() {
        return new j1();
    }

    @Override // javax.inject.Provider
    public j1 get() {
        return newInstance();
    }

    public static OfficeVcApiDependencyImpl_Factory create() {
        return a.f427837a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

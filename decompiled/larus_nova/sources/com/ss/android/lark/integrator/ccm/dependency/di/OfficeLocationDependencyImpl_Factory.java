package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeLocationDependencyImpl_Factory implements Factory<z0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeLocationDependencyImpl_Factory f427827a = null;

        static {
            f427827a = new OfficeLocationDependencyImpl_Factory();
        }
    }

    public OfficeLocationDependencyImpl_Factory() {
    }

    public static z0 newInstance() {
        return new z0();
    }

    @Override // javax.inject.Provider
    public z0 get() {
        return newInstance();
    }

    public static OfficeLocationDependencyImpl_Factory create() {
        return a.f427827a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

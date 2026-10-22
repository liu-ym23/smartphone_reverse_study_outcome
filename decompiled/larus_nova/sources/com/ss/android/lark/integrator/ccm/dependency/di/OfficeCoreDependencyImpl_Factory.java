package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeCoreDependencyImpl_Factory implements Factory<t0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeCoreDependencyImpl_Factory f427811a = null;

        static {
            f427811a = new OfficeCoreDependencyImpl_Factory();
        }
    }

    public OfficeCoreDependencyImpl_Factory() {
    }

    public static t0 newInstance() {
        return new t0();
    }

    @Override // javax.inject.Provider
    public t0 get() {
        return newInstance();
    }

    public static OfficeCoreDependencyImpl_Factory create() {
        return a.f427811a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

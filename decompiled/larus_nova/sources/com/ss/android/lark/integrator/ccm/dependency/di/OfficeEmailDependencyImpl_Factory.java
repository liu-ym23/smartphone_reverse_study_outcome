package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeEmailDependencyImpl_Factory implements Factory<v0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeEmailDependencyImpl_Factory f427812a = null;

        static {
            f427812a = new OfficeEmailDependencyImpl_Factory();
        }
    }

    public OfficeEmailDependencyImpl_Factory() {
    }

    public static v0 newInstance() {
        return new v0();
    }

    @Override // javax.inject.Provider
    public v0 get() {
        return newInstance();
    }

    public static OfficeEmailDependencyImpl_Factory create() {
        return a.f427812a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

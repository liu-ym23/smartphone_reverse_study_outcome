package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeOpenPlatformBrowserDependencyImpl_Factory implements Factory<e1> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeOpenPlatformBrowserDependencyImpl_Factory f427832a = null;

        static {
            f427832a = new OfficeOpenPlatformBrowserDependencyImpl_Factory();
        }
    }

    public OfficeOpenPlatformBrowserDependencyImpl_Factory() {
    }

    public static e1 newInstance() {
        return new e1();
    }

    @Override // javax.inject.Provider
    public e1 get() {
        return newInstance();
    }

    public static OfficeOpenPlatformBrowserDependencyImpl_Factory create() {
        return a.f427832a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

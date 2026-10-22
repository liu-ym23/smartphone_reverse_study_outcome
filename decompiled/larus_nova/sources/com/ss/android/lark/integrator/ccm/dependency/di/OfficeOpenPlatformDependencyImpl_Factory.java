package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeOpenPlatformDependencyImpl_Factory implements Factory<f1> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeOpenPlatformDependencyImpl_Factory f427833a = null;

        static {
            f427833a = new OfficeOpenPlatformDependencyImpl_Factory();
        }
    }

    public OfficeOpenPlatformDependencyImpl_Factory() {
    }

    public static f1 newInstance() {
        return new f1();
    }

    @Override // javax.inject.Provider
    public f1 get() {
        return newInstance();
    }

    public static OfficeOpenPlatformDependencyImpl_Factory create() {
        return a.f427833a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

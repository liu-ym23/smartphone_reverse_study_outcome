package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeQuickLaunchBarAIDependencyImpl_Factory implements Factory<h1> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeQuickLaunchBarAIDependencyImpl_Factory f427835a = null;

        static {
            f427835a = new OfficeQuickLaunchBarAIDependencyImpl_Factory();
        }
    }

    public OfficeQuickLaunchBarAIDependencyImpl_Factory() {
    }

    public static h1 newInstance() {
        return new h1();
    }

    @Override // javax.inject.Provider
    public h1 get() {
        return newInstance();
    }

    public static OfficeQuickLaunchBarAIDependencyImpl_Factory create() {
        return a.f427835a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

package com.bytedance.ee.bear.integrator.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes16.dex */
public final class AppInitializeImpl_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AppInitializeImpl_Factory f227077a = null;

        static {
            f227077a = new AppInitializeImpl_Factory();
        }
    }

    public AppInitializeImpl_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static AppInitializeImpl_Factory create() {
        return a.f227077a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

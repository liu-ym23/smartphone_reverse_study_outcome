package com.bytedance.ee.bear.integrator.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeAppInitializeImpl_Factory implements Factory<OfficeAppInitializeImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeAppInitializeImpl_Factory f227083a = null;

        static {
            f227083a = new OfficeAppInitializeImpl_Factory();
        }
    }

    public OfficeAppInitializeImpl_Factory() {
    }

    public static OfficeAppInitializeImpl newInstance() {
        return new OfficeAppInitializeImpl();
    }

    @Override // javax.inject.Provider
    public OfficeAppInitializeImpl get() {
        return newInstance();
    }

    public static OfficeAppInitializeImpl_Factory create() {
        return a.f227083a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeResourceImpl_Factory implements Factory<i1> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeResourceImpl_Factory f427836a = null;

        static {
            f427836a = new OfficeResourceImpl_Factory();
        }
    }

    public OfficeResourceImpl_Factory() {
    }

    public static i1 newInstance() {
        return new i1();
    }

    @Override // javax.inject.Provider
    public i1 get() {
        return newInstance();
    }

    public static OfficeResourceImpl_Factory create() {
        return a.f427836a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

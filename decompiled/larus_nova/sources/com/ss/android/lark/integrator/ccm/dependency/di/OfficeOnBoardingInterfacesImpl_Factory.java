package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeOnBoardingInterfacesImpl_Factory implements Factory<d1> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeOnBoardingInterfacesImpl_Factory f427831a = null;

        static {
            f427831a = new OfficeOnBoardingInterfacesImpl_Factory();
        }
    }

    public OfficeOnBoardingInterfacesImpl_Factory() {
    }

    public static d1 newInstance() {
        return new d1();
    }

    @Override // javax.inject.Provider
    public d1 get() {
        return newInstance();
    }

    public static OfficeOnBoardingInterfacesImpl_Factory create() {
        return a.f427831a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

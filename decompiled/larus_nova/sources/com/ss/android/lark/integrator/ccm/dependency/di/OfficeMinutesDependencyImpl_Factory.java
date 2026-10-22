package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeMinutesDependencyImpl_Factory implements Factory<c1> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeMinutesDependencyImpl_Factory f427830a = null;

        static {
            f427830a = new OfficeMinutesDependencyImpl_Factory();
        }
    }

    public OfficeMinutesDependencyImpl_Factory() {
    }

    public static c1 newInstance() {
        return new c1();
    }

    @Override // javax.inject.Provider
    public c1 get() {
        return newInstance();
    }

    public static OfficeMinutesDependencyImpl_Factory create() {
        return a.f427830a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

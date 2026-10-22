package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeMessagingDependencyImpl_Factory implements Factory<OfficeMessagingDependencyImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeMessagingDependencyImpl_Factory f427829a = null;

        static {
            f427829a = new OfficeMessagingDependencyImpl_Factory();
        }
    }

    public OfficeMessagingDependencyImpl_Factory() {
    }

    public static OfficeMessagingDependencyImpl newInstance() {
        return new OfficeMessagingDependencyImpl();
    }

    @Override // javax.inject.Provider
    public OfficeMessagingDependencyImpl get() {
        return newInstance();
    }

    public static OfficeMessagingDependencyImpl_Factory create() {
        return a.f427829a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

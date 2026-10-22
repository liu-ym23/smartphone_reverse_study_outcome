package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class CoreDependencyImpl_Factory implements Factory<CoreDependencyImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CoreDependencyImpl_Factory f433280a = null;

        static {
            f433280a = new CoreDependencyImpl_Factory();
        }
    }

    public CoreDependencyImpl_Factory() {
    }

    public static CoreDependencyImpl newInstance() {
        return new CoreDependencyImpl();
    }

    @Override // javax.inject.Provider
    public CoreDependencyImpl get() {
        return newInstance();
    }

    public static CoreDependencyImpl_Factory create() {
        return a.f433280a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

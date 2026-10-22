package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class MigrateTempDependencyImpl_Factory implements Factory<k> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MigrateTempDependencyImpl_Factory f433287a = null;

        static {
            f433287a = new MigrateTempDependencyImpl_Factory();
        }
    }

    public MigrateTempDependencyImpl_Factory() {
    }

    public static k newInstance() {
        return new k();
    }

    @Override // javax.inject.Provider
    public k get() {
        return newInstance();
    }

    public static MigrateTempDependencyImpl_Factory create() {
        return a.f433287a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

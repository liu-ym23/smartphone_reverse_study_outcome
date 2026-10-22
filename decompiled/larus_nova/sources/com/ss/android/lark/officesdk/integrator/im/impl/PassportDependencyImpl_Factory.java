package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class PassportDependencyImpl_Factory implements Factory<o> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PassportDependencyImpl_Factory f433290a = null;

        static {
            f433290a = new PassportDependencyImpl_Factory();
        }
    }

    public PassportDependencyImpl_Factory() {
    }

    public static o newInstance() {
        return new o();
    }

    @Override // javax.inject.Provider
    public o get() {
        return newInstance();
    }

    public static PassportDependencyImpl_Factory create() {
        return a.f433290a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

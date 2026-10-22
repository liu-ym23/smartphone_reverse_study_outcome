package com.ss.android.lark.passport.assemble;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class EnvironmentDependencyImpl_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnvironmentDependencyImpl_Factory f437684a = null;

        static {
            f437684a = new EnvironmentDependencyImpl_Factory();
        }
    }

    public EnvironmentDependencyImpl_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static EnvironmentDependencyImpl_Factory create() {
        return a.f437684a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

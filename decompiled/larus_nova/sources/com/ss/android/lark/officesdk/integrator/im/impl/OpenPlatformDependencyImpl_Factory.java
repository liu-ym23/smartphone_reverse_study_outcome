package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class OpenPlatformDependencyImpl_Factory implements Factory<n> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OpenPlatformDependencyImpl_Factory f433289a = null;

        static {
            f433289a = new OpenPlatformDependencyImpl_Factory();
        }
    }

    public OpenPlatformDependencyImpl_Factory() {
    }

    public static n newInstance() {
        return new n();
    }

    @Override // javax.inject.Provider
    public n get() {
        return newInstance();
    }

    public static OpenPlatformDependencyImpl_Factory create() {
        return a.f433289a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

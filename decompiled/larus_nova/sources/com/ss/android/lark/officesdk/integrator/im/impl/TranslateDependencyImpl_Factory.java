package com.ss.android.lark.officesdk.integrator.im.impl;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class TranslateDependencyImpl_Factory implements Factory<t> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TranslateDependencyImpl_Factory f433293a = null;

        static {
            f433293a = new TranslateDependencyImpl_Factory();
        }
    }

    public TranslateDependencyImpl_Factory() {
    }

    public static t newInstance() {
        return new t();
    }

    @Override // javax.inject.Provider
    public t get() {
        return newInstance();
    }

    public static TranslateDependencyImpl_Factory create() {
        return a.f433293a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

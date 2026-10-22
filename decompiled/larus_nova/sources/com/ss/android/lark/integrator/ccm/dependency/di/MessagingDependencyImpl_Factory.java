package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class MessagingDependencyImpl_Factory implements Factory<i0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MessagingDependencyImpl_Factory f427810a = null;

        static {
            f427810a = new MessagingDependencyImpl_Factory();
        }
    }

    public MessagingDependencyImpl_Factory() {
    }

    public static i0 newInstance() {
        return new i0();
    }

    @Override // javax.inject.Provider
    public i0 get() {
        return newInstance();
    }

    public static MessagingDependencyImpl_Factory create() {
        return a.f427810a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

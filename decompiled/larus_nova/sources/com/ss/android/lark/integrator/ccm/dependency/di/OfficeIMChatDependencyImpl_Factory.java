package com.ss.android.lark.integrator.ccm.dependency.di;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeIMChatDependencyImpl_Factory implements Factory<w0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final OfficeIMChatDependencyImpl_Factory f427825a = null;

        static {
            f427825a = new OfficeIMChatDependencyImpl_Factory();
        }
    }

    public OfficeIMChatDependencyImpl_Factory() {
    }

    public static w0 newInstance() {
        return new w0();
    }

    @Override // javax.inject.Provider
    public w0 get() {
        return newInstance();
    }

    public static OfficeIMChatDependencyImpl_Factory create() {
        return a.f427825a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

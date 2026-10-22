package com.ss.android.lark.passportc.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class NoopStaticGlobalScopeConvention_Factory implements Factory<u> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopStaticGlobalScopeConvention_Factory f438102a = null;

        static {
            f438102a = new NoopStaticGlobalScopeConvention_Factory();
        }
    }

    public NoopStaticGlobalScopeConvention_Factory() {
    }

    public static u newInstance() {
        return new u();
    }

    @Override // javax.inject.Provider
    public u get() {
        return newInstance();
    }

    public static NoopStaticGlobalScopeConvention_Factory create() {
        return a.f438102a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

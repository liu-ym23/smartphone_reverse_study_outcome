package com.ss.android.lark.passportc.api;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class NoopStaticUserScopeConvention_Factory implements Factory<v> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopStaticUserScopeConvention_Factory f438103a = null;

        static {
            f438103a = new NoopStaticUserScopeConvention_Factory();
        }
    }

    public NoopStaticUserScopeConvention_Factory() {
    }

    public static v newInstance() {
        return new v();
    }

    @Override // javax.inject.Provider
    public v get() {
        return newInstance();
    }

    public static NoopStaticUserScopeConvention_Factory create() {
        return a.f438103a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

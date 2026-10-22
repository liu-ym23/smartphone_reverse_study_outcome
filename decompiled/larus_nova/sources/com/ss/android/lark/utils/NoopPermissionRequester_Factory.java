package com.ss.android.lark.utils;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes38.dex */
public final class NoopPermissionRequester_Factory implements Factory<n0> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopPermissionRequester_Factory f444668a = null;

        static {
            f444668a = new NoopPermissionRequester_Factory();
        }
    }

    public NoopPermissionRequester_Factory() {
    }

    public static n0 newInstance() {
        return new n0();
    }

    @Override // javax.inject.Provider
    public n0 get() {
        return newInstance();
    }

    public static NoopPermissionRequester_Factory create() {
        return a.f444668a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

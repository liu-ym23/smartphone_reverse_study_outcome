package com.ss.android.lark.passport.dpop;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class NoopTokenService_Factory implements Factory<d> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopTokenService_Factory f437722a = null;

        static {
            f437722a = new NoopTokenService_Factory();
        }
    }

    public NoopTokenService_Factory() {
    }

    public static d newInstance() {
        return new d();
    }

    @Override // javax.inject.Provider
    public d get() {
        return newInstance();
    }

    public static NoopTokenService_Factory create() {
        return a.f437722a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

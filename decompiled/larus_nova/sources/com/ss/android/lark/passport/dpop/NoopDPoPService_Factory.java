package com.ss.android.lark.passport.dpop;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes37.dex */
public final class NoopDPoPService_Factory implements Factory<c> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopDPoPService_Factory f437721a = null;

        static {
            f437721a = new NoopDPoPService_Factory();
        }
    }

    public NoopDPoPService_Factory() {
    }

    public static c newInstance() {
        return new c();
    }

    @Override // javax.inject.Provider
    public c get() {
        return newInstance();
    }

    public static NoopDPoPService_Factory create() {
        return a.f437721a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

package com.ss.android.lark.integrator.security.compliance.endpoint;

import dagger.internal.Factory;
import hnb.b;

/* JADX INFO: loaded from: classes36.dex */
public final class NoopEndpointSecurityFactorService_Factory implements Factory<b> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopEndpointSecurityFactorService_Factory f428065a = null;

        static {
            f428065a = new NoopEndpointSecurityFactorService_Factory();
        }
    }

    public NoopEndpointSecurityFactorService_Factory() {
    }

    public static b newInstance() {
        return new b();
    }

    @Override // javax.inject.Provider
    public b get() {
        return newInstance();
    }

    public static NoopEndpointSecurityFactorService_Factory create() {
        return a.f428065a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

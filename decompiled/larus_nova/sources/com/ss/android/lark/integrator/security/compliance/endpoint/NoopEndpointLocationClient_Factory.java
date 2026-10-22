package com.ss.android.lark.integrator.security.compliance.endpoint;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class NoopEndpointLocationClient_Factory implements Factory<hnb.a> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NoopEndpointLocationClient_Factory f428064a = null;

        static {
            f428064a = new NoopEndpointLocationClient_Factory();
        }
    }

    public NoopEndpointLocationClient_Factory() {
    }

    public static hnb.a newInstance() {
        return new hnb.a();
    }

    @Override // javax.inject.Provider
    public hnb.a get() {
        return newInstance();
    }

    public static NoopEndpointLocationClient_Factory create() {
        return a.f428064a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}

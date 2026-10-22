package com.ss.android.lark.security.compliance.infra.auditnetimpl.userscope;

import dagger.internal.Factory;
import javax.inject.Provider;
import s4c.a;

/* JADX INFO: loaded from: classes38.dex */
public final class HttpExecutorGlobalScope_Factory implements Factory<a> {
    private final Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> rustProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.rustProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public HttpExecutorGlobalScope_Factory(Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> r100) {
        this.rustProvider = r100;
    }

    public static HttpExecutorGlobalScope_Factory create(Provider<com.ss.android.lark.security.compliance.infra.network.userscpoe.a> r100) {
        return new HttpExecutorGlobalScope_Factory(r100);
    }

    public static a newInstance(com.ss.android.lark.security.compliance.infra.network.userscpoe.a r100) {
        return new a(r100);
    }
}

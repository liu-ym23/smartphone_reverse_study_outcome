package com.ss.android.lark.audit.userscope.audit;

import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditRecordServiceProxy_Factory implements Factory<i> {
    private final Provider<v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;
    private final Provider<com.ss.android.lark.passportc.convention.b<l>> proxyProvider;

    @Override // javax.inject.Provider
    public i get() {
        return newInstance(this.passportProvider.get(), this.accessorProvider.get(), this.proxyProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuditRecordServiceProxy_Factory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101, Provider<com.ss.android.lark.passportc.convention.b<l>> r102) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
        this.proxyProvider = r102;
    }

    public static AuditRecordServiceProxy_Factory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101, Provider<com.ss.android.lark.passportc.convention.b<l>> r102) {
        return new AuditRecordServiceProxy_Factory(r100, r101, r102);
    }

    public static i newInstance(com.ss.android.lark.passportc.api.j r100, v r101, com.ss.android.lark.passportc.convention.b<l> r102) {
        return new i(r100, r101, r102);
    }
}

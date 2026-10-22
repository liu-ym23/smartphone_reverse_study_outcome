package com.ss.android.lark.audit.userscope.audit;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditRecordService_Factory implements Factory<g> {
    private final Provider<a> dispatcherProvider;
    private final Provider<m> passportProvider;
    private final Provider<d> storageProvider;

    @Override // javax.inject.Provider
    public g get() {
        return newInstance(this.passportProvider.get(), this.storageProvider.get(), this.dispatcherProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuditRecordService_Factory(Provider<m> r100, Provider<d> r101, Provider<a> r102) {
        this.passportProvider = r100;
        this.storageProvider = r101;
        this.dispatcherProvider = r102;
    }

    public static AuditRecordService_Factory create(Provider<m> r100, Provider<d> r101, Provider<a> r102) {
        return new AuditRecordService_Factory(r100, r101, r102);
    }

    public static g newInstance(m r100, d r101, a r102) {
        return new g(r100, r101, r102);
    }
}

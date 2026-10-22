package com.ss.android.lark.audit.userscope.audit;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditRecordServiceGlobalScope_Factory implements Factory<AuditRecordServiceGlobalScope> {
    private final Provider<kwa.e> httpExecutorProvider;

    @Override // javax.inject.Provider
    public AuditRecordServiceGlobalScope get() {
        return newInstance(this.httpExecutorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuditRecordServiceGlobalScope_Factory(Provider<kwa.e> r100) {
        this.httpExecutorProvider = r100;
    }

    public static AuditRecordServiceGlobalScope_Factory create(Provider<kwa.e> r100) {
        return new AuditRecordServiceGlobalScope_Factory(r100);
    }

    public static AuditRecordServiceGlobalScope newInstance(kwa.e r100) {
        return new AuditRecordServiceGlobalScope(r100);
    }
}

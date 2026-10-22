package com.ss.android.lark.audit.userscope.audit;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditDispatcher_Factory implements Factory<a> {
    private final Provider<e> auditRecordImplProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.auditRecordImplProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuditDispatcher_Factory(Provider<e> r100) {
        this.auditRecordImplProvider = r100;
    }

    public static AuditDispatcher_Factory create(Provider<e> r100) {
        return new AuditDispatcher_Factory(r100);
    }

    public static a newInstance(e r100) {
        return new a(r100);
    }
}

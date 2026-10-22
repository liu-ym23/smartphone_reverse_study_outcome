package com.ss.android.lark.audit.userscope.audit;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditEventStorage_Factory implements Factory<d> {
    private final Provider<String> idProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.idProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuditEventStorage_Factory(Provider<String> r100) {
        this.idProvider = r100;
    }

    public static AuditEventStorage_Factory create(Provider<String> r100) {
        return new AuditEventStorage_Factory(r100);
    }

    public static d newInstance(String r100) {
        return new d(r100);
    }
}

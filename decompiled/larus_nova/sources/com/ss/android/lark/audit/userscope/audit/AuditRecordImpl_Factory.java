package com.ss.android.lark.audit.userscope.audit;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class AuditRecordImpl_Factory implements Factory<e> {
    private final Provider<String> idProvider;
    private final Provider<d> storageProvider;
    private final Provider<com.bytedance.lark.rustclient.api.l> userClientProvider;

    @Override // javax.inject.Provider
    public e get() {
        return newInstance(this.userClientProvider.get(), this.storageProvider.get(), this.idProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AuditRecordImpl_Factory(Provider<com.bytedance.lark.rustclient.api.l> r100, Provider<d> r101, Provider<String> r102) {
        this.userClientProvider = r100;
        this.storageProvider = r101;
        this.idProvider = r102;
    }

    public static AuditRecordImpl_Factory create(Provider<com.bytedance.lark.rustclient.api.l> r100, Provider<d> r101, Provider<String> r102) {
        return new AuditRecordImpl_Factory(r100, r101, r102);
    }

    public static e newInstance(com.bytedance.lark.rustclient.api.l r100, d r101, String r102) {
        return new e(r100, r101, r102);
    }
}

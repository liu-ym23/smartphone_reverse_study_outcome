package com.ss.android.lark.audit.userscope.auth;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes34.dex */
public final class PermissionDataService_Factory implements Factory<PermissionDataService> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> globalKVProvider;

    @Override // javax.inject.Provider
    public PermissionDataService get() {
        return newInstance(this.globalKVProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PermissionDataService_Factory(Provider<com.ss.android.lark.storage.kv.storage.a> r100) {
        this.globalKVProvider = r100;
    }

    public static PermissionDataService_Factory create(Provider<com.ss.android.lark.storage.kv.storage.a> r100) {
        return new PermissionDataService_Factory(r100);
    }

    public static PermissionDataService newInstance(com.ss.android.lark.storage.kv.storage.a r100) {
        return new PermissionDataService(r100);
    }
}

package com.ss.android.lark.core.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class CoreUserKVStorage_Factory implements Factory<d> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> userKvStorageProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.userKvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CoreUserKVStorage_Factory(Provider<com.ss.android.lark.storage.kv.storage.a> r100) {
        this.userKvStorageProvider = r100;
    }

    public static CoreUserKVStorage_Factory create(Provider<com.ss.android.lark.storage.kv.storage.a> r100) {
        return new CoreUserKVStorage_Factory(r100);
    }

    public static d newInstance(com.ss.android.lark.storage.kv.storage.a r100) {
        return new d(r100);
    }
}

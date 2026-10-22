package com.ss.android.lark.conditional.access.display;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class CustomDisplayStorage_Factory implements Factory<e> {
    private final Provider<com.ss.android.lark.storage.kv.storage.a> kvStorageProvider;

    @Override // javax.inject.Provider
    public e get() {
        return newInstance(this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CustomDisplayStorage_Factory(Provider<com.ss.android.lark.storage.kv.storage.a> r100) {
        this.kvStorageProvider = r100;
    }

    public static CustomDisplayStorage_Factory create(Provider<com.ss.android.lark.storage.kv.storage.a> r100) {
        return new CustomDisplayStorage_Factory(r100);
    }

    public static e newInstance(com.ss.android.lark.storage.kv.storage.a r100) {
        return new e(r100);
    }
}

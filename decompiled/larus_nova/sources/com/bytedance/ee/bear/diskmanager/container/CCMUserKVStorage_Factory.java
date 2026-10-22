package com.bytedance.ee.bear.diskmanager.container;

import by4.b;
import com.ss.android.lark.storage.kv.storage.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class CCMUserKVStorage_Factory implements Factory<b> {
    private final Provider<a> userKvStorageProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.userKvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CCMUserKVStorage_Factory(Provider<a> r100) {
        this.userKvStorageProvider = r100;
    }

    public static CCMUserKVStorage_Factory create(Provider<a> r100) {
        return new CCMUserKVStorage_Factory(r100);
    }

    public static b newInstance(a r100) {
        return new b(r100);
    }
}

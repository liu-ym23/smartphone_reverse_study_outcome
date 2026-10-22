package com.bytedance.ee.bear.diskmanager.container;

import by4.b;
import com.ss.android.lark.storage.kv.storage.a;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class CCMUserKVStorage_Factory implements Factory<b> {
    private final Provider<a> userKvStorageProvider;

    public b get() {
        return newInstance((a) this.userKvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m131get() {
        return get();
    }

    public CCMUserKVStorage_Factory(Provider<a> r1) {
        this.userKvStorageProvider = r1;
    }

    public static CCMUserKVStorage_Factory create(Provider<a> r1) {
        return new CCMUserKVStorage_Factory(r1);
    }

    public static b newInstance(a r1) {
        return new b(r1);
    }
}

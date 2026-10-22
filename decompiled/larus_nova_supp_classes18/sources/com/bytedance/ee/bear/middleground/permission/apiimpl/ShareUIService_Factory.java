package com.bytedance.ee.bear.middleground.permission.apiimpl;

import by4.b;
import dagger.internal.Factory;
import javax.inject.Provider;
import jg5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ShareUIService_Factory implements Factory<q> {
    private final Provider<b> kvStorageProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public q m270get() {
        return newInstance((b) this.kvStorageProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m270get();
    }

    public ShareUIService_Factory(Provider<b> r1) {
        this.kvStorageProvider = r1;
    }

    public static ShareUIService_Factory create(Provider<b> r1) {
        return new ShareUIService_Factory(r1);
    }

    public static q newInstance(b r0) {
        return new q();
    }
}

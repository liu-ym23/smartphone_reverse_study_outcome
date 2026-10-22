package com.bytedance.ee.space.sync;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes19.dex */
public final class SyncPushService_Factory implements Factory<SyncPushService> {
    private final Provider<by4.b> kvStorageProvider;
    private final Provider<m> userServiceProvider;

    @Override // javax.inject.Provider
    public SyncPushService get() {
        return newInstance(this.kvStorageProvider.get(), this.userServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SyncPushService_Factory(Provider<by4.b> r100, Provider<m> r101) {
        this.kvStorageProvider = r100;
        this.userServiceProvider = r101;
    }

    public static SyncPushService_Factory create(Provider<by4.b> r100, Provider<m> r101) {
        return new SyncPushService_Factory(r100, r101);
    }

    public static SyncPushService newInstance(by4.b r100, m r101) {
        return new SyncPushService(r100, r101);
    }
}

package com.bytedance.ee.bear.drive.cache;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class OfficeDriveCacheService_Factory implements Factory<c0> {
    private final Provider<by4.b> kvStorageProvider;
    private final Provider<com.ss.android.lark.passportc.api.m> userServiceProvider;

    @Override // javax.inject.Provider
    public c0 get() {
        return newInstance(this.kvStorageProvider.get(), this.userServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeDriveCacheService_Factory(Provider<by4.b> r100, Provider<com.ss.android.lark.passportc.api.m> r101) {
        this.kvStorageProvider = r100;
        this.userServiceProvider = r101;
    }

    public static OfficeDriveCacheService_Factory create(Provider<by4.b> r100, Provider<com.ss.android.lark.passportc.api.m> r101) {
        return new OfficeDriveCacheService_Factory(r100, r101);
    }

    public static c0 newInstance(by4.b r100, com.ss.android.lark.passportc.api.m r101) {
        return new c0(r100, r101);
    }
}

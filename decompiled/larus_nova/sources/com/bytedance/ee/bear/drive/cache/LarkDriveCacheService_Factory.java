package com.bytedance.ee.bear.drive.cache;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class LarkDriveCacheService_Factory implements Factory<x> {
    private final Provider<by4.b> kvStorageProvider;
    private final Provider<com.ss.android.lark.passportc.api.m> userServiceProvider;

    @Override // javax.inject.Provider
    public x get() {
        return newInstance(this.kvStorageProvider.get(), this.userServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkDriveCacheService_Factory(Provider<by4.b> r100, Provider<com.ss.android.lark.passportc.api.m> r101) {
        this.kvStorageProvider = r100;
        this.userServiceProvider = r101;
    }

    public static LarkDriveCacheService_Factory create(Provider<by4.b> r100, Provider<com.ss.android.lark.passportc.api.m> r101) {
        return new LarkDriveCacheService_Factory(r100, r101);
    }

    public static x newInstance(by4.b r100, com.ss.android.lark.passportc.api.m r101) {
        return new x(r100, r101);
    }
}

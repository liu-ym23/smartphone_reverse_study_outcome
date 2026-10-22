package com.bytedance.ee.bear.drive.cache;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class LarkDriveCacheService_Factory implements Factory<x> {
    private final Provider<by4.b> kvStorageProvider;
    private final Provider<com.ss.android.lark.passportc.api.m> userServiceProvider;

    public x get() {
        return newInstance((by4.b) this.kvStorageProvider.get(), (com.ss.android.lark.passportc.api.m) this.userServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m327get() {
        return get();
    }

    public LarkDriveCacheService_Factory(Provider<by4.b> r1, Provider<com.ss.android.lark.passportc.api.m> r2) {
        this.kvStorageProvider = r1;
        this.userServiceProvider = r2;
    }

    public static LarkDriveCacheService_Factory create(Provider<by4.b> r1, Provider<com.ss.android.lark.passportc.api.m> r2) {
        return new LarkDriveCacheService_Factory(r1, r2);
    }

    public static x newInstance(by4.b r1, com.ss.android.lark.passportc.api.m r2) {
        return new x(r1, r2);
    }
}

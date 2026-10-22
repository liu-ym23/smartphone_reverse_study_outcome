package com.bytedance.ee.bear.drive.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveSdkService_Factory implements Factory<DriveSdkService> {
    private final Provider<by4.b> kvStorageProvider;

    public DriveSdkService get() {
        return newInstance((by4.b) this.kvStorageProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m362get() {
        return get();
    }

    public DriveSdkService_Factory(Provider<by4.b> r1) {
        this.kvStorageProvider = r1;
    }

    public static DriveSdkService_Factory create(Provider<by4.b> r1) {
        return new DriveSdkService_Factory(r1);
    }

    public static DriveSdkService newInstance(by4.b r1) {
        return new DriveSdkService(r1);
    }
}

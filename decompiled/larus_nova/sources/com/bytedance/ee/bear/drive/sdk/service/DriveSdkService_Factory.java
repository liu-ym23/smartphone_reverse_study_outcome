package com.bytedance.ee.bear.drive.sdk.service;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveSdkService_Factory implements Factory<DriveSdkService> {
    private final Provider<by4.b> kvStorageProvider;

    @Override // javax.inject.Provider
    public DriveSdkService get() {
        return newInstance(this.kvStorageProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DriveSdkService_Factory(Provider<by4.b> r100) {
        this.kvStorageProvider = r100;
    }

    public static DriveSdkService_Factory create(Provider<by4.b> r100) {
        return new DriveSdkService_Factory(r100);
    }

    public static DriveSdkService newInstance(by4.b r100) {
        return new DriveSdkService(r100);
    }
}

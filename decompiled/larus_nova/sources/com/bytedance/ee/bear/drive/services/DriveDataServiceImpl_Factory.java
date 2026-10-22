package com.bytedance.ee.bear.drive.services;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveDataServiceImpl_Factory implements Factory<i> {
    private final Provider<com.ss.android.lark.passportc.api.m> passportProvider;

    @Override // javax.inject.Provider
    public i get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DriveDataServiceImpl_Factory(Provider<com.ss.android.lark.passportc.api.m> r100) {
        this.passportProvider = r100;
    }

    public static DriveDataServiceImpl_Factory create(Provider<com.ss.android.lark.passportc.api.m> r100) {
        return new DriveDataServiceImpl_Factory(r100);
    }

    public static i newInstance(com.ss.android.lark.passportc.api.m r100) {
        return new i(r100);
    }
}

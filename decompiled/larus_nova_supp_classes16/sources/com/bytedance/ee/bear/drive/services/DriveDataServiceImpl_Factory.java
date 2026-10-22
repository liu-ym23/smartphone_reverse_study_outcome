package com.bytedance.ee.bear.drive.services;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveDataServiceImpl_Factory implements Factory<i> {
    private final Provider<com.ss.android.lark.passportc.api.m> passportProvider;

    public i get() {
        return newInstance((com.ss.android.lark.passportc.api.m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m368get() {
        return get();
    }

    public DriveDataServiceImpl_Factory(Provider<com.ss.android.lark.passportc.api.m> r1) {
        this.passportProvider = r1;
    }

    public static DriveDataServiceImpl_Factory create(Provider<com.ss.android.lark.passportc.api.m> r1) {
        return new DriveDataServiceImpl_Factory(r1);
    }

    public static i newInstance(com.ss.android.lark.passportc.api.m r1) {
        return new i(r1);
    }
}

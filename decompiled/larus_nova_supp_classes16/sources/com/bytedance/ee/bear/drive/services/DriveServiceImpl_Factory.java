package com.bytedance.ee.bear.drive.services;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveServiceImpl_Factory implements Factory<c0> {
    private final Provider<com.ss.android.lark.passportc.api.m> passportProvider;

    public c0 get() {
        return newInstance((com.ss.android.lark.passportc.api.m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m370get() {
        return get();
    }

    public DriveServiceImpl_Factory(Provider<com.ss.android.lark.passportc.api.m> r1) {
        this.passportProvider = r1;
    }

    public static DriveServiceImpl_Factory create(Provider<com.ss.android.lark.passportc.api.m> r1) {
        return new DriveServiceImpl_Factory(r1);
    }

    public static c0 newInstance(com.ss.android.lark.passportc.api.m r1) {
        return new c0(r1);
    }
}

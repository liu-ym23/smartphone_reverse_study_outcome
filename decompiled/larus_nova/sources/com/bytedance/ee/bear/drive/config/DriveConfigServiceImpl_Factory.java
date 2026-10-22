package com.bytedance.ee.bear.drive.config;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import o75.b;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveConfigServiceImpl_Factory implements Factory<b> {
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DriveConfigServiceImpl_Factory(Provider<m> r100) {
        this.passportProvider = r100;
    }

    public static DriveConfigServiceImpl_Factory create(Provider<m> r100) {
        return new DriveConfigServiceImpl_Factory(r100);
    }

    public static b newInstance(m r100) {
        return new b();
    }
}

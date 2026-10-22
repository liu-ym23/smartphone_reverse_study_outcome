package com.bytedance.ee.bear.drive.config;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;
import o75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveConfigServiceImpl_Factory implements Factory<b> {
    private final Provider<m> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public b m329get() {
        return newInstance((m) this.passportProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m329get();
    }

    public DriveConfigServiceImpl_Factory(Provider<m> r1) {
        this.passportProvider = r1;
    }

    public static DriveConfigServiceImpl_Factory create(Provider<m> r1) {
        return new DriveConfigServiceImpl_Factory(r1);
    }

    public static b newInstance(m r0) {
        return new b();
    }
}

package com.bytedance.ee.bear.drive.module;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import h85.d1;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveInterfaceImpl_Factory implements Factory<d1> {
    private final Provider<m> passportProvider;

    public d1 get() {
        return newInstance((m) this.passportProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m353get() {
        return get();
    }

    public DriveInterfaceImpl_Factory(Provider<m> r1) {
        this.passportProvider = r1;
    }

    public static DriveInterfaceImpl_Factory create(Provider<m> r1) {
        return new DriveInterfaceImpl_Factory(r1);
    }

    public static d1 newInstance(m r1) {
        return new d1(r1);
    }
}

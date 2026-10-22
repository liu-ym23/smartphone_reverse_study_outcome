package com.ss.android.lark.integrator.im.impl.notification;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import qza.a;
import ymb.c;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKOnlineNotificationModule_ProvideOfficeSDKNotificationApiFactory implements Factory<a> {
    private final c module;

    @Override // javax.inject.Provider
    public a get() {
        return provideOfficeSDKNotificationApi(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKOnlineNotificationModule_ProvideOfficeSDKNotificationApiFactory(c r100) {
        this.module = r100;
    }

    public static OfficeSDKOnlineNotificationModule_ProvideOfficeSDKNotificationApiFactory create(c r100) {
        return new OfficeSDKOnlineNotificationModule_ProvideOfficeSDKNotificationApiFactory(r100);
    }

    public static a provideOfficeSDKNotificationApi(c r100) {
        r100.getClass();
        return (a) Preconditions.checkNotNullFromProvides(new ymb.a());
    }
}

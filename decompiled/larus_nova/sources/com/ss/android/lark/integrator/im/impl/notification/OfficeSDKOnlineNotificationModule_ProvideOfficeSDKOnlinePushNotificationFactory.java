package com.ss.android.lark.integrator.im.impl.notification;

import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import qza.b;
import ymb.c;

/* JADX INFO: loaded from: classes36.dex */
public final class OfficeSDKOnlineNotificationModule_ProvideOfficeSDKOnlinePushNotificationFactory implements Factory<b> {
    private final c module;

    @Override // javax.inject.Provider
    public b get() {
        return provideOfficeSDKOnlinePushNotification(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeSDKOnlineNotificationModule_ProvideOfficeSDKOnlinePushNotificationFactory(c r100) {
        this.module = r100;
    }

    public static OfficeSDKOnlineNotificationModule_ProvideOfficeSDKOnlinePushNotificationFactory create(c r100) {
        return new OfficeSDKOnlineNotificationModule_ProvideOfficeSDKOnlinePushNotificationFactory(r100);
    }

    public static b provideOfficeSDKOnlinePushNotification(c r100) {
        r100.getClass();
        Object r101 = (b) OfficeSDKManager.getHostGlobalService(b.class);
        if (r101 != null) goto L6;
        r101 = new ymb.b();
    L6:
        return (b) Preconditions.checkNotNullFromProvides(r101);
    }
}

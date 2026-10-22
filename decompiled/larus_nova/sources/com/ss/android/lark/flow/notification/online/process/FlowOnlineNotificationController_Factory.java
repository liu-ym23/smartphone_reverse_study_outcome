package com.ss.android.lark.flow.notification.online.process;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowOnlineNotificationController_Factory implements Factory<e> {
    private final Provider<m> passportServiceProvider;

    @Override // javax.inject.Provider
    public e get() {
        return newInstance(this.passportServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FlowOnlineNotificationController_Factory(Provider<m> r100) {
        this.passportServiceProvider = r100;
    }

    public static FlowOnlineNotificationController_Factory create(Provider<m> r100) {
        return new FlowOnlineNotificationController_Factory(r100);
    }

    public static e newInstance(m r100) {
        return new e(r100);
    }
}

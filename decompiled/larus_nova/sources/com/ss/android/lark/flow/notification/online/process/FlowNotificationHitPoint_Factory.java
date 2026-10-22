package com.ss.android.lark.flow.notification.online.process;

import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowNotificationHitPoint_Factory implements Factory<c> {
    private final Provider<m> passportServiceProvider;

    @Override // javax.inject.Provider
    public c get() {
        return newInstance(this.passportServiceProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FlowNotificationHitPoint_Factory(Provider<m> r100) {
        this.passportServiceProvider = r100;
    }

    public static FlowNotificationHitPoint_Factory create(Provider<m> r100) {
        return new FlowNotificationHitPoint_Factory(r100);
    }

    public static c newInstance(m r100) {
        return new c(r100);
    }
}

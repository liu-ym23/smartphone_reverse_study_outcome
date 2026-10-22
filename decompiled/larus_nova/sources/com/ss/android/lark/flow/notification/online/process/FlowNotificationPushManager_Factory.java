package com.ss.android.lark.flow.notification.online.process;

import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowNotificationPushManager_Factory implements Factory<d> {
    private final Provider<m> passportProvider;
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public d get() {
        return newInstance(this.passportProvider.get(), this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FlowNotificationPushManager_Factory(Provider<m> r100, Provider<l> r101) {
        this.passportProvider = r100;
        this.rustClientProvider = r101;
    }

    public static FlowNotificationPushManager_Factory create(Provider<m> r100, Provider<l> r101) {
        return new FlowNotificationPushManager_Factory(r100, r101);
    }

    public static d newInstance(m r100, l r101) {
        return new d(r100, r101);
    }
}
